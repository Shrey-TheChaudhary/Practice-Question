class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] inDeg = new int[n];
        for (int[] e : edges) 
        {
            graph.get(e[0]).add(e[1]);
            inDeg[e[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                inDeg[v]--;
                ancestors.get(v).add(u);
                for (int ancestor : ancestors.get(u)) {
                    ancestors.get(v).add(ancestor);
                }
                if (inDeg[v] == 0) {
                    q.add(v);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        
        return ans;
    }
}