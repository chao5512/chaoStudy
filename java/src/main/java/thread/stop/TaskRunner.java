package thread.stop;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangchao on 2019/7/17.
 */
public class TaskRunner {
    protected final BlockingDeque<Runnable> channel;
    protected volatile Thread workerThread;

    public TaskRunner(BlockingDeque<Runnable> channel) {
        this.channel = channel;
        this.workerThread = new WorkerThread();
    }

    public TaskRunner() {
        this(new LinkedBlockingDeque<Runnable>());
    }

    public WorkerThread getWorker(){
        return (WorkerThread) workerThread;
    }
    public void init(){
        final Thread t = workerThread;
        if(null != t){
            t.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        channel.put(task);
    }

    class WorkerThread extends Thread{
        @Override
        public void run() {
            Runnable task = null;
            try{
                for(;;){
                    task = channel.take();
                    try{
                        task.run();
                    }catch (Throwable e){
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
