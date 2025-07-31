class Solution {
    public int powerfulInteger(int[][] interval, int k) {
        
       int max=0;
        for(int i=0;i<interval.length;i++){
            if(interval[i][1]>max) max=interval[i][1];
        }
        
        int[] arr= new int[max+2];
        for(int i=0;i<interval.length;i++){
            arr[interval[i][0]] +=1;
            arr[interval[i][1]+1] -=1;
        }
        
        
        for(int i=1;i<max+2;i++){
            arr[i]= arr[i-1]+arr[i];
        }
        
        for(int i=max+1;i>=0;i--){
            if(arr[i]>=k) return i;
        }
        
        
        return -1;
        
        
    }
}