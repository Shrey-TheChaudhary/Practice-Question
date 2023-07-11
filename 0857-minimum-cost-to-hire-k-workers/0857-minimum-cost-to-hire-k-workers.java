class Solution {
    class Worker {
        int quality;
        int wage;
        double ratio;
        Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.ratio = this.wage*1.0/this.quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        for(int i=0; i < quality.length; i++)
            workers.add(new Worker(quality[i], wage[i]));

Collections.sort(workers, (a,b) ->Double.compare(a.ratio,b.ratio));
        
        PriorityQueue<Worker> pq = new PriorityQueue<>((a,b)-> b.quality-a.quality);
        
        double totalQuality = 0, minCost = Double.MAX_VALUE;
        
        for(Worker worker : workers)
        {
            pq.add(worker);
            totalQuality += worker.quality;
            if(pq.size() == k)
            {
            minCost = Math.min(minCost, totalQuality*worker.ratio);
                totalQuality -= pq.remove().quality;       // Remove the worker with the highest quality
            }
        }
        
        return minCost;
    }
}