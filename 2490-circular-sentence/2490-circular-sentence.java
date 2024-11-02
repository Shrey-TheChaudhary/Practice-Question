class Solution {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(n - 1))
            return false;
        
        for(int i =0;i < n; i++)
        {
            if(sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) 
                return false;
        }
        return true;         
    }
}

// import java.util.StringTokenizer;
// class Solution {
//     public static boolean isCircularSentence(String sentence) {
//         StringTokenizer tokenizer = new StringTokenizer(sentence, " ");
        
       
//         if (!tokenizer.hasMoreTokens())
//             return false;
        
//         String firstWord = tokenizer.nextToken();
//         String previousWord = firstWord;
        
//         while (tokenizer.hasMoreTokens()) 
//         {
//             String currentWord = tokenizer.nextToken();
            
//             if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) 
//                 return false;
            
//             // Update previousWord for the next iteration
//             previousWord = currentWord;
//         }
        
//         // Finally, check if the last character of the last word matches the first character of the first word
//         return previousWord.charAt(previousWord.length() - 1) == firstWord.charAt(0);
//     }
// }