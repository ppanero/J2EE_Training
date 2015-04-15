package RMI;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {

    public static void main(String[] args){
        try {
            //Initialize server
            Registry reg = LocateRegistry.createRegistry(1099);
            Calculator c = new Calculator();
            //Bind the name with the object
            reg.rebind("Calculator", c);

            System.out.println("Calculator server status: running");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
