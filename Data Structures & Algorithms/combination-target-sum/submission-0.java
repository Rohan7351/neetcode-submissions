class Solution {

    List<List<Integer>> ans ; 
   
    public void helper(int[] arr, int target, List<Integer> ds, int ind){

        if(ind==arr.length){
            if(target==0)
          ans.add(new ArrayList<>(ds));
          return;
        }

        if(arr[ind]<=target){
           ds.add(arr[ind]);
           helper(arr, target-arr[ind],ds, ind);
           ds.remove(ds.size()-1);
           }
           helper(arr, target, ds, ind + 1);

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<Integer> ds = new ArrayList<>();
        ans  = new ArrayList<>();  
        helper(nums, target, ds, 0);
        return ans;
    }
}
