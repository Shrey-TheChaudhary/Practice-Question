class Solution {
    public int majorityElement(int[] nums) {
        //Moore’s Voting Algorithm:
        //Initialize 2 variables:
// Count –  for tracking the count of element
// Element – for which element we are counting
// Traverse through the given array.
// - If Count is 0 then store the current element of the array as Element.
// - If the current element and Element are the same increase the Count by 1.
// - If they are different decrease the Count by 1.
        
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

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n=nums.length;
//         HashMap<Integer,Integer> hm=new HashMap<>();
        
//         for(int i:nums)
//         {
//             hm.put(i,hm.getOrDefault(i,0)+1);
//         }
//          for (Map.Entry<Integer, Integer> it : hm.entrySet()) {
//             if (it.getValue() > (n / 2)) 
//                 return it.getKey();
//         }
//         return -1;
            
//     }
// }