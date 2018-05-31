package pattern.iterator.chaosCollection;


/**
 * Created by wangchao on 2018/3/2.
 */

//public class TestCollection extends Collection {
//    public void add(){
//        /**
//         * 抽象类的add()方法是默认修饰符时，同一个包里可以super.add 不同包里不能super.add；
//         * 抽象类和接口不同
//         * 接口方法的默认修饰符是public
//         * 抽象类的修饰符符合普遍规则，即默认修饰符就是default
//         */
//        super.add();
//    }
//}
public class TestCollection{
    public static void main(String [] args){
        LinkedList<Cat> cats= new LinkedList<Cat>();
        for(int i = 0 ; i < 11 ; i++){
            cats.add(new Cat(i));
        }
        System.out.println(cats.size());

        //取出linkedlist里面的元素
        LinkedList.Node node = cats.getHead();
        do{
            if(node==null){
                System.out.println("none");
            }else{
                System.out.println((Cat)node.getData());
            }
            node = node.getNext();
        }while (node != null);
//        System.out.println((cats.getHead().getNext().getNext().getO()));
    }

    /**
     * 测试使用head=head.next遍历
     * public Object next() {
     *      Object o = head.getData();
     *      head = head.getNext();
     *      return o;
     * }
     * 这种实现方式移动了head
     * 改正：用一个iterator的成员变量来遍历
     * 每次对引用进行赋值 有改进的空间么
     *
     */
    public void testHead(){
//        Collection<Cat> cats= new LinkedList<Cat>();
        Collection<Cat> cats= new ArrayList<Cat>();
        for(int i = 0 ; i < 11 ; i++){
            cats.add(new Cat(i));
        }
        System.out.println(cats.size());

        Iterator iterator = cats.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
//            System.out.println("head"+cats.getHead());
        }
        System.out.println("-------------------------");
        Iterator iterator1 = cats.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
//            System.out.println("head"+cats.getHead());
        }

    }
}
