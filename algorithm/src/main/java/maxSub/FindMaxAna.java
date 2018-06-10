package maxSub;

/**
 * 联机法？
 * thisSub = 0 刷新最大子数组起点
 * if(thisSub > maxSub) 排除最大子数组后面跟着的数据
 * Created by wangchao on 2018/6/11.
 */
public class FindMaxAna extends FindMaxSub{

    @Override
    int maxSub(int[] A, int start, int end) {
        int maxSub = 0;
        int thisSub = 0;
        for (int i = 0; i < A.length; i++) {
            thisSub += A[i];
            if(thisSub>maxSub){
                maxSub = thisSub;
            }else if(thisSub < 0){
                thisSub = 0;
            }
        }
        return maxSub;
    }
}
