package thread.readWriteLock;

/**
 * @author wangchao
 * @date 2019/12/4 - 11:17 下午
 */
public class ReadWriteLockImpl{
    protected int wattingReader = 0;
    protected int readingReader = 0;
    protected int wattingWriter = 0;
    protected int writtingWriter = 0;
    protected boolean preferWriter = false;

    public synchronized void readLock() throws InterruptedException {
        wattingReader++;
        while (writtingWriter > 0 || (preferWriter && wattingWriter > 0)){
            wait();
        }
        wattingReader--;
        readingReader++;
    }


    public synchronized void readUnLock() {
        readingReader--;
        notifyAll();
    }


    public synchronized void writeLock() throws InterruptedException {
        wattingWriter++;
        while (readingReader > 0 || writtingWriter > 0 ){
            wait();
        }
        wattingWriter--;
        writtingWriter++;
    }


    public synchronized void writeUnLock() {
        writtingWriter--;
        notifyAll();
    }
}
