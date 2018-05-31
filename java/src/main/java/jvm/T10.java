package jvm;

/**
 * -server -XX:+DoEscapeAnalysis -XX:+EliminateLocks
 * -server -XX:+DoEscapeAnalysis -XX:-EliminateLocks
 * Created by wangchao on 2018/5/16.
 */
public class T10 {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            creatString("wang","chao");
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }
    public static String creatString(String s1,String s2){
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}
