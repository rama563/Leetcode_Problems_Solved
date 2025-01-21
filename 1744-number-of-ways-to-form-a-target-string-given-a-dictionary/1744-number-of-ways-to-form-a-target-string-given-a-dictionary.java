class Solution {
    // Define the modulo constant to prevent integer overflow
    final int MOD = 1000000007;

    public int numWays(String[] words, String target) {
        int n = words[0].length(); // Number of columns in the matrix (length of each word)
        int[][] mat = new int[26][n]; // Frequency matrix to count occurrences of each character in each column

        // Step 1: Build the frequency matrix
        // `mat[c][j]` will store the count of character `c` at column `j` across all words
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                mat[ch - 'a'][j]++;
            }
        }

        // Step 2: Create a memoization table to store subproblem results
        // `dp[i][j]` represents the number of ways to form `target.substring(j)` starting from column `i`
        int[][] dp = new int[n][target.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed values
        }

        // Step 3: Call the recursive helper function starting from the 0th column and the 0th character of the target
        return helper(mat, target, 0, 0, dp);
    }

    /**
     * Recursive helper function to calculate the number of ways to form the target.
     *
     * @param freq   Frequency matrix built from `words`
     * @param target Target string to form
     * @param i      Current column index in the frequency matrix
     * @param j      Current character index in the target string
     * @param dp     Memoization table to cache results
     * @return       Number of ways to form the target starting from column `i` and character `j`
     */
    int helper(int[][] freq, String target, int i, int j, int[][] dp) {
        // Base case 1: If we have successfully formed the entire target
        if (j == target.length()) {
            return 1;
        }

        // Base case 2: If we have run out of columns to form the target
        if (i == freq[0].length) {
            return 0;
        }

        // Check if this subproblem has already been solved
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Case 1: Take the current character from column `i`
        int take = 0; // Initialize `take` as 0
        if (freq[target.charAt(j) - 'a'][i] > 0) { 
            // If the current character exists in column `i`
            // Multiply the number of ways to form the rest of the target by the frequency of the character
            take = (int)((long)freq[target.charAt(j) - 'a'][i] * helper(freq, target, i + 1, j + 1, dp) % MOD);
        }

        // Case 2: Skip the current column
        int notTake = helper(freq, target, i + 1, j, dp);

        // Store the result of the current subproblem in the memoization table
        return dp[i][j] = (take + notTake) % MOD;
    }
}
