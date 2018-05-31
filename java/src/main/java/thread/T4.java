package thread;

/**
 * 三个线程（分别打印a\b\c），要求打印出6个连续的abc
 * Created by wangchao on 2018/4/17.
 */
public class T4 {
    Object lock = new Object();

    public static void main(String[] args) {
        T4 t4 = new T4();
        new Thread((Runnable)()->{
            synchronized(t4.lock){
                for(int i=0;i<6;i++){
                    System.out.println("a");
                }
                try {
                    t4.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
