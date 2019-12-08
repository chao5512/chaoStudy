import java.util.Iterator;
import java.util.Vector;

/**
 * Created by wangchao on 2018/8/28.
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < 10; i++) {
            v.add(i);
        }

        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
