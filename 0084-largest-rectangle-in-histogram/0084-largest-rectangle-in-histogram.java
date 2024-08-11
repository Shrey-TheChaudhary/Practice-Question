class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxarea = Integer.MIN_VALUE;
        int nse[] = new int[heights.length]; //next smallest elemet
        int pse[] = new int[heights.length]; //previous smallest element
        Stack<Integer> s = new Stack<>();
        int n = heights.length;

        // next smaller right
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller left
        s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = s.peek();
            }
            s.push(i);

        }
        for (int i = 0; i < n; i++) {

            maxarea = Math.max((nse[i]-pse[i]-1)*heights[i], maxarea);
        }
        return maxarea;
    }
}