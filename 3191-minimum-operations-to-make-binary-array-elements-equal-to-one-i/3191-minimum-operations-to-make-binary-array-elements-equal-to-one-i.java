class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int i=0;i<n-2;i++){
            if(nums[i]==0){
                flip(nums,i);
                count++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                return -1;
            }
        }
        return count;
    }
    public void flip(int[] nums,int ind){
        for(int i=ind;i<ind+3;i++){
            if(nums[i]==0){
                nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
    }
}