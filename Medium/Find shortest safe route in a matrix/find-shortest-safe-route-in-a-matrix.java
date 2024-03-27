//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = delrow[k] + i;
                        int nc = delcol[k] + j;
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            ans[nr][nc] = 0;
                        }
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (ans[i][0] == 1) {
                queue.offer(new int[]{i, 0, 1});
            }
        }
        int[][] vis = new int[n][m];
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int row = a[0];
            int col = a[1];
            int count = a[2];
            vis[row][col] = 1;
            if (col == m - 1) {
                return count;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nr = delrow[i] + row;
                    int nc = delcol[i] + col;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && ans[nr][nc] == 1) {
                        vis[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}