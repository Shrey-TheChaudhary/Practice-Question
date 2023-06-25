class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(groups.containsKey(key))
                groups.get(key).add(word);
             else 
             {
                List<String>list = new ArrayList<String>();
                list.add(word);
                groups.put(key,list);
            }
        }
        
        return new ArrayList<List<String>>(groups.values());
    }
}