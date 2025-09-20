class Solution {
    public static int longestSubarray(int[] arr) {
        // code here
       /* if(arr == null || arr.length == 0) return 0;
        
        int n = arr.length;
        int res = 0;
        
        Stack<Integer>st = new Stack<>();
        
        for(int i =0;i<=n;i++){
            int cur = (i==n) ? Integer.MAX_VALUE : arr[i];
            while(!st.isEmpty() && arr[st.peek()]<cur){
                int j = st.pop();
                int prevIndex = st.isEmpty() ? -1 :  st.peek();
                int len = i-1-prevIndex;
                
                if(arr[j]<=len){
                    res = Math.max(res,len);
                }
            }
            if(i<n) st.push(i);
           
        }
        return res;*/
        int n = arr.length;
        int res = 0;

        // Stack stores indices in decreasing order of values
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // If end of array, take a "virtual" element = +∞
            int curr = (i == n) ? Integer.MAX_VALUE : arr[i];

            // Maintain decreasing stack
            while (!st.isEmpty() && arr[st.peek()] < curr) {
                int j = st.pop();               // index of the smallest element
                int prevIndex = st.isEmpty() ? -1 : st.peek();
                int len = i - 1 - prevIndex;    // subarray length

                // Check condition
                if (arr[j] <= len) {
                    res = Math.max(res, len);
                }
            }

            // Push current index (except the virtual one at end)
            if (i < n) st.push(i);
        }

        return res;
        
    }
}