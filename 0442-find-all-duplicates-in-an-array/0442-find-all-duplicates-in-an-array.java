class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+1];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
            ans[nums[i]] += 1;
        
        for(int i = 0; i < ans.length; i++)
            if(ans[i] == 2)
                al.add(i);
        
        return al;
    }
}