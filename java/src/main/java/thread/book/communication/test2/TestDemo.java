package thread.book.communication.test2;

import sun.security.provider.SHA;

/**
 * 线程间共享数据
 * Created by wangchao on 2018/6/5.
 */
public class TestDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    shareData.increment(Thread.currentThread().getName());
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    shareData.decrement(Thread.currentThread().getName());
                }
            }).start();
        }

    }
}
