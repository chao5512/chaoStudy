package pattern.oo;

/**
 * Created by wangchao on 2018/3/6.
 */
public class Cow {
    private Cow mom;
    private int id;
    private int age;

    public Cow(int id, int age,Cow mom) {
        this.mom = mom;
        this.id = id;
        this.age = age;
    }
    public Cow birth(){
        int sonId = id+1000;
        return new Cow(sonId,1,mom);
    }
    public boolean fertility(){
        if(age>=5) return true;
        else return false;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cow:" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
