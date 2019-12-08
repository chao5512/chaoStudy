package thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * 使用守护线程的方式优雅的停掉线程
 * 1. 若需要等待已经开始的线程完成，可以增加一个原子的任务count，只有count为0了才会从while循环中退出
 *
 * @author wangchao
 * @date 2019/12/8 - 11:54 下午
 */
public class GracefulStop {
    public static void main(String[] args) throws InterruptedException {
        //1. 业务逻辑
        Runnable work = () -> {
            while (true){
                System.out.println("real 业务逻辑");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable fastwork = ()->{
            System.out.println("real业务开始");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("real业务结束");
        };
        //2. 提交业务
        StoppableThread stoppableThread = new StoppableThread();
        stoppableThread.execute(fastwork);

        //3. 超时后停止业务
        stoppableThread.shutdown(2000);
    }

    static class StoppableThread{
        public volatile boolean stopped = false;
        public volatile boolean hasFinished = false;
        private Thread outerThread ;

        public void execute(Runnable task) {
            outerThread = new Thread(()->{
                //真正的工作线程--
                Thread worker = new Thread(task);
                worker.setDaemon(true);
                worker.start();
                //真正的工作线程--
                try {
                    worker.join();
                    hasFinished = true;
                } catch (InterruptedException e) {
                    System.out.println("外层应用线程被打断了！");
                }
            });
            outerThread.start();
        }

        public void shutdown(long timeout){
            long markPoint = System.currentTimeMillis();
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(System.currentTimeMillis()-markPoint<=timeout&&hasFinished){
                    System.out.println("任务完成，停止辅助线程！");
                    stopped = true;
                    outerThread.interrupt();
                    break;
                }else if(System.currentTimeMillis()-markPoint>timeout){
                    System.out.println("任务超时，打断他");
                    stopped = true;
                    outerThread.interrupt();
                    break;
                }
            }
        }
    }
}
