package Collection;

/**
 * 双向链表
 * Created by wangchao on 2018/8/8.
 */
public class DeNode<E> {
    private DeNode<E> prev;
    private DeNode<E> next;
    private E e;

    public DeNode(DeNode<E> prev, E e, DeNode<E> next) {
        this.prev = prev;
        this.next = next;
        this.e = e;
    }

    public DeNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DeNode<E> prev) {
        this.prev = prev;
    }

    public DeNode<E> getNext() {
        return next;
    }

    public void setNext(DeNode<E> next) {
        this.next = next;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
