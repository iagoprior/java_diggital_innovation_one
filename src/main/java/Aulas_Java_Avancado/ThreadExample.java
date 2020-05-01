package Aulas_Java_Avancado;

public class ThreadExample {
    public static void main(String[] args) {

        GerarPDF iniciarGerarPDF = new GerarPDF();
        BarraDeCarregamento2 iniciarBarraDeCarregamento2 = new BarraDeCarregamento2(iniciarGerarPDF);

        iniciarGerarPDF.start();
        iniciarBarraDeCarregamento2.start();



    }
}


class GerarPDF extends Thread {
    @Override
    public void  run() {

        try {System.out.println("Inicia");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento implements Runnable {
    @Override
    public void run() {
        System.out.println("Loading....");
    }
}

class BarraDeCarregamento2 extends Thread {
    private Thread iniciarGerarPDF;

    public BarraDeCarregamento2(Thread iniciarGerarPDF) {
        this.iniciarGerarPDF = iniciarGerarPDF;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (!iniciarGerarPDF.isAlive()) {
                    break;
                }
                System.out.println("Loading ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    class BarraDeCarregamento3 extends Thread {
        @Override
        public void run() {
            super.run();


            try {
                Thread.sleep(10000);
                System.out.println("rodei" + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}