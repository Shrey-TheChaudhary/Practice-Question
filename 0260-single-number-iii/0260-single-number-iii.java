class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0,ans1=-0,ans2=0;
        int arr[]=new int[2];
        for(int num:nums)
            xor=xor^num;
        
        int set=(xor&~(xor-1));
        
        for(int num:nums)
        {
            if((num & set)==0)
                ans1=ans1^num;
            else
                ans2=ans2^num;
        }
            arr[0]=ans1;
            arr[1]=ans2;
        
        return arr;
    }
}