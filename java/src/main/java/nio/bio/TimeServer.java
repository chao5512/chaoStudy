package nio.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * client可以发送请求指令"GET CURRENT TIME"给server端，
 * 每隔5秒钟发送一次，每次server端都返回当前时间
 * 虑到TCP编程中，不可避免的要处理粘包、解包的处理，这里为了简化，
 * server在解包的时候，每次读取一行，认为一行就是一个请求。
 * 考虑到可能会有多个client同时请求server，我们针对每个client创建一个线程来进行处理
 * Created by wangchao on 2018/6/24.
 */
public class TimeServer {
    public static void main(String[] args){
        ServerSocket timeServer = null;
        try {
            timeServer = new ServerSocket(1234);
            while (true){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class TimeServerHandler implements Runnable{
        private Socket clientProxy;

        public TimeServerHandler(Socket clientProxy) {
            this.clientProxy = clientProxy;
        }

        @Override
        public void run() {
            //向客户端回显时间
        }
    }

}
