package pattern.factory;

import pattern.proxy.Movealbe;

/**
 * Created by wangchao on 2018/3/13.
 */
public class Plane implements Movealbe {
    @Override
    public void move() {
        System.out.println("飞呀！");
    }
}
