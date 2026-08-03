class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void generateSubset(int[] nums, int ind, List<Integer> ds){
        if(ind==nums.length){
           ans.add(new ArrayList(ds));
           return;
        }
        
        ds.add(nums[ind]);
        generateSubset(nums, ind+1, ds);
        ds.remove(ds.size()-1);
        generateSubset(nums, ind+1, ds);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> ds = new ArrayList<>();
         
         generateSubset(nums, 0, ds);

         return ans;

        
    }
}
