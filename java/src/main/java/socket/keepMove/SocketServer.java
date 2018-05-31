package socket.keepMove;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socketServer端示例
 * 打开一个server的步骤
 * 1.new ServerSocket(port)
 * 2.监听端口,获得连接socket,server.accept
 * 3.获得输入流inputStream，socket.getInputStream();
 * 4.从流中读取指定长度的bytes，inputStream.read(bytes);
 * 5.业务逻辑
 * 6.输入流close
 * 7.连接socket close
 * 8.socket服务close
 * Created by wangchao on 2018/5/28.
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        inputStream.close();
        socket.close();
        server.close();
    }
}
