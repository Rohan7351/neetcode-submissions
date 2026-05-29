class Solution {
    public int characterReplacement(String s, int k) {
        int mxFreq  = 0;
        int left = 0;
        int n = s.length();
        int[] freq = new int[26];
        int ans = 0;

        for(int i=0;i<s.length();++i){
           
           int rightPos = s.charAt(i)-'A';

           freq[rightPos]++;
           mxFreq = Integer.max(mxFreq, freq[rightPos]);

           // Shrink the window till its valid 
           while(((i-left+1)-mxFreq)>k){  
               freq[s.charAt(left)-'A']--;
               left++;
           }

           ans = Integer.max(ans, i-left+1);

        //    freq[rightPos]++;   --- pushed to top
        //    mxFreq = Integer.max(mxFreq, freq[rightPos]);
        }

        return ans; 
    }
}
