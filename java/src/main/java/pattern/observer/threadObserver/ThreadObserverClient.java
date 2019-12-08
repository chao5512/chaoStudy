package pattern.observer.threadObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangchao
 * @date 2019/12/4 - 9:17 下午
 */
public class ThreadObserverClient {
    public static void main(String[] args) {
        ThreadLifeCycleObserver threadLifeCycleObserver = new ThreadLifeCycleObserver();
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        threadLifeCycleObserver.concurrentQuery(ids);
    }
}
