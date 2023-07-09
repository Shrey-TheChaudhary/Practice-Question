class Solution {
    public int lastStoneWeight(int[] stones) 
    {
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int each: stones)
            q.add(each);

        while(q.size()>1)
        {
            int top1 = q.poll();
            int top2 = q.poll();
            int diff = Math.abs(top1-top2);

            if(diff!=0)
                q.add(diff);
            
        }

        if(q.size()!=0)
            return q.poll();
        else
            return 0;
    }
}