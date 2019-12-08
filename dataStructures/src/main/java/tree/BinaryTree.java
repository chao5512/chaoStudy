package tree;

import Collection.ArrayList;
import javax.swing.tree.TreeNode;

/**
 * Created by wangchao on 2018/7/24.
 */
public class BinaryTree<T> {
    /**
     * tree节点
     */
    public static class TreeNode<T>{
        private T data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(T data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getData() {
            return data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }
    }

    TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getLeftChild(){
        if(root!=null){
            return root.getLeftChild();
        }
        return null;
    }

    public TreeNode getRightChild(){
        if(root!=null){
            return root.getRightChild();
        }
        return null;
    }
    /**
     * 获取节点个数
     */
    public int size(){
        return size(root);
    }
    public int size(TreeNode t){
        if(t==null){
            return 0;
        }
        return size(t.getLeftChild())+size(t.getRightChild());
    }
    /**
     * 二叉树的深度优先前序遍历
     */
    public ArrayList<T> deepthFirstPre(){
        ArrayList<T> tArrayList = new ArrayList<>(10);
        return null;
    }
}

