class SmallestInfiniteSet {
    int smallest;
    PriorityQueue<Integer> pq;
    
    public SmallestInfiniteSet() {
        smallest = 1;
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            return smallest++;
        }
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(num >= smallest || pq.contains(num)) {
            return;
        }
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */