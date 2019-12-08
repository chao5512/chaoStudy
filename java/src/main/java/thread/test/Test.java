package thread.test;

/**
 * Created by wangchao on 2018/9/24.
 */
public class Test {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        Thread t3 = new Thread(runnable, "t3");

        try {
            t1.start();
            t1.join();
            Thread.sleep(2000);
            t2.start();
            t2.join();
            t3.start();
            t3.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
