class Solution {
    public int findMinArrowShots(int[][] points) {
        // sorting balloons intervals by thier X end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int len = points.length;
        int minArrows = 1; //for the 1st ballon
        int previous = 0;// 1st ballon index
        
        for(int current = 1 ; current < len ; current++)
        {
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if(points[current][0] > points[previous][1]){
                minArrows ++;
                previous = current; //Update index of previously burst balloon
            }
        }
        return minArrows;       
    }
}