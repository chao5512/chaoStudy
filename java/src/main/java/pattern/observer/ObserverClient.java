package pattern.observer;

import java.util.Scanner;

/**
 * @author wangchao
 * @date 2019/12/4 - 7:51 下午
 */
public class ObserverClient {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setState(1);
        System.out.println("attach一个observer");
        subject.attach(new ConcreteObersever(subject));
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入int改变subject的状态：");
        int i = scanner.nextInt();
        subject.setState(i);
        System.out.println("attach 另一个 observer");
        subject.attach(new AnotherConcreteObserver(subject));
        System.out.println("输入int改变subject的状态：");
        int i1 = scanner.nextInt();
        subject.setState(i1);

        scanner.close();
    }
}
