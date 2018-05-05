package exemplormi.cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import exemplormi.servico.*;

public class ClienteB implements IServicoListener {

    public static void main(String[] args) {
        try {
            String nomeServico = "MeuServico";
            int porta = 12345;

            IServicoListener clienteB = new ClienteB();
            IServicoListener clienteBdistribuido = 
                    (IServicoListener) UnicastRemoteObject.exportObject(clienteB, 0);

            Registry registry = LocateRegistry.getRegistry(porta);
            IServico servicoRemoto = (IServico) registry.lookup(nomeServico);
            servicoRemoto.addListener(clienteBdistribuido);

            double valor = 10;
            System.out.println("Cliente B enviando: " + valor);
            servicoRemoto.setY(valor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calculoEfetuado(double resultado) throws RemoteException {
        System.out.println("Servidor devolveu para Cliente B o resultado: " + resultado);
    }
}
