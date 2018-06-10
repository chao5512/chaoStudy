package pattern.singleton;

/**
 * 单例懒汉模式
 * Created by wangchao on 2018/6/5.
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();
    //构造函数私有化
    private Singleton1(){}
    //只有一个singleton 不需要同步
    public static Singleton1 getSingleton1(){
        return singleton1;
    }
}
