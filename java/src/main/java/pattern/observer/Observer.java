package pattern.observer;

/**
 * @author wangchao
 * @date 2019/12/4 - 7:28 下午
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    abstract void update();
}
