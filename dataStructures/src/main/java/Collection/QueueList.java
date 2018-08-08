package Collection;

/**
 * Created by wangchao on 2018/8/8.
 */
public class QueueList<E> implements Queue<E>{
    private Node<E> first;
    private Node<E> tail;
    private int size;

    public QueueList() {
        first = new Node<>(null, tail);
        tail = null;
        size = 0;
    }

    @Override
    public void push(E e) {
        Node<E> eNode = new Node<>(e, null);
        if(isEmpty()){
            first.setNext(eNode);
        }else{
            tail.getNext().setNext(eNode);
        }
        tail.setNext(eNode);
        size++;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            String msg = "队列空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        E e = first.getNext().getE();
        first.setNext(first.getNext().getNext());
        size--;
        return e;
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
    public void clear() {
        first = new Node<>(null, tail);
        tail = null;
        size = 0;
    }
}
