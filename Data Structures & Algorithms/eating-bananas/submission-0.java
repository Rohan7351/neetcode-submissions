class Solution {
    
    public int hoursCheck(int[] arr, int speed){

        int hours = 0;

        for(int val : arr){
           hours += (val+speed-1)/speed;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int max = 0;
        int sum = 0;
         for(int val : piles){
           min = Integer.min(val, min);
           max = Integer.max(val, max);
           sum += val;
         }

         int l = min ; 
         int r = max;
         int ans = 0;

         while(l<=r){
            int mid = l+(r-l)/2;

            if(hoursCheck(piles,mid)<=h){
               ans = mid;
               r = mid-1;
            }else{
               l = mid+1;
            }
        }

        return ans;
        
    }
}
