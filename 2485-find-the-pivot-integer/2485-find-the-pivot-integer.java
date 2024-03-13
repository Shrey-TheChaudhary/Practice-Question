// public class Solution {
//     public int pivotInteger(int n) {
//         int sum = n * (n + 1) / 2;
      
//         int root = (int) Math.sqrt(sum);
//         if (root * root == sum) {
//             return root;
//         }
//         return -1;
//     }
// }
class Solution {
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int sleft = left;
        int sright = right;

        if (n == 1) return n;

        while (left < right) {
            if (sleft < sright) 
                sleft += ++left;
             else 
                sright += --right;
            

            if (sleft == sright && left + 1 == right - 1) {
                return left + 1;
            }
        }

        return -1;
    }
}
