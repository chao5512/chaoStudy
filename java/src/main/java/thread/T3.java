package thread;

import java.util.concurrent.TimeUnit;

/**
 * 实现一个死锁情况
 * Created by wangchao on 2018/4/16.
 */
public class T3 {
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        T3 t3 = new T3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("请求loc1");

                synchronized (t3.lock1){
                    System.out.println("获得了loc1");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("请求loc2");
                    synchronized (t3.lock2){
                        System.out.println("获得了loc2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("请求loc2");

                synchronized (t3.lock2){
                    System.out.println("获得了loc2");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("请求loc1");
                    synchronized (t3.lock1){
                        System.out.println("获得了loc1");
                    }
                }
            }
        }).start();

        new Thread((Runnable)()->{
            System.out.println("请求lock1");
        }).start();

    }
}
