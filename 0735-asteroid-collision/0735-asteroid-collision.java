// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         int n = asteroids.length;
//         int j = 0;

//         for (int i = 0; i < n; i++) {
//             int asteroid = asteroids[i];
//             while (j>0 && asteroids[j-1]>0 && asteroid<0 && asteroids[j-1] < Math.abs(asteroid)) 
//             {
//                 j--;
//             }

//             if (j==0 || asteroid>0 || asteroids[j-1]<0) 
//                 asteroids[j++] = asteroid;
//             else if(asteroids[j-1] == Math.abs(asteroid)) 
//                 j--;
//         }
        
//         int[] result = new int[j];
//         System.arraycopy(asteroids, 0, result, 0, j);

//         return result;
//     }
// }


//STRIVER
class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Flag to indicate if the current asteroid is still active
            boolean isActive = true;

            while (!stack.isEmpty() && isActive && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > top) {
                    stack.pop();  // The top asteroid gets destroyed
                } else if (Math.abs(asteroid) == top) {
                    stack.pop();  // Both asteroids get destroyed
                    isActive = false;  // Current asteroid is also destroyed
                } else {
                    isActive = false;  // Current asteroid gets destroyed
                }
            }

            if (isActive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}