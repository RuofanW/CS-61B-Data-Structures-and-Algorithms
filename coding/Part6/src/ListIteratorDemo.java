/**
 * Created by wangruofan on 2017/5/11.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ListIteratorDemo {
    public static void main(String[] args){
        List<Integer> friends = new ArrayList<Integer>();
        friends.add(3);
        friends.add(23);
        friends.add(42);

        Iterator<Integer> seer = friends.iterator();

        while(seer.hasNext()){
            System.out.println(seer.next());
        }


    }
}
