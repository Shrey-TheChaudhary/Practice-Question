class SpecialQueue {

    Queue<Integer> q;
    Deque<Integer> minQ;
    Deque<Integer> maxQ;
    
    public SpecialQueue() {
        // Define Data Structures
        q = new LinkedList<>();
        minQ = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        q.offer(x);
        
        while(!minQ.isEmpty() && minQ.peekLast()>x) minQ.pollLast();
        
        minQ.offerLast(x);
        
        while(!maxQ.isEmpty() && maxQ.peekLast()<x) maxQ.pollLast();
        
        maxQ.offerLast(x);
    }

    public void dequeue() {
        // Remove element from the queue
        if(q.isEmpty()) return;
        
        int rem = q.poll();
        
        if(!minQ.isEmpty() && minQ.peekFirst()==rem)  minQ.pollFirst();
        
        if(!maxQ.isEmpty() && maxQ.peekFirst()==rem)  maxQ.pollFirst();
    }

    public int getFront() {
        // Get front element
        if(q.isEmpty()) return -1;
        return q.peek();
    }

    public int getMin() {
        // Get minimum element
        if(minQ.isEmpty())  return -1;
        return minQ.peekFirst();
    }

    public int getMax() {
        // Get maximum element
        if(maxQ.isEmpty())  return -1;
        return maxQ.peekFirst();
    }
}