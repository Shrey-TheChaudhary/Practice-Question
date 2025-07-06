class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // Sort both arrays in descending order
        // This is crucial for the optimized approach
        Arrays.sort(a);
        Arrays.sort(b);
        // Reverse for descending order
        reverseArray(a);
        reverseArray(b);

        // Max-priority queue to store (sum, index_a, index_b) tuples
        // We'll use an array of size 3: [sum, index_a, index_b]
        // The comparator ensures it acts as a max-heap based on sum
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        // HashSet to keep track of visited pairs (index_a, index_b)
        // This prevents adding duplicate pairs to the heap
        HashSet<String> visited = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        // Add the largest sum (a[0] + b[0]) to the heap initially
        // and mark its indices as visited
        maxHeap.offer(new int[]{a[0] + b[0], 0, 0});
        visited.add("0,0");

        // Extract k largest sums
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int currentSum = current[0];
            int i = current[1]; // index from array 'a'
            int j = current[2]; // index from array 'b'

            result.add(currentSum);
            k--;

            // Consider the next possible sums by moving to the right in 'b' (j+1)
            // or moving down in 'a' (i+1)
            
            // Explore (i, j+1)
            if (j + 1 < b.length) {
                String nextPair1 = i + "," + (j + 1);
                if (!visited.contains(nextPair1)) {
                    maxHeap.offer(new int[]{a[i] + b[j + 1], i, j + 1});
                    visited.add(nextPair1);
                }
            }

            // Explore (i+1, j)
            if (i + 1 < a.length) {
                String nextPair2 = (i + 1) + "," + j;
                if (!visited.contains(nextPair2)) {
                    maxHeap.offer(new int[]{a[i + 1] + b[j], i + 1, j});
                    visited.add(nextPair2);
                }
            }
        }

        return result;
    }

    // Helper method to reverse an array
    private void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}