package thread.readWriteLock;

/**
 * @author wangchao
 * @date 2019/12/4 - 10:57 下午
 */
public interface ReadWriteLock {
    void readLock();
    void readUnLock();
    void writeLock();
    void writeUnLock();

}
