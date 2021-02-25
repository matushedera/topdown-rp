import operators.*;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Operator Union = (r1, r2, c) -> Stream.concat(r1, r2).distinct();

        HashMap<String, Integer> t1 = new HashMap<>();
        t1.put("A", 1);
        t1.put("B", 2);
        HashMap<String, Integer> t2 = new HashMap<>();
        t2.put("A", 3);
        t2.put("B", 4);
        HashMap<String, Integer> t3 = new HashMap<>();
        t3.put("A", 1);
        t3.put("B", 2);
        HashMap<String, Integer> t4 = new HashMap<>();
        t4.put("A", 5);
        t4.put("B", 6);

        Union.apply(Stream.of(t1, t2), Stream.of(t3, t4), null).forEach(System.out::println);
    }

}
