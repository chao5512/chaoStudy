package jvm.gc;

/**
 * Created by wangchao on 2019/11/22.
 */
public class PretenureTest {
    static final int size = 1024*1024;

    public static void main(String[] args) {
        //这里用int数组的话直接超过老年代的10m大小
        //int[] oneAlloc = new int[5 * size];
        byte[] anotherAlloc = new byte[5 * size];
        try {
            Thread.sleep(1000000);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
