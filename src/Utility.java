import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
/**
 * Contains various methods for easier programming
 * Created by silvan on 21.06.2017.
 */
public class Utility {

    public static <T> ArrayList<T> Array_ToList(T[] source){
        ArrayList<T> List = new ArrayList<>();
        Collections.addAll(List, source);
        return List;
    }

    public static <T> T Array_First(ArrayList<T> source, Predicate<T> predicate){
        for(T obj : source) if (predicate.test(obj)) return obj;
        return null;
    }

    public static boolean Array_Any(ArrayList source){ return source != null && source.size() > 0; }

    public static <T> T Array_Last(ArrayList<T> source){ return Array_Any(source) ? source.get(source.size()-1) : null; }

    public static <T> boolean Array_Any(ArrayList<T> source, Predicate<T> predicate){
        for(T obj : source) if (predicate.test(obj)) return true;
        return false;
    }

    public static <T> int Array_Count(ArrayList<T> source, Predicate<T> predicate){
        int count = 0;
        for (T obj : source) if(predicate.test(obj)) count++;
        return count;
    }

    public static <T> ArrayList<T> Array_Create(T[] content){
        ArrayList<T> result = new ArrayList<>();
        for (T item : content) result.add(item);
        return result;
    }
}