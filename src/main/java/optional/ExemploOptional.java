package optional;

import java.util.Optional;

public class ExemploOptional {

    public static void main(String[] args) {

        Optional<String> optionalString = Optional.of("Valor Decimal");
        System.out.println(optionalString.isPresent());
        System.out.println(optionalString.isEmpty());
        Optional<String> optionalString1 = Optional.empty();
        System.out.println(optionalString1.isPresent());
        System.out.println(optionalString1.isEmpty());
        Optional<String> optionalString2 = Optional.ofNullable(null);
        System.out.println(optionalString2.isPresent());
        System.out.println(optionalString2.isEmpty());

        optionalString.ifPresent(System.out::println);

        optionalString.ifPresentOrElse(System.out::println,
                () -> System.out.println("Valor não está presente"));

        if (optionalString.isPresent()) {
            String valor = optionalString.get();
            System.out.println(valor);
        }

        optionalString.map((valor) -> valor.concat("****")).ifPresent(System.out::println);
        System.out.println(optionalString.orElseThrow(IllegalStateException::new));
    }
}
