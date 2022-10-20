package Solution;

public class Solution22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //ListNode kthFromEnd = getKthFromEnd(head, 2);
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.getKthFromEnd(head, 2).val);
    }
//    public static ListNode getKthFromEnd(ListNode head, int k){
//        int num = 1;
//        ListNode location = head;
//        int s = Num(location,num)-k;
//        for (int i = 1; i <= s; i++) {
//            location = location.next;
//        }
//        return location;
//    }
//    public static int Num(ListNode location,int num){
//        while (location.next != null){
//            num++;
//            location = location.next;
//        }
//        return num;
//    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x){
//        val = x;
//    }
//}