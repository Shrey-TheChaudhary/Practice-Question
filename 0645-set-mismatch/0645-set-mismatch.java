// class Solution {
//     public int[] findErrorNums(int[] nums) {
        
//         int dup = 0, miss = 0;
//         HashSet<Integer> set = new HashSet<>();
        
//         // find duplicate using set
//         for(int i = 0; i < nums.length; ++i)
//         {
//             if(set.contains(nums[i]))  
//             dup = nums[i];
            
//             set.add(nums[i]);
//         }
        
//         // find missing
//         for(int i = 1; i <= nums.length; ++i){
//             if(set.contains(i) == false){
//                 miss = i;
//                 break;
//             }
//         }
        
//         return new int[]{dup, miss};
//     }
// }
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans=new int[2];
        int[] a=new int[10001];
        for(int i=0;i<nums.length;i++){
            if(a[nums[i]]==0)
                a[nums[i]]=-1;
            else
                a[nums[i]]*=-1;
        }
        for(int i=1;i<=nums.length;i++){
            if(a[i]==1)
                ans[0]=i;
            else if(a[i]==0)
                ans[1]=i;
        }
        return ans;
    }
}