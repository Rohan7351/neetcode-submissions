class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int[] freq = new int[26];
        int mxFreq  = 0;
        int ans = 0;

        while(r<n){
          freq[s.charAt(r)-'A']++;
          mxFreq = Integer.max(mxFreq, freq[s.charAt(r)-'A']);

        // For invalid window shrink it 
        while(((r-l+1)-mxFreq)>k){
            freq[s.charAt(l)-'A']--;
            l++;
        }

        ans = Integer.max(ans, (r-l+1));
         r++;
        }

        return ans; 
    }
}
