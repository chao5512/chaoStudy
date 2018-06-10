package thread.book.communication;

/**
 * shiyong javap -v SynchronizedClass.class
 * Created by wangchao on 2018/6/4.
 */
public class SynchronizedClass {
    public static void main(String[] args) {
        synchronized (SynchronizedClass.class){

        }
        m();
    }

    public static synchronized void m(){}
}
