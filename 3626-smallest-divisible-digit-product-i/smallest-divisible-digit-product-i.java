class Solution {
    public static int product_digit(int n){
        int pro = 1;
        while(n != 0){
            int temp = n % 10;
            pro *= temp;
            n /= 10;
        }
        return pro;
    }

    public int smallestNumber(int n, int t) {
        for(int i = 0; i <= 10; i++){
            if(product_digit(n + i) % t == 0)
                return n + i;
        }
        return -1;
    }
}