package lab8;

/**
 * Created by wangruofan on 2017/6/14.
 */
import java.util.Set;
import java.util.Iterator;
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private Node root;

    public BSTMap(){
        root=null;
    }

    @Override
    public void clear(){
        root=null;
    }

    @Override
    public boolean containsKey(K key){
        return get(key)!=null;
    }

    @Override
    public V get(K key){
        return get(root, key);
    }

    private V get(Node n, K key){
        if(n==null){
            return null;
        }
        int cmp=key.compareTo(n.key);
        if(cmp==0){
            return n.val;
        }
        //key may be in the left
        else if(cmp<0){
            return get(n.left, key);
        }
        // key may be in the right
        else{
            return get(n.right, key);
        }
    }

    @Override
    public int size(){
        return size(root);
    }

    @Override
    public void put(K key, V value){
        root= insert(root, key, value);
    }

    private Node insert(Node n, K key, V value){
        if(n==null){
            return new Node(key, value);
        }

        int cmp=key.compareTo(n.key);
        if(cmp==0){
            n.val=value;
        }
        else if(cmp <0){
            n.left=insert(n.left, key, value);
        }
        else{
            n.right=insert(n.right,key,value);
        }
        n.size = size(n.right) + size(n.left)+1;
        return n;
    }

    private int size(Node n){
        if(n==null) return 0;
        return n.size;
    }

    private class Node{

        private K key;
        private V val;
        private int size;

        private Node left;
        private Node right;

        public Node(K key, V val){
            this.key = key;
            this.val = val;
            left=null;
            right=null;
            size=1;
        }
        public Node(){
            this.key = null;
            this.val = null;
            left=null;
            right=null;
            size=1;
        }

    }

    public  V remove(K key){throw new UnsupportedOperationException();}
    public  V remove(K key, V value){throw new UnsupportedOperationException();}
    public  Set<K> keySet(){throw new UnsupportedOperationException();}
    public  Iterator iterator(){throw new UnsupportedOperationException();}

    public void printInOrder(){
        if(root==null){
            System.out.println(" None ");
        }
        else printInOrder(root);
    }

    private void printInOrder(Node n){
        if(n.right==null&&n.left==null){
            System.out.println(" "+n.key.toString()+" ");
        }
        else if(n.right==null&&n.left!=null){
            printInOrder(n.left);
            System.out.println(" " + n.key.toString()+" ");
        }
        else if(n.right!=null&&n.left==null){
            printInOrder(n.right);
            System.out.println(" " + n.key.toString()+" ");
        }
        else{
            printInOrder(n.left);
            System.out.println(" " + n.key.toString()+" ");
            printInOrder(n.right);
        }
    }

    private Node findparent(K key){
        if(key == root.key){
            return null;
        }
        Node parent = root;
        boolean found = (parent.left.key == key) || (parent.right.key == key);
        while(found != true){
            if(key.compareTo(parent.key) < 0 ){
                parent = parent.left;
            }
            if(key.compareTo(parent.key) > 0 ){
                parent = parent.right;
            }
            found = (parent.left.key == key) || (parent.right.key == key);
        }
        return parent;
    }

    private Node findcurrent(K key){
        Node curr = root;
        while(key.compareTo(curr.key) != 0){
            if(key.compareTo(curr.key) < 0){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return curr;
    }


    public void delete(K key){
        root = delete(root, key);
    }

    private Node delete(Node n, K key){
        if(n == null){
            throw new RuntimeException("cannot delete!");
        }
        else if(key.compareTo(n.key) < 0){
            n.left = delete(n.left, key);
        }
        else if(key.compareTo(n.key) > 0){
            n.right = delete(n.right, key);
        }
        else{
            if(n.left != null && n.right != null){
                n = findmin(n.right);
                n.right = delete(n.right, n.key);
            }
            else
                n = ( n.left != null ) ? n.left : n.right;
        }
        return n;
    }

    private Node findmin(Node n){
        if(n == null){
            return null;
        }
        else if(n.left == null){
            return n;
        }
        else {
            return findmin(n.left);
        }
    }



    public static void main(String[] args){
        BSTMap<String, Integer> bst = new BSTMap<String, Integer>();
        bst.put("d",1);
        bst.put("b",2);
        bst.put("f",5);
        bst.put("a",4);
        bst.delete("a");

        System.out.print(bst.findcurrent("b").left == null);
    }




}