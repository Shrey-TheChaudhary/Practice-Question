class Solution {
    public int[] intersection(int[] nums1 , int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i : nums1 ) {
            hs1.add(i);
        }

        
        HashSet<Integer> hs2 = new HashSet<>();
        for (int i : nums2) {
            
            if (hs1.contains(i)) {
                hs2.add(i);
            }
        }

      
        int[] ans = new int[hs2.size()];
        int idx = 0;
        for (int i : hs2) {
            ans[idx++] = i;
        }
        return ans;
    }
}