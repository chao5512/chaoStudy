package socket.keepMove.concurrentSocket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 为每一个发来请求的socket建一个线程去跑逻辑
 * 肯定使用线程池
 * 1线程复用，创建线程耗时，回收线程慢
 * 2防止短时间内高并发，指定线程池大小，超过数量将等待，避免短时间创建大量线程导致资源耗尽，服务挂掉
 * Created by wangchao on 2018/5/28.
 */
public class SocketServerPro {
    public static void main(String args[]) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        while (true) {
            //这里每有一个请求就建立一个连接？有没有连接池这种东西
            Socket socket = server.accept();

            Runnable runnable=()->{
                try {
                    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while ((len = inputStream.read(bytes)) != -1) {
                        // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                        sb.append(new String(bytes, 0, len, "UTF-8"));
                    }
                    System.out.println("get message from client: " + sb);
                    inputStream.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            threadPool.submit(runnable);
        }

    }
}
