package Collection.app;

import Collection.StackList;
import sun.jvm.hotspot.utilities.Assert;

/**
 * 栈混洗.
 * 1.甄别.
 * Created by wangchao on 2018/8/9.
 */
public class StackMix {
    public boolean isStackMix(int[] ints1, int[] ints2) {
        StackList<Integer> stack1 = new StackList<>();
        StackList<Integer> stack2 = new StackList<>();
        StackList<Integer> stack3 = new StackList<>();

        for (int i = 0; i < ints1.length; i++) {
            stack1.push(ints1[i]);
        }

        for (int i = 0; i < ints2.length; i++) {
            //栈混洗的过程。
            while (!stack1.isEmpty() && stack1.peek() != ints2[i]) {
                stack3.push(stack1.pop());
            }
            if (!stack1.isEmpty()) {
                stack3.push(stack1.pop());
            }
            while (!stack3.isEmpty() && i < ints2.length  && stack3.peek() == ints2[i]) {
                i++;
                stack2.push(stack3.pop());
            }
        }
        return stack1.isEmpty() && stack3.isEmpty();
    }

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3};
//        int[] ints2 = {1, 2, 3};
        int[] ints2 = {3, 1, 2};
        StackMix stackMix = new StackMix();
        Assert.that(stackMix.isStackMix(ints1, ints2), "未通过");

    }
}
