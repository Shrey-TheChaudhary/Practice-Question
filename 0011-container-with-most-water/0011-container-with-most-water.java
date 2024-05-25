// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0, right = height.length - 1;
//         int maxWater = 0;

//         while (left < right) {
//             // Calculate the area of the current container
//             int area = Math.min(height[left], height[right]) * (right - left);
//             maxWater = Math.max(maxWater, area);

//             // Move the pointer pointing to the shorter line inward
//             if (height[left] < height[right]) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }

//         return maxWater;
//     }
// }

class Solution {
    public int maxArea(int[] height) {
        int ans = 0, i = 0, j = height.length-1, res = 0;
        while (i < j) {
            if (height[i] <= height[j]) 
            {
                res = height[i] * (j - i);
                i++;
            } else {
                res = height[j] * (j - i);
                j--;
            }
            ans=Math.max(ans,res);
        }
        return ans;
        }
}