//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static String[] dirStr = {"U", "D", "L", "R"};

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        
        ArrayList<String> paths = new ArrayList<>();
        
        if (mat[0][0] == 0){ 
            return paths;
        }
        

        int[][] visited = new int[n][n];
        visited[0][0] = 1;

        explore(mat, 0, 0, "", paths, visited);

        return paths;
    }

    void explore(int[][] mat, int x, int y, String path, ArrayList<String> paths, int[][] visited) {
        int n = mat.length;
        if (x == n - 1 && y == n - 1) {
            paths.add(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (isValid(newX, newY, mat, visited)) {
                visited[newX][newY] = 1;
                
                explore(mat, newX, newY, path + dirStr[i], paths, visited);
                
                visited[newX][newY] = 0;
            }
        }
    }

    boolean isValid(int x, int y, int[][] mat, int[][] visited) {
        int n = mat.length;
        return x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1 && visited[x][y] == 0;
    }
}
