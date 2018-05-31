package thread.book;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * java天生的支持多线程
 * Created by wangchao on 2018/5/30.
 */
public class MutiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("id:"+threadInfo.getThreadId()+" "+threadInfo.getThreadName());
        }
    }
}
