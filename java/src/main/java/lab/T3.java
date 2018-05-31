package lab;

/**
 * Created by wangchao on 2018/4/18.
 */
public class T3 {
    private int age = 99;
    public class Inner{
        //在内部类中声明静态方法，那么内部类必须是静态的
        /*static*/ void print(){
            //内部类可以使用外部类属性，但静态内部类的静态方法不能直接使用非静态的外部类属性
            System.out.println(age);
        }

    }
    public Inner getInnerClass(){
        return new Inner();
    }
    public static void main(String[] args){
        T3 o = new T3();
        Inner in = o.new Inner();
        in.print();
    }
}


/*public*/class T4{
     //同一个java源文件中最多只可以声明一个public的类
}
