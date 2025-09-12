import java.util.*;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        Queue<Integer> vertical_cost = new LinkedList<>();
        Queue<Integer> horizontal_cost = new LinkedList<>();

        for (int i = x.length - 1; i >= 0; i--) {
            vertical_cost.add(x[i]);
        }
        for (int i = y.length - 1; i >= 0; i--) {
            horizontal_cost.add(y[i]);
        }

        int vertical_segments = 1;
        int horizontal_segments = 1;
        int total_cost = 0;

        while (!vertical_cost.isEmpty() || !horizontal_cost.isEmpty()) {
            int vertical_head = vertical_cost.isEmpty() ? -1 : vertical_cost.peek();
            int horizontal_head = horizontal_cost.isEmpty() ? -1 : horizontal_cost.peek();

            if (horizontal_cost.isEmpty() || 
                (!vertical_cost.isEmpty() && vertical_head >= horizontal_head)) {
                total_cost += vertical_cost.poll() * horizontal_segments;
                vertical_segments++;
            } else {
                total_cost += horizontal_cost.poll() * vertical_segments;
                horizontal_segments++;
            }
        }

        return total_cost;
    }
}