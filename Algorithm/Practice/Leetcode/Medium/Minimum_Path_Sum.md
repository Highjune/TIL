# Minimum_Path_Sum

- [문제](https://leetcode.com/problems/minimum-path-sum/)
- 풀이
    1. 2021.10.21 (실패)

# 내 풀이
- 실패


# 타인 풀이
- https://www.youtube.com/watch?v=v49ZgvJf7Xk&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=8
```
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] d = new int[grid.length][grid[0].length];
        d[0][0] = grid[0][0];
        
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid.length ; j++) {
                if (i==0 && j==0) continue;
                
                int up = (i > 0) ? d[i-1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? d[i][j-1] : Integer.MAX_VALUE;
                
                d[i][j] = Math.min(left, up) + grid[i][j];
            }
        }
        
        return d[grid.length - 1][grid[0].length - 1];
    }
}
```




public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] d = new int[grid.length][grid[0].length];
        d[0][0] = grid[0][0];

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; i < grid[0].length ; j++) {
                if (i == 0 && j == 0) continue;

                int top = i > 0 ? d[i-1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? d[i][j-1] : Integer.MAX_VALUE;

                d[i][j] = Math.min(top, left) + grid[i][j];
            }
        }

        return d[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        System.out.println(s.minPathSum(grid));
//
//        System.out.println(grid.length);
//        System.out.println(grid[0].length);

        System.out.println(s.minPathSum(grid));
    }

}