package pattern.iterator.chaosCollection;

/**
 * Created by wangchao on 2018/3/2.
 */
public class ArrayList<E> implements Collection<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int CURRENT_CAPACITY = 0;
    private int INDEX = 0;
    private transient Object[] dataElements;
    public ArrayList() {
        CURRENT_CAPACITY = DEFAULT_CAPACITY;
        dataElements = new Object[CURRENT_CAPACITY];
        //直接new一个ArrayList，不指定大小
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterator{
        int itrIndex = 0;
        public Object next() {
            return dataElements[itrIndex++];
        }

        public boolean hasNext() {
            return (dataElements[itrIndex] != null);
        }
    }
    public void add(E e) {
        //简单设置扩充策略
        if(INDEX+1 >= CURRENT_CAPACITY){
            CURRENT_CAPACITY += 5;
            Object[] tmp = new Object[CURRENT_CAPACITY];
            for(int i = 0 ; i < dataElements.length ; i++){
                tmp[i] = dataElements[i];
            }
            dataElements = tmp;
        }
        dataElements[INDEX] = e;
        INDEX++;
    }

    public int size() {
        return INDEX;
    }

    //临时的方法
    public int length(){
        return dataElements.length;
    }
}
