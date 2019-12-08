package nio.test;

import org.junit.Test;

import java.net.URL;

/**
 * Created by wangchao on 2019/11/9.
 */
public class ClassLoaderTest {
    @Test
    public void testClassLoader(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("类加载器" + systemClassLoader);
        //这里默认传空字符，输出的是资源的绝对路径
        System.out.println("加载路径" + systemClassLoader.getResource(""));
        System.out.println("父加载器" + systemClassLoader.getParent());
        System.out.println("父加载器的加载路径" + systemClassLoader.getParent().getResource(""));
        //这里看到扩展加载器的父类不是根加载器而是null，是由于根加载器不是java实现的
        System.out.println("父加载器的父加载器" + systemClassLoader.getParent().getParent());
    }
}
