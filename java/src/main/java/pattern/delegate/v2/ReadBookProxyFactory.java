package pattern.delegate.v2;

import pattern.delegate.ReadBookInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：被代理类修改的时候不用修改代理类
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * 不实现接口也不知道被代理类的方法呀kkk
 * Created by wangchao on 2017/10/25.
 */
public class ReadBookProxyFactory {
    private Object target;

    public ReadBookProxyFactory(ReadBookInterface target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("先准备准备。。");
                        Object invokeValue = method.invoke(target, args);
                        System.out.println("收拾收拾。。");
                        return invokeValue;
                    }
                }
        );
    }

}
