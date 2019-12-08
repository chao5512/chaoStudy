package pattern.singleton;

/**
 * volitale双重检查
 * @author wangchao
 * @date 2019/12/4 - 12:11 上午
 */
public class Singleton5 {
    private Singleton5(){}
    private static volatile Singleton5 instance = null;

    public static Singleton5 getInstance(){
        //1. 跳过大多数非空情况，保证速度
        if(null == Singleton5.instance){
            synchronized (Singleton5.class){
                //2. 保证正确性，当第一个进入到这里的线程new了这个单例后
                // 其他可以进来的线程再进来可以看到实例已经非空了
                if(null == Singleton5.instance){
                    Singleton5.instance = new Singleton5();
                }
            }
        }
        return Singleton5.instance;
    }
}
