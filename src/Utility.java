import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Contains various methods for easier programming
 * Created by silva on 21.06.2017.
 */
public class Utility {
    public static <T> T[] Array_Add(T[] source, T additional_obj){
        ArrayList<T> newArray = new ArrayList<T>();
        for (T obj : source) newArray.add(obj);
        newArray.add(additional_obj);
        return (T[])newArray.toArray();
    }

    public static <T> T Array_Find(T[] source, Predicate<T> predicate){
        for(T obj : source) if (predicate.test(obj)) return obj;
        return null;
    }

    public static boolean Array_Any(Object[] source){ return source != null && source.length > 0; }

    public static <T> T Array_Last(T[] source){ return Array_Any(source) ? source[source.length-1] : null; }

    public static <T> boolean Array_Any(T[] source, Predicate<T> predicate){
        for(T obj : source) if (predicate.test(obj)) return true;
        return false;
    }
}
