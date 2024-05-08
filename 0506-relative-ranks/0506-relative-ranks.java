class Solution {
    public String[] findRelativeRanks(int[] score) 
    {    
        String ans[]=new String[score.length];
        int copy[]=score.clone();
        Arrays.sort(copy);
        
        for(int i=0;i<score.length;i++)
        {
            int x=score[i];
            if(x==copy[copy.length-1])
                ans[i]="Gold Medal";
            
            else if(x==copy[copy.length-2])
                ans[i]="Silver Medal";
            
            else if(x==copy[copy.length-3])
                ans[i]="Bronze Medal";
            
            else
            {
                int k=Arrays.binarySearch(copy,x);
                ans[i]="";
                ans[i]+=score.length-k;
            }
        }
        
    return ans;

    }
}