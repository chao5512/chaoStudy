package pattern.singleton;

/**
 * 加锁的懒汉式
 * @author wangchao
 * @date 2019/12/3 - 11:44 下午
 */
public class Singleton3 {
    private Singleton3(){}
    private static Singleton3 instance = null;
    //缺点: 浪费，明显不为空的时候多呀
    public static synchronized Singleton3 getInstance(){
        if(null == Singleton3.instance){
            Singleton3.instance = new Singleton3();
        }
        return Singleton3.instance;
    }
}
