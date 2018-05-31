package lab;


/**
 * 类初始化顺序
 (1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
 (2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
 (3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
 (4) 父类构造函数
 (5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
 (6) 子类构造函数
 * Created by wangchao on 2018/4/18.
 */
public class T {
    private String s = "super";
    public T() {
        print();
    }
    void print(){
        System.out.println(s);
    }
    public static class SubT extends T{
        private String s = "sub";
        @Override
        void print() {
            System.out.println(s);
        }
    }

    /**
     * 执行分析，new 一个sub对象，执行初始化到步骤4的时候。父类构造函数调用子类的print方法，此时子类的非静态代码块尚未执行，即s还没有赋值
     * 只是在连接的准备阶段赋值为null，所以此时打印出null
     *
     * @param args
     */
    public static void main(String[] args) {
        T t = new SubT();
    }
}
