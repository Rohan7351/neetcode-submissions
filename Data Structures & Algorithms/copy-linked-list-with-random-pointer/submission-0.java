/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node,Node> mp = new HashMap<>();
        Node curr = head;
       // traverse the list and create new diff node .
        while(curr!=null){   
            mp.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

       //linking new node via assigning next and random pointer   
        while(curr!=null){
          Node node = mp.get(curr); 
          Node nextNode = mp.get(curr.next);
          Node randomNode = mp.get(curr.random);
          node.next = nextNode;
          node.random = randomNode; 
          curr = curr.next;
        }

        return mp.get(head);
    }
}
