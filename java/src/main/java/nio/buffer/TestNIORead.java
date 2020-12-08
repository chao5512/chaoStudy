package nio.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Example use of java.nio to read a file.
 * <p/>
 * Requires a test file of approximately 29K called E:\temp\tempin.txt
 *
 * @author Roedy Green, Canadian Mind Products
 * @version 1.0 2009-01-01 initial version
 * @since 2009-01-01
 */
public class TestNIORead {
    /**
     * read some raw bytes from a file
     *
     * @throws java.io.IOException if problems with read
     */
    @SuppressWarnings({"UnusedAssignment"})
    private static void readRawBytes() throws IOException {
        final FileInputStream fis = new FileInputStream("/home/wangchao/chaoStudy/java/src/main/java/nio/buffer/tmp.txt");
        // allocate a channel to read that file
        FileChannel fc = fis.getChannel();
        // allocate a buffer, as big a chunk as we are willing to handle at a pop.
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 15);
        showStats("newly allocated read", fc, buffer);
        // read a chunk of raw bytes, up to 15K bytes long
        // -1 means eof.
        int bytesRead = fc.read(buffer);
        showStats("after first read", fc, buffer);
        // flip from filling to emptying
        showStats("before flip", fc, buffer);
        buffer.flip();
        showStats("after flip", fc, buffer);
        byte[] receive = new byte[1024];
        buffer.get(receive);
        showStats("after first get", fc, buffer);
        buffer.get(receive);
        showStats("after second get", fc, buffer);
        // empty buffer to fill with more data.
        buffer.clear();
        showStats("after clear", fc, buffer);
        bytesRead = fc.read(buffer);
        showStats("after second read", fc, buffer);
        // flip from filling to emptying
        showStats("before flip", fc, buffer);
        buffer.flip();
        showStats("after flip", fc, buffer);
        fc.close();
    }

    /**
     * Display state of channel/buffer.
     *
     * @param where description of where we are in the program to label the state snapzhot
     * @param fc    FileChannel reading/writing.
     * @param b     Buffer to display state of:
     *
     * @throws java.io.IOException if I/O problems.
     */
    private static void showStats(String where, FileChannel fc, Buffer b) throws IOException {
        System.out.println(where +
                               " channelPosition: " +
                               fc.position() +
                               " bufferPosition: " +
                               b.position() +
                               " limit: " +
                               b.limit() +
                               " remaining: " +
                               b.remaining() +
                               " capacity: " +
                               b.capacity());
    }

    /**
     * test harness
     *
     * @param args not used
     *
     * @throws java.io.IOException if problems reading.
     */
    public static void main(String[] args) throws IOException {
        readRawBytes();
    }
}
