package sort;

/**
 * @author wangchao
 * @date 2019/12/2 - 10:10 上午
 */
public class MergeSortBU extends MergeSort {
    public MergeSortBU(String name) {
        super(name);
    }

    /**
     * TODO
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    @Override
    protected void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        for (int sz = 1; sz <= hi-lo; sz += sz) {
        }
        super.sort(a, aux, lo, hi);
    }
}
