package pattern.singleton;

import java.util.stream.IntStream;

/**
 * 枚举实现的单例
 * @author wangchao
 * @date 2019/12/4 - 12:41 上午
 */
public class Singleton7 {
    private Singleton7(){}

    private enum Singleton7Holder{
        INSTANCE;
        private final Singleton7 instance;
        Singleton7Holder(){
            instance = new Singleton7();
        }
    }
    public static Singleton7 getInstance(){
        return Singleton7Holder.INSTANCE.instance;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach((i)-> new Thread(() -> System.out.println(Singleton7.getInstance())).start());
    }
}
