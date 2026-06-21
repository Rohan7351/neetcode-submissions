class LRUCache {


   // Linked list start -------> end
   // Map<key, Node> lru

   Map<Integer, Node> mp ;
   int capacity;
   Node start = new Node(-1,-1);
   Node end = new Node(-1,-1);

    class Node{
    int key;
    int val;
    Node pre,next;

    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        start.next = end;
        end.pre = start;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            deleteNode(node);
            addToEnd(node);
            return node.val;

        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {

        Node node = new Node(key, value);
      
       if(mp.containsKey(key)){
          node = mp.get(key);
          node.val = value;
          deleteNode(node);
       }

       mp.put(key, node);

       if(mp.size()>capacity){
        Node lru = start.next;
        mp.remove(lru.key);
        deleteNode(lru);
       }
      
       addToEnd(node);

       return;    
    }

    public void deleteNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;

        node.next=null;
        node.pre=null;
    }

    public void addToEnd(Node node){
       Node preEnd = end.pre;

       preEnd.next = node;
       end.pre = node;
       node.next = end;
       node.pre = preEnd;

    }
}
