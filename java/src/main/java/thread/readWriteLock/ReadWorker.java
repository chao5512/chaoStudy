package thread.readWriteLock;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchao
 * @date 2019/12/5 - 12:17 上午
 */
public class ReadWorker extends Thread {
    ShareData shareData;

    public ReadWorker(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        try {
            char[] read = null;
            while (true){
                read = shareData.read();
                for (int i = 0; i < read.length; i++) {
                    System.out.print(read[i]);
                }
                System.out.println("waiting read count :" + shareData.getWaitingReadCount());
                slowly(4);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void slowly(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
