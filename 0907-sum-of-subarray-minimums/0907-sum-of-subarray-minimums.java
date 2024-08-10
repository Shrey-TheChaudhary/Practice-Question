// Striver

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] pgre = new int[length];
        int[] ngre = new int[length];
      
        Arrays.fill(pgre, -1);
        Arrays.fill(ngre, length);
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        //previous Greater
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pgre[i] = stack.peek();
            }
            stack.push(i);
        }
      
        stack.clear();
      
        //next greater
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ngre[i] = stack.peek();
            }
            stack.push(i);
        }
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i)
        {
            answer += (long) (i-pgre[i])*(ngre[i]- i)%mod *arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}