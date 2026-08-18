class Solution {

    List<List<Integer>> ans ; 
   
    public void helper(int[] arr, int target, List<Integer> ds, int ind){
        
            if(target==0){
          ans.add(new ArrayList<>(ds));
          return;
            }
       
 
        for(int i=ind;i<arr.length;++i){
            if(arr[i]<=target){
               ds.add(arr[i]);
               helper(arr, target-arr[i],ds, i);
               ds.remove(ds.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) { 
        List<Integer> ds = new ArrayList<>();
        ans  = new ArrayList<>();  
        helper(nums, target, ds, 0);
        return ans;
    }
}
