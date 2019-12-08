package pattern.observer.threadObserver;

import pattern.observer.Observer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchao
 * @date 2019/12/4 - 8:51 下午
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {
    private final Object LOCK = new Object();


    public void concurrentQuery(List<String> ids){
        if(null == ids || ids.isEmpty()){
            return;
        }
        ids.stream().forEach((id)->new Thread(new ObservableTread(this){
            @Override
            public void run() {
                try{
                    notifyChanges(new ThreadEvent(ThreadState.RUNNING,Thread.currentThread(),null));
                    System.out.println("do somthing");
                    TimeUnit.SECONDS.sleep(2);
                    notifyChanges(new ThreadEvent(ThreadState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyChanges(new ThreadEvent(ThreadState.ERROR,Thread.currentThread(),e));
                }
            }
        },id).start());
    }
    @Override
    public void onEvent(ObservableTread.ThreadEvent threadEvent) {
        synchronized (LOCK){
            if(null != threadEvent.getCause()){
                System.out.println("The thread [" + threadEvent.getThread() + "] get an error [" + threadEvent.getCause() + "] and state now is :" +threadEvent.getState());
                threadEvent.getCause().printStackTrace();
            }else {
                System.out.println("The thread [" + threadEvent.getThread() + "] state changed and state now is :" +threadEvent.getState());
            }
        }
    }
}
