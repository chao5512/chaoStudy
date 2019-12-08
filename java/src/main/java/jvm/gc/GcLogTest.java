package jvm.gc;

/**
 * Created by wangchao on 2019/11/22.
 -verbose:gc
 -Xms20M
 -Xmx20M
 -Xmn10M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8
 观察 [a,b]的不同组合 gc的情况
 [2,3]: minorGC
 [3,3]: ninorGC+FullGC
 */
public class GcLogTest {
    public static void main(String[] args) {
        int b = 2;
        int c = 2;
        int size = 1024 * 1024;
        byte[] myAllocl = new byte[2 * size];
        byte[] myAlloc2 = new byte[b * size];
        byte[] myAlloc3 = new byte[c * size];
        //对应直接分配到老年代，[b,c]为[2, 2]
        //byte[] myAlloc4 =  new byte[ 3*size];
        System.out.println("hello world");
    }
}
