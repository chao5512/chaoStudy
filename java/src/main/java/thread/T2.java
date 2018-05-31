package thread;

/**
 *想把++操作的非原子性体现出来，未成功
 * Created by wangchao on 2018/4/16.
 */
public class T2 {
    public /*static*/ int i =0;
    int generateSerialNumber(){
        return i++;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        for (int i=1;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println("线程"+Thread.currentThread().getName()+":"+t2.generateSerialNumber());
                    }
                }
            }).start();
        }
    }
}
