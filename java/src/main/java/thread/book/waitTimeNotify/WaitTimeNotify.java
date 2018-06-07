package thread.book.waitTimeNotify;

import java.util.concurrent.TimeUnit;

/**
 * 等待通知范式+超时机制
 * Created by wangchao on 2018/6/6.
 */
public class WaitTimeNotify {
    //超时时间
    private static int waitTime = 4000;
    //共享变量
    private static int share;
    //锁
    private static Object lock = new Object();
    static class Wait implements Runnable{

        @Override
        public void run() {
                synchronized(lock) {
                    long expectFutrue = System.currentTimeMillis()+waitTime;
                    long remaining = waitTime;
                    while (share <= 0&&remaining>0){
                        try {
                            lock.wait(remaining);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        long future = System.currentTimeMillis();
                        remaining = expectFutrue-future;
                    }
                    if(remaining<0){
                        System.out.println("等待超时了");
                        System.out.println("超时处理");
                    }else{
                        share--;
                        System.out.println("消费者消费了一个产品，现在产品有："+share);
                    }
                }
            }
    }
    static class Notify implements Runnable{

        @Override
        public void run() {
                synchronized (lock){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("生产者生产消耗时间2秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    share++;
                    lock.notifyAll();
                    System.out.println("生产者生产了一个产品,现在产品有："+share);
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
