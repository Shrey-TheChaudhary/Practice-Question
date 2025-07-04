import java.util.HashMap;

class Solution {
    public int countAtMostK(int arr[], int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (right = 0; right < n; right++) {
            // Add current element to frequency map
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            // Shrink the window if more than k distinct elements
            while (freq.size() > k) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                left++;
            }

            // Add number of subarrays ending at right with at most k distinct
            count += (right - left + 1);
        }

        return count;
    }

    // To find exact k distinct, use this:
    public int countExactlyK(int arr[], int k) {
        return countAtMostK(arr, k) - countAtMostK(arr, k - 1);
    }
}

b