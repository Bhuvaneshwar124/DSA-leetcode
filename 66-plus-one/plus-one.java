class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) 
        {
            // If digit is less than 9, just increment and return
            if (digits[i] < 9) 
            {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set to 0 (carry)
            digits[i] = 0;
        }

        // If we reach this point, all digits were 9, so we need extra space
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}