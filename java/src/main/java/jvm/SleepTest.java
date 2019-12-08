package jvm;

/**
 * @author wangchao
 * @date 2019/12/8 - 11:28 上午
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("I'm here in the thread");
        Thread.sleep(1000000);
    }
}
