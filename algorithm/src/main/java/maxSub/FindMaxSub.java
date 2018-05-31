package maxSub;

import java.util.Random;

/**
 * Created by wangchao on 2018/4/19.
 */
public abstract class FindMaxSub {
    abstract int maxSub(int[] A, int start, int end);
    public int[] makeArray(int length , int bound){
        if(length<=0||bound==0){
            System.out.println("参数非法");
            return null;
        }
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            a[i] = random.nextInt()%bound;
        }
        return a;
    }
}
