class Solution {
    public void generateSubset(int[] arr,int ind ,Set<List<Integer>> ans , List<Integer> ds){
        
            ans.add(new ArrayList<>(ds));
           
    
        //   ds.add(arr[ind]);
        //   generateSubset(arr, ind+1, ans, ds);
        //   ds.remove(ds.size()-1);
        //   generateSubset(arr, ind+1, ans, ds);
          for(int i=ind;i<arr.length;++i){
            if(i>ind && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            generateSubset(arr, i+1, ans, ds);
            ds.remove(ds.size()-1);
          }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(nums, 0 , ans , ds);

        return new ArrayList<>(ans);

    }
}
