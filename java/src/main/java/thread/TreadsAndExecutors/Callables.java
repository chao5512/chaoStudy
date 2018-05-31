package thread.TreadsAndExecutors;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.Executors;

/**
 * Created by wangchao on 2018/5/29.
 */
public class Callables {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    @Test
    public void testCallable(){
        int call = 0;
        Callable<Integer> task = ()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
                return 123;
            }catch (InterruptedException e){
                throw new IllegalStateException("task interrupted", e);
            }
        };
//        new Thread(task)
        try {
            call = task.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(call);
    }
}
