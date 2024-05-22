class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for(int num : nums1)
            hs1.add(num);

        for(int num : nums2)
            hs2.add(num);

        for(int num : nums1){
            res[0] += hs2.contains(num) ? 1 : 0;
        }

        for(int num : nums2){
            res[1] += hs1.contains(num) ? 1 : 0;
        }
        return res;
    }
}