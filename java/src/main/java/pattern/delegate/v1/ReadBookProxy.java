package pattern.delegate.v1;

import pattern.delegate.ReadBookInterface;

/**
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * Created by wangchao on 2017/10/25.
 */
public class ReadBookProxy {
    private ReadBookInterface target;
    public ReadBookProxy(ReadBookInterface target) {
        this.target = target;
    }
    public void read(String bookName){
        System.out.println("准备点吃的。。");
        target.read(bookName);
        System.out.println("看完了，也吃完了。。");
    }
}
