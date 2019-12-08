import edu.princeton.cs.algs4.StdDraw;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.Test;

/**
 * Created by wangchao on 2018/6/14.
 */
public class SomeTest {
    @org.junit.Test
    public void test(){
//        new Scanner()
    }
    @Test
    public void testDraw() throws InterruptedException {
        Double[] doubles = new Double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = new Random().nextDouble();
            System.out.println(doubles[i]+" ");
            StdDraw.line(0.7*i,0,0.7*i,doubles[i]);
        }
        TimeUnit.SECONDS.sleep(1000);
    }
}
