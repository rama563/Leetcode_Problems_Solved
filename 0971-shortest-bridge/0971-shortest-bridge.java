class Solution {

    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    private boolean isSafe(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        if(x<0 || x>=n || y<0 || y>=m) {
            return false;
        }

        return true;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        //already pulled a node

        //do the work
        visited[x][y] = true;

        //explore unvisited neighbors
        int newX = 0, newY = 0;
        for(int k = 0; k<4; k++) {
            newX = x + dx[k];
            newY = y + dy[k];

            if(isSafe(grid, newX, newY) && visited[newX][newY] == false && grid[newX][newY] == 1) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    private void findFirstIsland(int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, visited, i, j);

                    //no need to continue further
                    return;                  
                }
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        //step 1: find the first island
        findFirstIsland(grid, visited);

        //step 2: run bfs from first island cells
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(visited[i][j] == true) {
                    //means it's part of first island that was explored by dfs call during step 1
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[] pair = null;
        int x = 0, y = 0;
        int newX = 0, newY = 0;
        int level = 0;
        int size = 0;

        while(!queue.isEmpty()) {

            size = queue.size();

            for(int i = 0; i<size; i++) {
                //pull a node
                pair = queue.remove();
                x = pair[0];
                y = pair[1];

                //if we see a node that's 1 beyond level 0, that's the second island
                if(level > 0 && grid[x][y] == 1) {
                    //if we found 2nd island 2 levels away, we need to flip only 1 zero in between. So, return level-1
                    return level-1;
                }

                //explore unvisited neighbors
                for(int k = 0; k<4; k++) {
                    newX = x + dx[k];
                    newY = y + dy[k];

                    if(isSafe(grid, newX, newY) && visited[newX][newY] == false) {
                        queue.add(new int[] {newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }

            level++;
        }

        //here means we never found the 2nd island
        return 0;
    }
}