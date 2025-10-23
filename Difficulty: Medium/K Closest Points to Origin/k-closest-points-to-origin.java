class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        Arrays.sort(points,(p1,p2) -> {
            int dist1 = p1[0]*p1[0]+p1[1]*p1[1];
            int dist2 = p2[0]*p2[0] + p2[1]*p2[1];
            
            return Integer.compare(dist1,dist2);
        });
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            int[] point = points[i];
            
            ArrayList<Integer> pointList = new ArrayList<>();
            pointList.add(point[0]);
            pointList.add(point[1]);
            
            res.add(pointList);
        }
        
        return res;
    }
}