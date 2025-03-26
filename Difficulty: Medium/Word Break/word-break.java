//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary) == 1) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
    
    static class Trie {
        TrieNode root;
        Trie() { root = new TrieNode(); }
        
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }
        
        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
            return node.isEnd;
        }
    }
    
    static Trie trie;
    static Boolean[] memo;
    
    public int wordBreak(String s, String[] dictionary) {
        trie = new Trie();
        for (String word : dictionary) trie.insert(word);
        
        memo = new Boolean[s.length()];
        return canBreak(s, 0) ? 1 : 0;
    }
    
    private boolean canBreak(String s, int start) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        
        TrieNode node = trie.root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) break;
            
            node = node.children.get(c);
            if (node.isEnd && canBreak(s, i + 1)) {
                return memo[start] = true;
            }
        }
        
        return memo[start] = false;
    }
}