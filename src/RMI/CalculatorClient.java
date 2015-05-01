package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {

    public static void main(String[] args){

        try{
            //Initialize client
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            CalculatorInterface c = (CalculatorInterface)reg.lookup("Calculator");

            //Execute RMI
            System.out.println("1+1 = " + c.add(1,1));
            System.out.println("1-1 = " + c.subtract(1,1));
            System.out.println("1*1 = " + c.multiply(1,1));
            System.out.println("1/1 = " + c.divide(1,1));

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
