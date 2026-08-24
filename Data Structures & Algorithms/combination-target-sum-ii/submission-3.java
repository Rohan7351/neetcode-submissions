class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int[] arr, int target, List<Integer> ds, int ind){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<arr.length;++i){
            if(i>ind && arr[i]==arr[i-1])
             continue;

            if(arr[i]<=target){
                ds.add(arr[i]);
                helper(arr, target-arr[i], ds, i+1);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> ds = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates, target, ds, 0);

        return ans;
       
        
    }
}
