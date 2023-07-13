class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());

            for(int i=0; i<n; i++)
            {
            for(int j: graph[i])
            {
                adj.get(j).add(i);
            }
        }
        
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int it : adj.get(i)) 
                indegree[it]++;
            
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) 
        {
            if (indegree[i] == 0) 
                q.add(i);
        }

        List<Integer> safe=new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safe.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) 
                    q.add(it);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}