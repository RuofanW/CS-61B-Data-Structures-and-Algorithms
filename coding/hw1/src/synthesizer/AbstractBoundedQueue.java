package synthesizer;

/**
 * Created by wangruofan on 2017/5/13.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity(){
        return capacity;
    }

    public int fillCount(){
        return fillCount;
    }

}
