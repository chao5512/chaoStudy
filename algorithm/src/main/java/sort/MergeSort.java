package sort;

/**
 * 自顶向下的归并排序.
 * Created by wangchao on 2018/7/11.
 */
public class MergeSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        Comparable[] aux = new Comparable[a.length];//一次性分配空间
        sort(a, aux,lo, hi);
    }

    private void sort(Comparable[] a,Comparable[]aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo)>>>1);
        sort(a,aux ,lo, mid);
        sort(a,aux ,mid + 1, hi);
        merge(a,aux, lo, mid, hi);
    }

    //todo
    private void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        //如果已经有序了，直接返回原数组
        if(lessThan(a[mid],a[mid+1]))return;
        //
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        for(int i = lo, p = lo, q = mid+1; i <= hi; i++) {
            if (q > hi || p < mid+1 && lessThan(aux[p],aux[q]))
                a[i] = aux[p++];
            else
                a[i] = aux[q++];
        }
    }

    public static void main(String[] args) {
        //, "zhang", "san", "li", "si"
        String[] a = {"wang", "er", "ma", "zi", "zhang", "san", "li", "si"};
//        String[] a = {"zhang", "san", "li", "si"};
        Sort sort = new MergeSort();
        sort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
