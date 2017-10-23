package lab9;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by wangruofan on 2017/6/21.
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    public int n = 0;
    public int initialSize = 4;
    public double loadFactor = 10;
    public LinkedList<K>[] keylist = new LinkedList[initialSize];
    public LinkedList<V>[] vallist = new LinkedList[initialSize];

    public MyHashMap(){
        for(int i = 0; i < keylist.length; i ++){
            keylist[i] = new LinkedList<K>();
            vallist[i] = new LinkedList<V>();
        }
    }

    public MyHashMap(int m){
        this.initialSize = m;
        for(int i = 0; i < m; i ++){
            keylist[i] = new LinkedList<K>();
            vallist[i] = new LinkedList<V>();
        }
    }

    public MyHashMap(int m, int fc){
        this.initialSize = m;
        this.loadFactor = fc;
        for(int i = 0; i < m; i ++){
            keylist[i] = new LinkedList<K>();
            vallist[i] = new LinkedList<V>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % initialSize;
    }

    @Override
    public void clear(){
        for(int i = 0; i < initialSize; i ++){
            keylist[i] = new LinkedList<K>();
            vallist[i] = new LinkedList<V>();
        }
        n = 0;
    }

    @Override
    public int size(){
        return n;
    }

    @Override
    public boolean containsKey(K key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        int i = hash(key);
        return keylist[i].contains(key);
    }

    @Override
    public V get(K key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int hashcode = hash(key);
        int index = keylist[hashcode].indexOf(key);
        if(index > -1){
            return vallist[hashcode].get(index);}
        else{return null;}
    }



    @Override
    public  V remove(K key){throw new UnsupportedOperationException();}
    @Override
    public  V remove(K key, V value){throw new UnsupportedOperationException();}

    @Override
    public Set<K> keySet(){
        HashSet<K> hs = new HashSet<K>();
        for(int i = 0; i < initialSize; i ++){
            for(K key : keylist[i]){
                hs.add(key);
            }
        }
        return hs;
    }

    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        /*if (val == null) {
            delete(key);
            return;
        }*/

        // double table size if average length of list >= 10
        //if (n >= 10*initialSize) resize(2*initialSize);

        int i = hash(key);
        if (!containsKey(key))
        { n = n + 1;
        keylist[i].add(key);
        vallist[i].add(val);
        }
    }

    /*private void resize(int chains) {
        MyHashMap<K, V> temp = new MyHashMap(chains);
        for (int i = 0; i < initialSize; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }*/
    public  Iterator iterator(){throw new UnsupportedOperationException();}
    public static void main(String[] args) {
        MyHashMap<String,Integer> test = new MyHashMap<>();
        System.out.print(test.keylist.length);
    }
    //public  Set<K> keySet(){throw new UnsupportedOperationException();}


}
