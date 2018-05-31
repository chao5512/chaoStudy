package utils;

/**
 * Created by wangchao on 2018/1/26.
 */
public class StringDB {
    private int maxSize = 1000;
    private int index = 0;
    private String[] strings = new String[maxSize];
    boolean hasAdd = false;


    public StringDB(int maxSize) {
        this.maxSize = maxSize;
        strings = new String[maxSize];
    }

    public String[] getAll() {
        return strings;
    }

    public boolean add(String s){
        strings[index] = s;
        index++;
        hasAdd = true;
        return hasAdd;
    }
    public String[] getByContent(String target){
        //临时数组的长度怎么设定
        String[] tmps = new String[10];
        int i = 0;
        for(String s :strings){
            if(s.equals(target)){
                tmps[i] = s;
                i++;
            }
        }
        return tmps;
    }


}
