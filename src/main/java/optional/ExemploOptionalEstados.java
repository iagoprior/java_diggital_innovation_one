package optional;

import java.util.Optional;

public class ExemploOptionalEstados {

    public static void main(String[] args) {

        Optional<String> optionalString = Optional.of("Valor Presente");
        System.out.println("Valor optional presente:");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("não está presente") );

        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("Valor optional não presente:");
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = não está presente"));


        Optional<String> emptyOptional = Optional.empty();
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("empty = não está presente"));

        Optional<String> optionalNullErro = Optional.of(null);
        optionalNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("erro = não está presente"));
    }
}
