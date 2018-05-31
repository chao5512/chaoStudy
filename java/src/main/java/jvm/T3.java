package jvm;

import com.sun.media.sound.SoftTuning;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * jvm option： -Xmx10m  -Xms5m
 * 使用Runtime获得堆的分配情况
 * jvm会尽量保持在mxs最小堆大小，如果gc完后实在不能小于最小堆，才扩容
 * Created by wangchao on 2018/5/4.
 */
public class T3 {
    private final static int _1M=1*1024*1024;
    public static void main(String[] args) {
        System.out.println("可申请的最大堆空间"+Runtime.getRuntime().maxMemory()/1024.00/1024+"M");
        System.out.println("堆可用空间"+Runtime.getRuntime().freeMemory()/1024.00/1024+"M");
        System.out.println("堆实际大小"+Runtime.getRuntime().totalMemory()/1024.00/1024+"M");
        System.out.println();
        System.out.println("分配1M");
        alloc(2);
        System.out.println("可申请的最大堆空间"+Runtime.getRuntime().maxMemory()/1024.00/1024+"M");
        System.out.println("堆可用空间"+Runtime.getRuntime().freeMemory()/1024.00/1024+"M");
        System.out.println("堆实际大小"+Runtime.getRuntime().totalMemory()/1024.00/1024+"M");
        System.out.println();
        System.out.println("分配4M");
        alloc(4);
        System.out.println("可申请的最大堆空间"+Runtime.getRuntime().maxMemory()/1024.00/1024+"M");
        System.out.println("堆可用空间"+Runtime.getRuntime().freeMemory()/1024.00/1024+"M");
        System.out.println("堆实际大小"+Runtime.getRuntime().totalMemory()/1024.00/1024+"M");
        System.out.println();
        System.out.println("手动GC");
        System.gc();
        System.out.println("可申请的最大堆空间"+Runtime.getRuntime().maxMemory()/1024.00/1024+"M");
        System.out.println("堆可用空间"+Runtime.getRuntime().freeMemory()/1024.00/1024+"M");
        System.out.println("堆实际大小"+Runtime.getRuntime().totalMemory()/1024.00/1024+"M");

    }
    public static void alloc(int p){
        byte[] bytes = new byte[p*_1M];
    }
}
