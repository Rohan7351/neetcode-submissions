class Solution {
    public boolean isPalindrome(String str){
        int n = str.length();
        for(int i=0;i<str.length()/2;++i){
           if(str.charAt(i)!= str.charAt(n-1-i)){
              return false;
           }
        }
          return true;
    }
    
    public void helper(int ind, String s, List<List<String>> ans, List<String> ds){
     
      if(ind==s.length()){
        ans.add(new ArrayList(ds));
        return ;
      }

      for(int i=ind;i<s.length();++i){
         
         if(isPalindrome(s.substring(ind,i+1))){
           ds.add(s.substring(ind,i+1));
           helper(i+1, s, ans, ds);
           ds.remove(ds.size()-1);
         }
      }


    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        
        helper(0 , s, ans , ds);

        return ans;
    }
}
