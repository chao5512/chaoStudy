package Collection;

/**
 * Created by wangchao on 2018/8/8.
 */
public class StackList<E> implements Stack<E>{
    private Node top = null;
    private int size = 0;

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
    public void clear() {
        this.top = null;
        this.size = 0;
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
