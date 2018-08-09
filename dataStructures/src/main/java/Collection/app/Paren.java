package Collection.app;

import Collection.ExceptionDataStructEmpty;
import Collection.StackList;
import sun.jvm.hotspot.utilities.Assert;

/**
 * todo：扩展到可以匹配任意格式形如<></>
 * Created by wangchao on 2018/8/8.
 */
public class Paren {
    private StackList<String> cstack = new StackList<>();

    /**
     * 判断整个String是否匹配.
     * @param exp
     * @return
     */
    public boolean doParen(String[] exp) {
        for (int i = 0; i < exp.length; i++) {
            if(!check(exp[i])){
                String msg = "输入参数不合法"+i+exp[i];
                throw new ExceptionInvalidParam(msg);
            }

            if (!isRight(exp[i])) {
                cstack.push(exp[i]);
            } else if (isRight(exp[i])&&isPattern(cstack.peek(),exp[i])) {
                try {
                    cstack.pop();
                } catch (ExceptionDataStructEmpty e) {
                    System.out.println("匹配失败");
                    return false;
                }
            }
        }
        return cstack.isEmpty();
    }

    /**
     * 判断是否是闭口.
     *
     * @return true是闭口
     */
    private boolean isRight(String exp) {
        return exp.charAt(1) == '/';
    }

    /**
     * 判断两个串是否是一对
     * @param left
     * @param right
     * @return
     */
    private boolean isPattern(String left, String right) {
        return obtainContent(left).equals(obtainContent(right));
    }

    private String obtainContent(String exp) {
        String content = null;

        try {
            if (isRight(exp)) {
                content = exp.substring(2);
            } else {
                content = exp.substring(1);

            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new ExceptionInvalidParam(e.getMessage());
        }
        return content;
    }

    /**
     * 检查参数是否是形如<></>的格式
     */
    public boolean check(String exp) {
        return exp.charAt(0)=='<'&&exp.charAt(exp.length()-1)=='>';
    }

    public void clear() {
        cstack.clear();
    }

    public static void main(String[] args) {
        String[] s1 = {"<h1>","<h2>","</h2>","</h1>"};
        String[] s2 = {"<h1>","<h2>","</h1>","</h1>"};
        Paren paren = new Paren();
        Assert.that(paren.isRight("</sss>"), "isRight()error");
        Assert.that(!paren.isRight("<sss>"), "isRight()error");
        Assert.that(paren.check("</sss>"),"</sss>未通过");
        Assert.that(paren.check("<sss>"),"</sss>未通过");
//        Assert.that(paren.check("/sss>"),"/sss>未通过");

        Assert.that(paren.doParen(s1),"s1测试未通过");
        Assert.that(paren.doParen(s2),"s2测试未通过");

    }
}
