class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
         int n = s.length();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        
        prev[0] =s.charAt(0);
        next[n-1] =s.charAt(n-1);
        //prefix sum
        for(int i=1;i<n;i++){
            prev[i] =prev[i-1]+s.charAt(i);
        }
        //nextsum
        for(int i=n-2;i>=0;i--){
            next[i] =next[i+1]+s.charAt(i);
        }
        
        for(int i=0;i<n;i++){
            //if character is already in set  it means it has already calculated ./
            if(set.contains(s.charAt(i)))    continue;
            
            char ch = s.charAt(i);
            set.add(ch);
            //max sum is calculated in next[0]
            int val = next[0] -(prev[s.indexOf(ch)]+next[s.lastIndexOf(ch)]);
            //if in case the character has only one occurence 
            //it will give negative val
            if(val>0)ans.add(val);
            
        }
        return ans;
    }
}