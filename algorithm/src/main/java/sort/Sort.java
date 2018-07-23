package sort;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by wangchao on 2018/7/9.
 */
public abstract class Sort {
    /**
     * 数组是否有序
     */
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a,0,a.length-1);
    }
    public static boolean isSorted(Comparable[] a,int lo,int hi){
        for (int i = lo; i <= hi; i++) {
            if (!lessThan(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 交换索引i,j所指向的元素
     */
    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 排序
     */
    public abstract void sort(Comparable[] a);

    /**
     * v是否小于w
     */
    protected static boolean lessThan(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 打印结果
     */
    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 打印柱状图
     */
    protected static void showDraw(Comparable[] a){
//        StdDraw
    }
}
