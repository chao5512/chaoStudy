package thread.TreadsAndExecutors;

/**
 * Created by wangchao on 2018/5/29.
 */
public class Threads {
    public static void main(String[] args) {
        Runnable task =()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("done!");
    }
}
