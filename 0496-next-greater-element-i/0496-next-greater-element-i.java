// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int ans[]=new int[nums1.length];
//         Map<Integer, Integer> map = new HashMap<>();
        
//         Stack<Integer> st=new Stack<>();
        
//         for(int num: nums2)
//         {
//             while(!st.empty() && st.peek()<num){
//                 map.put(st.pop(),num);
//             }
//             st.push(num);
//         }
//         for (int i = 0; i < nums1.length; i++)
//             nums1[i]=map.containsKey(nums1[i])?map.get(nums1[i]):-1;
        
//         return nums1;
//     }
// }

class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int i=n2.length-1;i>=0;i--)
        {
            int num=n2[i];
            while(!s1.isEmpty() && s1.peek()<=num)
            {
               s1.pop(); 
            }
            if(s1.isEmpty()) 
                map.put(num,-1);
            else 
                map.put(num,s1.peek());
            
        s1.push(num);
        }
    
     for (int i = 0; i < n1.length; i++) {  
            n1[i] = map.containsKey(n1[i]) ? map.get(n1[i]) : -1;  
        }
        return n1;
    }
}
