class MyQueue {
    public Stack<Integer> st1 = new Stack<>();
    public Stack<Integer> st2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        if(!st1.isEmpty())
        {
            return st1.pop();
        }
        return -1;
    }
    
    public int peek() {
        if(!st1.isEmpty())
        {
            return st1.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */