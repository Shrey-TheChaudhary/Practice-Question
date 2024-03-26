//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
     public boolean isAdditiveSequence(String n) {
          s = n;
          return solve(0, "", "", "");
     }
     String s;
     boolean solve(int i, String a, String b, String c) {
          if (i == s.length()) {
               if (a.equals("") || b.equals("") || c.equals(""))
                    return false;

               int na = Integer.parseInt(a);
               int nb = Integer.parseInt(b);
               int nc = Integer.parseInt(c);
               if (na + nb == nc)
                    return true;
               return false;
          }

          if (a.equals("")) {
               // add to a

               boolean c1 = solve(i + 1, a + s.substring(i, i + 1), b, c);
               if (c1)
                    return true;
               return false;
          } else {
               if (b.equals("")) {
                    // add to a
                    boolean c1 = false;
                    if (a.length() < 9)
                         c1 = solve(i + 1, a + s.substring(i, i + 1), b, c);
                    if (c1)
                         return true;

                    // add to b
                    boolean c2 = solve(i + 1, a, b + s.substring(i, i + 1), c);
                    if (c2)
                         return true;

                    return false;
               } else {
                    if (c.equals("")) {
                         // add to b
                         boolean c1 = false;
                         if (b.length() < 9)
                              c1 =
                                  solve(i + 1, a, b + s.substring(i, i + 1), c);
                         if (c1)
                              return true;

                         // add to c
                         boolean c2 = false;
                         c2 = solve(i + 1, a, b, c + s.substring(i, i + 1));
                         if (c2)
                              return true;

                         // add to c, stop and calculate
                         int na = Integer.parseInt(a);
                         int nb = Integer.parseInt(b);
                         int nc = Integer.parseInt(c + s.substring(i, i + 1));
                         if (na + nb != nc)
                              return false;
                         else {
                              // System.out.println("here");
                              if (i == s.length() - 1) {
                                   return true;
                              }
                              return solve(
                                  i + 1, b, c + s.substring(i, i + 1), "");
                         }

                    } else {
                         // add to c
                         boolean c2 = false;
                         if (c.length() < 9)
                              c2 =
                                  solve(i + 1, a, b, c + s.substring(i, i + 1));
                         if (c2)
                              return true;

                         if (c.length() == 9)
                              return false;

                         // add to c, stop and calculate
                         int na = Integer.parseInt(a);
                         int nb = Integer.parseInt(b);
                         int nc = Integer.parseInt(c + s.substring(i, i + 1));
                         if (na + nb != nc)
                              return false;
                         else {
                              if (i == s.length() - 1) {
                                   return true;
                              }
                              return solve(
                                  i + 1, b, c + s.substring(i, i + 1), "");
                         }
                    }
               }
          }
     }
}