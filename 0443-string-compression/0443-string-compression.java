class Solution {
    public int compress(char[] chars) {
        StringBuilder ans = new StringBuilder("");

        for(int i=0; i<chars.length; i++) {
            ans.append(chars[i]);
            int count = 1;

            while(i<chars.length-1) {
                if(chars[i] == chars[i+1]) {
                    count++;
                    i++;
                }
                else 
                    break;
            }

            if(count>1) {
                ans.append(count);
            }
        }

        for(int j=0; j<ans.length(); j++) {
            chars[j] = ans.charAt(j);
        }
        return ans.length();
    }
}