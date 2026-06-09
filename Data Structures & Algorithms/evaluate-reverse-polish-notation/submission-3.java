class Solution {

    public int solve(int first,int second ,String ch){
         if(ch.equals("+")){
           return first + second;
         }else if(ch.equals("-")){
           return second - first ;
         }else if(ch.equals("*")){
           return first * second;
         }else if(ch.equals("/")){
           return second / first;
         } 

         return 0;
    }
    public int evalRPN(String[] tokens) {
      Stack<Integer> st = new Stack<>();
      
        for(String ch : tokens){
           if(ch.equals("+") ||ch.equals("-") ||ch.equals("/") ||ch.equals("*")){
                int first = st.pop();
                int second = st.pop();
                int temp = solve(first, second , ch);
                st.push(temp);
           }else{
             st.push(Integer.parseInt(ch));
           }
        }

        return st.peek();
    }
}
