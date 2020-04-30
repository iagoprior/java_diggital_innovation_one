package map;

import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {

    public static void main(String[] args) {
        Map<String, Integer> campeoesMundialFifa = new HashMap<>();

        campeoesMundialFifa.put("Brasil", 5);
        campeoesMundialFifa.put("Alemanha", 4);
        campeoesMundialFifa.put("Italia", 4);
        campeoesMundialFifa.put("Uruguai", 2);
        campeoesMundialFifa.put("Argentina", 2);
        campeoesMundialFifa.put("França", 2);
        campeoesMundialFifa.put("Inglaterra", 1);
        campeoesMundialFifa.put("Espanha", 1);
        campeoesMundialFifa.put("GO", null);
        campeoesMundialFifa.put("RO", null);

        System.out.println(campeoesMundialFifa);
        campeoesMundialFifa.put("Brasil", 6);
        System.out.println(campeoesMundialFifa);


        System.out.println(campeoesMundialFifa.get(2));


        System.out.println(campeoesMundialFifa.containsKey("França"));

        campeoesMundialFifa.remove("França");
        System.out.println(campeoesMundialFifa);

        System.out.println(campeoesMundialFifa.containsValue(6));

        System.out.println(campeoesMundialFifa.size());


        for (Map.Entry<String, Integer> entry : campeoesMundialFifa.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        for (String key : campeoesMundialFifa.keySet()) {
            System.out.println(key + "----" + campeoesMundialFifa.get(key));
        }

        campeoesMundialFifa.clear();
        System.out.println(campeoesMundialFifa);


    }
}
