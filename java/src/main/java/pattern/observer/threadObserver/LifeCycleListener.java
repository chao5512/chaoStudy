package pattern.observer.threadObserver;

/**
 * @author wangchao
 * @date 2019/12/4 - 8:39 下午
 */
public interface LifeCycleListener {
    void onEvent(ObservableTread.ThreadEvent threadEvent);
}
