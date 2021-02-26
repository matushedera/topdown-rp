package operators;

import java.util.HashMap;
import java.util.stream.Stream;
import java.util.function.Supplier;

@FunctionalInterface
public interface Operator {

    Supplier<Stream<HashMap<String, Integer>>> apply(
        Supplier<Stream<HashMap<String, Integer>>> r1,
        Supplier<Stream<HashMap<String, Integer>>> r2,
        Condition c
    );

}
