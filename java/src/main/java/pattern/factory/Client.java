package pattern.factory;

import pattern.proxy.Movealbe;

/**
 * Created by wangchao on 2018/3/13.
 */
public class Client {
    public static void main(String[] args) {
        VehicleFactory vehicalFactory = new CarFactory();
        Movealbe m = vehicalFactory.createVehical();
        m.move();
    }
}
