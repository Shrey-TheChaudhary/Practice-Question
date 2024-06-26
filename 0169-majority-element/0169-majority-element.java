class Solution {
    public int majorityElement(int[] nums) {
        //Moore’s Voting Algorithm:
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