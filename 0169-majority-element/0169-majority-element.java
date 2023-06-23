class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, maxElement = 0;
        for(int num: nums)
        {
        if(count == 0) 
        maxElement = num;
                        
        if(num == maxElement) 
            count++;
         else 
            count--;
        }
        return maxElement;
    }
}