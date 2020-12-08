package nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * buffer创建示例.
 * Created by wangchao on 2018/6/29.
 */
public class CreateBufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer1 = IntBuffer.allocate(10);
        int[] bytes = new int[10];
        IntBuffer intBuffer2 = IntBuffer.wrap(bytes);
        IntBuffer intBuffer3 = IntBuffer.wrap(bytes, 1, 5);
        print(intBuffer1, intBuffer2, intBuffer3);

        System.out.println("focus on the equal method");
        byte[] b1 = "1test".getBytes(StandardCharsets.UTF_8);
        byte[] b2 = "test1".getBytes(StandardCharsets.UTF_8);
        ByteBuffer w1 = ByteBuffer.wrap(b1);
        w1.position(1); // "1test" pos = 1 limit = 5
        System.out.println(w1.position());
        ByteBuffer w2 = ByteBuffer.wrap(b2);
        w2.limit(4); //"test1" pos = 0 limit = 4

        System.out.println(" it should be equaled:" + w2.equals(w1));

        System.out.println("考察进出顺序");
        IntBuffer ints = IntBuffer.allocate(3);
        ints.put(1);
        System.out.println("put 1.");
        ints.put(2);
        System.out.println("put 2.");
        print(ints);
        ints.flip();
        print(ints);
        IntBuffer duplicate = ints.duplicate();
        System.out.println("get: " + duplicate.get());
        print(duplicate);
        //System.out.println("get: " + ints.get());
        ints.flip();
        ints.put(3);
        ints.flip();
        IntBuffer duplicate1 = ints.duplicate();
        print(duplicate, duplicate1, ints);
        System.out.println("put " + 3);
        System.out.println("get: " + duplicate1.get());
        System.out.println("get: " + duplicate1.get(1));

    }

    public static void print(IntBuffer... ib) {
        for (IntBuffer buffer : ib) {
            System.out.println("capacity=" + buffer.capacity()
                    + ",limit=" + buffer.limit()
                    + ",position=" + buffer.position()
                    + ",hasRemaining:" + buffer.hasArray()
                    + ",remaining=" + buffer.remaining()
                    + ",hasArray=" + buffer.hasArray()
                    + ",isReadOnly=" + buffer.isReadOnly()
                    + ",arrayOffset=" + buffer.arrayOffset());
        }
    }
}
