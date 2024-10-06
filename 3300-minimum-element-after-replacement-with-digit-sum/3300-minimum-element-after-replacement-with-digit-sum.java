class Solution {
    public int minElement(int[] nums) {
        int ans=9999;
        for(int x:nums)
        {int sum=0;
            while(x>0)
            {
                sum+=x%10;
                x=x/10;
            }
         ans=Math.min(sum,ans);
        }
        return ans;
    }
}