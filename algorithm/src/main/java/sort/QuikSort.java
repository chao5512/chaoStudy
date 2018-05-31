package sort;
import utils.ArrayUtils;

import java.util.Random;

/**
 * Created by wangchao on 2018/4/26.
 */
public class QuikSort {
    public int[] sort(int[] src,int start, int end){
        if(end == start){
            return src;
        }
        int r = new Random().nextInt(end-start) + start;
        System.out.println("r:"+src[r]);
        for (int i = 0; i <= r; i++) {
            if(src[i]>=src[r]){
                for (int j = end; j >= r ; j--) {
                    if(i==j){
                        break;
                    }
                    if(src[j]<src[r]){
                        int tmep = src[i];
                        src[i] = src[j];
                        src[j] = tmep;
                        if(i==r){
                            r=j;
                        }
                        if(j==r){
                            r=i;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i]+",");
        }
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new ArrayUtils().makeArray(10, 50);
        new QuikSort().sort(ints,0,ints.length-1);
    }
}
