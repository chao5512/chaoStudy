package cap1.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * 打印这样规则的数列
 * 斐波那契?
 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
 * Created by wangchao on 2018/5/24.
 */
public class T2 {
    public static void main(String[] args) {
        int f=0;
        int g=1;
        for (int i = 0; i <=15; i++) {
            StdOut.print(f+" ");
            f=f+g;
            g=f-g;
        }
    }
}
