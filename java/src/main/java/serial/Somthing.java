package serial;

import java.io.Serializable;

/**
 * Created by wangchao on 2018/5/18.
 */
public class Somthing implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
