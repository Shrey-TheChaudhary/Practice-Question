class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> result = new ArrayList<>();
        
        for(int[] slot : intervals) 
        {
            if(slot[1] < newInterval[0]) 
                result.add(slot);
            
            else if(newInterval[1] < slot[0])
            {
                result.add(newInterval);
                newInterval = slot;
            } 
            else
            {
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }
        
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}