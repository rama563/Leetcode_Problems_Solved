class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long[] dp = new long[n + 1];
        long mod = (long) (1e9 + 7);
        for (int i = n; i >= 0; i--) {
            if (i == n) dp[i] = 1;
            else if (s.charAt(i) == '0') dp[i] = 0;
            else {
                long num = 0, count = 0;
                for (int j = i; j < n; j++) {
                    num = (num * 10) + s.charAt(j) - '0';
                    if (num > k) break;
                    else {
                        count = (count % mod + dp[j + 1] % mod) % mod;
                    }
                }
                dp[i] = count;
            }
        }
        return (int) dp[0];
    }
}