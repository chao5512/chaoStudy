package jvm;

import javax.sound.midi.Soundbank;
import java.util.Vector;

/**
 * 绝对线程安全，绝对的意思是不管运行时环境如何，调用者都不需要任何额外的同步措施
 * 看下vector
 * Created by wangchao on 2018/5/21.
 */
public class T11 {
    static Vector v =new Vector();

    public static void main(String[] args) {
        while (true){
            for (int i = 0; i < 10; i++) {
                v.add(i);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < v.size(); i++) {
                        v.remove(i);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < v.size(); i++) {
                        System.out.println(v.get(i));
                    }
                }
            }).start();

            while (Thread.activeCount()>20){
                System.exit(0);
            }

        }

    }
}
