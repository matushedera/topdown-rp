package operators;

import java.util.HashMap;
import java.util.stream.Stream;

@FunctionalInterface
public interface Operator {

    Stream<HashMap<String, Integer>> apply(Stream<HashMap<String, Integer>> r1, Stream<HashMap<String, Integer>> r2, Condition c);

}
