class Solution {
    public boolean isPossibleToSplit(int[] nums) {
      
//         HashMap<Integer,Integer> hs=new HashMap<>();
        
//         for(int i: nums)
//             hs.put(i,hs.getOrDefault(i,0)+1);
        
//         for(int x:hs.values())
//         {
//             if(x>2)
//                 return false;
//         }
//         return true;
        
        int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
            if (count[n]>2) 
                return false;
        }
        return true;
    }
}