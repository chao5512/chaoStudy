package pattern.factory.SpringBeanFactory;

import pattern.proxy.Movealbe;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangchao on 2018/3/15.
 */
public class Test {
    @org.junit.Test
    public void testProp() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        //目录从src开始
        properties.load(Test.class.getClassLoader().getResourceAsStream("src/main/java/pattern/factory/SpringBeanFactory/springBeanFactory.properties"));
        String vehicleType = properties.getProperty("vehicleType");
        Object o = Class.forName(vehicleType).newInstance();
        Movealbe m = (Movealbe) o;
        m.move();
    }
    @org.junit.Test
    public void testPath(){
        System.out.println(Test.class.getClassLoader().getResourceAsStream(""));
        System.out.println("...");
    }
}
