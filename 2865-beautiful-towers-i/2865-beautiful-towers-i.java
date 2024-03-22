class Solution {
    public long maximumSumOfHeights(List<Integer> h) {
        int n=h.size(); long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) 
        {
            long sum=h.get(i), left=h.get(i), right=h.get(i);
            
            for(int j=i+1;j<n;j++)
            {
                left=Math.min(left, h.get(j));
                sum+=left;
            }
            for(int j=i-1; j>=0; j--) 
            {
                right=Math.min(right, h.get(j));
                sum+=right;
            }
            max=Math.max(max, sum);
        }
        return max;
    }
}