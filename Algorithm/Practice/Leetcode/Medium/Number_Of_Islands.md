# Number_Of_Islands
- [문제](https://leetcode.com/problems/number-of-islands/)
- 풀이
    - 2021.10.18 (실패)

# 내 풀이
- 실패

# 타인 풀이
- https://www.youtube.com/watch?v=36du-PpTazc&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=6
- Graph 문제
- DFS 로 접근 (BFS로 해도 됨)
```
class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return numIslands;
        }
        
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                
                numIslands++;
                dfs(grid, i, j);
            }
        }
        
        return numIslands;        
    }
    
    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 'x';
        
        // right
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') dfs(grid, i, j + 1);
            
        // left
        if (j - 1 >= 0 && grid[i][j-1] == '1') dfs(grid, i, j-1);
            
        // up
        if (i - 1 >= 0 && grid[i-1][j] == '1') dfs(grid, i - 1, j);
            
        // down
        if (i + 1 < grid.length && grid[i+1][j] == '1') dfs(grid, i + 1, j);
    }
}

```