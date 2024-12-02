class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i=0;
        
        for(String str : sentence.split(" ")){
            if(str.startsWith(searchWord)){                
                return i+1;
            }
            i++;
        }

        return -1;
    }
}