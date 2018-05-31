package pattern.proxy.test;

import pattern.proxy.Proxy;
import pattern.proxy.TimeHandler;

/**
 * Created by wangchao on 2018/3/12.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        UserMgr userMgr = new UserMgrImpl();
        TimeHandler timeHandler = new TimeHandler(userMgr);
        UserMgr u = (UserMgr) Proxy.newInstance(UserMgr.class, timeHandler);
        u.addUser();
    }
}
