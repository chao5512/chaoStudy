package algs4.unionfind;

import edu.princeton.cs.algs4.StdOut;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * unionFind的偏查询速度的解法.
 * Created by wangchao on 2018/6/13.
 */
public class QuickFind implements UF{
    private int array[];
    private int count;

    public QuickFind(int n) {
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        count = n;
    }

    /**
     * 在数组a中计算x和y是否联通.
     *
     * @param x 成员x
     * @param y 成员y
     * @return 是否联通
     */
    public boolean connected(int x, int y) {
        if (array[x] == array[y]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找x所在的联通分量.
     */
    public int find(int x) {
        return array[x];
    }

    /**
     * merge x and y
     */
    public void union(int x, int y) {
        int xe = find(x);
        int ye = find(y);
        if(xe == ye){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ye) {
                array[i] = xe;
            }
        }
        count--;
    }

    public int count(){
        return count;
    }
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            throw new IllegalArgumentException("参数非法，参数应为测试数据路径");
        }
        String path= args[0];
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        UF quickFind = new QuickFind(n);

        String linetxt ;
        while ((linetxt = bufferedReader.readLine())!=null) {
//            quickFind.print();
            String[] split = linetxt.split(" ");

            int p = Integer.parseInt(split[0]);
            int q = Integer.parseInt(split[1]);
            if (quickFind.connected(p, q)) continue;
            quickFind.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFind.count() + " components");
    }
}
