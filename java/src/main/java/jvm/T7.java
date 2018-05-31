package jvm;

/**
 * Created by wangchao on 2018/5/16.
 */
public class T7 {
    public static class ThreadSleep implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 栈空间溢出
     * -Xmx1g -Xss1m
     * java.lang.OutOfMemoryError: unable to create new native thread
     * 解决方法：
     *  1.减少堆空间
     *  2.增大栈空间
     */
    public static void main(String args[]){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"M");
        for (int i = 0; i < 10000; i++) {
            new Thread(new T6.ThreadSleep(),"Thread"+i).start();
            System.out.println("thread" +i+"启动");
        }
    }
}
