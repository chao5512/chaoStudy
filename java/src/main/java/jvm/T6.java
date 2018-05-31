package jvm;

import jvm.bean.OOMObject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * -Xmx10m -Xms10m
 * OOM
 * Created by wangchao on 2018/5/16.
 */
public class T6 {
    /**
     * 堆空间溢出
     * java.lang.OutOfMemoryError: Java heap space
     * 解决方法：增大堆空间，及时释放内存
     */
    public void t1() {
        System.out.println(Runtime.getRuntime().maxMemory());
        ArrayList<Object> objectArrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
            objectArrayList.add(new byte[1024*1024]);
        }
    }
    /**
     * 永久区溢出
     * -XX:PermSize=10m -XX:MaxPermSize=10m 不好使
     * 解决方法：增大perm区，允许class回收吧
     */
    public void t2(){
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
    /**
     *
     */
    public static class ThreadSleep implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 栈空间溢出
     * -Xmx1g -Xss1m
     * java.lang.OutOfMemoryError: unable to create new native thread
     * 解决方法：
     *  1.减少堆空间
     *  2.增大栈空间
     */
    public void t3(){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"M");
        for (int i = 0; i < 10000; i++) {
            new Thread(new ThreadSleep(),"Thread"+i).start();
            System.out.println("thread" +i+"启动");
        }
    }
    /**
     * 直接内存溢出
     * -Xmx1g -XX:+PrintGCDetails
     * 解决方法：减少堆内存，主动gc
     */
    public void t4(){
        for (int i = 0; i < 10240; i++) {
            ByteBuffer.allocateDirect(1024*1024);
            System.out.println(i);
            System.gc();
        }
    }
}
