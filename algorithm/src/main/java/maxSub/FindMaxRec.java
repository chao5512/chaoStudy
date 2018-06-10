package maxSub;

/**
 * 分治法（递归思想）
 * Created by wangchao on 2018/4/19.
 */
public class FindMaxRec extends FindMaxSub {
    public int maxSub(int[] A,int s,int e){
        //设置函数出口
        if(s ==e){
            return A[s];
        }
        int middle = (s+e)/2;
        //1.最大子数组完全分布在a的前半段
        int mp = maxSub(A,s,middle);
        //2.最大子数组完全分布在a的后半段
        int ml = maxSub(A,middle+1,e);
        //最大子数组跨过middle
        int maxSuff = 0;
        int sum = 0;
        for(int i =middle;i>=s;i--){
            sum += A[i];
            if(sum>=maxSuff){
                maxSuff = sum;
            }
        }
        sum =0;
        int maxPre = 0;
        for(int i =middle+1;i<=e;i++){
            sum += A[i];
            if(sum>=maxPre){
                maxPre = sum;
            }
        }
        int mm =maxPre+maxSuff;

        int maxSub = mp > ml?(mp > mm? mp:(ml>mm?ml:mm)):(ml>mm?ml:mm);

        return maxSub;
    }

    public static void main(String[] args) {
        FindMaxRec findMaxRec = new FindMaxRec();
        int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findMaxRec.maxSub(a,0,a.length-1));
    }
}
