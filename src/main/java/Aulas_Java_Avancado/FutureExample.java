package Aulas_Java_Avancado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExample {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException{
        Casa casa = new Casa(new Quarto());
        List<? extends Future<?>> futuros =
                new CopyOnWriteArrayList<>(casa.obterFazeresDaCasa().stream()
                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                            try {
                                atividade.realizar();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }))
                        .collect(Collectors.toList()));
        while (futuros.stream().allMatch(Future::isDone)){
            int numeroDeAtividadesNaoFinalizadas = 0;
            for (Future<?> futuro : futuros) {
                if(futuro.isDone()){
                    try {
                        System.out.println("Parabéns" + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }
            System.out.println("Numero de Atividades Nãi Finalizadas :: " +numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }
        pessoasParaExecutarAtividade.shutdown();

    }

}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos){this.comodos = Arrays.asList(comodos);}

    List<Atividade> obterFazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    void realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade>  obterAfazeresDoComodo(){
        return Arrays.asList(
          this::arrumarCama,
          this::varrerQuarto,
          this::arrumarGuardaRoupa
        );
    }

    private void arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar o Guarda-Roupa");}
    private void arrumarCama() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar a Cama");}
    private void varrerQuarto() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Varrer o Quarto");}
}