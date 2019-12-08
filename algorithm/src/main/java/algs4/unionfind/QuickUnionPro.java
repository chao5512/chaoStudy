package algs4.unionfind;

import edu.princeton.cs.algs4.StdOut;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * UinonFind的quickUnion解法.
 * 使用weight来平衡树，不让其过高
 * Created by wangchao on 2018/6/14.
 */
public class QuickUnionPro implements UF{
    private int hi = 10000;
    private int[] ints;
    private int count;

    public QuickUnionPro(int n) {
        this.ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
        count = ints.length;
    }

    /**
     * 查找root，root表示为
     * @param x
     * @return
     */
    public int find(int x){
        if(x == ints[x]){
            return x;
        }
        while (ints[x]<=hi){
            x = ints[x];
        }
        return x;
    }

    @Override
    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x==y;
    }

    /**
     * 合并两棵树，把小树放在大树下面
     * todo:如何判断xy已经相连
     */
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if(connected(x,y)){
            return;
        }
        
        int xe = ints[x];
        int ye = ints[y];
        if(xe <= hi&&ye>hi){
            ints[y] += 1;
            ints[x] = y;
            count--;
            return;
        }
        if(ye<=hi&&xe>hi){
            ints[x] += 1;
            ints[y] = x;
            count--;
            return;
        }
        if(ye<=hi&&xe<=hi){
            ints[y] = hi +2;
            ints[x] = y;
            count--;
            return;
        }
        if(ye>hi&&xe>hi){
            if(ye>xe){
                ints[y]+=ints[x];
                ints[x] = y;
                count--;
            }else{
                ints[x]+=ints[y];
                ints[y] = x;
                count--;
            }
        }
//        if(xe >ye){
//            ints[x] = xe + ye - hi;
//            ints[y] = x;
//        }
    }

    @Override
    public int count() {
        return count;
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
        UF quickUnionPor = new QuickUnionPro(n);

        String linetxt ;
        while ((linetxt = bufferedReader.readLine())!=null) {
//            quickFind.print();
            String[] split = linetxt.split(" ");

            int p = Integer.parseInt(split[0]);
            int q = Integer.parseInt(split[1]);
            if (quickUnionPor.connected(p, q)) continue;
            quickUnionPor.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickUnionPor.count() + " components");
    }
}
