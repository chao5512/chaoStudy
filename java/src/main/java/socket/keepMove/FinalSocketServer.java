package socket.keepMove;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 不关闭socket连接
 * 在流中，两个字节表示命令长度，后面跟这个长度的命令
 * 读取的时候，先读两个字节，确定长度length，再去流中读这个length长的byte[]
 * Created by wangchao on 2018/5/28.
 */
public class FinalSocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
        while (true) {
            // 首先读取两个字节表示的长度
            int first = inputStream.read();
            //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
            if(first==-1){
                break;
            }
            int second = inputStream.read();
            int length = (first << 8) + second;
            // 然后构造一个指定长的byte数组
            bytes = new byte[length];
            // 然后读取指定长度的消息即可
            inputStream.read(bytes);
            System.out.println("get message from client: " + new String(bytes, "UTF-8"));
        }
        inputStream.close();
        socket.close();
        server.close();
    }
}
