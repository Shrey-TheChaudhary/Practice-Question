class Solution {
    String minSum(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) num1.append(arr[i]);
            else num2.append(arr[i]);
        }

        return addStrings(num1.toString(), num2.toString());
    }

    String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString().replaceFirst("^0+(?!$)", "");
    }
}