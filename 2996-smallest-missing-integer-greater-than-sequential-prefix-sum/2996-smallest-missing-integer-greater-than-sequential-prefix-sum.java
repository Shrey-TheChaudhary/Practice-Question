class Solution {
    public int missingInteger(int[] nums) {
        
        int pre=nums[0];
        for( int i=1; i<nums.length; i++)
        {
            if(nums[i]==nums[i-1]+1)
            {
                pre+=nums[i];
            }
            else
            {
                break;
            }
        }
        ArrayList<Integer>list=new ArrayList<>();

        for( int i=0; i<nums.length; i++)
        {
            list.add(nums[i]);
        }
        for( int i=0; i<nums.length; i++)
        {
            if(list.contains(pre))
            {
                pre++;
            }
        }
        return pre;
    }
}