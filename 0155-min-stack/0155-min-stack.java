class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minimumStack;
    

    public MinStack() {
        stack = new Stack<>();
        minimumStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if (minimumStack.isEmpty()) {
            minimumStack.push(value);
        } else {
            minimumStack.push(Math.min(minimumStack.peek(), value));
        }
    }
    
    public void pop() {
        stack.pop();
        minimumStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */