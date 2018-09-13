package sort;

/**
 * Created by wangchao on 2018/9/13.
 *  Time Complexity -> O(n^2);
 *  Memory Complexity -> O(1);
 *  never use this
 */
public class BubbleSort extends Sort{

    @Override
    public void sort(Comparable[] a) {
        if(null==a||a.length<2){
            return;
        }
        int hi = a.length-1;
        for(int i = 1;i<hi;i++){
            boolean isSorted = true;
            int temphi = hi;
            for(int j = i-1;j<hi-i;j++){
                if(lessThan(a[j++],a[j])){
                    exch(a,j++,j);
                    isSorted = false;
                    temphi = j;
                }
            }
            hi = temphi;
            if(isSorted)break;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        new BubbleSort().sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
