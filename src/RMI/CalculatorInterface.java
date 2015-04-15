package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInterface extends Remote{

    public int add(int n, int m) throws RemoteException;

    public int subtract(int n, int m) throws  RemoteException;

    public int multiply(int n, int m) throws  RemoteException;

    public int divide(int n, int m) throws  RemoteException;

}
