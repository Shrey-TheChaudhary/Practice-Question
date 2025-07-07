class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> ds=new ArrayList<>();
        int n=arr.length;
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i%n]>=st.peek()){
                st.pop();
            }
            
            if(i<n){
                ds.add(st.isEmpty() ? -1 : st.peek());
            }
            
            st.push(arr[i%n]);
        }
        Collections.reverse(ds);
        return ds;
    }
}