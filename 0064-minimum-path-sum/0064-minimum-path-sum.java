import java.util.Arrays;

class Solution {
    int solve(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if (i >= m || j >= n) return Integer.MAX_VALUE; // Boundary check
        if (i == m - 1 && j == n - 1) return grid[i][j]; // Base case: bottom-right corner
        if (dp[i][j] != -1) return dp[i][j]; // Return cached result
        dp[i][j] = grid[i][j] + Math.min((solve(i, j + 1, m, n, dp, grid)), (solve(i + 1, j, m, n, dp, grid))); // Add the current cell value
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1
        }

        return solve(0, 0, m, n, dp, grid); // Start from the top-left corner
    }
}
