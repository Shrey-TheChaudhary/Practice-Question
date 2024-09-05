class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
                int sum = n;
        for (int roll : rolls) {
            sum += roll;
        }
        int totalSum = mean * (rolls.length + n);
        int diff = totalSum - sum;

        if (diff > n * 5 || diff < 0) {
            return new int[0];
        }

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int i = 0;
        while (diff > 0) {
            int increment = Math.min(diff, 6 - arr[i]);
            arr[i] += increment;
            diff -= increment;
            if (arr[i] == 6) {
                i++;
            }
        }
        return arr;
    }
}