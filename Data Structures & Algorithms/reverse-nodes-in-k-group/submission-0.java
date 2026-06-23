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

    public ListNode getKthNode(ListNode temp, int k){
       k = k - 1;
       while(temp!=null && k>0){
        k--;
        temp = temp.next;
       }
       return temp;
    }

    public ListNode reverseList(ListNode temp){
      if(temp==null || temp.next==null) return temp;

      ListNode newHead = reverseList(temp.next);

       temp.next.next = temp;
       temp.next = null;

       return newHead;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode preNode = null;

        while(temp!=null){
          ListNode kthNode = getKthNode(temp, k);
          
          if(kthNode==null){

            if(preNode!=null)
              preNode.next = temp;
            break;
          }else{
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);

            if(temp==head){
               head = kthNode;
            }else{
               preNode.next = kthNode;
            }
              preNode = temp;
              temp = nextNode;
          }

        }

        return head;
    }
}
