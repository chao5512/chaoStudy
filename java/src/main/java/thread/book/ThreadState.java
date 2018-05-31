package thread.book;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态
 * jps看进程号
 * jstack分析进程中的线程
 * Created by wangchao on 2018/5/30.
 */
public class ThreadState {
    static class Waiting{};
    public static void main(String[] args) {
        //不停的sleep的线程
        new Thread(()->{while(true) try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        },"TimeWaiting!").start();

        //在waiting.class实例上等待
        new Thread(()->{
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"Waiting!!").start();

        //在waiting.class上加锁后不会释放锁
        new Thread(()->{
            synchronized (Waiting.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"竞争1").start();
        new Thread(()->{
            synchronized (Waiting.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"竞争2").start();
    }
}
