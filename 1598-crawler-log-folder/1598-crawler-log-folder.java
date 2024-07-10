class Solution {
    public int minOperations(String[] logs) {
        int folderDepth = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (folderDepth > 0) folderDepth--;
            } 
            else if (!log.equals("./")) {
                folderDepth++;
            }
        }

        return folderDepth;
    }
}