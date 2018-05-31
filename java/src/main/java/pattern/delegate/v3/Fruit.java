package pattern.delegate.v3;

/**
 * Cglib代理
 * 没有实现任何接口
 * 哇塞！！必须有一个无参的构造方法，如果定义了一个有参的构造函数，将会覆盖默认的无参的构造函数，name在enhancer.create（）的时候将会报错
 * Created by wangchao on 2017/10/26.
 */
public class Fruit {
    private String fruitName;

    public Fruit() {
    }

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public void beEat(){
        System.out.println(fruitName+"被吃了。。");
    }
}
