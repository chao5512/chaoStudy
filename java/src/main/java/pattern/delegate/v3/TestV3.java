package pattern.delegate.v3;


/**
 * Created by wangchao on 2017/10/26.
 */
public class TestV3 {
    public void testEat(){
        Fruit target = new Fruit("苹果");
        ProxyFactory proxyFactory = new ProxyFactory(target);
        Fruit fruit = (Fruit) proxyFactory.getInstance();
        fruit.beEat();
    }
    public void test(){
        System.out.println("\00p");
    }
}
