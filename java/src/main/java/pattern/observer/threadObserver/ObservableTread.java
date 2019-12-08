package pattern.observer.threadObserver;

import sun.plugin.viewer.LifeCycleManager;

/**
 * @author wangchao
 * @date 2019/12/4 - 8:19 下午
 */
public class ObservableTread implements Runnable {

    final protected LifeCycleListener lifeCycleListener;

    Thread.State state;

    public ObservableTread(LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    public Thread.State getState() {
        return state;
    }

    public void setState(Thread.State state) {
        this.state = state;
    }

    @Override
    public void run() {
    }

    void notifyChanges(ThreadEvent threadEvent){
        lifeCycleListener.onEvent(threadEvent);
    }

    public enum ThreadState{
        RUNNING,ERROR,DONE;
    }
    public static class ThreadEvent{
        private final ThreadState state;
        private final Thread thread;
        private final Throwable cause;

        public ThreadEvent(ThreadState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public ThreadState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
