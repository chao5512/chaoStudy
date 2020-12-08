package nio.buffer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
    * Example use of java.nio for writing.
    * <p/>
    * It needs a directory E:\temp to write a test file to.
    *
    * @author Roedy Green, Canadian Mind Products
    * @version 1.0 2009-01-01 initial version
    * @since 2009-01-01
    */
public class TestNioWrite
{
    /**
     * Display state of channel/buffer.
     *
     * @param where description of where we are in the program to label the state snapzhot
     * @param fc    FileChannel reading/writing.
     * @param b     Buffer to display state of:
     *
     * @throws java.io.IOException if I/O problems.
     */
    private static void showStats(String where, FileChannel fc, Buffer b ) throws IOException
    {
        System.out.println( where +
                         " channelPosition: " +
                         fc.position() +
                         " bufferPosition: " +
                         b.position() +
                         " limit: " +
                         b.limit() +
                         " remaining: " +
                         b.remaining() +
                         " capacity: " +
                         b.capacity() );
    }

    /**
     * write some raw bytes to file
     *
     * @throws java.io.IOException if problems writing bytes.
     */
    private static void writeRawBytes() throws IOException
    {
        final FileOutputStream fos = new FileOutputStream("/home/wangchao/chaoStudy/java/src/main/java/nio/buffer/out.txt" );
        // allocate a channel to write that file
        FileChannel fc = fos.getChannel();
        // allocate a buffer, as big a chunk as we are willing to handle at a pop.
        //  Unlike the buffer on a stream, item is up to you not to overflow the buffer.
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 15 );
        showStats( "newly allocated write", fc, buffer );
        // write 10 buffers each partly full.
        for ( int i = 0; i < 10; i++ )
        {
            // prepare buffer to fill with data.
            buffer.clear();
            showStats( "after clear", fc, buffer );
            // Put some data in the buffer, up to 15K worth.
            for ( int j = 0; j < 100; j++ )
            {
                // Put bytes, not char[] or String.
                buffer.put( "hello".getBytes( "8859_1"/* encoding */ ) );
                showStats( "after put", fc, buffer );
            }
            // flip from filling to emptying to prepare buffer for write
            showStats( "before flip", fc, buffer );
            buffer.flip();
            showStats( "after flip", fc, buffer );
            // write a chunk of raw bytes, up to 15K bytes long
            fc.write( buffer );
            showStats( "after write", fc, buffer );
        }
        fc.close();
    }

    /**
     * test harness
     *
     * @param args not used
     *
     * @throws java.io.IOException if trouble writing bytes.
     */
    public static void main( String[] args ) throws IOException
    {
        writeRawBytes();
    }
}
