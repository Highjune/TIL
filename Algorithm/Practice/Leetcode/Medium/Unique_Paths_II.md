# Unique_Paths_II
- [문제](https://leetcode.com/problems/unique-paths-ii/description/)
- 풀이
    1. 2021.10.26 

# 내 풀이
- 푸는 중
```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] d = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        d[0][0] = 1;
        
        for (int i = 0 ; i < obstacleGrid.length ; i++) {
            for (int j = 0 ; j < obstacleGrid[0].length ; j++) {
                 if (obstacleGrid[i][j] == 1) {
                     obstacleGrid[i][j] = Integer.MAX_VALUE;
                 }
            }
        }        
        
        for (int i = 0 ; i < obstacleGrid.length ; i++) {
            for (int j = 0 ; j < obstacleGrid[0].length ; j++) {
                
                                
                int top = i > 0 ? 
                            (obstacleGrid[i-1][j] != Integer.MAX_VALUE ? grid[i-1][j] : 0) : 0;
                                
                int left = j > 0 ?
                            (obstacleGrid[i][j-1] != Integer.MAX_VALUE ? grid[i][j-1] : 0) : 0;
                                
                d[i][j] = top + left;
            }
        }
        
        
        return d[obstacleGrid.length - 1][obstacleGrid[0].length-1];
    }
}
```


# 타인 풀이