package pattern.proxy;

import java.util.Random;

/**
 * Created by wangchao on 2018/3/7.
 */
public class Tank implements Movealbe {
    public void move() {
        System.out.println("tank在移动！");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
