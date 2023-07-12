class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int cur = image[sr][sc];
        if(cur == color){
            return image;
        }
        image[sr][sc]=color;
        dfs(image, sr, sc-1, cur, color);
        dfs(image, sr-1, sc, cur, color);
        dfs(image, sr+1, sc, cur, color);
        dfs(image, sr, sc+1, cur, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int cur, int color) {
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=cur){
            return; 
        }
        image[sr][sc]= color;
        dfs(image, sr, sc-1, cur, color);
        dfs(image, sr-1, sc, cur, color);
        dfs(image, sr+1, sc, cur, color);
        dfs(image, sr, sc+1, cur, color);
    }
}