package utils;

/**
 * Created by wangchao on 2017/11/6.
 */
public class ByteUtils {
    /**
     * 字节数组A是否包含字节数组B
     * 只考虑B在A的开头的情况
     * 能不能按位比较
     * @param A
     * @param B
     * @return
     */
    public static boolean isContained(byte[]A,byte[]B){
        if (A==null&&B==null){
            return true;
        }
        if (A==null||B==null){
            return false;
        }
        boolean isEq = false;
        if (A.length<B.length){
            isEq = false;
        }else {
            isEq = true;
            for (int i = 0;i<B.length;i++){
                if (A[i]!=B[i]){
                    isEq = false;
                }
            }
        }


        return isEq;
    }
}
