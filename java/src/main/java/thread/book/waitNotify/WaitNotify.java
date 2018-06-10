package thread.book.waitNotify;

import java.util.concurrent.TimeUnit;

/**
 * 等待通知范式
 *
 * 一个小坑，当我调用wait和notify方法时，直接调用的是this的这两个方法，并不是我加锁的lock对象
 * 这是会抛出java.lang.IllegalMonitorStateException异常
 *
 * 第二个坑，生产者生产了产品后，通知等待在lock上的消费者，消费者却一直还在waitting状态
 * 这是因为我在notify线程中的逻辑错误，导致notify()方法没有机会被调用
 * if(share>0){
 lock.notifyAll();
 }
 share++;
 * Created by wangchao on 2018/6/6.
 */
public class WaitNotify {
    //共享变量
    private static int share;
    //锁
    private static Object lock = new Object();
    static class Wait implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized(lock) {
                    while (share <= 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    share--;
                    System.out.println("消费者消费了一个产品，现在产品有："+share);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("消费者休息1秒钟");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Notify implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    share++;
                    lock.notifyAll();
                    System.out.println("生产者生产了一个产品,现在产品有："+share);
                }
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("生产者休息2秒钟");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new Wait(),"消费者").start();
        System.out.println("消费者等待产品。。。");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒钟以后，生产者生产了一个产品并通知消费者。。。");
        new Thread(new Notify(),"生产者").start();

    }
}
