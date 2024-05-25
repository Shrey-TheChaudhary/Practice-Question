class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        
        Collections.sort(processorTime);
        Collections.sort(tasks,Collections.reverseOrder());
        
        int max2=Integer.MIN_VALUE;
        
        for(int i=0;i<processorTime.size();i++){
            max2 = Math.max(max2,processorTime.get(i)+tasks.get(i*4));
        }
        return max2;
    }
}