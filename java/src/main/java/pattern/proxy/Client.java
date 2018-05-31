package pattern.proxy;

/**
 * Created by wangchao on 2018/3/8.
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Tank tank = new Tank();
        TimeHandler timeHandler = new TimeHandler(tank);
        //todo：invocationHandler
        Movealbe m = (Movealbe)Proxy.newInstance(Movealbe.class , timeHandler );
        m.move();
    }
}
