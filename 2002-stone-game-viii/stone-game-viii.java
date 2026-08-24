class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) sum += s;

        int mx = sum;
        for (int i = n - 2; i > 0; i--) {
            sum -= stones[i+1];
            mx = Math.max(mx, sum - mx);
        }
       return mx;
    }
}

