package sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by wangchao on 2018/7/16.
 * 1. 随机选择一个轴点
 * 2. 对轴点进行partition操作（归位操作）
 * 3. 递归对轴点两侧进行partition操作
 */
public class QuickSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        //对数组a洗牌
        //洗牌方法，遍历数组，每次与数组随机（n-current）下标的元素交换
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    //分治递归
    public void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a, lo, partition-1);
        sort(a, partition + 1, hi);
    }

    //分区，让一个元素归位,并返回这个位置下标
    public int partition(Comparable[] a, int lo, int hi) {
        //ridge 山脊
        Comparable ridge = a[lo];
        int i = lo;
        //这里+1是配合后面的--j
        int j = hi + 1;
        while (true) {
            //这里两个while设置的条件是让基准数左边都是小于轴点候选，右边都是不小于轴点候选
            //从左向右找到第一个大于轴点的元素位置i
            while (lessThan(a[++i], ridge)) {
                if (i == hi) {
                    break;
                }
            }
            //从右向左找到第一个小于轴点的元素位置j
            while (!lessThan(a[--j], ridge)) {
                if (j == lo) {
                    break;
                }
            }
            //当i>=j，说明数组已经按基准数左右划分完
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        //这里换基准数和j，因为最后j停在一个比基准数小的数上，并且此时，数组有序
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        new QuickSort().sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
