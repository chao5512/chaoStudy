package pattern.strategy.cal;

/**
 * @author wangchao
 * @date 2019/12/8 - 7:15 下午
 */
public class MyCalClient {
    public static void main(String[] args) {
        MyCal myCal1 = new MyCal();
        BaseCal myCal = new BaseCal(myCal1);
        System.out.println("默认的计算方式");
        System.out.println(myCal.setX(1.0).setY(2.0).start());
        Calculatal myCal2 = (x,y)-> 2*x+y;
        myCal.setCal(myCal2);
        System.out.println("更改了一次策略");
        System.out.println(myCal.setX(1.0).setY(2.0).start());
        myCal.setCal((x,y)->7*y);
        System.out.println("更改了一次策略");
        System.out.println(myCal.setX(1.0).setY(2.0).start());

    }
}
