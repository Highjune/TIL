# Unique_Paths
- [문제](https://leetcode.com/problems/unique-paths/description/)
- 다이나믹 프로그래밍
- 풀이
    1. 2021.10.29 (성공)

# 내 풀이
- 승지니어님이 푸는 방식처럼 풀었다.
```
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        
        d[0][0] = 1;
        
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i==0 && j==0) continue;
                int top = i > 0 ? d[i-1][j] : 0;
                int left = j > 0 ? d[i][j-1] : 0;
                    
                d[i][j] = top + left;
            }
        }
        
        return d[m-1][n-1];
    }
}
```

# 타인 풀이
- https://www.youtube.com/watch?v=cK_0tjzVCy4&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=14
```
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        
        d[0][0] = 1;
        
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i==0 && j==0) continue;
                if (i>0) d[i][j] += d[i-1][j];
                if (j>0) d[i][j] += d[i][j-1];
            }
        }
        
        return d[m-1][n-1];
    }
}
```