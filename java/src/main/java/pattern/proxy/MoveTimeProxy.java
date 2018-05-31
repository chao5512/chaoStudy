package pattern.proxy;

import pattern.InvacationHandler;

import java.lang.reflect.Method;

/**
 * 获得moveable 的move方法的运行时间
 * Created by wangchao on 2018/3/7.
 */
public class MoveTimeProxy implements Movealbe {
    Movealbe m;
    InvacationHandler h;

    public MoveTimeProxy(Movealbe m, InvacationHandler h) {
        this.m = m;
        this.h = h;
    }
    public void move() {
        long startTime = System.currentTimeMillis();
        try {
            Method method = m.getClass().getMethod("move");
            h.invoke(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("跑了："+(stopTime-startTime)/1000+"秒");

    }
}