package pattern.strategy;

/**
 *
 * Created by wangchao on 2018/3/1.
 */
public class Mall {
    /**
     * 出售苹果
     * todo:应该修改成可以出售任何商品
     * @param order
     */
    public void sell(Order order){
        System.out.println(order.toString());
    }

    /**
     * 打折出售商品
     */
    public void discountSell(Order order){
        order.discountSell();
    }
}
