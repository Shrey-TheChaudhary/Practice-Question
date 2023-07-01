class Solution 
{
    public int minDays(int[] bloomDay, int m, int k) 
    {   
        if (m*k> bloomDay.length)
            return -1;
        int ans=-1;
        
         int low=0;
        int high=0;
        for(int bloom:bloomDay)
          high= Math.max(high,bloom);
        
        while (low<=high)
        {
            int mid= low+ (high-low)/2; 
            
            if (isPossible(bloomDay, mid, m, k)){   
                ans= mid;
                high= mid-1;
            }
            else
                low= mid+1; 
        }
        return ans;
       
    }
    public boolean isPossible(int arr[], int mid, int bouquets, int k) 
    {   
        int flowers=0;
        int boqs=0;

        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]>mid) 
                flowers=0; 
            
            else 
            {
                flowers++; 
                if (flowers==k)
                {
                    boqs++; 
                    flowers=0; 
                }
                else
                    continue;
            }
            
        }
        if (boqs>= bouquets) 
            return true;
        else 
            return false;
    }
}