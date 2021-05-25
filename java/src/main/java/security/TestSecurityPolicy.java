package security;

public class TestSecurityPolicy {
    public static void main(String[] args) {
        // 相当于在启动参数上加-Djava.security.manager
        System.setSecurityManager(new SecurityManager());
        testPolicy();
    }

    /**
     * 考察当前线程对stopThread的权限
     * 在文件${java.home}/lib/security/java.policy中
     * 关注 permission java.lang.RuntimePermission "stopThread";
     * 1. 不修改，则可以正常调用Thread.stop
     * 2. 注释掉，则报访问权限异常
     */
    public static void testPolicy() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start sleep for 1s");
                    Thread.sleep(1000);
                    System.out.println("finish sleep!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        t.stop();
        System.out.println("stop finish");
    }
}
