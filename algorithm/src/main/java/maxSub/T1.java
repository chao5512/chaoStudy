package maxSub;
/**
 * 暴力法求解最大子数组。
 * 求所有子数组的和，找到最大值
 * 时间复杂度为n的平方。n的三次方式怎么搞得
 * Created by wangchao on 2018/4/19.
 */
public class T1 extends FindMaxSub {
    public int maxSub(int[] A,int s,int e){
        int maxSub = 0;
        int sum =0;
        for(int i =0; i<A.length; i++){
            for(int j =i;j<A.length;j++){
                sum = A[j]+sum;
                if(sum >=maxSub){
                    maxSub = sum;
                }
            }
            sum =0;
        }
        return maxSub;
    }
}
