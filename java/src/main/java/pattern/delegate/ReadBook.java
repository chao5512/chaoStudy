package pattern.delegate;

/**
 * Created by wangchao on 2017/10/25.
 */
public class ReadBook implements ReadBookInterface{
    public void read(String bookName){
        System.out.println("读了:《"+bookName+"》");
    }
}
