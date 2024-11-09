import java.util.ArrayList;
import java.util.List;

class Solution {
    public long minEnd(int n, int x) {
        long result = (long) x; 
        long maxi = 1;
        List<Integer> index = new ArrayList<>();

       
        for (int i = 0; i < 63; i++) {
            if ((result >> i & maxi) == 0) { 
                index.add(i);
            }
        }

        int size = index.size();
        long count = (maxi << size);
        for (long i = 0; i < count; i++) {
            if (--n == 0) { 
                for (int j = 0; j < size; j++) { 
                    if ((i >> j & maxi) != 0) {
                        result |= (maxi << index.get(j));
                    }
                }
                return result;
            }
        }
        return result;
    }
}
