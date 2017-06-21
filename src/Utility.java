import java.util.ArrayList;
import java.util.function.Function;

/**
 * Contains various methods for easier programming
 * Created by silva on 21.06.2017.
 */
public class Utility {
    public static <T> T[] Array_Add(T[] source, T additional_obj){
        ArrayList<T> newArray = new ArrayList<T>();
        for (T obj : source)
            newArray.add(obj);
        newArray.add(additional_obj);
        return (T[])newArray.toArray();
    }

    public static <T> T Array_Find(T[] source, Function<T, Boolean> predicate){
        for(T obj : source)
            if (predicate.apply(obj))
                return obj;
        return null;
    }
}
