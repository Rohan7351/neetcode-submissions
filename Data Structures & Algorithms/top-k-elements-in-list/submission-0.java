class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      int n = nums.length;
      
      // Story point 
      // 1. Create an map to track frequency
      // 2.  Create an bucket to stror elament acc to their frequncy 
      // 3.  Traverse to bucket to get k element
    
     Map<Integer, Integer> mp = new HashMap<>();
     List<Integer>[] bucket = new List[n+1];

     int[] ans = new int[k];

     for(int i=0;i<n;++i){
      mp.put(nums[i], mp.getOrDefault(nums[i], 0)+ 1);
     }

     for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
       int ind = entry.getValue();
        if(bucket[ind]==null){   // To habndle null issue 
           bucket[ind] = new ArrayList<>();
        }
       bucket[ind].add(entry.getKey());
     }

     
     int ind = 0;
     for(int pos=n;pos>=0;pos--){
      if(bucket[pos]!=null){
         for(int i=0;i<bucket[pos].size() && ind<k;++i){
            ans[ind] = bucket[pos].get(i);
            ind++;
         }
      }
     }

      return ans;

        
    }
}
