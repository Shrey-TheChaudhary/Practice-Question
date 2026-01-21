class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        for(int i=0;i<n;i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(i + 1);
            } else {
                list.add(i - stack.peek());
            }
            stack.push(i);
        }
        return list;
    
    }
}