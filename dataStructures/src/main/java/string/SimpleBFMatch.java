package string;

/**
 * Created by wangchao on 2018/7/4.
 */
public class SimpleBFMatch {
    public static int match(String target,String pattern){
        //参数合法检查
        if(target==null&&pattern==null&&target.length()<pattern.length()){
            return -1;
        }
        int start = 0;
        int count = 0;
        int tpos = 0;
        int ppos = 0;
        int plength = pattern.length();
        //只要target上的指针还没有走到target.length()-pattern.length()+1,就继续寻找
        while (start < target.length()-pattern.length()+1){
            //比较target和patten的一位，相等target和pattern的指针后移
            if(target.charAt(start+count)==pattern.charAt(count)){
                count += 1;
            }else{
                //如果不相等，target指针后移一位，pattern指针重置
                start += 1;
                count = 0;
            }
            //当整个pattern比较完成了，返回target和patter串头对齐的位置
            if(plength == count){
                return start;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String t = "asdfasdfbcdd";
        String p = "cdd";

        System.out.println(match(t,p));
    }
}
