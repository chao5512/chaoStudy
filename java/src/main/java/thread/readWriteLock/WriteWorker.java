package thread.readWriteLock;

/**
 * @author wangchao
 * @date 2019/12/5 - 12:20 上午
 */
public class WriteWorker extends Thread {
    ShareData shareData ;
    char[] chars;

    public WriteWorker(ShareData shareData, char[] chars) {
        this.shareData = shareData;
        this.chars = chars;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName()+ "申请写锁");
                shareData.write(chars);
                System.out.println(Thread.currentThread().getName()+ "完成一次写");
                System.out.println("waiting reader count : " + shareData.getWaitingReadCount());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
