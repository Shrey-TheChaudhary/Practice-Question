class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n =arr.length;
        int i=0,j=0,count =0;
        
        while(i<n && j<n){
            while(i<n && arr[i]!='P')i++;
              while(j<n && arr[j]!='T')j++;
            if(i<n && j<n && Math.abs(i-j)<=k){
               count++;
                i++;
                j++;
            }else if(j<n && j<i){
                j++;
            }else if(i<n && i<j){
                i++;
            }
        }
        return count;
    }
}