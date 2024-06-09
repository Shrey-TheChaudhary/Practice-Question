//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {

    public static boolean isZigzag(int n, int[] arr) {
        int f = 1;

        for (int i = 1; i < n; i++) {
            if (f == 1) {
                if (arr[i - 1] > arr[i]) return false;
            } else {
                if (arr[i - 1] < arr[i]) return false;
            }
            f ^= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            obj.zigZag(n, arr);

            boolean check = isZigzag(n, arr);
            if (check) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}

// } Driver Code Ends



class Solution {
    public static void zigZag(int n, int[] arr) {
        // Initialize a flag to indicate the expected comparison direction
        boolean isLessRelationExpected = true;

        // Loop through the array till the second last element
        for (int i = 0; i < n - 1; i++) {
            if (isLessRelationExpected) {
                // If the current element is greater than the next, swap them
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                // If the current element is less than the next, swap them
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            // Toggle the expected comparison direction for the next iteration
            isLessRelationExpected = !isLessRelationExpected;
        }
    }

    // Utility function to swap elements at two indices in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}