package pattern.proxy.test;

import pattern.proxy.$Proxy1;
import org.junit.Test;
import pattern.proxy.TimeHandler;

/**
 * Created by wangchao on 2018/3/12.
 */
public class test {
    @Test
    public void testCast(){
        UserMgr u = new UserMgrImpl();
        TimeHandler timeHandler = new TimeHandler(u);
        UserMgr ut = (UserMgr)new $Proxy1(timeHandler);
        ut.addUser();
    }
}
