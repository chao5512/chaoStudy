import Collection.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.Test;

/**
 * Created by wangchao on 2018/7/25.
 */
public class TreeTest {
    @Test
    public void treeSet(){
        Integer integer = new Integer(1);
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(integer);
    }

    @Test
    public void treeMap(){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(new Integer(10),"10");
        treeMap.put(new Integer(6),"6");
        treeMap.put(new Integer(4),"4");
        treeMap.put(new Integer(8),"8");
        treeMap.put(new Integer(2),"2");
        treeMap.put(new Integer(1),"1");


    }
}
