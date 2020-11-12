package nio.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/home/wangchao/pan");
        // getTotalSpace() 获得文件所在设备（磁盘，硬盘等）的总空间
        System.out.println(file.getAbsolutePath() + ":" + file.getTotalSpace()/(1024 * 1024 * 1024) + "G");
        try {
            //getCanonicalPath() 会把软连接改为它指向的路径
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
