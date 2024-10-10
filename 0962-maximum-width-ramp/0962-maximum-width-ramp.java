class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int maxWidth = 0;

        // Build a decreasing stack of indices
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // Traverse from right to left to find the maximum width ramp
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }
}