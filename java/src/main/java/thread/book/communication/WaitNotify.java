package thread.book.communication;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by wangchao on 2018/6/4.
 */
public class WaitNotify {
    public static boolean flag = false;
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                if(!flag){
                    try {
                        System.out.println("thread-wait:调用wait前"+Thread.currentThread().getState().name());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag="+flag+",但是notify线程已经完成了唤醒sleep线程的任务");
                System.out.println("注意上面两句话的输出顺序");
            }
        },"thread-sleep").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                int noThreads = threadGroup.activeCount();
                Thread[] lstThreads = new Thread[noThreads];
                threadGroup.enumerate(lstThreads);
                for (int i = 0; i < noThreads; i++) System.out.println("thread-wait被唤醒之前。线程号：" + i + " = " + lstThreads[i].getName()+"：线程状态："+lstThreads[i].getState().name());
                System.out.println("thread-notify：睡了2秒后开始唤醒lock上wait的线程");
                lock.notify();
            }
            /*
            调用notify方法之前需要先获得锁，不然会报这个错
            java.lang.IllegalMonitorStateException
             */
//            lock.notify();

        },"thread-notify").start();
    }
}
