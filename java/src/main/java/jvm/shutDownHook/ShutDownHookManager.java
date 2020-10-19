package jvm.shutDownHook;


/**
 * 1. 使用kill pid 命令,shutdown hook 还有执行机会
 * 2. 使用kill -9 pid ,进程直接退出
 */
public class ShutDownHookManager {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shut me down!");
        }));
        Thread.sleep(Integer.MAX_VALUE);
    }
}
