package pattern.proxy.test;

/**
 * Created by wangchao on 2018/3/12.
 */
public class UserMgrImpl implements UserMgr {
    @Override
    public void addUser() {
        System.out.println("添加一个用户");
    }
}
