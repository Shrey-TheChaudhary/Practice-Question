class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            
            int l=queries[i][0];
            int r=queries[i][1];
            count=0;
            for(int j=0;j<n;j++){
                if(arr[j]>=l && arr[j]<=r){
                    count++;
                }
            }
            
            ans.add(count++);
        }
        return ans;
    }
}