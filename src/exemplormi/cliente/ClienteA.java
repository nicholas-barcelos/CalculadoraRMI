package exemplormi.cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import exemplormi.servico.*;

public class ClienteA implements IServicoListener {

    public static void main(String[] args) {
        try {
            String nomeServico = "MeuServico";
            int porta = 12345;

            IServicoListener clienteA = new ClienteA();
            IServicoListener clienteAdistribuido = 
                    (IServicoListener) UnicastRemoteObject.exportObject(clienteA, 0);

            Registry registry = LocateRegistry.getRegistry(porta);
            IServico servicoRemoto = (IServico) registry.lookup(nomeServico);
            servicoRemoto.addListener(clienteAdistribuido);

            double valor = 20;
            System.out.println("Cliente A enviando: " + valor);
            servicoRemoto.setX(valor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calculoEfetuado(double resultado) throws RemoteException {
        System.out.println("Servidor devolveu para Cliente A o resultado: " + resultado);
    }
}
