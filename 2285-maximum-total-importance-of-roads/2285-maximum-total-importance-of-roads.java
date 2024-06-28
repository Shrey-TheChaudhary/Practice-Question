class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n]; // Array to store the degree of each city
        
        // Calculate the degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        // Count the frequency of each degree
        int[] frequency = new int[n];
        for (int d : degree) {
            frequency[d]++;
        }
        
        long totalImportance = 0;
        long value = 1;
        
        // Assign values to cities starting from the highest degree
        for (long i = 0; i <n; i++) {
            for (int j = 0; j < frequency[(int)i]; j++) {
                totalImportance += i * value++;
            }
        }
        
        return totalImportance;
    }
}
