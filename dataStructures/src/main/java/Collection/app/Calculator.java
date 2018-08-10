package Collection.app;

import Collection.Stack;
import Collection.StackList;

/**
 * 加减乘除计算器
 * Created by wangchao on 2018/8/9.
 */
public class Calculator {
    private Stack<Double> ns = new StackList<>();
    private Stack<Operation> ops = new StackList<>();
    enum Operation {
        ADD('+'), SUB('-'), MUL('*'), DIV('/'), L_P('('), R_P(')'), EOE('$');
        //chars[栈顶][当前] 优先级关系是栈顶与当前的关系
        private static char[][] chars = {
                {'>', '>', '<', '<', '<', '>', '>'}// + ***
                , {'>', '>', '<', '<', '<', '>', '>'}// - 栈
                , {'>', '>', '>', '>', '<', '>', '>'}// * 顶
                , {'>', '>', '>', '>', '<', '>', '>'}// / 运
                , {'<', '<', '<', '<', '<', '=', ' '}// ( 算
                , {' ', ' ', ' ', ' ', ' ', ' ', ' '}// ) 符
                , {' ', ' ', ' ', ' ', ' ', ' ','='}// $ ***
                // + - * / ( ) $
                // *** 当前运算符 ***

                //"2*((23-1*3)*10)/4$"
        };


        Operation(char c) {
        }

        /**
         * 比较两个操作符的优先级
         *
         * @return 小于零当前优先级较低，大于零当前优先级高，等于零优先级相等
         */
        public int compare(Operation op) {
            char c = chars[this.getIndex()][op.getIndex()];
            switch (c){
                case '>':return 1;
                case '=':return 0;
                case '<':return -1;
                default:return -2;
            }
        }

        public double cal(double n1,double n2){
            switch (this){
                case ADD: return n1+n2;
                case SUB: return n1-n2;
                case MUL: return n1*n2;
                case DIV: return n1/n2;
                default:return -1;
            }
        }
        private boolean isEOE(){
            return this==EOE;
        }
        private int getIndex() {
            switch (this) {
                case ADD:
                    return 0;
                case SUB:
                    return 1;
                case MUL:
                    return 2;
                case DIV:
                    return 3;
                case L_P:
                    return 4;
                case R_P:
                    return 5;
                case EOE:
                    return 6;
                default:
                    return -1;
            }
        }
    }
    public double cal(String exp){
        double result =0;
        if(exp==null||exp.length()==0){
            String msg = "算式长度非法";
            throw new ExceptionInvalidParam(msg);
        }
        ops.push(Operation.EOE);
        for (int i = 0; i < exp.length(); i++) {
            if(isOp(exp.charAt(i))){
                Operation op = getOp(exp.charAt(i));
                //操作符入栈
                if(ops.peek().compare(op)>0){
                    //栈顶操作符优先级高，栈顶运算符进行计算
                    Double n2 = ns.pop();
                    Double n1 = ns.pop();
                    ns.push(ops.pop().cal(n1,n2));
                    i--;
                }else if(ops.peek().compare(op)==0){
                    if(ops.peek()==Operation.EOE){
                        result = ns.pop();
                        ops.pop();
                        break;
                    }
                    ops.pop();

                }else {
                    ops.push(getOp(exp.charAt(i)));
                }
            }else {
                //操作数入栈
                i=readNumber(exp,i)-1;
            }
        }
        return result;
    }
    private int readNumber(String exp ,int i){
        if(isOp(exp.charAt(i))){
            String msg ="当前字符为操作数";
            throw new ExceptionInvalidParam(msg);
        }
        ns.push((double)(exp.charAt(i++)-48));
        while (i<exp.length()&&!isOp(exp.charAt(i))){
            ns.push((ns.pop())*10+(double)(exp.charAt(i)-48));
            i++;
        }
        return i;
    }
    private double realCal(double n1,double n2,Operation op){
        return op.cal(n1,n2);
    }
    private Operation getOp(char c){
        switch (c) {
            case '+':
                return Operation.ADD;
            case '-':
                return Operation.SUB;
            case '*':
                return Operation.MUL;
            case '/':
                return Operation.DIV;
            case '(':
                return Operation.L_P;
            case ')':
                return Operation.R_P;
            case '$':
                return Operation.EOE;
            default:
                return null;
        }
    }
    private void clear(){
        ns.clear();
        ops.clear();
    }
    private boolean isOp(char c){
        return c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')'||c=='$';
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String exp = "1+23$";
        String exp1 = "2*((23-1*3)*10)/4$";

        System.out.println(Operation.ADD.getIndex());
        System.out.println(Operation.ADD.cal(4,2));
        System.out.println(calculator.readNumber(exp,0));
        System.out.println(calculator.ns.peek());
        System.out.println(Operation.DIV.cal(2.0,3.0));
        System.out.println('1'-0);

        System.out.println(calculator.cal(exp));
        calculator.clear();
        System.out.println(calculator.cal(exp1));
        calculator.clear();
    }
}
