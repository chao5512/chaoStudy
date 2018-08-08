package Collection.app;

import Collection.StackList;

/**
 * 进制转换器.
 * 十进制转换到指定进制
 * Created by wangchao on 2018/8/8.
 */
public class NumberCoversion {
    private int radix = 10;
    //可用于16进制的转换
    private char[] digit = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    StackList<Character> stack = new StackList<>();

    public NumberCoversion(int radix) {
        this.radix = radix;
    }

    public void convert(int number){
        while (number>0){
            stack.push(digit[number%radix]);
            number/=radix;
        }
    }
    public void print(){
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
    public void clear(){
        stack.clear();
    }

    public static void main(String[] args) {
        NumberCoversion nc = new NumberCoversion(16);
        nc.convert(10);
        nc.print();
        System.out.println();
        nc.clear();
        nc.convert(15);
        nc.print();
    }
}
