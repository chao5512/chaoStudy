package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangchao on 2018/9/21.
 */


public class ListRevert {

    //链表反转
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            //当前节点
            ListNode cur = head;
            //左边的节点
            ListNode pre = null;
            //右边的节点
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


    }
    // 链表合并
    public void merge(ListNode list1, ListNode list2){
//        if(list1 == null){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
        ListNode tmp = null;
        if(list1.val<list2.val){
            tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        ListNode result = list2;
        while (list1!=null&&list2!=null){
//            if(list2.next==null){
//                list2.next=list1;
//                list1 = null;
//                break;
//            }

            while (list2.next!=null&&list2.next.val<=list1.val){
                list2=list2.next;
            }
            tmp = list2.next;
            list2.next = list1;
            list2 = list1;
            list1 = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;

        l4.next=l5;
        l5.next=l6;

        new ListRevert().merge(l1,l4);

    }

}