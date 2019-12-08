package Collection;

import java.lang.annotation.Target;

/**
 * Created by wangchao on 2018/7/24.
 */
public class ArrayList<T> {
    private Object[] list;
    private int index=0;

    public ArrayList(int size) {
        list = new Object[size];
    }

    public void add(T t){
        ensureCapacity();
        list[index++] = t;
    }

    /**
     * 确保数组空间够用
     */
    private void ensureCapacity(){
        int oldCapacity = list.length;
        if(index>oldCapacity-10){
            int newCapacity = oldCapacity + oldCapacity >> 1;
            Object[] newList = new Object[newCapacity];
            for (int i = 0; i < index ; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
    }

    public T get(int target){
        rangeCheck(target);
        return (T) list[target];
    }

    private void rangeCheck(int target){
        if(target>=index){
            throw new IndexOutOfBoundsException("index:"+target+"out of bound："+index);
        }
    }

}
