package pattern.proxy;

import pattern.InvacationHandler;

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
 * Created by wangchao on 2018/3/8.
 */
public class Proxy {
    public static Object newInstance(Class interfaces , InvacationHandler invacationHandler) throws Exception {
        //1源码到class
        String methodstr ="";
        Method[] methods = interfaces.getMethods();
        for (Method method : methods) {
            methodstr +="    public void "+method.getName()+"() {\n" +
                        "        try {\n" +
                        "            Method method = "+interfaces.getName()+".class.getMethod(\""+method.getName()+"\");\n" +
                        "            h.invoke(method);\n" +
                        "        } catch (NoSuchMethodException e) {\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "\n" +
                        "    }";
        }

        String src = "package pattern.proxy;\n" +
                "\n" +
                "import InvacationHandler;\n" +
                "\n" +
                "import java.lang.reflect.Method;\n" +
                "\n" +
                "/**\n" +
                " * 获得moveable 的move方法的运行时间\n" +
                " * Created by wangchao on 2018/3/7.\n" +
                " */\n" +
                "public class $Proxy1 implements "+interfaces.getName()+"{\n" +
                "    InvacationHandler h;\n" +
                "\n" +
                "    public $Proxy1(InvacationHandler h) {\n" +
                "        this.h = h;\n" +
                "    }\n" +
                methodstr +
                "}";
        String fileName = System.getProperty("user.dir") + "/src/main/java/pattern/proxy/$Proxy1.java";
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
        URL[] urls = {new URL("file:/" + System.getProperty("user.dir") + "/src/main/java")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        //注意这里的参数，是包名，目录结构是.连接的
        Class<?> proxy = urlClassLoader.loadClass("pattern.proxy.$Proxy1");
        System.out.println(proxy);

        //3.动态加载的class生成对象
        Constructor<?> constructor = proxy.getConstructor(InvacationHandler.class);
        Object m = constructor.newInstance(invacationHandler);
        return m;
    }
}
