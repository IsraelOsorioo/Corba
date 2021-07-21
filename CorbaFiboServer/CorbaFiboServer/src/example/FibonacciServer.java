package example;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class FibonacciServer {
    public static void main(String args[]){
        try{
            //Crear instancia del ORB
            ORB orb = ORB.init(args, null);
            
            //Crear instancia POA
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            //Activa POA Manager
            rootPoa.the_POAManager().activate();
            
            //Instancia de clase Fibonacci
            FibonacciImp fiboImp = new FibonacciImp();
            
            //Obtiene la referencia de la clase
            Object ref = rootPoa.servant_to_reference(fiboImp);
            Fibonacci href = FibonacciHelper.narrow(ref);
            
            //Obtenemos la referencia del servicio de direcotorios
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);
            
            NameComponent nameComponent[] = rootContext.to_name("Fibonacci");
            rootContext.rebind(nameComponent, href);
            
            //Listo para recibir peticiones
            System.out.println("Servidor > listo y en espera");
            orb.run();
        }catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
