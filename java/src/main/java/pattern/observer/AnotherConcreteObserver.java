package pattern.observer;

/**
 * @author wangchao
 * @date 2019/12/4 - 7:48 下午
 */
public class AnotherConcreteObserver extends Observer{

    public AnotherConcreteObserver(Subject subject) {
        super(subject);
    }

    @Override
    void update() {
        System.out.println("another concrete observer : " + Integer.valueOf(subject.getState())+ "some actions");
    }
}
