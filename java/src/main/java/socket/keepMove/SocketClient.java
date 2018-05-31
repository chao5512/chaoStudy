package socket.keepMove;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 连接一个socket服务并使用连接的步骤
 * 1.建立连接socket，new Socket(host, port);
 * 2.获得输出流，socket.getOutputStream();
 * 3.outPutStream.write(bytes)
 * 4.输出流关闭
 * 5.连接close
 * Created by wangchao on 2018/5/28.
 */
public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="你好  yiwangzhibujian";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
