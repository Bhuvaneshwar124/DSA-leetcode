class Solution {
    public int maxProduct(int n) {
        int one=Integer.MIN_VALUE;
        int two=Integer.MIN_VALUE;
        while(n!=0){
            int temp=n%10;
            if(temp>=one){ 
                two=one;
                one=temp;
                }
            else if(temp>two) two=temp;
            n=n/10;
        }
        return one*two;
    }
}