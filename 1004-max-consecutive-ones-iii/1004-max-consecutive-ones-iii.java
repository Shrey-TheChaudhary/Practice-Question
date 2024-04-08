// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int i=0,j=0;
//         int n=nums.length;
//         int countZeroes=0,ans=Integer.MIN_VALUE;

//         while(j<n) {
//             if(nums[j]==0) 
//                 countZeroes++;
            
//             if(countZeroes>k)
//             {
//                 if(nums[i]==0) 
//                     countZeroes--;
                
//                 i++;
//             }
//             ans = Math.max(ans,j-i+1);
//             j++;
//         }
//         return ans;

//     }
// }


//STRIVER
class Solution {
    public int longestOnes(int[] nums, int k) {
        int count  = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        int n = nums.length;

        while(r<n){
            if(nums[r]==0) 
                count++;

            if(count>k){
                if(nums[l] == 0) 
                    
                    count--;
                l++;
            }

            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}