package jvm;

import java.util.Vector;

/**
 * -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/wangchao/IdeaProjects/bookRead/src/main/java/log
 * Created by wangchao on 2018/5/8.
 */
public class T5 {
    private final static int _1M=1*1024*1024;

    public static void main(String[] args) {
        Vector<Object> v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[_1M]);
        }
    }
}
