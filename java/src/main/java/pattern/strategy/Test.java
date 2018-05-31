package pattern.strategy;

import java.math.BigDecimal;

/**
 * Created by wangchao on 2018/3/1.
 */
public class Test {
    public static void main(String [] args){
        Apple apple = new Apple(001, BigDecimal.valueOf(2.3));
        Banana banana = new Banana(002, BigDecimal.valueOf(3.2));

//        Order order = new Order(001, apple, BigDecimal.valueOf(50),new WeightDiscountor());
        Order order = new Order(001, apple, BigDecimal.valueOf(10),new CostDiscountor());
        Mall mall = new Mall();
        mall.sell(order);
        mall.discountSell(order);

        Order order1 = new Order(002, banana, BigDecimal.valueOf(10), new WeightDiscountor());
        mall.sell(order1);
        mall.discountSell(order1);
    }
}
