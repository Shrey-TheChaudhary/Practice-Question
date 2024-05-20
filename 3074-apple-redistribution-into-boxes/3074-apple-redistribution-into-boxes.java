import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        
        int sum=0,ans=0;
        for(int i:apple)
            sum+=i;
        
        int n= capacity.length;
        for(int i=n-1;i>=0;i--)
        {
           sum-=capacity[i];
           ans++;
           if(sum<=0) 
               break;
        }       
        
        return ans;
    }
}