class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n=nums.length;
        
        Deque<Integer> dq=new LinkedList<>();
        
        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
                dq.pollLast();
            
            dq.offerLast(i);
        }
        int ans[]=new int[n-k+1];
        int a=0;
        for(int i=k;i<n;i++)
        {
            ans[a++]=nums[dq.peek()];
            while(!dq.isEmpty() && dq.peek()<=i-k)
                dq.pollFirst();
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
                dq.pollLast();
            
            dq.offerLast(i);
        }
        ans[a]=nums[dq.peek()];
        
        return ans;
    }
}