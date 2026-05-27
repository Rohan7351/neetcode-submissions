class Solution {
    public int longestConsecutive(int[] nums) {
        // Optimised Approach using HashSet

        Set<Integer> s = new HashSet<>();
        int ans = 0;

        for(int val : nums){
            s.add(val);
        }

        for(int i=0;i<nums.length;++i){

            int curr = nums[i];
            int count = 1;

            // To improve it to O(n)
            if(s.contains(curr-1)) continue;

            while(s.contains(curr+1)){
                curr++;
                count++;
            }

            ans = Integer.max(ans, count);
        }

        return ans;
    }
}
