package jvm.classload;

import java.util.UUID;

/**
 * Created by wangchao on 2019/11/20.
 *
 * test1:
 * hi,this is parent2 static code
 * hi,this is not a final member
 * 输出了第一句，parent2类被初始化了
 *
 *
 * test2：
 * hi,this is a final member
 * 只输出了final常量，类没有被初始化
 * 这个常量在编译完成后就与Parent2类没有关系了
 * 在下面这个例子中，parent2类编译的class文件甚至可以删除
 *
 * javap c class文件反编译+助记符
 *
 * test3:
 *------运行期才能被确定的常量---------
 * 9e20ec57-e281-4efd-a231-b051a0e59dfc
 * 访问运行期才会确定下来的常量会导致定义该常量的类的初始化
 * 因为其没法在编译器就确定下来并加入到Test2的常量池中，
 * 因此运行期会主动访问ClassLoadFinal类
 */
public class ClassLoadTest2 {
    public static void main(String[] args) {
        //test1 and test2
        //System.out.println(ClassLoadParent2.str);
        //test3
        System.out.println(ClassLoadFinal.str);
    }
}
class ClassLoadParent2{
    //test1
    //public static String str = "hi,this is not a final member";
    //test2
    public static final String str = "hi,this is a final member";
    static {
        System.out.println("hi,this is parent2 static code");
    }
}
class ClassLoadFinal{
    public static final String str = UUID.randomUUID().toString();
    static{
        System.out.println("------运行期才能被确定的常量---------");
    }
}