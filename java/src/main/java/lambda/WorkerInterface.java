package lambda;

/**
 * 功能接口
 * 只允许有一个抽象方法（即功能方法）
 * Created by wangchao on 2018/5/29.
 */
@FunctionalInterface
public interface WorkerInterface {
    public void doWork();
}
