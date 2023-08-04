class Solution {
    public int[] constructRectangle(int area) {
       int wid = (int) Math.sqrt(area);
        while (area%wid != 0){
            wid--;
        }
        int hig = area/wid;
        return (new int[] {hig, wid});
    
    }
}