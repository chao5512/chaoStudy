package thread.book.communication.test1;

/**
 * 子线程循环10次,紧接着主线程循环100次，来回50次
 * Created by wangchao on 2018/6/4.
 */
public class CommunicateTest1 {
    public static void main(String[] args) {
        TestTarget testTarget = new TestTarget();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                testTarget.sub(i);
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            testTarget.main(i);
        }
    }
}
