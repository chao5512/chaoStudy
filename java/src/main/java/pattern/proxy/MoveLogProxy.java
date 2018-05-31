package pattern.proxy;

/**
 * Created by wangchao on 2018/3/7.
 */
public class MoveLogProxy implements Movealbe{
    private Movealbe m;

    public MoveLogProxy(Movealbe m) {
        this.m = m;
    }

    public void move() {
        System.out.println("起跑时间："+System.currentTimeMillis()/1000);
        m.move();
        System.out.println("停止时间："+System.currentTimeMillis()/1000);
    }
}
