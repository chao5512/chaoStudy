package thread;

import org.junit.Test;

/**
 * Created by wangchao on 2017/10/30.
 */
public class Print {
    private static int n = 1;
    private static int flag = 1;
    //if(flag!=1)会丢失数据。
    @Test
    public void test() {
        final Print lock = new Print();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock){

                        while(flag != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + n++);
                        }
                        flag = 2;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock){

                        while (flag != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + n++);
                        }
                        flag = 3;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程2").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock){

                        while (flag != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + n++);
                        }
                        flag = 1;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程3").start();


    }
}
