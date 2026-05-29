class Solution {
    public int minElement(int[] nums) {

        int minval=Integer.MAX_VALUE;

        for (int currnum:nums){
            int currsum=0;
            while (currnum>0){
                currsum+=(currnum%10);
                currnum/=10;
            }
            if (currsum<minval){
                minval=currsum;
            }
        }
        return minval;
    }
}