package pattern.strategy;

import java.math.BigDecimal;

/**
 * 商品抽象类
 * Created by wangchao on 2018/3/1.
 */
public class Goods{
    private int goodsId;
    private BigDecimal price;

    public Goods(int goodsId, BigDecimal price) {
        this.goodsId = goodsId;
        this.price = price;
    }

    public int getId() {
        return goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
