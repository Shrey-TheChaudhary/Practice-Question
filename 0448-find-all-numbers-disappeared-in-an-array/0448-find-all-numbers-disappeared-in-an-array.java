class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] memory = new int[nums.length+1];
        
        for(int i=0;i<nums.length;i++)
            memory[nums[i]]++;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<memory.length;i++)
            if(memory[i]==0)
                list.add(i);
        
        return list;
    }
}