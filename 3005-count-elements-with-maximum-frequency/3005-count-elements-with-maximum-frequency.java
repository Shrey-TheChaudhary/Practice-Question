class Solution {
    public int maxFrequencyElements(int[] nums) {
        int a[]=new int[101];
        for(int i:nums)
        {
            a[i]++;
        }
        int max=0;
        for(int i=0;i<=100;i++)
        {
            max=Math.max(max,a[i]);
        }
        int ans=0;
        for(int i=0;i<=100;i++)
        {
            if(a[i]==max)
            {
                ans+=max;
            }
        }
        return ans;
    }
}