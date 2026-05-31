class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;++i){
           // We need to maintain monotonic deque (Decreasing order)
           // Remove out of window element from dequeue
            while(!dq.isEmpty() && dq.peekFirst()<=(i-k)){
                dq.pollFirst();
            }


            //Reomve last element from deque if current is greater 
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
               dq.offerLast(i);

            if(i>=k-1){
              ans.add(nums[dq.peekFirst()]);
            }


        }


        int[] res = new int[ans.size()];

for(int i = 0; i < ans.size(); i++) {
    res[i] = ans.get(i);
}

return res;
    }
}
