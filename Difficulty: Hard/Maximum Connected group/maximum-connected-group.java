//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

private static final int[] dx = {-1, 1, 0, 0};

private static final int[] dy = {0, 0, -1, 1};

public int MaxConnection(int[][] grid) {

int n = grid.length;

int[][] component = new int[n][n];

List<Integer> componentSize = new ArrayList<>();

componentSize.add(0); // To make componentSize 1-based

int compIndex = 1;

// DFS to find all components of 1's

for (int i = 0; i < n; i++) {

  for (int j = 0; j < n; j++) {

      if (grid[i][j] == 1 && component[i][j] == 0) {

               int size = dfs(grid, component, i, j, compIndex);

               componentSize.add(size);

               compIndex++;

}

}

}

int maxConnection = 0;

// Check the max connection without changing any 0

for (int size : componentSize) {

       maxConnection = Math.max(maxConnection, size);

    }

     // Evaluate each 0 in the grid

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {

        if (grid[i][j] == 0) {

           Set<Integer> neighboringComponents = new HashSet<>();

           int possibleSize = 1; // Changing this 0 to 1

           // Check all 4 directions

           for (int d = 0; d < 4; d++) {

              int ni = i + dx[d];

              int nj = j + dy[d];

              if (ni >= 0 && ni < n && nj >= 0 && nj < n && component[ni][nj] != 0) {

             neighboringComponents.add(component[ni][nj]);

}

}

for (int comp : neighboringComponents) {

possibleSize += componentSize.get(comp);

}

maxConnection = Math.max(maxConnection, possibleSize);

}

}

}

return maxConnection;

}

private int dfs(int[][] grid, int[][] component, int x, int y, int compIndex)

{

int n = grid.length;

Stack<int[]> stack = new Stack<>();

stack.push(new int[]{x, y});

component[x][y] = compIndex;

int size = 0;

while (!stack.isEmpty())

{ int[] cell = stack.pop();

int i = cell[0];

int j = cell[1];

size++;

for (int d = 0; d < 4; d++) {

int ni = i + dx[d];

int nj = j + dy[d];

if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1 && component[ni][nj] == 0) {

stack.push(new int[]{ni, nj});

component[ni][nj] = compIndex;

}

}

}

return size;

}

}