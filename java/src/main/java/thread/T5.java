package thread;

import java.util.concurrent.TimeUnit;

/**
 * 指令重排序对线程的影响,然而并没有体现出来
 * Created by wangchao on 2018/4/17.
 */
public class T5 {
    int a = 0;
    boolean flag = false;
    public static void main(String[] args) {
        T5 t5 = new T5();
        new Thread((Runnable)()->{
            t5.a = 1;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t5.flag = true;
        }).start();

        new Thread((Runnable)()->{
            if(t5.flag){
                System.out.println(t5.a);
            }
        }).start();
    }
}
