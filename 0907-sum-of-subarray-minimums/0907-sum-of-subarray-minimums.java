// Striver

class Solution {
    public int sumSubarrayMins(int[] arr) {
                int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // Initialize arrays with default values
        for (int i = 0; i < n; i++) {
            prevSmaller[i] = -1;
            nextSmaller[i] = n;
        }

        // Stack for finding previous smaller elements
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear the stack for finding next smaller elements
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the sum of subarray minimums
        long result = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            int left = i - prevSmaller[i];
            int right = nextSmaller[i] - i;
            result = (result + (long) arr[i] * left * right) % mod;
        }

        return (int) result;
    }
}