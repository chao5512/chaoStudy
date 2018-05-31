package pattern.iterator.studentManager;

/**
 * 学生类，目前只有姓名和年龄，且未做数据校验
 * Created by wangchao on 2017/11/8.
 */
public class Student {
    private String studentName;
    private int age;

    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }
}
