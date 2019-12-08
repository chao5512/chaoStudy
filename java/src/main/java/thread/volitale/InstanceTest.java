package thread.volitale;

import java.util.concurrent.TimeUnit;

import lab.T;

/**
 * 测试volitale修饰的对象是否保证原子性
 * 运行结果
     线程A:a=1
     a = 2b = 2
     a = 2b = 2
     线程A:b=1
     a = 2b = 1
     a = 2b = 1
 * 结论，volatile不保证对象的原子性
 * Created by wangchao on 2019/7/10.
 */
public class InstanceTest {
    private static volatile   O o = new O();
    public static void main(String[] args) {
        //线程A,set a= 1,2s后 set b = 1
        new Thread(()->{
            o.a = 1;
            System.out.println("线程A:a=1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.b = 1;
            System.out.println("线程A:b=1");

        }).start();
        //线程B，set a= 2,b=2
        new Thread(()->{
            o.a = 2;
            o.b = 2;
        }).start();
        //线程C，每1s读取一次a，b值
        new Thread(()->{
            while (true){
                System.out.println("a = " + o.a + "b = " + o.b);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    static class O {
        int a = 0;
        int b = 0;
    }
}
