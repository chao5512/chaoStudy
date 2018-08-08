package Collection;

/**
 * 双端队列.
 * Created by wangchao on 2018/8/8.
 */
public interface Deque<E> extends DataStruct<E>{
    public E first();
    public E last();
    public void insertFirst(E e);
    public void insertLast(E e);
    public E pollFirst()throws ExceptionDataStructEmpty;
    public E pollLast()throws ExceptionDataStructEmpty;

}
