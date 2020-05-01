package Aulas_Java_Avancado;

public class FuncaoComClasseAnonima {

    public static void main(String[] args) {

        Funcao colocarPrefixoSenhor = new Funcao() {
            @Override
            public String gerar(String valor){
                return  "Sr. " + valor;
            }
        };
        System.out.println(colocarPrefixoSenhor.gerar("Joao"));
    }
}
