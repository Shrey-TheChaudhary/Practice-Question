import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int v;
        long d;
        Node(int v, long d){ this.v = v; this.d = d; }
        public int compareTo(Node o){ return Long.compare(this.d, o.d); }
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        if (a == b) return 0;

        int totalNodes = V * 2; // layer0: 0..V-1, layer1: V..2V-1
        int E = edges.length;
        int M = E * 6; // upper bound on directed edges in expanded graph

        int[] head = new int[totalNodes];
        Arrays.fill(head, -1);
        int[] to = new int[M];
        int[] nxt = new int[M];
        int[] w = new int[M];

        int[] ec = new int[1];
        class Adder {
            void add(int u, int v, int wt) {
                int id = ec[0]++;
                to[id] = v;
                w[id] = wt;
                nxt[id] = head[u];
                head[u] = id;
            }
        }
        Adder adder = new Adder();

  
        for (int i = 0; i < E; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int ws = edges[i][2]; // straight weight
            int wc = edges[i][3]; // curved weight

            int u0 = u;
            int v0 = v;
            int u1 = u + V;
            int v1 = v + V;

          
            adder.add(u0, v0, ws);
            adder.add(v0, u0, ws);
            adder.add(u1, v1, ws);
            adder.add(v1, u1, ws);

            
            adder.add(u0, v1, wc);
            adder.add(v0, u1, wc);
        }

        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[totalNodes];
        Arrays.fill(dist, INF);
        boolean[] seen = new boolean[totalNodes];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[a] = 0;
        pq.add(new Node(a, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;
            if (seen[u]) continue;
            seen[u] = true;

        
            if (seen[b] && seen[b + V]) break;

            for (int e = head[u]; e != -1; e = nxt[e]) {
                int vtx = to[e];
                long nd = dist[u] + (long) w[e];
                if (nd < dist[vtx]) {
                    dist[vtx] = nd;
                    pq.add(new Node(vtx, nd));
                }
            }
        }

        long ans = Math.min(dist[b], dist[b + V]);
        return (ans >= INF/2) ? -1 : (int) ans;
    }
}