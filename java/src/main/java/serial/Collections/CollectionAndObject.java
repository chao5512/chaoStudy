package serial.Collections;

import java.io.*;
import java.util.List;

/**
 * Created by wangchao on 2018/5/18.
 */
public class CollectionAndObject {
    /**
     * ArrayList序列化成byte[]
     */
    public byte[] serialize(List list){
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            for (int i = list.size()-1; i >=0; i--) {
                oos.writeObject(list.get(i));
            }
            oos.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
