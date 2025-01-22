class Solution {
    int[][] dp; 
    int lcs(int i, int j, int m, int n, String t1, String t2) {
        if (i >= m || j >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + lcs(i + 1, j + 1, m, n, t1, t2);
        } else {
            dp[i][j] = Math.max(lcs(i, j + 1, m, n, t1, t2), lcs(i + 1, j, m, n, t1, t2));
        }

        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(0, 0, m, n, text1, text2);
    }
}
