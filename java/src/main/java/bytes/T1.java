package bytes;


import java.util.Arrays;

/**
 * Created by wangchao on 2018/4/25.
 */
public class T1 {
    /**
     * <p>When scanning for a prefix the scan should stop immediately after the the last row that
     * has the specified prefix. This method calculates the closest next rowKey immediately following
     * the given rowKeyPrefix.</p>
     * <p><b>IMPORTANT: This converts a rowKey<u>Prefix</u> into a rowKey</b>.</p>
     * <p>If the prefix is an 'ASCII' string put into a byte[] then this is easy because you can
     * simply increment the last byte of the array.
     * But if your application uses real binary rowids you may run into the scenario（脚本） that your
     * prefix is something like:</p>
     * &nbsp;&nbsp;&nbsp;<b>{ 0x12, 0x23, 0xFF, 0xFF }</b><br/>
     * Then this stopRow needs to be fed into the actual scan<br/>
     * &nbsp;&nbsp;&nbsp;<b>{ 0x12, 0x24 }</b> (Notice that it is shorter now)<br/>
     * This method calculates the correct stop row value for this usecase.
     *
     * @param rowKeyPrefix the rowKey<u>Prefix</u>.
     * @return the closest next rowKey immediately following the given rowKeyPrefix.
     */
     static byte[] calculateTheClosestNextRowKeyForPrefix(byte[] rowKeyPrefix) {
        // 基本上我们都把rowkeyPrefix作为 'unsigned very very long'加一.
        // 寻找以 0xFFs 结尾start
        int offset = rowKeyPrefix.length;
        while (offset > 0) {
            if (rowKeyPrefix[offset - 1] != (byte) 0xFF) {
                break;
            }
            offset--;
        }

        if (offset == 0) {
            // 获得了一个 0xFFFF... (only FFs) 的stopRow，这已经是我们能表达的最大字节数组了
            // 即stopRow为无穷大，扫描至表尾
            return new byte [0];
        }

        // Copy the right length of the original
        byte[] newStopRow = Arrays.copyOfRange(rowKeyPrefix, 0, offset);
        // And increment the last one
        newStopRow[newStopRow.length - 1]++;
        return newStopRow;
    }

    public static void main(String[] args) {
        byte[] bytes = Bytes.toBytes("r1");
        byte[] b = calculateTheClosestNextRowKeyForPrefix(bytes);
        System.out.println(Bytes.toString(b));
    }
}
