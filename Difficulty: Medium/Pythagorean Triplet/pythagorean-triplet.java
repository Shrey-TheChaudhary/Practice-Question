class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]*arr[i]);
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int ans=arr[i]*arr[i]+arr[j]*arr[j];
                if(hs.contains(ans)){
                    return true;
                }
            }
        }
        return false;
    }
}