import java.util.List;
import java.util.Arrays;

class Solution {
    int solve(int i, int j, int[][] dp, List<List<Integer>> triangle) {
        // Base case: If we are at the last row, return the value at that position
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        
        // Return cached result if already computed
        if (dp[i][j] != -1) return dp[i][j];
        
        // Recursive relation: Add current value and take the minimum of the next row's two possible paths
        dp[i][j] = triangle.get(i).get(j) + Math.min(
            solve(i + 1, j, dp, triangle),      // Path going down
            solve(i + 1, j + 1, dp, triangle)  // Path going diagonally right
        );
        
        return dp[i][j];
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(); // Number of rows in the triangle
        int[][] dp = new int[m][m]; // Create a dp array (triangle is sparse but m x m size is safe)
        
        // Initialize dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Solve starting from the top of the triangle
        return solve(0, 0, dp, triangle);
    }
}
