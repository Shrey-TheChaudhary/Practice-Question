class Solution {
    public int maximalRectangle(char[][] matrix) {
          int row = matrix.length;
        int col = matrix[0].length;
        int[][] mat = new int[row][col];
        
        for(int i =0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j] == '1')
                    mat[i][j] = 1;
                else
                    mat[i][j] = 0;
            }
        }
                
           
        int res=largestRectangleArea(mat[0]);
        for(int i =1;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==1)
                    mat[i][j]+=mat[i-1][j];
            }
            res=Math.max(res,largestRectangleArea(mat[i]));
        }
                return res;
                
    }
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