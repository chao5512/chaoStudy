package jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import jvm.bean.OOMObject;

/**
 * Created by wangchao on 2019/11/21.
 */
public class MetaspaceOOM {
    /**
     * 1.8以后 metaspace溢出
     * -XX:MetaspaceSize=10m
     * 解决方法：增大perm区，允许class回收吧
     */
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"M");
        for (int i = 0; i < 1000000; i++) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }
}
