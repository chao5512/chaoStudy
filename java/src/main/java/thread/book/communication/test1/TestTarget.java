package thread.book.communication.test1;

/**
 * 面试题
 * 子线程循环10次,紧接着主线程循环100次，来回50次
 * Created by wangchao on 2018/6/4.
 */
public class TestTarget {
    private boolean isSubTurn = true;
    public synchronized void sub(int j){
        //防止伪唤醒
        while (!isSubTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for (int i = 0; i < 2; i++) {
            System.out.println("sub:"+i+"of"+j);
        }
        isSubTurn = false;
        notify();
    }

    public synchronized void main(int j){
        while (isSubTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("main:"+i+"of"+j);
        }
        isSubTurn = true;
        notify();
    }
}
