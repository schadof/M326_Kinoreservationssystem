import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * Contains various methods for easier programming
 * Created by silva on 21.06.2017.
 */
public class Utility {

    public static <T> ArrayList<T> Array_ToList(T[] source){
        ArrayList<T> List = new ArrayList<>();
        Collections.addAll(List, source);
        return List;
    }

    public static <T> T[] Array_Add(T[] source, T target){
        ArrayList<T> newArray = Array_ToList(source);
        newArray.add(target);
        return (T[])newArray.toArray();
    }

    public static <T> T[] Array_Remove(T[] source, T target){
        ArrayList<T> newArray = Array_ToList(source);
        newArray.remove(target);
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

    public static <T> int Array_Count(T[] source, Predicate<T> predicate){
        int count = 0;
        for (T obj : source) if(predicate.test(obj)) count++;
        return count;
    }
}
