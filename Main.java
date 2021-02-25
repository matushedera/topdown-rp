import operators.*;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Operator Union = (r1, r2, c) -> {
            r1.forEach( (t) -> {
                for (String key : t.keySet()) System.out.println(t.get(key));
            }
            );
            return r2;
        };
        HashMap<String, Integer> t1 = new HashMap<>();
        t1.put("A", 1);
        t1.put("B", 2);
        HashMap<String, Integer> t2 = new HashMap<>();
        t2.put("B", 3);
        t2.put("C", 4);
        Union.apply(Stream.of(t1, t2), null, null);
    }

}
