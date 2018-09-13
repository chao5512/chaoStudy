package concreteAlgs;

import Collection.Stack;
import Collection.StackList;

/**
 * 汉诺塔递归实现
 * Created by wangchao on 2018/8/27.
 */
public class AglsHanoi {
    //有3个栈A、B、C,其中A里面存有依次减小的n个数，现想要将A中的数都移动到C，可以借助B
    // ，且保证移动过程中A、B、C中依旧是依次减小。

    //递归hanoi描述
    //将A栈顶n-1个元素hanoi到B，借助C
    //将A中最后一个元素直接移动到C
    //将B中元素hanoi到C，借助A

    //时间复杂度
    //T(1)=O(1)
    //T(n)=2*T(n-1)+O(1)
    //凑项法得T(n)的前n项和为Sn=2^n-2-n
    /**
     *
     * @param n 个元素
     * @param A 从A
     * @param B 借助B
     * @param C 移动到C
     */
    static void hanoi(int n, Stack A, Stack B, Stack C){
        if(n>0){
            hanoi(n-1,A,C,B);
            C.push(A.pop());
            hanoi(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        StackList<Integer> sA = new StackList<>();
        StackList<Integer> sB = new StackList<>();
        StackList<Integer> sC = new StackList<>();
        for (int i = 0; i < 10; i++) {
            sA.push(10-i);
        }
        hanoi(10,sA,sB,sC);

        while (!sC.isEmpty()){
            System.out.println(sC.pop());
        }
    }
}
