class MedianFinder {
 PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue();
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(min.size() == max.size()){
            min.add(num);
            max.add(min.remove());
        }else{
            max.add(num);
            min.add(max.remove());
        }
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek())/2.0 : max.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */