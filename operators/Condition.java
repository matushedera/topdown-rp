package operators;

import java.util.HashMap;

@FunctionalInterface
public interface Condition {

    boolean satisfies(HashMap<String, Integer> t);

    default Condition negate() {return (t) -> !this.satisfies(t);}

}
