package pattern.strategy;

import java.math.BigDecimal;

/**
 * Created by wangchao on 2018/3/1.
 */
public class WeightDiscountor implements Discountor {
    public void discount(Order o) {
        if(o.getWeight().compareTo(BigDecimal.valueOf(50))>=0){
            System.out.println("交易单号为" + o.getOrderId() +
                    ", 总价为：" + o.getGoods().getPrice().multiply(BigDecimal.valueOf(0.5)).multiply(o.getWeight())+"元");
        }else if(o.getWeight().compareTo(BigDecimal.valueOf(10))>=0){
            System.out.println("交易单号为" + o.getGoods().getId() +
                    ", 总价为：" + o.getGoods().getPrice().multiply(BigDecimal.valueOf(0.85)).multiply(o.getWeight())+"元");
        }else{
            System.out.println(o.toString());
        }
    }
}
