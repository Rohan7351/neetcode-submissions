class Solution {
    public void generateSubset(int[] arr,int ind ,Set<List<Integer>> ans , List<Integer> ds){
          if(ind==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
          }
    
          ds.add(arr[ind]);
          generateSubset(arr, ind+1, ans, ds);
          ds.remove(ds.size()-1);
          generateSubset(arr, ind+1, ans, ds);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(nums, 0 , ans , ds);

        return new ArrayList<>(ans);

    }
}
