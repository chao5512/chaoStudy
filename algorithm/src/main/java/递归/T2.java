package 递归;

/**
 * recursive
 * 递归出口无效（因为根本没走到），导致栈空间溢出
 * Created by wangchao on 2018/5/23.
 */
public class T2 {
    public static String t1(int n){
        String s = t1(n-3)+6+t1(n-2)+6;
        if(n<=0)return "";
        return s;
    }

    public static void main(String[] args) {
        System.out.println(t1(6));
    }
}
