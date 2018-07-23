package sort;

/**
 * 希尔排序
 * Created by wangchao on 2018/7/10.
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        //选择一个递增序列
        int h = 1;
        int l = a.length;
        while (h < l / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //把一种h序子数组排序
            for (int i = h; i < l; i++) {
            //这里j的开始位置不好找，所以不如从后往前找。j==0是不对的
//                for (int j = 0; j < i; j+=h) {
//                    if(lessThan(a[i],a                                                                [j])){
//                        Comparable t=a[i];
//                        for (int k = i; k > j; k-=h) {
//                            a[k] = a[k-h];
//                        }
//                        a[j]=t;
//                        break;
//                    }
//                }
                for(int j=i;j>=h&&lessThan(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        String[] a ={"wang","er","ma","zi","zhang","san","li","si"};
        Sort sort = new ShellSort();
        sort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
