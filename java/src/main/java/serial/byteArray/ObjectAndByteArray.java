package serial.byteArray;

import java.io.*;

/**
 * Created by wangchao on 2018/5/18.
 */
public class ObjectAndByteArray {
    /**
     * 对象转byte数组
     */
    public byte[] serialize(Object o){
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            bytes = baos.toByteArray();
            oos.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * byte数组转对象
     */
    public Object deserialize(byte[] b){
        Object o = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
            ois.close();
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
