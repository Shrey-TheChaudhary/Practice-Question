class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array twice to handle the circularity
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result; 
    }
}