import sort.InsertSort;
import sort.SelectSort;
import sort.Sort;
import utils.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Created by wangchao on 2018/5/31.
 */
public class TestSortPerformance {
    @org.junit.Test
    /**
     * 一次测试结果如下
     * 选择排序
     * cost time : 30.0
     * 结果长度为200000,是否输出y/n:
     * 插入排序
     * cost time : 35.0
     * 结果长度为200000,是否输出y/n:
     *
     * 测试结论，insert咋还不如select呢？
     * 因为我这里的insert插入条件为小于插入条件，而这里有大量重复元素，所以多余的事情做的比较多
     * 改为不大于插入条件后，同样的规模下插入就快了，那么，大量重复元素对选择有什么影响呢。没有。
     *
     */
    public void testSelectAndInsert(){
        Integer[] integers = ArrayUtils.makeArray(100000, 1);
        Integer[] integers1 = Arrays.copyOf(integers, integers.length);
        Sort selectSort = new SelectSort("选择排序");
        Sort insertSort = new InsertSort("插入排序");
        String cmd = "n \n";
        InputStream in = System.in;
        try {
            System.setIn(new ByteArrayInputStream(cmd.getBytes()));
            selectSort.testSort(integers);
            System.setIn(new ByteArrayInputStream(cmd.getBytes()));
            insertSort.testSort(integers1);
        } finally {
            System.setIn(in);
        }
    }
    @org.junit.Test
    public void test(){
        new Scanner(System.in).next();
    }
}
