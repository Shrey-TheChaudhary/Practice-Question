//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String arr[] = read.readLine().trim().split("\\s+");
            double perimeter = Double.parseDouble(arr[0]);
            double area = Double.parseDouble(arr[1]);

            Solution ob = new Solution();
            double ans = ob.maxVolume(perimeter, area);
            System.out.println(String.format("%.2f", ans));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    double maxVolume(double perimeter, double area) {
        double P = perimeter;
        double A = area;
        
        // Compute intermediate terms to find dimensions
        double sqrtTerm = Math.sqrt(P * P - 24 * A);
        double dimension1 = (P - sqrtTerm) / 12.0;
        double dimension2 = (P / 4.0) - 2 * dimension1;
        
        // Calculate the volume
        double volume = Math.pow(dimension1, 2) * dimension2;
        
        // Round the result to two decimal places
        return Math.round(volume * 100.0) / 100.0;
    }
}