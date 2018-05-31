package philosopher;
import java.util.ArrayList;

/**
 * 哲学家就餐问题
 * Created by wangchao on 2018/4/16.
 */
public class T {
    public static void main(String[] args) {
        ArrayList<Phiosopher> phiosopherArrayList = new ArrayList();
        for (int i =0;i<5;i++){
            phiosopherArrayList.add(new Phiosopher(i));
        }
        ArrayList<Chopsticks> chopsticksArrayList = new ArrayList();
        for(int i = 0;i<5;i++){
            chopsticksArrayList.add(new Chopsticks(i));
        }



    }

}
