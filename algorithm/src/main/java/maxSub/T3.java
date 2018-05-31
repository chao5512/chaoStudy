package maxSub;
/**
 * 这是错的
 * 分析法的两趟遍历实现。考虑是不是可以一趟遍历完成
 * v1，修正了第一次分析的不完整性，表现为单向变双向
 * Created by wangchao on 2018/4/20.
 */
public class T3 extends FindMaxSub {
    @Override
    int maxSub(int[] A, int start, int end) {
        int max1 = 0;
        int max2 = 0;
        int min1 = A[0];
        int min2 = A[end];
        int sum = 0;
        int stopPos = end;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum > max1){
                max1 = sum;
                stopPos = i;
            }
        }
        sum = 0;
        for (int i = 0; i <= stopPos; i++) {
            sum += A[i];
            if(sum <= min1){
                min1 = sum;
            }
        }
        System.out.println("----"+(max1-min1));
        stopPos = 0;
        sum = 0;
        for (int i = A.length-1; i > 0; i--) {
            sum += A[i];
            if(sum > max2){
                max2 = sum;
                stopPos = i;
            }
        }
        sum = 0;
        for (int i = A.length-1; i >= stopPos; i--) {
            sum += A[i];
            if(sum <= min2){
                min2 = sum;
            }
        }
        System.out.println("----"+(max2-min2));

        return (max1 - min1)>=(max2-min2)?(max1 - min1):(max2-min2);
    }
}
