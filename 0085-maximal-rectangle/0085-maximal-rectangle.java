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
        int maxarea=Integer.MIN_VALUE;
        int nsl[]=new int[heights.length];
        int nsr[]=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        
        //next smaller right
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]= heights.length;
            }
            else{
                nsr[i]= s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]= -1;
            }
            else{
                nsl[i]= s.peek();
            }
            s.push(i);

        }
        for(int i=0;i<heights.length;i++)
        {
            int heigth=heights[i];
            int width=nsr[i]-nsl[i]-1;
            
            int currarea=heigth*width;
            maxarea=Math.max(currarea,maxarea);
        }
        return maxarea;
    }
}