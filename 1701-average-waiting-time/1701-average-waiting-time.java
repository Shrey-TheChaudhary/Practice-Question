class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length, curTime = 0;
        double totalTime = 0;
        for(int i = 0; i < n; i++) 
        {
            if(curTime <= customers[i][0]) 
            {
                totalTime += customers[i][1];
                curTime = customers[i][0] + customers[i][1];
            }
            else 
            {
                totalTime += (curTime - customers[i][0] + customers[i][1]);
                curTime += customers[i][1];
            }
        }
        return totalTime / n;
    }
}