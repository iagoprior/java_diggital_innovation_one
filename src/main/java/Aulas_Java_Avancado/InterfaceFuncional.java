package FatorialRecursivo;

public class InterfaceFuncional {

    public static void main(String[] args) {

        Funcao1 funcao1 = valor -> valor;

    }
}

@FunctionalInterface
interface Funcao1 {
    String gerar(String valor);
}

