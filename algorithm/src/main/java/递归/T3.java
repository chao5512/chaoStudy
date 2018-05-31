package 递归;

import java.util.function.IntBinaryOperator;

/**
 * Created by wangchao on 2018/5/23.
 */
public class T3 {
    public static int t(int a, int b){
        if(b==0)return 0;
        if(b%2==0)return t(a+a,b/2);
        return t(a+a,b/2)+a;
    }

    public static void main(String[] args) {
        System.out.println(t(2,25));
        System.out.println(t(3,11));
    }
}
