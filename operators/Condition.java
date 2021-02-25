package operators;

import java.util.HashMap;

@FunctionalInterface
public interface Condition {

    boolean satisfies(HashMap<String, Integer> t1, HashMap<String, Integer> t2);

}
