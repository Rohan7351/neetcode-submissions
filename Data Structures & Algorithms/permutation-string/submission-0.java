class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;

        int[] freq = new int[26];
        int[] win = new int[26];

        for(int i=0;i<n;++i){
           freq[s1.charAt(i)-'a']++;
           win[s2.charAt(i)-'a']++;
        }

        if(match(freq, win)) return true; 

        for(int i=n;i<m;++i){
            win[s2.charAt(i)-'a']++;
            win[s2.charAt(i-n)-'a']--;

            if(match(freq, win)) return true;
        }

        return false;

        
    }


    public boolean match(int[] freq, int[] win){
        for(int i=0;i<26;++i){
            if(freq[i]!=win[i])
              return false;
        }
          return true;
    }
}
