package Solution;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.awt.*;

public class Solution18 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
//        Solution solution = new Solution();
//        ListNode a = solution.deleteNode(listNode,5);
//        while (a.next != null){
//            System.out.println(a.val);
//            a.next = a.next.next;
//        }
    }


}

//class Solution{
//    public ListNode deleteNode(ListNode head,int val){
//        ListNode node = new ListNode(val);
//        ListNode node1 = new ListNode(0);
//        if (head.val == val){
//            return head.next;
//        }
//
//        node1.next = head;
//        node.next = head.next;
//
//        while (node.next != null){
//            if (node.val == node.next.val){
//                node1.next.next = node.next.next;
//                return head;
//            }
//            node1.next = node.next;
//            node.next = node.next.next;
//        }
//        return head;
//    }
//}



class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}


