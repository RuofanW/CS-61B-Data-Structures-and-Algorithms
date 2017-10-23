/**
 * Created by wangruofan on 2017/5/10.
 */
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayMap <K, V> implements Iterable<K>{

    private K[] keys;
    private V[] vals;
    private int size;

    public ArrayMap(){
        keys = (K[]) new Object[100];
        vals = (V[]) new Object[100];
        size = 0;
    }

    private int findKey(K key){
        for(int i = 0; i < size; i ++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value){
        int location = findKey(key);
        if(location > -1){
            vals[location] = value;
        }
        else{
            keys[size] = key;
            vals[size] = value;
            size = size + 1;
        }
    }

    public V get(K key){
        if (findKey(key) < 0) {
            throw new IllegalArgumentException(key + " was not a valid key.");
        }
        return vals[findKey(key)];
    }

    public boolean containsKey(K key) {
        return findKey(key) > -1;
    }

    public List<K> keys() {
        if (size == 0) {
            return null;
        }
        return Arrays.asList(keys).subList(0, size);
    }

    public class MapWizard implements Iterator<K> {
        private int notionofloc;

        public MapWizard() {
            notionofloc = 0;
        }

        public boolean hasNext() {
            return (notionofloc < size);
        }

        public  K next(){
            K currentthing  = keys[notionofloc];
            notionofloc = notionofloc + 1;
            return currentthing;
        }

    }

    public Iterator<K> iterator() {
        return new MapWizard();
    }
}
