//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int maxPartitions(String s) {
        // code here
        int[] lastOccurrence = new int[26];
        int idx = 0;
        for (char c : s.toCharArray()) {
            lastOccurrence[c-'a'] = idx;
            idx++;
        }

        List<Integer> ans = new ArrayList<>();
        idx = 0;
        int st = 0, n = s.length();
        while (idx < n) {
            st = getMax(s,lastOccurrence,idx);
            ans.add(st-idx+1);
            idx = st+1;
        }
        return ans.size();
    }
    private int getMax(String str, int[] lastOccurence, int s) {
        int l = Math.max(s,lastOccurence[str.charAt(s)-'a']), m = l;
        while (s <= Math.max(m,l)) {
            m = Math.max(m,lastOccurence[str.charAt(s)-'a']);
            s++;
        }
        return m;
    }
}