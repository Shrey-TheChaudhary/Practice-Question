//{ Driver Code Starts
import java.io.*;
import java.util.*;

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

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {

    public int findNumberOfGoodComponent(int numberOfEdges, int numberOfVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = buildAdjacencyList(numberOfVertices, edges);
        int countGoodComponents = 0;
        int[] visited = new int[numberOfVertices + 1];
        
        for (int i = 1; i <= numberOfVertices; i++) {
            if (visited[i] == 0) {
                int[] vertices = {0};
                int[] edgeCount = {0};
                depthFirstSearch(i, vertices, edgeCount, adjacencyList, visited);
                edgeCount[0] /= 2; // Since each edge is counted twice
                if (edgeCount[0] == (vertices[0] * (vertices[0] - 1)) / 2) {
                    countGoodComponents++;
                }
            }
        }
        return countGoodComponents;
    }

    private void depthFirstSearch(int vertex, int[] vertices, int[] edges, ArrayList<ArrayList<Integer>> adjacencyList, int[] visited) {
        visited[vertex] = 1;
        vertices[0]++;
        edges[0] += adjacencyList.get(vertex).size();
        
        for (int neighbor : adjacencyList.get(vertex)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(neighbor, vertices, edges, adjacencyList, visited);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> buildAdjacencyList(int numberOfVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(numberOfVertices + 1);
        
        for (int i = 0; i <= numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u); // Since it's an undirected graph
        }
        return adjacencyList;
    }
}