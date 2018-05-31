package maxSub;
/**
 * Created by wangchao on 2018/4/20.
 */
public class T6 extends FindMaxSub {
    @Override
    int maxSub(int[] A, int start, int end) {
        int min = 0;
        int sum = 0;
        int pos = 0;
        int pos2 = end;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if(min>=sum){
                min = sum;
                pos = i;
            }
        }
        sum = 0;
        min = 0;
        for (int i = A.length-1; i >= 0; i--) {
            sum+=A[i];
            if(min>=sum){
                min = sum;
                pos2 = i;
            }
        }
        sum = 0;
        if(pos+1<=pos2-1){
            for (int i = pos+1; i <=pos2-1 ; i++) {
                sum+=A[i];
            }
            return sum;
        }else {
            return 0;
        }
    }
}
