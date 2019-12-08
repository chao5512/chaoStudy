package reflect.tests;

/**
 * 测试能否通过反射拿到一个Object对象的真正的对象
 * Created by wangchao on 2018/6/8.
 */
public class T1 {
    static class Data{

    }

    public static void main(String[] args) {
        Data data = new Data();
        Object o = data;
        System.out.println(o.getClass().getName());
    }
}
