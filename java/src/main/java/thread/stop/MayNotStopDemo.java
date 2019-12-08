package thread.stop;

/**
 * Created by wangchao on 2019/7/17.
 */
public class MayNotStopDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskRunner t = new TaskRunner();
        t.init();
        t.submit(() -> {
            System.out.println("before task running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //什么也不做，但是这里吞掉了中端标志位
            }
            System.out.println("after task running");
        });
        //此时尝试中断线程，不起作用
        t.workerThread.interrupt();
    }
}
