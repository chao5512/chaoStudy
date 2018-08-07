package Collection;

import com.sun.org.apache.bcel.internal.generic.PUSH;

/**
 * Created by wangchao on 2018/8/7.
 */
public interface Stack<E> {
    public void push(E e);
    public E pop();
    public E peek();
    public int size();
    public boolean isEmpty();
}
