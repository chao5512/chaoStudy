package concreteAlgs;

import java.io.PipedWriter;
import javax.swing.text.MaskFormatter;
import sun.jvm.hotspot.runtime.Bytes;

/**
 * 计算输入的十进制数n的二进制表示里面的1的个数.
 * Created by wangchao on 2018/8/24.
 */
public class CountOnes {
    int count1(int n){
        int i = 0;
        while (n>0){
            if(n%2==1){
                i++;
            }
            n/=2;
        }
        return i;
    }

    /**
     * 位运算改进版
     */
    int count2(int n){
        int i = 0;
        while (n>0){
            //每次循环将最右边的一个1置零
            n &= (n-1);
            i++;
        }
        return i;
    }

    /**
     * 位运算再改进版
     */
    int count3(int n){
        int i = 0;
        return 0;
    }

    int pow(int c){
        return 1<<c;
    }
    /**
     * 生成间隔的01
     * 用来对n进行分组，分组大小为2^n
     * MASK(0) = 01010101 01010101 01010101 01010101
     * MASK(1) = 00110011 00110011 00110011 00110011
     * MASK(2) = 00001111 00001111 00001111 00001111
     * MASK(3) = 00000000 11111111 00000000 11111111
     * MASK(4) = 00000000 00000000 11111111 11111111
     */
    int mask(int c){
        return 0x80000000/(pow(pow(c))+1);
    }
    //获取int型的二进制表示
    public static String getBinaryValue(int n) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < 32; i++) {
            int t = (n & 0x80000000 >>> i) >>> (31 - i);
            result.append(t);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        CountOnes countOnes = new CountOnes();
        System.out.println(countOnes.count1(255));

        System.out.println(countOnes.count2(255));

        System.out.println(getBinaryValue(countOnes.mask(0)));

        System.out.println(new Integer(5).bitCount(5));
    }
}
