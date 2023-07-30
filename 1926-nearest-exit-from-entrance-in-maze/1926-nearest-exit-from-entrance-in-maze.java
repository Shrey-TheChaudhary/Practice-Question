class Solution {
    class Pair{
        int row, col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vis = new int[m][n];
        maze[entrance[0]][entrance[1]] = '*';

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && maze[i][0]=='.'){
                q.add(new Pair(i, 0, 0));
                vis[i][0]=1;
            }

            if(vis[i][n-1]==0 && maze[i][n-1]=='.'){
                q.add(new Pair(i, n-1, 0));
                vis[i][n-1]=1;
            }
        }

        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && maze[0][i]=='.'){
                q.add(new Pair(0, i, 0));
                vis[0][i]=1;
            }
            if(vis[m-1][i]==0 && maze[m-1][i]=='.'){
                q.add(new Pair(m-1, i, 0));
                vis[m-1][i]=1;
            }
        }

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && maze[nrow][ncol]=='*')
                    return dist+1;

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && maze[nrow][ncol]=='.'){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol, dist+1));
                }
            }
        }
        return -1;
    }
}