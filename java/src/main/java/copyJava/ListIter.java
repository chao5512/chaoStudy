package copyJava;

/**
 * Created by wangchao on 2018/2/26.
 */
public interface ListIter<E> extends Iterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();

    void remove();
    void set(E e);
    void add(E e);
}
