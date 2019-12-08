package jvm.memory;


/**
 * Created by wangchao on 2019/11/21.
 */
public class DeadloadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                A.run();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                B.run();
            }
        }).start();
    }
}
class A {
    public static synchronized void run(){
        System.out.println("a-thread------");
        try {
            Thread.sleep(5000);
            B.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class B{
    public static synchronized void run(){
        System.out.println("b-thread-----");
        try {
            Thread.sleep(5000);
            A.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}