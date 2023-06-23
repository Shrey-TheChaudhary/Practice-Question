class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int start=0,curr_gas=0;
        int prev_gas=0;
        for(int i=0;i<n;i++)
        {
            curr_gas+=gas[i]-cost[i];
            if(curr_gas<0)
            {
                start=i+1;
                prev_gas+=curr_gas;
                curr_gas=0;
            }
        }
        return ((curr_gas+prev_gas)>=0)?(start):-1;
    }
}