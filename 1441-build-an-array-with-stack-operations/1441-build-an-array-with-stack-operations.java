class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        int currNum = 1;
        int index = 0;
        while (currNum <= n && index < target.length) {
            int num = target[index];
            if (num == currNum) {
                operations.add("Push");
                currNum++;
                index++;
            } else {
                operations.add("Push");
                operations.add("Pop");
                currNum++;
            }
        }
        return operations;
    }
}