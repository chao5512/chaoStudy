package Collection;

/**
 * 数组实现的栈.
 * 默认容量为1024
 * todo:线程安全
 * Created by wangchao on 2018/8/7.
 */
public class StackArr<E> implements Stack<E>{
    private int DEFAULT_CAPACITY = 1024;
    private int CAPACITY;
    private Object[] elements;
    private int top = -1; //top置一为空
    private int size = 0;

    public StackArr() {
        this.CAPACITY = DEFAULT_CAPACITY;
        this.elements = new Object[CAPACITY];
    }

    public StackArr(int capacity) {
        this.CAPACITY = capacity;
        this.elements = new Object[capacity];
    }

    @Override
    public void push(E e) {
        if(this.size >= this.elements.length){
            String msg = "栈满异常";
            throw new ExceptionDataStructFull(msg);
        }
        this.elements[++this.top] = e;
        this.size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        E e = null;
        e = (E)this.elements[top];
        this.elements[this.top--] = null;
        this.size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            String msg = "栈空异常";
            throw new ExceptionDataStructEmpty(msg);
        }
        return (E)this.elements[this.top];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0; //注意这里等于零也是空
    }

    @Override
    public void clear() {
        this.elements = new Object[CAPACITY];
        this.top = -1; //top置一为空
        this.size = 0;
    }
}
