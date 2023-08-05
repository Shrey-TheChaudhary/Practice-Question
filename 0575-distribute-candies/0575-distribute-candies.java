class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet();

        for(int candy : candyType)
            set.add(candy);
        
        return Math.min(set.size(), n/2);
    }
}