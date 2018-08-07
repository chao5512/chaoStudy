package Collection;

/**
 * 数组实现的栈.
 * 默认容量为1024
 * todo:线程安全
 * Created by wangchao on 2018/8/7.
 */
public class StackArr<E> implements Stack<E>{
    private int DEFAULT_CAPACITY = 1024;
    private Object[] elements;
    private int top = -1; //top置一为空
    private int size = 0;

    public StackArr() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public StackArr(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public void push(E e) {
        if(size >= elements.length){
            String msg = "栈满异常";
            throw new ExceptionStackFull(msg);
        }
        elements[++top] = e;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionStackEmpty(msg);
        }
        E e = null;
        e = (E)elements[top];
        elements[top--] = null;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionStackEmpty(msg);
        }
        return (E)elements[top];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0; //注意这里等于零也是空
    }
}
