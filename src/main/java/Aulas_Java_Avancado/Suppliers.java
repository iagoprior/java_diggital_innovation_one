package Aulas_Java_Avancado;

import java.util.function.Supplier;

public class Suppliers {

    public static void main(String[] args) {
        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
        System.out.println(instanciaPessoa.get());
    }
}


class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "joão";
        idade = 23;
    }

    @Override
    public String toString() {
        return String.format("nome: %s, idade: %d" ,nome,idade);
    }
}