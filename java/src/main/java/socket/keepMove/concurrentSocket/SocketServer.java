package socket.keepMove.concurrentSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可以处理多个客户端的请求的server
 * 即死循环server.accept和处理逻辑
 * 缺点：能够循环处理多个Socket请求，不过当一个请求的处理比较耗时的时候，后面的请求将被阻塞，
 * 所以一般都是用多线程的方式来处理Socket，即每有一个Socket请求的时候，就创建一个线程来处理它
 * Created by wangchao on 2018/5/28.
 */
public class SocketServer {
    public static void main(String args[]) throws IOException {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        while(true){
            Socket socket = server.accept();
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
        }

    }
}
