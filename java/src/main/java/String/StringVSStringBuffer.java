package String;

import org.junit.Test;

/**
 * Created by wangchao on 2018/4/11.
 */
public class StringVSStringBuffer {

    /**
     * string常量和string变量的连接操作“+”
     */
    @Test
    public void round1(){

        String s1a = "ab";
        String s1b = "cd";
        String s1c = "";

        long t1Start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            /**
             * 1.new一个字符串缓存
             * StringBuilder temp = new StringBuilder(s1b);
             * temp.append();
             * s1c = temp.toString();
             */
             s1c= s1a+s1b;
        }
        long t1End = System.currentTimeMillis();
        System.out.println("time of StringBuffer:"+(t1End-t1Start));

        String t2 = "";
        long t2Start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            //在编译期就已经完成连接运算并指向“abcd”拘留字符串对象
            //类加载的时候只是取出拘留字符串对象的地址赋给t2==》这个赋值过程目前表现是不耗费时间
            t2 = "ab"+"cd";
        }
        long t2End = System.currentTimeMillis();
        System.out.println("time of String:"+(t2End-t2Start));
    }

    /**
     * String 和StringBuffer的累和链接操作的对比
     */
    @Test
    public void round2(){
        String a1 = "a1";
        String a2 = "";
        long t1Start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            //String对象的value[]是final类型的，每次累加发生变化的时候要创建新的value【】，效率低
            a2 = a2 + a1;
        }
        long t1End = System.currentTimeMillis();
        System.out.println("time of String:"+(t1End-t1Start));

        StringBuffer b1 = new StringBuffer("b1");
        String b2 = "a1";
        long t2Start = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            //StringBuffer的value[]是可变的，每次累加只需要增长自己的长度就可以了
            b1 = b1.append(b2);
        }
        long t2End = System.currentTimeMillis();
        System.out.println("time of String:"+(t2End-t2Start));

    }
}
