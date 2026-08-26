class Solution {
    
    public void generatePermutation(int[] arr, List<List<Integer>> ans, List<Integer> ds, int[] vis){
       if(ds.size()==arr.length){
        ans.add(new ArrayList<>(ds));
        return;
       }

       for(int i=0;i<arr.length;++i){
        if(vis[i]==1) continue;
 
        vis[i] = 1;
        ds.add(arr[i]);
        generatePermutation(arr, ans, ds, vis);
        vis[i] = 0;
        ds.remove(ds.size()-1);
       }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        int[] vis = new int[nums.length];
        generatePermutation(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
}
