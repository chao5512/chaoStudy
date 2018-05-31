package pattern.delegate.v3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wangchao on 2017/10/26.
 */
public class ProxyFactory implements MethodInterceptor{
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        Object instance = enhancer.create();
        return instance;
    }
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("找个电视。。");
        Object invokeValue = method.invoke(target, args);
        System.out.println("扔垃圾。。");
        return invokeValue;
    }
}
