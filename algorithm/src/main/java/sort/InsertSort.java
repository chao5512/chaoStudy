package sort;

/**
 * 插入排序.
 * 索引左边的元素已经有序
 * 索引的元素插入左边的元素序列的合适位置
 * Created by wangchao on 2018/7/9.
 */
public class InsertSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        Comparable t;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(lessThan(a[i],a[j])){
                    //i元素插入j的位置，j右面的元素后移一位
                    t = a[i];
                    for (int k = i; k > j; k--) {
                        a[k] = a[k-1];
                    }
                    a[j] = t;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] a ={"wang","er","ma","zi","zhang","san","li","si"};
        Sort sort = new InsertSort();
        sort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
