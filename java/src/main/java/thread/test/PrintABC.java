package thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



/**
 * Created by wangchao on 2018/9/24.
 */
public class PrintABC {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condA = lock.newCondition();
    private static final Condition condB = lock.newCondition();
    private static final Condition condC = lock.newCondition();
    private static String flag = "A";

    public static void printA(){
        lock.lock();
        try {
            while (!flag.equals("A")){
                condA.await();
            }
            System.out.println(Thread.currentThread().getName());
            flag = "B";
            condB.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void printB(){
        lock.lock();
        try {
            while (!flag.equals("B")){
                condB.await();
            }
            System.out.println(Thread.currentThread().getName());
            flag = "C";
            condC.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void printC(){
        lock.lock();
        try {
            while (!flag.equals("C")){
                condC.await();
            }
            System.out.println(Thread.currentThread().getName());
            flag = "A";
            condA.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        Runnable rA = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printA();
                }
            }
        };
        Runnable rB = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printB();
                }
            }
        };
        Runnable rc = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printC();
                }
            }
        };
        new Thread(rA,"a").start();
        new Thread(rB,"b").start();
        new Thread(rc,"c").start();
    }
}
