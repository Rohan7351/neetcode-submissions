class KthLargest {

    PriorityQueue<Integer> p = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0;i<nums.length; ++i){
            p.offer(nums[i]);
            if(p.size()>k)
             p.poll();
        }
    }
    
    public int add(int val) {

        p.offer(val);
        if(p.size()>k)
             p.poll();

             return p.peek();
        
    }
}
