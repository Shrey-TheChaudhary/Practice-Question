class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] temp=new int[profits.length][2];

        for(int i=0;i<profits.length;i++)
        {
            temp[i][0]=capital[i];
            temp[i][1]=profits[i];
        }

   Arrays.sort(temp,(a,b)->a[0]-b[0]);
   PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder()); 
   int i=0;
        while(k>0)
        {
           while(i<temp.length && temp[i][0]<=w)
           {
                 pq.offer(temp[i][1]);
                 i++;
           }

           if(pq.isEmpty())
           break;
           
             w+=pq.poll();
             k--;
        }
        return w;
    }
}