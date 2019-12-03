package sort;

import utils.ArrayUtils;

/**
 * 自顶向下的归并排序
 * Created by wangchao on 2018/7/11.
 */
public class MergeSort extends Sort {

    public MergeSort(String name) {
        super(name);
    }

    @Override
    public void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        Comparable[] aux = new Comparable[a.length];//一次性分配空间
        sort(a, aux,lo, hi);
    }

    protected void sort(Comparable[] a,Comparable[]aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //不使用(lo+hi)/2这种形式找中点的原因之一是下面这样不会发生（lo+hi）溢出的错误
        int mid = lo + ((hi - lo)>>>1);
        sort(a,aux ,lo, mid);
        sort(a,aux ,mid + 1, hi);
        merge(a,aux, lo, mid, hi);
    }

    //todo
    protected void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);


        //如果已经有序了，直接返回原数组,递归基
        if(!lessThan(a[mid+1],a[mid]))return;
        //
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        //分成p,q前后两个数组。
        for(int i = lo, p = lo, q = mid+1; i <= hi; i++) {
            if (q > hi || p < mid+1 && !lessThan(aux[q],aux[p]))
                //p归队的情况
                //1. q > hi q数组已经为空
                //2. 或者在p不为空（p<mid+1）的前提下，p的首元素小于等于(等于这个条件是为了稳定性)q的寿元素
                a[i] = aux[p++];
            else
                //其他情况全是q
                a[i] = aux[q++];
        }
    }

    public static void main(String[] args) {
        //, "zhang", "san", "li", "si"
        //String[] a = {"wang", "er", "ma", "zi", "zhang", "san", "li", "si"};
//        String[] a = {"zhang", "san", "li", "si"};
        Integer[] a = ArrayUtils.makeArray(200000, 3000);
        Sort sort = new MergeSort("归并排序");
        sort.testSort(a);

    }
}
