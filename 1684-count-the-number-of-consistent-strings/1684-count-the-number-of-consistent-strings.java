class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char x : allowed.toCharArray()) {
            set.add(x);
        }
        int count = 0;
        boolean flag;
        for(String x : words) {
            flag = true;
            for(char ch : x.toCharArray()) {
                if(!set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }
}