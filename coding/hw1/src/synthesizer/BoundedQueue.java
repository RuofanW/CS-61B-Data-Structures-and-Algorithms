/**
 * Created by wangruofan on 2017/5/13.
 */
package synthesizer;

public interface BoundedQueue<T> {

    int capacity();          // return size of the buffer
    int fillCount();         // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();
    default boolean isEmpty(){
        return fillCount() == 0;
    }

    default boolean isFull(){
        return capacity() == fillCount();
    }
}
