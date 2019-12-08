package Collection;

import java.util.Random;

/**
 * @author wangchao
 * @date 2019/12/6 - 6:57 下午
 */
public class SkipList {
    private enum NodeType{
        HEAD,TAIL,DATA;

    }
    private class node{
        private Integer value;
        private node up,down,left,right;
        private NodeType nodeType;

        public node getUp() {
            return up;
        }

        public void setUp(node up) {
            this.up = up;
        }

        public node getDown() {
            return down;
        }

        public void setDown(node down) {
            this.down = down;
        }

        public node getLeft() {
            return left;
        }

        public void setLeft(node left) {
            this.left = left;
        }

        public node getRight() {
            return right;
        }

        public void setRight(node right) {
            this.right = right;
        }

        public node(Integer value, NodeType type) {
            this.value = value;
            nodeType = type;
        }
    }

    private node head;
    node tail;
    int size;
    Random random;

    public SkipList() {
        this.head = new node(null,NodeType.HEAD);
        this.tail = new node(null,NodeType.TAIL);
        size = 0;
        head.setRight(tail);
        tail.setLeft(head);
        random = new Random(System.currentTimeMillis());
    }

    node search(Integer i){
        node current = head;
        while (true) {
            while (current.getRight() != tail && i.compareTo(current.getRight().value) < 0) {
                current = current.getRight();
            }
            if (null != current.getDown()) {
                current = current.getDown();
            } else {
                break;
            }
        }

        return current;
    }
    void insert (Integer value){
        node insert = new node(value, NodeType.DATA);
        node search = search(value);
        if(search.nodeType==NodeType.HEAD){
            node current = head.getRight();
            head.setRight(insert);
            insert.setLeft(head);
            insert.setRight(current);
            current.setLeft(insert);
            //random

        }
    }
}
