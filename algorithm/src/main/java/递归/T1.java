package 递归;

/**
 * 递归1
 * Created by wangchao on 2018/5/23.
 */
public class T1 {
    public static String t1(int n){
        if(n<=0)return "";
        return t1(n-3)+6+t1(n-2)+6;
    }
    public static void main(String[] args) {
        System.out.println(t1(6));
    }
}
