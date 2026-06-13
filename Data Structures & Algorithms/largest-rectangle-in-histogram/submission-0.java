class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        int ans = 0;
        // for(int i=0;i<n;++i){
        //     nse[i] = -1;
        //     pse[i] = -1;
        // }

        // whilc(curr>=st.top()) pop();

        for(int i=n-1;i>=0;--i){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()) 
              nse[i] = st.peek();
            else 
              nse[i] = n;
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i=0;i<n;++i){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()) 
              pse[i] = st.peek();
            else 
              pse[i] = -1;
            st.push(i);
        }

        for(int val : nse){
            System.out.print(val+" ");
        }
        System.out.println(" ");
        for(int val : pse){
            System.out.print(val+" ");
        }


       
        for(int i=0;i<n;++i){
          int window = nse[i] - pse[i] - 1;
          ans = Integer.max(ans, heights[i]*window);
        }
       

        
            return ans;
    }
}
