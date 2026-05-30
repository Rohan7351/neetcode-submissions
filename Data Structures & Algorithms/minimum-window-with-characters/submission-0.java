class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> win  = new HashMap<>();
        int required = 0;
        int formed = 0;
        int ans = Integer.MAX_VALUE;
        String result = "";

        for(char ch : t.toCharArray()){
           need.put(ch, need.getOrDefault(ch, 0)+1);
        }

        required = need.size();

        int l = 0 ;
        for(int r=0;r<s.length();++r){
           char ch = s.charAt(r);
           win.put(ch, win.getOrDefault(ch, 0)+1);
           if(need.containsKey(ch) && need.get(ch)==win.get(ch)){
             formed++;
           }

           //  how to shrink window I am not clear using while loop 
            

           

           while(formed==required){ // valid window
            if(ans>(r-l+1)){
                ans = r-l+1;
                result = s.substring(l,l+ans);
            }
             ch = s.charAt(l);  
           if(need.containsKey(ch) && need.get(ch)==win.get(ch)){
             formed--;
           }
           
           win.put(ch, win.get(ch)-1);
           
           l++;
              
           }  
        }

        return result;
    }
}
