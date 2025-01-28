//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); 
        boolean[] visited = new boolean[chars.length];
        backtrack(result, new StringBuilder(), chars, visited);
        return result;
    }

    private void backtrack(ArrayList<String> result, StringBuilder current, char[] chars, boolean[] visited) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue; // Skip if already used
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue; // Skip duplicates

            visited[i] = true;
            current.append(chars[i]);

            backtrack(result, current, chars, visited);

            current.deleteCharAt(current.length() - 1); // Backtrack
            visited[i] = false;
        }
    }
}