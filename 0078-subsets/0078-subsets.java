class Solution {
//      public List<List<Integer>> subsets(int[] nums) {
         
//         List<List<Integer>> res=new ArrayList<>();
//         subsequence(0, nums, new ArrayList<>(), res);
//         return res;
//     }
    
//    void subsequence(int ind , int[] nums , List<Integer> subset, List<List<Integer>> result){
       
//         if(ind >= nums.length )
//         {
//         result.add(new ArrayList<>(subset));
//         return;
//         }

//         //for the current element 
//         subset.add(nums[ind]);
//         subsequence(ind +1, nums , subset ,result);

//         //exclude the current element
//         subset.remove(subset.size() - 1 );
//         subsequence(ind +1 , nums,subset , result);

//     }
    
    //--Using bit manupilation
    
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int power=(int)Math.pow(2,n);
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num <power; num++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((num & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }

            ans.add(temp);
        }

        return ans;
    }
}
   