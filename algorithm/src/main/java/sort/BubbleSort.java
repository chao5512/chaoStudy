package sort;

/**
 * Created by wangchao on 2018/9/13.
 *  Time Complexity -> O(n^2);
 *  Memory Complexity -> O(1);
 *  never use this
 *  优化进程
 *  1、
 *  2、
 *  3
 */
public class BubbleSort extends Sort{

    @Override
    public void sort(Comparable[] a) {
        if(null == a || a.length < 2){
            return;
        }
        int hi = a.length-1;
        for(int i = 0 ; i < hi ; ){
            //循环中任意一次遍历未产生任何元素交换，即排序已经完成了
            boolean isSorted = true;
            int temphi = hi;
            for(int j = 0;j<hi;j++){
                if(lessThan(a[j+1],a[j])){
                    exch(a,j,j+1);
                    isSorted = false;
                    temphi = j;
                }
            }
            hi = temphi;
            if(isSorted)break;
        }
    }

    public static void main(String[] args) {
//        Integer[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        //这种是满足在第二轮比较中没有位置交换，issort标志位为true，跳出排序
//        Integer[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 4};

        //每一轮比较发生位置交换的位置靠前，无序数组的下标直接设置为交换的最后一个元素的下标
        Integer[] ints = {1, 1, 0, 2, 3, 3, 4, 4, 4, 4};


        new BubbleSort().sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
