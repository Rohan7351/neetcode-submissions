class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> st = new HashSet<>();
        int left = 0;
        int ans = 0;

        for(int i=0;i<s.length();++i){
            
            char ch = s.charAt(i);

            while(st.contains(ch)){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(ch);
            ans = Integer.max(i-left+1, ans);
        }

        return ans;
        
    }
}
