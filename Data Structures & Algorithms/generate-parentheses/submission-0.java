class Solution {
    
    public void helper(int n, List<String> ans, StringBuilder sb, int open,int close ){
         if(open==close && open==n){
            ans.add(sb.toString());
            return;
         }

         if(open>n || close>n) return;

        // we can add open
        sb.append('(');
        open++;
        helper(n,ans,sb,open,close);
        sb.deleteCharAt(sb.length() - 1);
        open--;
        // helper(n,ans,sb,open,close);
        // we can add close

        if(open>close){
         sb.append(')');
        close++;
        helper(n,ans,sb,open,close);
        sb.deleteCharAt(sb.length() - 1);
        close--;
        // helper(n,ans,sb,open,close);   
        }
         
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n , ans, sb, 0, 0);
        return ans;
    }
}
