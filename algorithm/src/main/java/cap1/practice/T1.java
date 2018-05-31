package cap1.practice;

/**
 * 命令行参数
 * Created by wangchao on 2018/5/24.
 */
public class T1 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length-1; i++) {
            System.out.println(args[i]);
            if(!args[i].equals(args[i+1])){
                System.out.println("not equal!");
                System.exit(0);
            }
        }
        System.out.println("equal!!");
    }
}
