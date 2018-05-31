package pattern.delegate.v1;

import pattern.delegate.ReadBook;
/**
 * Created by wangchao on 2017/10/25.
 */
public class TestV1 {
    public void testRead(){
        //创建需要被代理的对象
        ReadBook readBook = new ReadBook();

        //把代理对象和被代理对象联系到一起
        ReadBookProxy readBookProxy = new ReadBookProxy(readBook);

        //调用代理的方法
        readBookProxy.read("数据库系统实现");

    }
}
