import java.util.ArrayList;

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (arr == null) return res;
        backtrack(arr, 0, res);
        return res;
    }

    private static void backtrack(int[] arr, int idx, ArrayList<ArrayList<Integer>> res) {
        if (idx == arr.length) {
            ArrayList<Integer> perm = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) perm.add(arr[i]);
            res.add(perm);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            backtrack(arr, idx + 1, res);
            swap(arr, idx, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}