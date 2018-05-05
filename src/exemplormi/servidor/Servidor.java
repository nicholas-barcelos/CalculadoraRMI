package exemplormi.servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import exemplormi.servico.Servico;
import exemplormi.servico.IServico;

public class Servidor {

    public static void main(String args[]) {
        try {
            String nomeServico = "MeuServico";
            int porta = 12345;

            IServico servico = new Servico();
            IServico servicoDistribuido = 
                    (IServico) UnicastRemoteObject.exportObject(servico, 0);

            Registry registry = LocateRegistry.createRegistry(porta);
            registry.bind(nomeServico, servicoDistribuido);
            System.out.printf("Servico disponivel: %s%n", nomeServico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}