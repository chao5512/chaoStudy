package maxSub;
/**
 * Created by wangchao on 2018/4/20.
 */
public class T5 extends FindMaxSub {
    @Override
    int maxSub(int[] A, int start, int end) {
        int sum =0;
        int max =0;
        int pos =0;
        for (int i = 0; i < end + 1; i++) {
            sum+=A[i];
            if(sum > max){
                max = sum;
                pos = i;
            }
        }
        sum = 0;
        max = 0;
        for (int i = pos; i >0; i--) {
            sum+=A[i];
            if(sum > max){
                max=sum;
            }
        }
        return max;
    }
}
