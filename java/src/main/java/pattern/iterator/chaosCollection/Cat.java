package pattern.iterator.chaosCollection;

/**
 * Created by wangchao on 2018/3/5.
 */
public class Cat {
    private int id;

    public Cat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cat{"  + id +
                "：喵喵喵";
    }
}
