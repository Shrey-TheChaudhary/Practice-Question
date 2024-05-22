class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int min=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        
        int c=0;
        for(int i=0;i<min;i++)
        {
            if(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i))
                c++;
            else 
                break;
        }
        if(c==0)
            return -1;
        else 
            return (s1.length()+s2.length()+s3.length())-3*c;
    }
}