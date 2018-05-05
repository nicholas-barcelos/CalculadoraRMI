package exemplormi.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServicoListener extends Remote {
    void calculoEfetuado(double resultado) throws RemoteException;
}
