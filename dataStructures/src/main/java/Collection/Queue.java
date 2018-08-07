package Collection;

/**
 * Created by wangchao on 2018/8/7.
 */
public interface Queue<E> extends DataStruct<E>{
    public void push(E e);
    public E poll();
}
