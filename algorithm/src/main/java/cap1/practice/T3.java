package cap1.practice;

/**
 * 整数的二进制表示，并用字符串表示
 * Created by wangchao on 2018/5/24.
 */
public class T3 {
    public static String toBinaryString(int n){
        StringBuffer sb = new StringBuffer();
        while (n>1){
            if(n%2==1){
                sb.append(1);
            }else {
                sb.append(0);
            }
            n/=2;
        }
        sb.append(1);
        return sb.toString();
    }

    /**
     * 更简洁的实现
     * @param n
     * @return
     */
    public static String toBinaryString2(int n){
        String s = "";
        while (n>0){
            s=n%2+s;
            n/=2;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(toBinaryString(10));
        System.out.println(toBinaryString2(10));
    }
}
