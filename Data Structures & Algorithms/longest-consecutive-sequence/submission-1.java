class Solution {
    public int longestConsecutive(int[] nums) {
        // Via sorting 
        Arrays.sort(nums);
        int ans = 0;
        int currLongest = 0;
        for(int i=0;i<nums.length;++i){
            if(i>0 && nums[i]==nums[i-1]) continue;

            if(i==0 || nums[i]==nums[i-1]+1){
                currLongest++;
                ans = Integer.max(ans, currLongest);
            }else{
                currLongest=1;
            }
        }

        return ans;

    }
}
