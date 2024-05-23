class Solution {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        
        for(int i=0;i<nums.size();i++){
            
            List<Integer> li = new ArrayList<>();
            for(int j=i;j<nums.size();j++)
            {
                int ele = nums.get(j);
                if(!li.contains(ele))
                    li.add(ele);
            
                result += li.size()*li.size();
            }
        }
        return result;
    }
}