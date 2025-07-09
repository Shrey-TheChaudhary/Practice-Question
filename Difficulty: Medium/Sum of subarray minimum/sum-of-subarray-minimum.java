class Solution {
    public int sumSubMins(int[] arr) {
        int[] nextsum=nextSubarrayMins(arr);
        int[] prevsum=prevSubarrayMins(arr);
        long count=0;
       int mod =1000000007;

        for(int i=0;i<arr.length;i++)
        {
            int first=i-prevsum[i];
            int second =nextsum[i]-i;

            long prod=(first*second)%mod;
            prod=(prod*arr[i])%mod;
            count=(count%mod+prod)%mod;
        }
        return (int) count;
    }
       


    private int[] nextSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
        while(!stack.isEmpty() && arr[stack.peek()] >=arr[i]){
            stack.pop();
        }
        if(stack.isEmpty()){
            ans[i]=arr.length;
           } else{
                ans[i]=stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
     private int[] prevSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
        while(!stack.isEmpty() && arr[stack.peek()] >arr[i]){
            stack.pop();
        }
        if(stack.isEmpty()){
            ans[i]=-1;
            }else{
                ans[i]=stack.peek();
            }
            stack.push(i);
        }
        return ans;
        
    }
}
