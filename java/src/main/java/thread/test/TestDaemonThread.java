package thread.test;

/**
 * @author wangchao
 * @date 2019/12/8 - 10:22 下午
 */
public class TestDaemonThread {
    public static void main(String[] args) throws InterruptedException {
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
            //daemon线程中启动的线程默认也是daemon线程
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

        });
        //daemon线程随着应用线程的消亡而消亡
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3_000);
        System.out.println("main");
    }
}
