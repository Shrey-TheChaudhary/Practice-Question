class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<arr.length ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = arr.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && map.get(st.peek())<=map.get(arr[i])){
                st.pop();
            }
            
            ans.add(st.isEmpty()?-1:st.peek());
            
            st.push(arr[i]);
        }
        
        Collections.reverse(ans);
        
        return ans ;
    }
}