import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentSkipListMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author wangchao
 * @date 2019/12/7 - 12:22 上午
 */
public class TestConcurrentSkipListMap {
    ConcurrentSkipListMap<Integer, String> skipList;
    @Before
    public void init(){
        skipList = new ConcurrentSkipListMap<>();
        skipList.put(1,"java");
        skipList.put(2,"idea");
        skipList.put(6,"emacs");
    }
    @Test
    public void testCompute(){
        skipList.compute(1,(k,v)->{
            assertThat(k,equalTo(1));
            assertThat(v,equalTo("java"));
            return v+"1.8";
        });
    }
    @Test
    public void testMerge(){
        skipList.merge(2,"chao",(ov,v)->{
            assertThat(ov,equalTo("idea"));
            assertThat(v,equalTo("chao"));
            return v+"1.8";
        });
    }
}
