package algs4.unionfind;

/**
 * Created by wangchao on 2018/6/14.
 */
public interface UF {
    int find(int x);
    boolean connected(int x,int y);
    void union(int x,int y);
    int count();
}
