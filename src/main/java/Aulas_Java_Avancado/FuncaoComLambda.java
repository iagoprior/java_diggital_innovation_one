package Aulas_Java_Avancado;

public class FuncaoComLambda {

    public static void main(String[] args) {

        Funcao colocarPrefixoSenhor = valor -> "Sr. " + valor;
        System.out.println(colocarPrefixoSenhor.gerar("João"));
    }
}
