class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i < n; i++)
            arr.add(new ArrayList<>());
           
        // make the adjacency list 
        for(int i = 0; i < prerequisites.length; i++){
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] inDegree = new int[n];
        
        // make the indegree list
        for(int i = 0 ; i< n;i++){
            for(Integer it: arr.get(i))
                inDegree[it]++;
        }
        
        // make a queue to store the inDegree with 0
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0 ; i< n; i++)
            if(inDegree[i] == 0)
                q.add(i);
        
        ArrayList<Integer> topoSortOrder = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            topoSortOrder.add(node);
            
            for(Integer it: arr.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)
                    q.add(it);
            }
        }
        
        if(topoSortOrder.size() == n) return topoSortOrder;
        return new ArrayList<Integer>();
    }
}