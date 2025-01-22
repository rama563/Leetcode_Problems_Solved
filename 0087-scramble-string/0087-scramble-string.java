class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2))
            return true;
        if (n < 1)
            return false;

        String key = s1 + " " + s2;
        if(memo.containsKey(key)) return memo.get(key);
        boolean ans = false;

        for (int i = 1; i <= n - 1; i++) {
            boolean swap = (isScramble(s1.substring(0, i), s2.substring(n - i, n))
                    && isScramble(s1.substring(i, n ), s2.substring(0, n-i)));
            boolean noSwap = (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, n), s2.substring(i, n)));

            if (swap || noSwap) {
                ans = true;
                break;
            }

        }
        memo.put(key,ans);
        return ans;
    }
}