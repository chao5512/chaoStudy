import Collection.Deque;
import Collection.DequeImpl;
import Collection.QueueArr;
import org.junit.Test;

/**
 * Created by wangchao on 2018/8/7.
 */
public class QueueTest {
    @Test
    public void testArr(){
        QueueArr<String> queue = new QueueArr<>(5);
        queue.push("e1");
        System.out.println(queue.size());
        queue.push("e2");
        System.out.println(queue.size());
        queue.push("e3");
        System.out.println(queue.size());
        queue.push("e4");
        System.out.println(queue.size());
//        queue.push("e5");
//        System.out.println(queue.size());
//        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("end");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
    @Test
    public void testList(){
        QueueArr<String> queue = new QueueArr<>(5);
        queue.push("e1");
        System.out.println(queue.size());
        queue.push("e2");
        System.out.println(queue.size());
        queue.push("e3");
        System.out.println(queue.size());
        queue.push("e4");
        System.out.println(queue.size());
//        queue.push("e5");
//        System.out.println(queue.size());
//        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("e5");
        System.out.println(queue.poll());
        queue.push("end");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void testDeque(){
        Deque<String> deque = new DequeImpl<>();
        deque.insertFirst("e1");
        deque.insertFirst("e2");
        deque.insertFirst("e3");
        deque.insertFirst("e4");
        deque.insertFirst("e5");
        System.out.println(deque.first()+":"+deque.last());
        deque.insertLast("e10");
        deque.insertLast("e9");
        deque.insertLast("e8");
        deque.insertLast("e7");
        deque.insertLast("e6");
        System.out.println(deque.first()+":"+deque.last());
        deque.pollFirst();
        System.out.println(deque.first());
        assert deque.first().compareTo("e4")==0;
        deque.pollLast();
        assert deque.last().compareTo("e7")==0;


        System.out.println(deque.size());
        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();

        deque.pollFirst();
        System.out.println(deque.size());
        deque.pollFirst();
        deque.pollFirst();


    }
}
