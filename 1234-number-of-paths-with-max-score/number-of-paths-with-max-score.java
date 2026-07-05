class Solution {
    int max = 0;
    Integer[][] dp;
    Integer[][] dp1;
     int MOD = 1000000007;
 public int[] pathsWithMaxScore(List<String> mat) {
        int n = mat.size();
        dp = new Integer[n][n];
        dp1 = new Integer[n][n];
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = mat.get(i);
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        max = func(n - 1, n - 1, grid);
        if (max < 0) {
            return new int[] {0, 0};
        }
        int ways = dfs(n - 1, n - 1, grid);
        return new int[] {max, ways};
    }
    public int val(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        return 0;
    }
public int dfs(int i, int j, char[][] grid) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp1[i][j] != null) {
            return dp1[i][j];
        }
        long ans = 0;
        int best = func(i, j, grid);
        if (i - 1 >= 0 && grid[i - 1][j] != 'X') {
            int temp = func(i - 1, j, grid);
            if (temp != Integer.MIN_VALUE &&
                temp + val(grid[i - 1][j]) == best) {
                ans += dfs(i - 1, j, grid);
            }
        }
        if (j - 1 >= 0 && grid[i][j - 1] != 'X') {
            int temp = func(i, j - 1, grid);
            if (temp != Integer.MIN_VALUE && temp + val(grid[i][j - 1]) == best) {

                ans += dfs(i, j - 1, grid);
            }
        }
        if (i - 1 >= 0 && j - 1 >= 0 &&
            grid[i - 1][j - 1] != 'X') {
            int temp = func(i - 1, j - 1, grid);
            if (temp != Integer.MIN_VALUE && temp + val(grid[i - 1][j - 1]) == best) {

                ans += dfs(i - 1, j - 1, grid);
            }
        }
        return dp1[i][j] = (int)(ans % MOD);
    }
    public int func(int i, int j, char[][] grid) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int up = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;
        int diag = Integer.MIN_VALUE;
        if (i - 1 >= 0 && grid[i - 1][j] != 'X') {
            int temp = func(i - 1, j, grid);
            if (temp != Integer.MIN_VALUE) {
                up = temp + val(grid[i - 1][j]);
            }
        }
        if (j - 1 >= 0 && grid[i][j - 1] != 'X') {
            int temp = func(i, j - 1, grid);
            if (temp != Integer.MIN_VALUE) {
                left = temp + val(grid[i][j - 1]);
            }
        }
        if (i - 1 >= 0 && j - 1 >= 0 &&
            grid[i - 1][j - 1] != 'X') {
        int temp = func(i - 1, j - 1, grid);
            if (temp != Integer.MIN_VALUE) {
                diag = temp + val(grid[i - 1][j - 1]);
            }
        }
        return dp[i][j] = Math.max(up, Math.max(left, diag));
    }
}