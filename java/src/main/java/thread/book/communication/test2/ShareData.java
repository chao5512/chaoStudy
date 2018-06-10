package thread.book.communication.test2;

/**
 * Created by wangchao on 2018/6/5.
 */
public class ShareData {
    private int i = 0;
    public synchronized void  increment(String s){
        i++;
        System.out.println(s+"add:"+i);
    }
    public synchronized void decrement(String s){
        System.out.println(s+"des:"+i);
        i--;
    }
    public void print(){
        System.out.println(i);
    }
}
