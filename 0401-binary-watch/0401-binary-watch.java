class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 10) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
      
        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
				
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    
                    result.add(String.format("%d:%02d", hour, minute));
                    
                }
            }
        }      
        
        return result;
    }
}