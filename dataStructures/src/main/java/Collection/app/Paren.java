package Collection.app;

import Collection.ExceptionDataStructEmpty;
import Collection.StackList;

/**
 * Created by wangchao on 2018/8/8.
 */
public class Paren {
    private StackList<Character> cstack = new StackList<>();

    public void doParen(char[] exp){
        for (int i = 0; i < exp.length; i++) {
            if('('==exp[i]){
                cstack.push(exp[i]);
            }else if(')'==exp[i]){
                try {
                    cstack.pop();
                }catch (ExceptionDataStructEmpty e){
                    System.out.println("匹配失败");
                    System.exit(0);
                }
            }
        }
    }

    public void check(){
        if(cstack.isEmpty()){
            System.out.println("匹配正确");
        }else{
            System.out.println("匹配失败");
        }
    }

    public void clear(){
        cstack.clear();
    }
    public static void main(String[] args) {
        char[] chars = {'(', '(', ')', ')'};
        char[] chars1 = {'(', ')', ')', ')'};
        Paren paren = new Paren();
        paren.doParen(chars);
        paren.check();

        paren.clear();
        paren.doParen(chars1);
        paren.check();
    }
}
