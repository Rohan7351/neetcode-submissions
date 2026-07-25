class Solution {
    public int lastStoneWeight(int[] stones) {

        if(stones.length==1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int val : stones){
            pq.offer(val);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            int diff = first - second;
            if(diff>0){
                pq.offer(diff);
            }
        }

        if(pq.size()==0) return 0;
        return pq.peek();
    }
}
