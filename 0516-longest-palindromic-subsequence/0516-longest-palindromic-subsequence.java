class Solution {
    int[][] dp; // To store the results of subproblems
    
    int lps(int i, int j, String s) {
        if (i == j) return 1; // Single character is a palindrome
        if (i > j) return 0;  // Invalid range
        
        if (dp[i][j] != -1) return dp[i][j]; // Return cached result
        
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + lps(i + 1, j - 1, s); // Extend the palindrome
        } else {
            dp[i][j] = Math.max(lps(i + 1, j, s), lps(i, j - 1, s)); // Exclude one character
        }
        
        return dp[i][j];
    }
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n]; // Initialize dp array
        
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill dp with -1 (unvisited state)
        }
        
        return lps(0, n - 1, s); // Solve for the entire string
    }
}
