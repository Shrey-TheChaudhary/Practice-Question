class Solution 
{
    
    private int papers(int arr[], int H)
    {
        int c=0;
        
        for(int x:arr)
            if(x>=H)
                c++;
        return c;
    }
    
    public int hIndex(int[] citations)
    {
        // code here
        int low=1, high= citations.length, ans=0;
        while(low<=high)
        {
            int mid= (low+high)/2; //H
            if(papers(citations,mid)>=mid)
            {
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        
        return ans;
    }
}