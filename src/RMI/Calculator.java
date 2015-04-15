package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements CalculatorInterface{


    protected Calculator() throws RemoteException {
    }

    @Override
    public int add(int n, int m) throws RemoteException {
        return n+m;
    }

    @Override
    public int subtract(int n, int m) throws RemoteException {
        return n-m;
    }

    @Override
    public int multiply(int n, int m) throws RemoteException {
        return n*m;
    }

    @Override
    public int divide(int n, int m) throws RemoteException {
        return n/m;
    }
}
