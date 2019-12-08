package algs4.unionfind;

import edu.princeton.cs.algs4.StdOut;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * unionfind偏向合并速度的解法.
 * 问题，可能会构成一颗非常高的树，这样的话，每次union都要回溯整棵树，效率低
 * Created by wangchao on 2018/6/13.
 */
public class QuickUnion implements UF{
    private int ints[];
    private int count;

    public QuickUnion(int n) {
        this.ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
        count = n;
    }

    public int find(int x) {
        while (ints[x] != x) {
            x = ints[x];
        }
        return x;
    }

    public void union(int x, int y) {
        if(connected(x,y)){
            return;
        }
        int xe = find(x);
        int ye = find(y);
        ints[xe] = ye;
        count--;
    }

    @Override
    public int count() {
        return count;
    }

    public boolean connected(int x,int y){
        return find(x)==find(y);
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
        QuickUnion quickUnion = new QuickUnion(n);

        String linetxt ;
        while ((linetxt = bufferedReader.readLine())!=null) {
//            quickFind.print();
            String[] split = linetxt.split(" ");

            int p = Integer.parseInt(split[0]);
            int q = Integer.parseInt(split[1]);
            if (quickUnion.connected(p, q)) continue;
            quickUnion.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickUnion.count() + " components");
    }
}
