package example;


/**
* example/FibonacciOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/reposComputoDistribuido/Corba/CorbaFiboInterface/CorbaFiboInterface/src/fibonacci.idl
* mi�rcoles 21 de julio de 2021 01:00:34 AM CDT
*/

public interface FibonacciOperations 
{

  /*Codigo fibonacci CORBA
          *in: el valor del parametro se le envia al servidor
          *long: -231...231-1 (32bits)
          *numero: nombre de la variable
          */
  String generar (int numero);
} // interface FibonacciOperations