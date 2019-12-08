import Collection.Stack;
import Collection.StackArr;
import Collection.StackList;
import org.junit.Test;

/**
 * Created by wangchao on 2018/8/7.
 */
public class StackTest {
    @Test
    public void testArr(){
        Stack<String> stack = new StackArr<>(5);
        stack.push("e1");
        System.out.println(stack.peek());
        stack.push("e2");
        System.out.println(stack.peek());
        stack.push("e3");
        System.out.println(stack.peek());
        stack.push("e4");
        System.out.println(stack.peek());
        stack.push("e5");
        System.out.println(stack.peek());
//        stack.push("e5");

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());

    }
    @Test
    public void testList(){
        Stack<String> stack = new StackList();
        stack.push("e1");
        System.out.println(stack.peek());
        stack.push("e2");
        System.out.println(stack.peek());
        stack.push("e3");
        System.out.println(stack.peek());
        stack.push("e4");
        System.out.println(stack.peek());
        stack.push("e5");
        System.out.println(stack.peek());
        stack.push("e5");

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
