package thread.TreadsAndExecutors;


import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangchao on 2018/5/29.
 */
public class Executors {
    ExecutorService executorService;
    @Before
    public void init(){
        executorService = java.util.concurrent.Executors.newSingleThreadExecutor();
    }
    @Test
    public void testInit() {
        executorService.submit(()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
    }

    /**
     * 线程池并不会自己关闭。ExecutorService提供两个方法：
     shutdown():等待当前运行的线程结束。
     shutdownNow():立即中断所有线程并关闭线程池。
     */
    @Test
    public void testShutDown(){
        try {
            System.out.println("attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
