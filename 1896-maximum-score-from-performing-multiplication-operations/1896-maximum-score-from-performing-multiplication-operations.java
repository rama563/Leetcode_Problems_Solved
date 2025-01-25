class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        Map<String, Integer> dp = new HashMap<>();
        int N = nums.length;
        int M = multipliers.length;
        
        return solve(nums, multipliers, 0, N - 1, 0, dp);
    }
    private int solve(int[] nums, int[] multipliers, int l, int r, int m, Map<String, Integer> dp) {
        if (m == multipliers.length) {
            return 0;
        }
        
        String key = l + "," + r + "," + m;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        int left = solve(nums, multipliers, l + 1, r, m + 1, dp) + multipliers[m] * nums[l];
        int right = solve(nums, multipliers, l, r - 1, m + 1, dp) + multipliers[m] * nums[r];
        
        int result = Math.max(left, right);
        dp.put(key, result);
        
        return result;
    }
}