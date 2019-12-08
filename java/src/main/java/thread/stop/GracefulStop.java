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
        //2. 提交业务
        StoppableThread stoppableThread = new StoppableThread(work);
        new Thread(stoppableThread).start();
        TimeUnit.SECONDS.sleep(3);
        //3. 3秒后停止业务
        stoppableThread.shutdown();
    }

    static class StoppableThread implements Runnable{
        public volatile boolean stopped = false;
        private Runnable work;

        public StoppableThread(Runnable work) {
            this.work = work;
        }

        @Override
        public void run() {
            new Thread(()->{
                //真正的工作线程--
                Thread worker = new Thread(work);
                worker.setDaemon(true);
                worker.start();
                //真正的工作线程--
                while (!stopped){
                    try {
                        System.out.println("我还跑着呢");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public void shutdown(){
            stopped = true;
        }
    }
}
