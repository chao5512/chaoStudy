package nio.buffer;

import java.nio.IntBuffer;

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
