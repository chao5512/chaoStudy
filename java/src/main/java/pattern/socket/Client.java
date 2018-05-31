package pattern.socket;

import java.net.Socket;

/**
 * Created by wangchao on 2018/4/9.
 */
public class Client {
    public static void main(String[] args) throws Exception{
        String host = "localhost";
        int port = 10000;
        Socket socket = new Socket(host, port);
        socket.getOutputStream();
        System.out.println(" 连接成功！");

    }
}
