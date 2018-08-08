package sort;

/**
 * 自顶向下的归并排序.
 * Created by wangchao on 2018/7/11.
 */
public class MergeSort extends Sort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        aux = new Comparable[a.length];//一次性分配空间
        sort(a, aux,lo, hi);
    }

    private void sort(Comparable[] a,Comparable[]aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a,aux ,lo, mid);
        sort(a,aux ,mid + 1, hi);
        merge(a,aux, lo, mid, hi);
    }

    //todo
    private void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        int k = lo;
        if (lo >= hi) {
            return;
        }
        while (k<=hi){
            if (i > mid) {
                a[k++]=aux[j++];
            } else if (j > hi) {
                a[k++] = aux[i++];
            } else if (lessThan(aux[i], aux[j])) {
                a[k++] = aux[i++];
            } else{
                a[k++] = aux[j++];
            }
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