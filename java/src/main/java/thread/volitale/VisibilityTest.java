package thread.volitale;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 测试volitale的可见性
 * Created by wangchao on 2019/7/10.
 */
public class VisibilityTest {
// 不加volatile修饰的共享变量，cpu在空闲时也是回去内存中去同步共享变量的，只是不那么及时
//    public static  int[] ints = new int[5];
    //加volatile修饰后，写入会刷回内存，读取会从内存中拉取
    public static volatile int[] ints = new int[5];

    /*
    测试不使用volitale关键字时，cpu何时去内存中pull共享变量
     */
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            //线程A
            try {
                System.out.println("thread-a");
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ints[0] = 2;
        }).start();
        new Thread(() -> {            //线程B
            while (true) {
                if (ints[0] == 2) {
                    System.out.println("结束");
                    break;
                }
                //1.System.out.pringln()源码中有synchronized关键字，
                // 是很耗时的，这时候cpu就有空去刷新int[0]的值到主存了。
//                System.out.println("未能同步数组的相对新值");

                //2.加try-catch也是一个耗时操作，同上
//                try {
//                    Thread.sleep(1);
////                    System.out.println("未能同步数组的相对新值");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        }).start();
    }
}
