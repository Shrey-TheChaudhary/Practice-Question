class Solution {

    public int longestSubarray(int[] a, int limit) {
        int len=a.length;
        int result,right,left,i;

        result=right=left=i=0;
        while(i<len-1){
          if(len-result+1<i)
             return result+1;
          
           left=a[i];
           right=a[i];
               
           int j=i+1;
           while(j<len){
               
           left=Math.max(left,a[j]);
           right=Math.min(right,a[j]);
   
               if(left-right<=limit){
               result=Math.max(result,j-i);
               j++;
               continue;
               }
               else
               break;
              
           }
           i++;
        }
        
        return result+1;
    }
}