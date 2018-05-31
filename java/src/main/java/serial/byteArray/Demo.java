package serial.byteArray;

import serial.Somthing;

/**
 * Created by wangchao on 2018/5/18.
 */
public class Demo {
    public static void main(String[] args) {
        Somthing somthing = new Somthing();
        somthing.setId(1);
        somthing.setName("chao");

        ObjectAndByteArray objectAndByteArray = new ObjectAndByteArray();
        byte[] serialize = objectAndByteArray.serialize(somthing);
        for (byte b : serialize) {
            System.out.println(b);
        }
        System.out.println("序列化完成了");

        Somthing deserialize = (Somthing)objectAndByteArray.deserialize(serialize);
        System.out.println(deserialize.getId());
        System.out.println(deserialize.getName());
        System.out.println("反序列化完成了");

    }
}
