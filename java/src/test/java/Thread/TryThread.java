package Thread;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author wangchao
 * @date 2019/12/8 - 7:44 下午
 */
public class TryThread {
    @Test
    public void tryInit1(){
        Thread thread = new Thread();
        thread.start();
    }

    @Test
    public void tryInitWithStackSize() {
        Thread thread = new Thread(null, () -> {
            System.out.println(Thread.currentThread().getStackTrace());
            byte[] bytes = new byte[1024 * 1024 * 20];
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-with-stackSize", 10);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tryDefaultThreadGroup() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        ThreadGroup threadGroup = thread.getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
    }

    @Test
    public void tryDaemonThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                while (true) {
                    System.out.println("inner-thread");
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //innerThread.setDaemon(true);
            innerThread.start();
            while (true){
                System.out.println("daemon-thread");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //daemon线程随着应用线程的消亡而消亡
        });
        //thread.setDaemon(true);
        thread.start();
        Thread.sleep(10_000);
        System.out.println("main");
    }
}
