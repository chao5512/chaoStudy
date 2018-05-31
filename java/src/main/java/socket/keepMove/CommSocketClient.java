package socket.keepMove;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 双向通信客户端
 * 多加的东西，在向输出流write之后
 * 使用socket.shutdownOutput();方法通知server我已经发送完消息了，
 * 开始接收消息
 * 打开一个输入流，巴拉巴拉
 * Created by wangchao on 2018/5/28.
 */
public class CommSocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好  yiwangzhibujian";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        //通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from server: " + sb);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
