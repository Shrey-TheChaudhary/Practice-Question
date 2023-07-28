class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return help(nums,0,nums.length-1,nums.length)>=0;
    }
     public int help(int[] nums,int i,int j,int n){
        if(i==j)
            return nums[i];
         
        int left=nums[i]-help(nums,i+1,j,n);
        int right=nums[j]-help(nums,i,j-1,n);
        return Math.max(left,right);
    }
}