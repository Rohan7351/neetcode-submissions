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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head;

        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
        
        if(list1.val<=list2.val){
            head = list1;
            node1 = node1.next;
        }else{
            head = list2;
            node2 = node2.next;
        }

        ListNode curr=head;

        while(node1!=null && node2!=null){
            if(node1.val<=node2.val){
               curr.next = node1;
               curr = node1;
               node1 = node1.next;
            }else{
               curr.next = node2;
               curr = node2;
               node2 = node2.next; 
            }
        }

        if(node1!=null){
            curr.next = node1;
        }else{
            curr.next = node2;
        }


        return head;
    }
}