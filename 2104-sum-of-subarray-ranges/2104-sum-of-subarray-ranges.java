// class Solution {
//    public long subArrayRanges(int[] A) {
//         long res = 0;
//         for (int i = 0; i < A.length; i++) 
//         {
//             int max = A[i], min = A[i];
//             for (int j = i; j < A.length; j++)
//             {
//                 max = Math.max(max, A[j]);
//                 min = Math.min(min, A[j]);
//                 res += max - min;
//             }
//         }
//         return res;
//     }
// }

//STRIVER
class Solution {

    // Function to calculate the sum of subarray ranges
    public static long subArrayRanges(int[] nums) {
        return sumOfSubarrayMax(nums) - sumOfSubarrayMin(nums);
    }

    // Function to calculate the sum of subarray maximums
    private static long sumOfSubarrayMax(int[] nums) {
        int n = nums.length;
        long sumMax = 0;

        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        for (int i = 0; i < n; i++) {
            prevGreater[i] = -1;
            nextGreater[i] = n;
        }

        // Calculate previous greater element for each element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Calculate next greater element for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the sum of subarray maximums
        for (int i = 0; i < n; i++) {
            sumMax += (long) nums[i] * (i - prevGreater[i]) * (nextGreater[i] - i);
        }

        return sumMax;
    }

    // Function to calculate the sum of subarray minimums
    private static long sumOfSubarrayMin(int[] nums) {
        int n = nums.length;
        long sumMin = 0;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            prevSmaller[i] = -1;
            nextSmaller[i] = n;
        }

        // Calculate previous smaller element for each element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Calculate next smaller element for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the sum of subarray minimums
        for (int i = 0; i < n; i++) {
            sumMin += (long) nums[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
        }

        return sumMin;
    }
}