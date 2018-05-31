package pattern.strategy;

import java.math.BigDecimal;

/**
 * Created by wangchao on 2018/3/1.
 */
public class Apple extends Fruit {
    public Apple(int goodsId, BigDecimal price) {
        super(goodsId, price);
    }


    @Override
    public String toString() {
        return "苹果,单价为"+this.getPrice()+"元";
    }
}
