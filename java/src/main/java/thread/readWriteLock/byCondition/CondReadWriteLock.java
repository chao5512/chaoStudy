package thread.readWriteLock.byCondition;

import thread.readWriteLock.ReadWriteLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo condition练习
 * @author wangchao
 * @date 2019/12/4 - 10:59 下午
 */
public class CondReadWriteLock implements ReadWriteLock {
    final Lock lock = new ReentrantLock();
    static volatile AtomicInteger readCount = new AtomicInteger(0);
    final Condition noRead = lock.newCondition();
    final Condition noWrite = lock.newCondition();
    @Override
    public void readLock() {
        try {
            noWrite.await();
            readCount.getAndIncrement();
        } catch (InterruptedException e) {
            System.out.println("读锁请求被中断");
            e.printStackTrace();
        }
    }

    @Override
    public void readUnLock() {

    }

    @Override
    public void writeLock() {
        try {
            noRead.await();
            noWrite.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeUnLock() {

    }
}
