class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i =0; i<nums.length ;i++)
            q.add(nums[i]);
        
        for(int i=0;i<k-1;i++)
            q.remove();
        
        return q.peek();
    }
}