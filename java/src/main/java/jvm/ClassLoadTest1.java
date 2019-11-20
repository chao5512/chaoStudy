package jvm;

/**
 * Created by wangchao on 2019/11/20.
 *
 * 直接用子类访问父类静态成员的时候只会初始化父类
 * 测试结果如下:test1
 * hi, this is parent class
 * here is parent static member
 * 注意上面的结果，并没有打印子类静态快中的内容
 *
 * 子类初始化时，要求父类初始化完成
 * 测试:test2
 * hi, this is parent class
 * hi, this is child class
 * here is the Child class static member
 *
 */
public class ClassLoadTest1 {
    public static void main(String[] args) {
        //test1
        //System.out.println(ClassLoadChild1.str);
        //test2
        System.out.println(ClassLoadChild1.strChild);
    }
}
class ClassLoadParent1{
    public static String str = "here is parent static member";
    static{
        System.out.println("hi, this is parent class");
    }
}

class ClassLoadChild1 extends ClassLoadParent1{
    public static String strChild = "here is the Child class static member";
    static{
        System.out.println("hi, this is child class");
    }
}