package pattern.strategy;

import java.math.BigDecimal;

/**
 * Created by wangchao on 2018/3/1.
 */
public class Order implements Discountable{
    private int orderId;
    private Goods goods;
    private BigDecimal weight;
    private Discountor discountor;

    public Order(int orderId, Goods goods, BigDecimal weight,Discountor discountor) {
        this.orderId = orderId;
        this.goods = goods;
        this.weight = weight;
        this.discountor = discountor;
    }

    @Override
    public String toString() {
        return "订单id为："  + orderId +
                "的商品是：" + goods +
                ", 数量是：" + weight+
                ",总价为:"+goods.getPrice().multiply(weight)+"元";
    }

    public int getOrderId() {
        return orderId;
    }

    public Goods getGoods() {
        return goods;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Discountor getDiscountor() {
        return discountor;
    }

    public void discountSell() {
        discountor.discount(this);
    }
}
