class Solution {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        int n = s.length();
        if (n == 0) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to be decoded

        // Single character decoding
        dp[1] = s.charAt(0) == '*' ? 9 : (s.charAt(0) != '0' ? 1 : 0);

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i - 1);
            char previous = s.charAt(i - 2);

            // Single character decoding for current position
            if (current == '*') {
                dp[i] = 9 * dp[i - 1];
            } else if (current != '0') {
                dp[i] = dp[i - 1];
            }

            // Two character decoding for current and previous position
            if (previous == '*') {
                if (current == '*') {
                    dp[i] += 15 * dp[i - 2]; // "**" can be 11-19, 21-26
                } else if (current <= '6') {
                    dp[i] += 2 * dp[i - 2]; // "*[0-6]" can be 1* and 2*
                } else {
                    dp[i] += dp[i - 2]; // "*[7-9]" can be only 1*
                }
            } else if (previous == '1') {
                if (current == '*') {
                    dp[i] += 9 * dp[i - 2]; // "1*" can be 11-19
                } else {
                    dp[i] += dp[i - 2]; // "1X" can be 11-19
                }
            } else if (previous == '2') {
                if (current == '*') {
                    dp[i] += 6 * dp[i - 2]; // "2*" can be 21-26
                } else if (current <= '6') {
                    dp[i] += dp[i - 2]; // "2X" can be 21-26
                }
            }

            dp[i] %= MOD; // Apply modulo operation to keep the number manageable
        }

        return (int) dp[n];
    }
}