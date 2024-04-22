class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] vis = new boolean[10000];
        for(String end:deadends){
            vis[Integer.parseInt(end)] = true;
        }

        int trgt = Integer.parseInt(target);
        if(vis[0]) return -1;

        for(int i=1; !queue.isEmpty(); i++){
            int size = queue.size();

            for(int j=0; j<size; j++){
                int cur = queue.poll();

                for(int z=1; z<10000; z*=10){
                    int mask = cur%(z*10)/z;
                    int masked = cur-(mask*z);
                
                    for(int k=1; k<10; k+=8){
                        int next = masked + (mask+k)%10 *z;
                        if(vis[next]) continue;
                        if(next==trgt) return i;
                        vis[next]=true;
                        queue.add(next);
                    }
                }
            }
        }

        return -1;
    }
}