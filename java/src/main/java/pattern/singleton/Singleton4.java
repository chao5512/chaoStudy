package pattern.singleton;

/**
 * double check
 * @author wangchao
 * @date 2019/12/3 - 11:51 下午
 */
public class Singleton4 {
    private Singleton4(){}
    private static Singleton4 instance = null;

    public static Singleton4 getInstance(){
        //1. 跳过大多数非空情况，保证速度
        if(null == Singleton4.instance){
            synchronized (Singleton4.class){
                //2. 保证正确性，当第一个进入到这里的线程new了这个单例后
                // 其他可以进来的线程再进来可以看到实例已经非空了
                //3. 缺点：有可能会导致空指针异常，第一个线程看到实例为空，去创建实例
                // 还没有等到实例初始化完成（例如还有外部引用的对象没有初始化）就return了，释放锁，这个时候等待锁的另外一个线程看到实例不为空
                // 直接去使用了，可是这时可能还未初始化完成。
                if(null == Singleton4.instance){
                    Singleton4.instance = new Singleton4();
                }
            }
        }
        return Singleton4.instance;
    }
}
