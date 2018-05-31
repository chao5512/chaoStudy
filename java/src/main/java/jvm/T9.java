package jvm;

import java.util.Vector;

/**
 * 不使用
 * -XX:+UseBiasedLocking
 * 使用，jvm虽然默认启用了偏向锁，但是在jvm刚启动的时候，竞争比较激烈，所以偏向锁延后启动
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 * Created by wangchao on 2018/5/16.
 */
public class T9 {
    public static Vector v = new Vector();

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count<10000000){
            v.add(startnum);
            startnum+=2;
            count++;
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

    }
}
