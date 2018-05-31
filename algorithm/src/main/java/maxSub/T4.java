package maxSub;
/**
 * 这是错的
 * 对于这个题目来说，有缺陷的分析法，表现为只考查了一个方向的
 * 有缺陷就要重新思考
 * Created by wangchao on 2018/4/20.
 */
public class T4 extends FindMaxSub {
    @Override
    int maxSub(int[] A, int start, int end) {
        int max = 0;
        int min = A[end];
        int sum = 0;
        int stopPos = 0;

        for (int i = A.length-1; i > 0; i--) {
            sum += A[i];
            if(sum > max){
                max = sum;
                stopPos = i;
            }
        }
        sum = 0;
        for (int i = A.length-1; i >= stopPos; i--) {
            sum += A[i];
            if(sum <= min){
                min = sum;
            }
        }
        return max - min;
    }
}
