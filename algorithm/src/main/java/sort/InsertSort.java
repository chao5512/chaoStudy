package sort;

/**
 * 插入排序.
 * 索引左边的元素已经有序
 * 索引的元素插入左边的元素序列的合适位置
 * Created by wangchao on 2018/7/9.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
// In case of an almost sorted small array, use this
// swapping and shifting are the same complexity , takes constant time
public class InsertSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int hi = a.length;
        for (int i = 1; i < hi; i++) {
            int j=i-1;
            Comparable t = a[i];
            while (j>=0&&a[j].compareTo(t)>0){
                a[j+1]=a[j];
                j--;
            }
            if(j!=i-1){
                a[j+1]=t;
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
