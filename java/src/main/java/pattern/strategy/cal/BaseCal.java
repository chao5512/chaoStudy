package pattern.strategy.cal;

/**
 * @author wangchao
 * @date 2019/12/8 - 7:18 下午
 */
public class BaseCal implements Calculatal {
    protected double x;
    protected double y;
    private Calculatal cal;

    public void setCal(Calculatal cal) {
        this.cal = cal;
    }

    public BaseCal(Calculatal cal) {
        this.cal = cal;
    }

    public BaseCal setX(double x){
        this.x = x;
        return this;
    }
    public BaseCal setY(double y){
        this.y = y;
        return this;
    }
    @Override
    public double cal(double x,double y) {
        return cal.cal(x,y);
    }

    public Calculatal getCal(){
        return cal;
    }

    public double start(){
        return getCal().cal(this.x,this.y);
    }
}
