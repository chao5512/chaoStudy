package Collection;


/**
 * 队列的数组实现.
 * todo：用环形数组
 * Created by wangchao on 2018/8/7.
 */
public class QueueArr<E> implements Queue<E>{
    private int DEFAULT_CAPACITY = 1024;
    private int CAPACITY;
    private Object[] elements;
    private int first = -1;
    private int index = -1;

    public QueueArr() {
        this.CAPACITY = DEFAULT_CAPACITY;
        this.elements = new Object[CAPACITY];
    }

    public QueueArr(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        elements = new Object[CAPACITY];
    }

    @Override
    public void push(E e) {
        if(size() >= CAPACITY){
            String msg = "队列已满";
            throw new ExceptionDataStructFull(msg);
        }
        elements[++index] = e;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            String msg = "队列为空";
            throw new ExceptionDataStructEmpty(msg);
        }
        E e;
        e = (E)elements[++first];
        elements[first] = null;
        return e;
    }

    @Override
    public int size() {
        return index - first;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }
}
