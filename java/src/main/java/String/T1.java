package String;

import org.junit.Test;

/**
 * Created by wangchao on 2018/5/2.
 */
public class T1 {
    @Test
    public void testNew(){
        String s1 = "100";
        String s2 = "1"+new String("00");

        System.out.println(s1==s2);
    }
}
