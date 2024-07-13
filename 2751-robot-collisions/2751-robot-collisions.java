class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer[] indices = new Integer[positions.length];
        for (int i = 0; i < positions.length; i++)
            indices[i] = i;
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);
        List<Integer> robots = new ArrayList<>();
        for (int i : indices) {
            if (directions.charAt(i) == 'R')
                robots.add(i);
            else {
                while (!robots.isEmpty() && healths[i] > 0) {
                    int n = robots.get(robots.size() - 1);
                    if (healths[n] > healths[i]) {
                        healths[n]--;
                        healths[i] = 0;
                    }
                    else {
                        robots.remove(robots.size() - 1);
                        healths[i] -= (healths[n] < healths[i] ? 1 : healths[i]);
                        healths[n] = 0;
                    }
                }
            }
        }
        return Arrays.stream(healths).filter(h -> h > 0).boxed().collect(Collectors.toList());
    }
}