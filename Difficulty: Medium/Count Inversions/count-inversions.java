//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array
    static int inversionCount(int arr[]) {
        int n = arr.length;
        // Temporary array for merge sort
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    // Function to perform merge sort and count inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0; // Initialize the inversion count
        
        if (left < right) {
            // Find the midpoint of the array
            int mid = left + (right - left) / 2;

            // Recursively count inversions in the left and right halves
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count inversions during the merge step
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two halves and count inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for the left subarray
        int j = mid + 1;  // Starting index for the right subarray
        int k = left;     // Starting index for the merged array
        int invCount = 0; // Count of inversions

        // Merge the two halves
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                // No inversion, copy the smaller element
                temp[k++] = arr[i++];
            } else {
                // Inversion found
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted elements back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}