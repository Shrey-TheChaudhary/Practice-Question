class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}

// import java.util.*;
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character, Integer> hm= new HashMap<>();

//         for(int i=0;i<magazine.length();i++)
//         { 
//             char ch=magazine.charAt(i);
//             hm.put(ch, hm.getOrDefault(ch,0)+1);
//         }

//         for(int i=0;i<ransomNote.length();i++)
//         {
//         if(hm.containsKey(ransomNote.charAt(i)) &&                             hm.get(ransomNote.charAt(i))>0)
//     {
//         hm.put(ransomNote.charAt(i),hm.get(ransomNote.charAt(i))-1);
//             }
//             else 
//             return false;
//     }

//         return true;
//     }
// }