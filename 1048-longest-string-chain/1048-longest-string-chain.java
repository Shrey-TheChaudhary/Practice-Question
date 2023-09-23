class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());

        HashMap<String,Integer> hp = new HashMap<>();

        int ans = 0;

        for(String s : words){
            hp.put(s,1);
            for(int i=0; i<s.length(); i++){
                String str = s.substring(0,i)+s.substring(i+1);

                if(hp.containsKey(str)){
                    hp.put(s,Math.max(hp.get(s),hp.get(str)+1));
                }
            }
            ans = Math.max(ans,hp.get(s));
        }
        return ans;
    }
}