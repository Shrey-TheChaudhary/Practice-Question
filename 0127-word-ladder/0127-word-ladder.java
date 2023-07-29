class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(beginWord,1));
        
        Set<String> st=new HashSet<>();
        int len=wordList.size();
        
        for(int i=0;i<len;i++)
            st.add(wordList.get(i));
        
        st.remove(beginWord);
        
        while(!q.isEmpty())
        {
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            
            if(word.equals(endWord)==true)
                return steps;
            
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char reparr[]=word.toCharArray();
                    reparr[i]=ch;
                    
                    String repword=new String(reparr);
                    
                    if(st.contains(repword)==true)
                    {
                        st.remove(repword);
                        q.add(new Pair(repword,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}