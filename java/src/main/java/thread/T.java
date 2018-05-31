package thread;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字变量保证线程之间的可见性
 * Created by wangchao on 2018/4/16.
 */
public class T {
    public static /*volatile*/ boolean stopFlag;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopFlag){
                   i++;
                    System.out.println(i++);
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopFlag = true;
    }
}
