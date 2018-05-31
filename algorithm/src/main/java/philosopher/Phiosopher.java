package philosopher;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangchao on 2018/4/16.
 */
public class Phiosopher {
    private int number;

    public Phiosopher(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    public void eat(ArrayList<Chopsticks> chopsticksArrayList){
        chopsticksArrayList.get(number);
        chopsticksArrayList.get(number+1);
    }
    public void think(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
