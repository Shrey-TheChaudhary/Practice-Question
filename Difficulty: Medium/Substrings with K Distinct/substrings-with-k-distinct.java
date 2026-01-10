class Solution {
    public int countSubstr(String s, int k) {
        return solve(s,k) - solve(s,k-1);
        
    }
    private int solve(String s, int k){
        int i=0,j=0;
        int n=s.length();
        int count=0;
        HashMap<Character, Integer> hm= new HashMap<>();
        while(i<n){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()>k){
                char ch2=s.charAt(j);
                hm.put(ch2,hm.get(ch2)-1);
                if(hm.get(ch2)==0) hm.remove(ch2);
                j++;
            }
            count=count+(i-j+1);
            i++;
        }
        return count;
    }
}