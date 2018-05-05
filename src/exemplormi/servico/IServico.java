package exemplormi.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServico extends Remote {

    void addListener(IServicoListener listener) throws RemoteException;

    void setX(double valor) throws RemoteException;

    void setY(double valor) throws RemoteException;
}