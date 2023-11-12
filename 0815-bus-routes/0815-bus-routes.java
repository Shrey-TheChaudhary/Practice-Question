class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int len = routes.length;
        HashMap<Integer, List<Integer>> map = new HashMap();
        
        for(int i = 0; i < routes.length; i++)
        {
            for(int j = 0; j < routes[i].length; j++)
            {
                if(map.containsKey(routes[i][j]))
                {
                    List<Integer> current = map.get(routes[i][j]);
                    current.add(i);
                    map.put(routes[i][j], current);
                }
                else
                {
                    List<Integer> current = new LinkedList();
                    current.add(i);
                    map.put(routes[i][j], current);
                }
            }
        }
        Set<Integer> buses = new HashSet();
        Set<Integer> stops = new HashSet();
        
        Queue<Integer> q = new LinkedList();
        q.offer(source);
        int moves = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int stop = q.poll();
                if(stop == target) return moves;
                
                for(int route: map.get(stop))
                {
                    if(buses.contains(route)) continue;
                    buses.add(route);
                    
                    for(int neighbour: routes[route])
                    {
                        if(stops.contains(neighbour)) continue;
                        stops.add(neighbour);
                        q.offer(neighbour);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}