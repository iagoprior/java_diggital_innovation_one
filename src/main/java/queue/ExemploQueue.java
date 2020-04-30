package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Juliana");
        filaBanco.add("Pedro");
        filaBanco.add("Carlos");
        filaBanco.add("Larissa");
        filaBanco.add("Joao");

        for (String client: filaBanco) {
            System.out.println(client);
        }

        String primeiroCliente = filaBanco.peek();
        System.out.println(primeiroCliente);

        System.out.println(filaBanco);

        String clienteASerAtendido = filaBanco.poll();
        System.out.println(clienteASerAtendido);
        System.out.println(filaBanco);
        //filaBanco.clear();


        filaBanco.add("Daniel");
        System.out.println(filaBanco);


        String primeiroClienteOuErro = filaBanco.element();
        System.out.println(primeiroClienteOuErro);
        System.out.println(filaBanco);



        Iterator<String> iteratorFilaBanco = filaBanco.iterator();

        while (iteratorFilaBanco.hasNext()) {
            System.out.println("-->" + iteratorFilaBanco.next());
        }
        System.out.println(filaBanco.size());
        filaBanco.clear();
        System.out.println(filaBanco.isEmpty());
    }
}
