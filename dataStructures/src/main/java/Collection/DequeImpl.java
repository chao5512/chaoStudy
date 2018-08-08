package Collection;

/**
 * 双向队列
 * Created by wangchao on 2018/8/8.
 */
public class DequeImpl<E> implements Deque<E>{
    private DeNode<E> first;
    private DeNode<E> last;
    private int size = 0;

    public DequeImpl() {
        this.first = new DeNode<>(null,null,null);
        this.last = new DeNode<>(null,null,null);
        this.first.setNext(last);
        this.last.setPrev(first);
    }

    @Override
    public E first() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        return (E)first.getNext().getE();
    }

    @Override
    public E last() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        return (E)last.getPrev().getE();
    }

    @Override
    public void insertFirst(E e) {
        DeNode<E> eDeNode = new DeNode<>(null, e, null);
        eDeNode.setNext(first.getNext());
        eDeNode.getNext().setPrev(eDeNode);
        first.setNext(eDeNode);
        size++;
    }

    @Override
    public void insertLast(E e) {
        DeNode<E> eDeNode = new DeNode<>(null, e, null);
        eDeNode.setPrev(last.getPrev());
        eDeNode.getPrev().setNext(eDeNode);
        last.setPrev(eDeNode);
        size++;
    }

    @Override
    public E pollFirst() throws ExceptionDataStructEmpty {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        E e = first();
        first.setNext(first.getNext().getNext());
        first.getNext().setPrev(first);
        size--;
        return e;
    }

    @Override
    public E pollLast() throws ExceptionDataStructEmpty {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        E e = last();
        last.setPrev(last.getPrev().getPrev());
        last.getPrev().setNext(last);
        size--;
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public void clear() {
        this.first = new DeNode<>(null,null,null);
        this.last = new DeNode<>(null,null,null);
        this.first.setNext(last);
        this.last.setPrev(first);
    }
}
