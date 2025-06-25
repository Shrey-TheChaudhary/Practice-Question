class Solution {
    boolean sameFreq(String s) {
        //aaabbbcc
        HashMap<Character,Integer> freqmap = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            freqmap.put(ch, freqmap.getOrDefault(ch, 0) + 1);//{a-3,b-3,c-2}
        }
        HashMap<Integer,Integer> countmap = new HashMap<>();
        for(int freq : freqmap.values())
        {
            countmap.put(freq, countmap.getOrDefault(freq, 0) + 1);//{3-2,2-1}
        }
        if(countmap.size() == 1) return true;
        else if(countmap.size() > 2) return false;
        else
        {
            int freq1 = 0;
            int freq2 = 0;
            int value1 = 0;
            int value2 = 0;
            int i=0;
            for(Map.Entry<Integer,Integer> entry: countmap.entrySet())
            {
                if(i == 0)
                {
                    freq1 = entry.getKey();
                    value1 = entry.getValue();
                }
                else
                {
                    freq2 = entry.getKey();
                    value2 = entry.getValue();
                }
                i++;
            }
             if ((freq1 == 1 && value1 == 1) || (freq2 == 1 && value2 == 1)) {
            return true;
        }
            
             if ((Math.abs(freq1 - freq2) == 1) &&
            ((freq1 > freq2 && value1 == 1) || (freq2 > freq1 && value2 == 1)))
            {
            return true;
            }
            return false;
            
        }
        
    }
}