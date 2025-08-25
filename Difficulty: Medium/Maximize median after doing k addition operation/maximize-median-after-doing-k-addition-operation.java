class Solution {
    public int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int iOld=arr.length%2==0?arr.length/2-1:arr.length/2;
        int i=iOld+1;
        for( i=iOld+1;i<arr.length;i++){
            if((arr[i]-arr[iOld])*(i-iOld)<=k){
                k-=(arr[i]-arr[iOld])*(i-iOld);
                arr[iOld]=arr[i];
            }
            else{
                arr[iOld]+=(k/(i-iOld));
                k-= (k/(i-iOld))*(i-iOld);
            }
        }
        
        // Make sure best possible all k are exhausted 
        arr[iOld]+=(k/(arr.length-iOld));
        k-=(k/(arr.length-iOld))*(arr.length-iOld);
        
        
        // System.out.println(Arrays.toString(arr) +"-"+k);
        
        
        
        return arr.length%2==1? arr[iOld]:(arr[iOld]<arr[iOld+1]?(arr[iOld]+arr[iOld+1])/2:arr[iOld]);
        
    }
}