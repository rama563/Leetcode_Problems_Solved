class Solution {
    int[][] dp; 

    int solve(int i, int j, String s) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(i + 1, j - 1, s);
        } else {
            dp[i][j] = 1 + Math.min(solve(i + 1, j, s), solve(i, j - 1, s));
        }

        return dp[i][j];
    }

    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s);
    }
}
