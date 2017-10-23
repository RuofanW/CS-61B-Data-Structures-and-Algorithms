/**
 * Created by wangruofan on 2017/5/11.
 */

import static org.junit.Assert.*;
import java.util.List;
import java.util.LinkedList;

public class MapHelper {

    public static <A,B> B get(ArrayMap<A,B> am, A key){
        if(am.containsKey(key)){
            return am.get(key);
        }
        return null;
    }
    public static <A extends Comparable<A>,B> A MaxKey(ArrayMap<A,B> am){
        List<A> keys = am.keys();
        A MaxA = keys.get(0);
        for(A a : keys){
            if(a.compareTo(MaxA) > 0){
                MaxA = a;
            }
        }
        return MaxA;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<String, Integer>();
        am.put("hello", 5);
        am.put("ketchup", 10);
        assertEquals(5, (long) MapHelper.get(am, "hello"));
        assertEquals(null, MapHelper.get(am, "moo"));
        assertEquals("ketchup", MapHelper.MaxKey(am));
    }

}
