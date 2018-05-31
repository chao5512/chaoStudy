package pattern.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by wangchao on 2018/3/7.
 */
public class Test {
//    @org.junit.Test
//    public void run(){
//        Tank tank = new Tank();
//        MoveTimeProxy moveTimeProxy = new MoveTimeProxy(tank);
//        MoveLogProxy moveLogProxy = new MoveLogProxy(moveTimeProxy);
//        Movealbe m = moveLogProxy;
//        m.move();
//    }

    /**
     * 1.javaCompiler、cglib
     * 动态生成类--class
     * 2.接下来考虑怎么把动态生成的的类load到内存
     * 3.生成对象
     * ---上面是实现了moveable接口的动态代理
     * 考虑适用于各种接口的动态代理
     */

    @org.junit.Test
    public void printFile() throws Exception{
        //1源码到class
        String src = "package pattern.proxy;\n" +
                "\n" +
                "/**\n" +
                " * 获得moveable 的move方法的运行时间\n" +
                " * Created by wangchao on 2018/3/7.\n" +
                " */\n" +
                "public class MoveTimeProxy implements Movealbe {\n" +
                "    Movealbe m;\n" +
                "\n" +
                "    public MoveTimeProxy(Movealbe m) {\n" +
                "        this.m = m;\n" +
                "    }\n" +
                "\n" +
                "    public void move() {\n" +
                "        long startTime = System.currentTimeMillis();\n" +
                "        m.move();\n" +
                "        long stopTime = System.currentTimeMillis();\n" +
                "        System.out.println(\"跑了：\"+(stopTime-startTime)/1000+\"秒\");\n" +
                "\n" +
                "    }\n" +
                "}";
        String fileName = System.getProperty("user.dir")+"/src/main/java/pattern/proxy/MoveTimeProxy.java";
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(systemJavaCompiler.getSourceVersions());
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
        //凑这句
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        try {
            standardFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2 class load进内存
        URL[] urls = {new URL("file:/"+System.getProperty("user.dir")+"/src")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        //注意这里的参数，是包名，目录结构是.连接的
        Class<?> moveTimeProxy = urlClassLoader.loadClass("pattern.proxy.MoveTimeProxy");
        System.out.println(moveTimeProxy);

        //3.动态加载的class生成对象
        Constructor<?> constructor = moveTimeProxy.getConstructor(Movealbe.class);
        Movealbe m = (Movealbe) constructor.newInstance(new Tank());

        m.move();

    }
    @org.junit.Test
    public void testGavac(){
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(systemJavaCompiler.getSourceVersions());
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);

    }
    @org.junit.Test
    public void testReflesh(){
        Method[] methods = Test.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method);
        }
    }
    @org.junit.Test
    public void testProduct(){
//        Movealbe m = new $Proxy1(new Tank(), new TimeHandler(new Tank()));
//        m.move();
    }
    @org.junit.Test
    public void testClassLoader() throws Exception {
        ///Users/wangchao/IdeaProjects/bookRead/src/main/java/pattern/proxy/$Proxy1.java
        System.out.println(System.getProperty("user.dir"));
        URL[] urls = {new URL("file:/" + System.getProperty("user.dir") + "/src/main/java")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> proxy = urlClassLoader.loadClass("pattern.proxy.$Proxy1");
        System.out.println(proxy);
    }
}
