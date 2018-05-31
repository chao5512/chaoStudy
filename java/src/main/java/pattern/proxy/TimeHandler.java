package pattern.proxy;

import pattern.InvacationHandler;

import java.lang.reflect.Method;

/**
 * Created by wangchao on 2018/3/9.
 */
public class TimeHandler implements InvacationHandler {
    Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    @Override
    public void invoke(Method method) {
        System.out.println("startTime:"+System.currentTimeMillis());
        try {
            //todo：考察jdk如何处理这个异常的
            method.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("stopTime:"+System.currentTimeMillis());
    }
}
