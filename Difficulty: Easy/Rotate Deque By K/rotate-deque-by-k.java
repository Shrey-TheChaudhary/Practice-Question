class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        while (k-- > 0) {
            if (type == 1)
                dq.addFirst(dq.pollLast());
            else
                dq.addLast(dq.pollFirst());
        }
    }
}