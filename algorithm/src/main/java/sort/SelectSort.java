package sort;

import edu.princeton.cs.algs4.In;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * 内循环从剩余元素中选出最小的元素
 * 外循环交换元素值到正确位置
 * Created by wangchao on 2018/7/9.
 */
public class SelectSort extends Sort{
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (lessThan(a[j], a[i])) {
                    exch(a, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {

        String[] a ={"wang","er","ma","zi",};
        Sort sort = new SelectSort();
        sort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
