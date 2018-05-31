package pattern.iterator.chaosCollection;

/**
 * Created by wangchao on 2018/3/5.
 */
public class LinkedList<E> implements Collection<E> {
    private Node head = null;
    private Node tail = null;
    private int INDEX = 0;

    public void add(E e) {
        Node node = new Node(e , null);
        //第一个节点作为头尾节点
        if(head == null){
            head = node;
            tail = node;
        }
        tail.setNext(node);
        tail = node;
        INDEX ++;
    }

    public int size() {
        return INDEX;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getINDEX() {
        return INDEX;
    }


    public class Node{
        private Object data;
        private Node next;

        public Node(Object data , Node node) {
            this.data = data;
            this.next = node;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }
    public Iterator iterator(){
        System.out.println("初始化"+head.getData());
        return new LinkedListIterator();
    }
    public class LinkedListIterator implements Iterator{
        Node headTmp = head;
        public Object next() {
            Object o = headTmp.getData();
            headTmp = headTmp.getNext();
            return o;
        }

        public boolean hasNext() {
            if(headTmp == null) return false;
            else return true;
        }
    }
}
