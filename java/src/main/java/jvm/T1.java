package jvm;

/**
 * Created by wangchao on 2018/5/4.
 */
public class T1 {
    /**
     * 打印整数的二进制表示
     */
    public void test(){
        int a = -6;
        for (int i = 0; i < 32; i++) {
            int t = (a&0x80000000>>>i)>>>(31-i);
            System.out.print(t);
        }
        System.out.println();
    }
}
