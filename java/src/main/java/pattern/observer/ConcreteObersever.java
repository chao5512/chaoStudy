package pattern.observer;

/**
 * @author wangchao
 * @date 2019/12/4 - 7:43 下午
 */
public class ConcreteObersever extends Observer {


    public ConcreteObersever(Subject subject) {
        super(subject);
    }

    @Override
    void update() {
        System.out.println("concrete observer ： " + Integer.valueOf(subject.getState()));
    }
}
