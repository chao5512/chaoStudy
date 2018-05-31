package maxSub;
/**
 * Created by wangchao on 2018/4/20.
 */
public class T7 extends FindMaxSub {
    @Override
    int maxSub(int[] A, int start, int end) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if(sum<sum+A[i]){
                sum=sum+A[i];
            }else {
                if(A[i]>sum){
                    sum = A[i];
                }else {
                    return sum;
                }

            }

        }
        return sum;
    }
    int max(int a,int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }
}
