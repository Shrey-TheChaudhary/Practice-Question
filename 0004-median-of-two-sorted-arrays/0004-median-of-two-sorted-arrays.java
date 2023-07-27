class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] ans = new int[n];

        int i=0, j=0, k=0;

        while (i<=n1 && j<=n2) {
            if (i == n1) {
                while(j<n2) 
                    ans[k++] = nums2[j++];
                break;
            } else if (j == n2) {
                while (i<n1) 
                    ans[k++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        if (n%2==0) 
            return (float)(ans[n/2-1] + ans[n/2])/2;
        else 
            return ans[n/2];
    }
}