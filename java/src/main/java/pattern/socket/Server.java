package pattern.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangchao on 2018/4/9.
 */
public class Server {
    ServerSocket serverSocket = null;
    public Server() throws IOException {
        serverSocket = new ServerSocket(10000,3);
        System.out.println("服务器启动");
    }
    public void service(){
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted "+
                        socket.getInetAddress()+":"+socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.service();
    }
}
