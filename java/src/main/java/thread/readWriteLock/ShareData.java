package thread.readWriteLock;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchao
 * @date 2019/12/4 - 11:29 下午
 */
public class ShareData {
    private final ReadWriteLockImpl lock = new ReadWriteLockImpl();
    private final char[] data;

    public ShareData(int size) {
        this.data = new char[size];
        for (int i = 0; i < size; i++) {
            data[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        char[] d = new char[data.length];
        try {
            lock.readLock();
            for (int i = 0; i < data.length; i++) {
                d[i] = data[i];
                slowly(1);
            }

        }finally {
            lock.readUnLock();
        }
        return d;
    }

    private void slowly(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(char[] c) throws InterruptedException {
        try {
            lock.writeLock();
            for (int i = 0; i < c.length; i++) {
                data[i] = c[i];
                slowly(1);
            }
        }finally {
            lock.writeUnLock();
        }
    }

    public int getWaitingReadCount(){
        return lock.wattingReader;
    }
}
