class Solution {
        int solve(int i,int j,int m,int n, int dp[][],int g[][]){
        if(i>=m || j>=n || g[i][j]==1)
        {
            return 0;
        }

        if(i == m-1 && j == n-1)
        {
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        else
        return dp[i][j] = solve(i+1,j,m,n,dp,g)+solve(i,j+1,m,n,dp,g);
    }
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length;
        int n = g[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n,dp,g);
    }
}