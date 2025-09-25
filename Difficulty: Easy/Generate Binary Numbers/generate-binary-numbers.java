class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            res.add(Integer.toBinaryString(i));
        }
        return res;
    }
}
