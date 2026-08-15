class Solution {
    public int longestSubsequence(int[] nums) {
        boolean oddCountFound = false;
        boolean allZeros = true;
        for(int bit = 0;bit<=31;bit++){
            int oneCount = 0;
            for(int num: nums){
                if(((num>>bit) & 1)==1) oneCount++;
                if(bit == 0) {
                    if(num!=0) allZeros = false;
                }
            }
            if(oneCount%2!=0){
                oddCountFound = true;
                break;
            }
        }
        if(allZeros) return 0;
        int n = nums.length;
        return oddCountFound?n:n-1;
    }
}