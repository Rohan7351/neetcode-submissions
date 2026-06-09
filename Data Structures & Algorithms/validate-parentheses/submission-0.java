class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch==')'|| ch==']' || ch=='}'){
                if(st.isEmpty()) return false;

                char top = st.pop();

                if((ch==')' && top!='(') || (ch==']' && top!='[')  || (ch=='}' && top!='{'))
                  return false;

            }else{
                st.push(ch);
            }
        }

        if(st.size()>0)
         return false;

         return true;
    }
}
