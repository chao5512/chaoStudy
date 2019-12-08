package thread.readWriteLock;

import java.util.Optional;
import java.util.SimpleTimeZone;

/**
 * @author wangchao
 * @date 2019/12/5 - 12:01 上午
 */
public class ReadWriteClient {

    public static void main(String[] args) {
        ShareData shareData = new ShareData(2);
        new Thread(new ReadWorker(shareData),"读1").start();
        new Thread(new ReadWorker(shareData),"读2").start();
        new Thread(new ReadWorker(shareData),"读3").start();
        new Thread(new ReadWorker(shareData),"读4").start();

        new Thread(new WriteWorker(shareData,new char[]{'1','2'}),"写1").start();
        new Thread(new WriteWorker(shareData,new char[]{'7','8'}),"写2").start();
    }

    void consumer(char[] c){
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
}
