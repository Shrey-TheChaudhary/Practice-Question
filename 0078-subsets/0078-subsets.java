class Solution {
     public List<List<Integer>> subsets(int[] nums) {
         
        List<List<Integer>> res=new ArrayList<>();
        subsequence(0, nums, new ArrayList<>(), res);
        return res;
    }
    
   void subsequence(int ind , int[] nums , List<Integer> subset, List<List<Integer>> result){
       
        if(ind >= nums.length )
        {
        result.add(new ArrayList<>(subset));
        return;
        }

        //for the current element 
        subset.add(nums[ind]);
        subsequence(ind +1, nums , subset ,result);

        //exclude the current element
        subset.remove(subset.size() - 1 );
        subsequence(ind +1 , nums,subset , result);

    }
}
   