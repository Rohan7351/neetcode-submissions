class MinStack {

    Stack<Integer> st ;
    Stack<Integer> mono;

    public MinStack() {
        st = new Stack<>();
        mono = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        if(mono.isEmpty() || val<=mono.peek()) 
         mono.push(val);
    }
    
    public void pop() {
        int val = st.pop();

        if(!mono.isEmpty() && val == mono.peek())
          mono.pop();

    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }
    
    public int getMin() {
       return  mono.peek();
    }
}
