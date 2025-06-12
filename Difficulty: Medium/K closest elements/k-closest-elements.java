class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

     
        int idx = Arrays.binarySearch(arr, x);
        if (idx >= 0) {
       
            idx--;
        } else {
            idx = -idx - 1;
        }

        int left = idx - 1;
        int right = idx;

        while (k > 0) {
            int leftDiff = Integer.MAX_VALUE;
            int rightDiff = Integer.MAX_VALUE;

            if (left >= 0 && arr[left] != x) {
                leftDiff = Math.abs(arr[left] - x);
            }
            if (right < n && arr[right] != x) {
                rightDiff = Math.abs(arr[right] - x);
            }

            if (leftDiff == Integer.MAX_VALUE && rightDiff == Integer.MAX_VALUE) {
                break;
            }

            if (leftDiff < rightDiff) {
                result.add(arr[left--]);
            } else if (rightDiff < leftDiff) {
                result.add(arr[right++]);
            } else {
        
                if (left >= 0 && right < n) {
                    if (arr[left] > arr[right]) {
                        result.add(arr[left--]);
                    } else {
                        result.add(arr[right++]);
                    }
                } else if (left >= 0) {
                    result.add(arr[left--]);
                } else {
                    result.add(arr[right++]);
                }
            }

            k--;
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}