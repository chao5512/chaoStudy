package string;

/**
 * Created by wangchao on 2018/7/4.
 */
public class KMPSearch {
    //根据待匹配的串p制前缀表
    public static int[] prefixTable(String p) {
        int[] prefixTable = new int[p.length()];
        prefixTable[0] = 0;
        //模式串的前缀和后缀相等的最大长度
        int len = 0;
        int i = 1;
        //从前向后遍历，计算前缀表的值。
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                prefixTable[i] = ++len;
                i++;
            } else {
                prefixTable[i] = 0;
                i++;
                len = 0;
            }
        }
        return prefixTable;
    }

    public static int search(String p, String t) {
        //拿到前缀表
        int[] prefixTable = prefixTable(p);
        int i = 0;
        int j = 0;
        while (i < t.length()){
            if(t.charAt(i)==p.charAt(j)){
                //当t和p当前指向的值相等的时候，比较后一位
                i++;
                j++;
            }else {
                //出现不相等的情况，按前缀表j-1指向的值移动j
                if(j==0){
                    i++;
                }else{
                    j=prefixTable[j-1];
                }
            }
            if(j==p.length()-1){
                return i-j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String t = "cabaaaaabaa";
        String p = "aaaaabaa";
        int[] prefix = prefixTable(p);
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i]+" ");
        }
        System.out.println();

        System.out.println(search(p,t));

    }
}
