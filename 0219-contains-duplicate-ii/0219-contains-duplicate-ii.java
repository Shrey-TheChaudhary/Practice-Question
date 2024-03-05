// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         if (k == 0) 
//             return false;

//     Map<Integer, Integer> hashMap = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) 
//     {
//         int integer = nums[i];
// if (hashMap.containsKey(integer) && i - hashMap.get(integer) <= k)
//             return true;
        
//           hashMap.put(integer, i);
//     }
//         return false;
//     }
// }

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int temp = Math.abs(map.get(nums[i]) - i);
                if(temp <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;  
    }
}