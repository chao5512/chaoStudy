package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by wangchao on 2018/5/9.
 */
public class T1 {
    public static void main(String[] args) {
        //1.获得类的三种方式
        //得把包名写全咯
        String className = "Employee";
        try {
            //1,明显看出来更灵活
            Class<?> c1 = Class.forName(className);
            //2，类已经被固定死，不够灵活
            Class<Employee> c2 = Employee.class;
            //3，从对象拿类，最不灵活
            Employee employee = new Employee();
            Class<? extends Employee> aClass = employee.getClass();

        //拿到class对象后，创建类的实例
            //调用了Employee的无参构造方法
            Employee e = (Employee)c1.newInstance();

        //获取属性的两种方式
            //获取所有属性
            //获取所有的属性?
            Field[] fs = c1.getDeclaredFields();

            //定义可变长的字符串，用来存储属性
            StringBuffer sb = new StringBuffer();
            //通过追加的方法，将每个属性拼接到此字符串中
            //最外边的public定义
            sb.append(Modifier.toString(c1.getModifiers()) + " class " + c1.getSimpleName() +"{\n");
            //里边的每一个属性
            for(Field field:fs){
                sb.append("\t");//空格
                sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
                sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
                sb.append(field.getName()+";\n");//属性的名字+回车
            }
            sb.append("}");
            System.out.println(sb);

            //获取特定属性
            /*
            User u = new User();
            u.age = 12; //set
            System.out.println(u.age); //get
            */

            //获取id属性
            Field idF = null;
            try {
                idF = c1.getDeclaredField("name");
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
                System.out.println("没有这个字段");
            }
            //实例化这个类赋给o
            Employee o = (Employee)c1.newInstance();
            //打破封装
            idF.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。
            //给o对象的id属性赋值"110"
            idF.set(o, "110"); //set
            //get
            System.out.println(idF.get(o));
            System.out.println(o.getName());

        } catch (ClassNotFoundException e) {
            System.out.println(className+"这个类没找到");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("非法访问");
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("初始化失败");
        }
    }
}
