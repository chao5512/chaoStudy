package pattern.singleton;

/**
 * @author wangchao
 * @date 2019/12/4 - 12:30 上午
 */
public class Singleton6 {
    private Singleton6(){}

    private static class Singleton6Holder{
        private static final Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Singleton6Holder.instance;
    }
}
