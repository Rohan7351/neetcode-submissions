/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode reversedList(ListNode head){
       if(head==null || head.next==null) return head;

       ListNode newHead = reversedList(head.next);
        head.next.next = head;
        head.next = null;
       return newHead;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode r1 = l1;
      ListNode r2 = l2;
      ListNode dummy = new ListNode(-1);
      ListNode temp = dummy;
      int query = 0;

      while (r1 != null || r2 != null ) {
    int sum = query;

    if (r1 != null) {
        sum += r1.val;
        r1 = r1.next;
    }

    if (r2 != null) {
        sum += r2.val;
        r2 = r2.next;
    }

    temp.next = new ListNode(sum % 10);
    temp = temp.next;

    query = sum / 10;
}

if(query>0){
    temp.next = new ListNode(query);
}

return dummy.next;

 }
}
