package philosopher;

/**
 * Created by wangchao on 2018/4/16.
 */
public class Chopsticks {
    private int number;

    public Chopsticks(int number) {
        this.number = number;
    }

    public synchronized int getChopsticks() {
        return number;
    }
}
