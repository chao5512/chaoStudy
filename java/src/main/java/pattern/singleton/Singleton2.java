package pattern.singleton;

/**
 * 单例饿汉模式
 * Created by wangchao on 2018/6/5.
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;
    private Singleton2(){}
    //做单例==null判断时，有可能多个线程都判断等于空，创建多个单例对象，虽然最后一个会覆盖前面所有的，但创建了多余对象
    public static synchronized Singleton2 getSingleton2(){
        if (singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
