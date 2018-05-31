package pattern.delegate.v2;

import pattern.delegate.ReadBook;
import pattern.delegate.ReadBookInterface;

/**
 * Created by wangchao on 2017/10/26.
 */
public class TestV2 {
    public void testRead(){
        ReadBookInterface target = new ReadBook();
        ReadBookProxyFactory readBookProxyFactory = new ReadBookProxyFactory(target);
        ReadBookInterface proxyInstance = (ReadBookInterface)readBookProxyFactory.getProxyInstance();
        proxyInstance.read("数据库系统概念");
    }
}
