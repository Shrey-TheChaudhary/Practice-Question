// class Pair {
//     int first;
//     int second;
//     public Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         int m = roads.length;
//         for (int i = 0; i < m; i++) {
//             adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
//             adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
//         }

//         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

//         int[] dist = new int[n];
//         int[] ways = new int[n];
//         for (int i = 0; i < n; i++) {
//             dist[i] = Integer.MAX_VALUE;
//             ways[i] = 0;
//         }
//         dist[0] = 0;
//         ways[0] = 1;
//         pq.add(new Pair(0, 0));

//         int mod = (int)(1e9 + 7);

//         while (pq.size() != 0) {
//             int dis = pq.peek().first;
//             int node = pq.peek().second;
//             pq.remove();

//             for (Pair it : adj.get(node)) {
//                 int adjnode = it.first;
//                 int edw = it.second;

//                 if (dis + edw < dist[adjnode]) {
//                     dist[adjnode] = dis + edw;
//                     pq.add(new Pair(dis + edw, adjnode));
//                     ways[(int)adjnode] = ways[(int)node];
//                 } else if (dis + edw == dist[adjnode]) {
//                     ways[(int)adjnode] = (ways[(int)adjnode] + ways[(int)node]) % mod;
//                 }
//             }
//         }
//         return ways[n - 1] % mod;
//     }
// }

import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> Long.compare(x.a, y.a));
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ar : roads) {
            adj.get(ar[0]).add(new Pair(ar[1], ar[2])); // node wt
            adj.get(ar[1]).add(new Pair(ar[0], ar[2]));
        }
        long[] dis = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dis, Long.MAX_VALUE / 2);
        dis[0] = 0;
        ways[0] = 1;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            long pd = q.peek().a;
            long node = q.peek().b;
            q.remove();
            for (Pair i : adj.get((int) node)) {
                long edgewt = i.b;
                long adjnode = i.a;
                if (edgewt + pd < dis[(int) adjnode]) {
                    dis[(int) adjnode] = edgewt + pd;
                    q.add(new Pair(dis[(int) adjnode], adjnode));
                    ways[(int) adjnode] = ways[(int) node];
                } else if (edgewt + pd == dis[(int) adjnode]) {
                    ways[(int) adjnode] = (ways[(int) adjnode] + ways[(int) node]) % ((int) 1e9 + 7); // Corrected ways count
                }
            }
        }

        return ways[n - 1] % ((int) 1e9 + 7);
    }
}

class Pair {
    long a; // distance
    long b; // node

    Pair(long a, long b) {
        this.a = a;
        this.b = b;
    }
}
