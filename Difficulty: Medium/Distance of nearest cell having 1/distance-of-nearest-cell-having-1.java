class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<grid.length;i++){
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                int num = findOne(grid, i, j);
                al.add(num);
            }
            ans.add(al);
        }
        
        return ans;
    }
    
    int findOne(int[][] grid, int a, int b){
        int len = grid.length * grid[0].length;
        
        for(int n=0;n<len;n++){
            int i=0, j=n;
            
            while(i<=n){
                if(a-i>=0 && b-j>=0 && grid[a-i][b-j]==1){
                    return i + j;
                }
                
                if(a-i>=0 && b+j<grid[0].length && grid[a-i][b+j]==1){
                    return i + j;
                }
                
                if(b-j>=0 && a+i<grid.length && grid[a+i][b-j]==1){
                    return i + j;
                }
                
                if(a+i<grid.length && b+j<grid[0].length && grid[a+i][b+j]==1){
                    return i + j;
                }
                
                i++;
                j--;
            }
        }
        
        return 0;
    }
}