package jvm;

/**
 * 栈上分配
 * -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
 * Created by wangchao on 2018/5/4.
 */
public class T2 {
    public static void alloc(){
        byte[] bytes = new byte[2];
        bytes[0] = 1;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
