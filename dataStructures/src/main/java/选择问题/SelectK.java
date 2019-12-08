package 选择问题;

/**
 * 选出N个数中最大的K个数
 * Created by wangchao on 2018/6/5.
 */
public class SelectK {
    public static int[] soulution1(int[] a,int k){
        int[] ks = new int[k];
        //排序
        //选出最大的k个数
        return ks;
    }

    public static int[] soulution2(int[] a,int k){
        int[] ks = new int[k];
        for (int i : ks) {
            ks[i] = a[i];
        }
        //对ks排序，让最小的始终位于0位置
        for (int i = k; i < a.length; i++) {
            for(int target : ks){
                if(a[i]>=ks[i]){
                    ks[0] = ks[i];
                    ks[i] = a[i];
                }
            }
        }
        return ks;
    }
}
