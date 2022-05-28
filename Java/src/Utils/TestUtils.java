package Utils;

import java.util.ArrayList;
import java.util.List;

public class TestUtils<T> {
    @SafeVarargs
    public static <T> List<T> toList(T... args) {
        List<T> ret = new ArrayList<T>();
        for(T value : args){
            ret.add(value);
        }
        return ret;
    }
}
