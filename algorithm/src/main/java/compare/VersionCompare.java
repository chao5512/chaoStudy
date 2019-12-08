package compare;

/**
 * Created by wangchao on 2018/7/17.
 */
public class VersionCompare {
    /**
     *v1和v2比较
     * 若v1较大,返回值大于零
     * 若v1 v2相等，返回0
     * 若v1较小，返回值小于零
     */
    public int compare(String v1,String v2){
        int len1 = v1.length();
        int len2 = v2.length();
        int min = Math.min(len1,len2);
        if(min<=0){
            throw new IllegalArgumentException("版本号长度不合法");
        }
        int k = 0;
        char t = '.';
        while (k < min) {
            char c1 = v1.charAt(k);
            char c2 = v2.charAt(k);
            if (c1 != c2) {
                //v1和v2谁先到.谁的版本号比较小
                if(c1==t){
                    return -1;
                }else if (c2==t){
                    return 1;
                }
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
    public static void main(String[] args) {
        VersionCompare vc = new VersionCompare();
        int c1 = vc.compare("1.2.3b", "1.2.3");
        int c2 = vc.compare("1.2.3a", "1.2.4b");
        int c3 = vc.compare("1.2.4a", "1.2.3b");
//        int c4 = vc.compare("1.2.4a", "");
        int c5 = vc.compare("1.2.4a", "1.2.4b");
        int c6 = vc.compare("1.2.4b", "1.2.4b");
        int c7 = vc.compare("1", "1.2.6");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
//        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
    }
}
