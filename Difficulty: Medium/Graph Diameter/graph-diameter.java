class Solution {

    public int diameter(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adjList = new ArrayList<>();
        for(int i=0;i<V;i++) adjList.add(new ArrayList<>());
        
        for(int[] i:edges) {
            adjList.get(i[0]).add(i[1]);
            adjList.get(i[1]).add(i[0]);
        }
        
        /*
            Bfs gives the shortest path to all nodes.In this process we find the farthest node
            Then we will once again use dfs to find the diameter which is longest path between any two vertices 
        */
        
        int[] farthest = bfs(V, 0, adjList);
        int dia = bfs(V, farthest[0], adjList)[1];
        return dia;
    }
    
    private int[] bfs(int n, int src, List<List<Integer>>adj) {
        
        int far = src, maxDist = 0;
        Queue<int[] >q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        boolean[] visit = new boolean[n];
        visit[src] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            if(dist > maxDist) {
                maxDist = dist;
                far = node;
            }
            
            for(int nei : adj.get(node)) {
                if(!visit[nei]) {
                    visit[nei] = true;
                    q.offer(new int[]{nei, dist+1});
                }
            }
        }
        
        return new int[]{far, maxDist};
        
    }
}