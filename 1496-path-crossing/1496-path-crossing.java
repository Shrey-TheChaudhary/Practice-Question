import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isPathCrossing(String movementPath) {
        Set<String> visitedPoints = new HashSet<>();
        
        int currentX = 0, currentY = 0;
        visitedPoints.add(currentX + "," + currentY);

        for (char direction : movementPath.toCharArray()) {
            if (direction == 'N') 
                currentY++;
            else if (direction == 'S') 
                currentY--;
            else if (direction == 'E') 
                currentX++;
            else 
                currentX--;

            String point = currentX + "," + currentY;
            if (visitedPoints.contains(point)) {
                return true;
            }

            visitedPoints.add(point);
        }

        return false;
    }
}