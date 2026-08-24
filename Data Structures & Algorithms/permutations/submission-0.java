class Solution {
   public void generatePermutation(int[] nums, int ind, int[] vis,List<List<Integer>> ans,List<Integer> ds){

    if(ds.size()==nums.length){
        ans.add(new ArrayList<>(ds));
        return;
    }

    for(int i=ind;i<nums.length;++i){
           if(vis[i]==1) continue;
            vis[i] = 1;
            ds.add(nums[i]);

            generatePermutation(nums,0, vis, ans, ds);

            ds.remove(ds.size() - 1);
            vis[i] = 0;
    }

   }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int[] vis = new int[nums.length];

        generatePermutation(nums, 0 , vis, ans, ds);

        return ans;
    }
}
