package function;

import Function.Apple;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wangchao
 * @date 2019/12/7 - 6:17 下午
 */
public class TestFunction {
    List<Apple> apples;
    @Before
    public void init(){
        apples = Arrays.asList(new Apple[]{
                new Apple("green", 10.0),
                new Apple("black",50.0),
                new Apple("green",50.0)});

    }
    @Test
    public void testPredicte(){
        Stream<Apple> green = apples.stream().filter((apple) -> apple.getColor().equals("green"));
        green.forEach((apple)->System.out.println(apple.getWeight()));
    }
}
