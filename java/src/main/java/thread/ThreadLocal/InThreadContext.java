package thread.ThreadLocal;
import java.lang.ThreadLocal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 使用这个类来做为线程内的上下文
 * 使用String来作为key，value的类型需要使用者已知。
 * Created by wangchao on 2018/6/7.
 */
public class InThreadContext {
    //只允许通过getInThreadContext方法获得本类对象
    private InThreadContext() {
    }

    //这里没有必要写成ThreadLocal子类的形式，因为目前来看，默认值等于null很合理
    //这里写成ThreadLocal子类的形式，主要是为了重写initialValue方法，这样当get先于set操作的时候
    //不会因为map没有实例化而抛出空指针异常，而是符合逻辑的返回null
    private static ThreadLocal<Map<String,Object>> data = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new HashMap<String,Object>();
        }
    };
    public static InThreadContext getInThreadContext(){
        return new InThreadContext();
    }

    public Object get(String k){
        return data.get().get(k);
    }

    public void set(String k,Object v){
        data.get().put(k,v);
    }
    public static void main(String[] args) {
        InThreadContext inThreadContext = InThreadContext.getInThreadContext();
        assert null == inThreadContext.get("null");
        assert null == inThreadContext.get(null);
        Object o = new Object();
        inThreadContext.set(null,o);
        //调用一次GC，目前不清楚是否会clear这个弱引用,但从结果来看，null作为key是可以的
        //但是要尽量避免这么做
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(inThreadContext.get(null));
        System.out.println(inThreadContext.get("A"));
    }

}
