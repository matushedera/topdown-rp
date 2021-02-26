import operators.*;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Operator Union = (r1, r2, c) -> () ->
            Stream.concat(r1.get(), r2.get()).distinct();

        Operator Join = (r1, r2, c) -> () -> r1.get().flatMap( (t1) -> r2.get().map( (t2) -> {
            HashMap<String, Integer> t3 = new HashMap<>();
            t1.forEach((key, value) -> t3.merge(key, value, (v1, v2) -> v1));
            t2.forEach((key, value) -> t3.merge(key, value, (v1, v2) -> v1));
            return t3;
        } ) ).filter(t -> c.satisfies(t));

        Operator Antijoin = (r1, r2, c) -> Join.apply(r1, r2, c.negate());

        HashMap<String, Integer> t1 = new HashMap<>();
        t1.put("A", 1);
        t1.put("B", 2);
        HashMap<String, Integer> t2 = new HashMap<>();
        t2.put("A", 3);
        t2.put("B", 4);
        HashMap<String, Integer> t3 = new HashMap<>();
        t3.put("C", 1);
        t3.put("D", 2);
        HashMap<String, Integer> t4 = new HashMap<>();
        t4.put("C", 5);
        t4.put("D", 6);

        Union.apply( () -> Stream.of(t1, t2), () -> Stream.of(t3, t4), null).get().forEach(System.out::println);
        Join.apply( () -> Stream.of(t1, t2), () -> Stream.of(t3, t4), (t) -> t.get("D")>t.get("B")).get().forEach(System.out::println);
        Antijoin.apply( () -> Stream.of(t1, t2), () -> Stream.of(t3, t4), (t) -> t.get("D")>t.get("B")).get().forEach(System.out::println);
    }

}
