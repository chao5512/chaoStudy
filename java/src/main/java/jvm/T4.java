package jvm;


/**
 * VM option：-Xmx20m -Xms20m -Xmn1m -XX:+PrintGCDetails
 * Created by wangchao on 2018/5/4.
 */
public class T4 {
    private final static int _1M=1*1024*1024;
    public void t1() {
        byte[] b=null;
        //这里触发了新生代GC好多次，不科学
        System.out.println("分配了4个1M，但是新生区小于1M，所以全部分配在老年代");
        for (int i = 0; i < 4; i++) {
//            b=new byte[_1M];
        }
    }
}
