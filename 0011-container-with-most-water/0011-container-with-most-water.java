class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Calculate the area of the current container
            int area = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, area);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}