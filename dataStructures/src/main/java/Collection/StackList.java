package Collection;

/**
 * Created by wangchao on 2018/8/8.
 */
public class StackList<E> implements Stack<E>{
    private Node top = null;
    private int size = 0;

    private class Node<E>{
        E e;
        Node<E> next;

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

    public StackList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void push(E e) {
        Node<E> eNode = new Node<>(e, top);
        top = eNode;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        Node e = top;
        top = top.getNext();
        size--;
        return (E)e.getE();
    }

    @Override
    public E peek() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        return (E)top.getE();
    }
}
