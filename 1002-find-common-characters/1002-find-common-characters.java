class Solution {
    public List<String> commonChars(String[] words) {
        List<HashMap<Character,Integer>> list = new ArrayList<>();
        for(String s: words){
            HashMap<Character,Integer> map = new HashMap<>();
            for(char ch: s.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            list.add(map);
        }
        List<String> ans = new ArrayList<>();
        for(char ch : list.get(0).keySet()) {
            int min = Integer.MAX_VALUE;
            for (HashMap<Character, Integer> map : list) {
                if (!map.containsKey(ch)) {
                    min = 0;
                    break;
                }
                min = Math.min(min, map.get(ch));
            }
            for (int i = 0; i < min; i++) {
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }
}