package nio.test;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by wangchao on 2019/11/8.
 */
public class Network {
    @Test
    public void getIP(){

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements()){
                //相当于一块网卡？
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("名字： " + networkInterface.getDisplayName());
                System.out.println("硬件地址" + networkInterface.getHardwareAddress());
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println(inetAddress.getAddress().toString());
                    System.out.println(inetAddress instanceof Inet4Address?"v4":(inetAddress instanceof Inet6Address?"v6":"这是啥"));
                    System.out.println("主机名" + inetAddress.getHostName());
                    System.out.println(inetAddress.getHostAddress());
                }

                System.out.println();
                System.out.println();
                System.out.println();

            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
