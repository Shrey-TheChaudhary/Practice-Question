class Solution {
     public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights)
        {
            low=Math.max(low,i);
            high+=i;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(capacity(weights,days,mid)){
                
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean capacity(int[] weights,int days,int minw){
        int countday=1;
        int w=0;
        for(int i=0;i<weights.length;i++)
        {
            if(w+weights[i]<=minw){
                w+=weights[i];
            }
            else{
                countday++;
                w=weights[i];
            }
        }
        if(countday>days)
            return false;
        
        return true;
    }
}