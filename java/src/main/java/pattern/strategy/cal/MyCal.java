package pattern.strategy.cal;

/**
 * @author wangchao
 * @date 2019/12/8 - 7:12 下午
 */
public class MyCal implements Calculatal {

    @Override
    public double cal(double x, double y) {
        return x+y;
    }
}
