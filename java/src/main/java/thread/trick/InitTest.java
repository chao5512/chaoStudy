package thread.trick;

/**
 * Created by wangchao on 2018/5/30.
 */
public class InitTest {
    public static void main(String[] args) {
        //直接用Thread(){};new一个子类对象
        new Thread("thread-1"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        //传入runnable和thread子类都存在的时候会走哪个
        new Thread(()->{
            System.out.println("Runnable"+Thread.currentThread().getName());
        },"thread-runnable"){
            @Override
            public void run() {
                System.out.println("子类"+Thread.currentThread().getName());
            }
        }.start();
    }
}
