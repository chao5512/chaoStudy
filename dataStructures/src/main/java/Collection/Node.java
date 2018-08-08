package Collection;

/**
 * Created by wangchao on 2018/8/8.
 */
public class Node<E> {
    private E e;
    private Node<E> next;

    public Node(E e, Node<E> next) {
        this.e = e;
        this.next = next;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
