class MinStack {

    private Stack<int[]> stack;
    public MinStack() {
        stack=new Stack<int[]>();
    }
    
    public void push(int val) {
        
        if(stack.isEmpty())
        {
            stack.push(new int[]{val,val});
            return;
        }
        int currentmin=stack.peek()[1];
        stack.push(new int[]{val,Math.min(val,currentmin)});
        return;
    }
    
    public void pop() {
       if(!stack.isEmpty()) {stack.pop();}
    }
    
    public int top() {
          if(!stack.isEmpty()) {
            return  stack.peek()[0];
          }
        return 0;
    }
    
    public int getMin() {
          if(!stack.isEmpty()) {
            return  stack.peek()[1];
          }
         return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */