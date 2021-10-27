# Unique_Paths_II
- [문제](https://leetcode.com/problems/unique-paths-ii/description/)
- 다이나믹 프로그래밍
- 풀이
    1. 2021.10.26 (성공)

# 내 풀이
- 성공
- 유투브 승지니어 님 푸는 방식을 차용해서 새로운 문제에 적용해서 풀었다!
- 삼항 연산자 안에 삼항연산자 수식 넣은 것이 쉽지 않았다.
```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        int[][] d = new int[obstacleGrid.length][obstacleGrid[0].length];

        d[0][0] = 1;
        

        for (int i = 0 ; i < obstacleGrid.length ; i++) {
            for (int j = 0 ; j < obstacleGrid[0].length ; j++) {
                if (i==0 && j==0) continue;
                int top = i > 0 ?
                        (obstacleGrid[i-1][j] != 1 ? d[i-1][j] : 0) : 0;
                int left = j > 0 ?
                        (obstacleGrid[i][j-1] != 1 ? d[i][j-1] : 0) : 0;
                d[i][j] = top + left;
            }
        }


        return d[obstacleGrid.length - 1][obstacleGrid[0].length-1];
    }
}
```

# 타인 풀이
- https://www.youtube.com/watch?v=W2eoNUgzFVs&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=12
```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * d[i][j] = 0, 0 -> i, j 까지의 경로의 갯수
         */
        int[][] o = obstacleGrid;
        int[][] d = new int[o.length][o[0].length];
        d[0][0] = 1;    // 초기화

        for (int i = 0 ; i < obstacleGrid.length ; i++) {
            for (int j = 0 ; j < obstacleGrid[0].length ; j++) {
                int cur = o[i][j];
                if (cur == 1) {
                    d[i][j] = 0;
                } else {
                    if(i>0) d[i][j] += d[i-1][j];   // 이 부분이 간단명료
                    if(j>0) d[i][j] += d[i][j-1];   // 이 부분이 간단명료
                }
            }
        }
        
        return d[o.length - 1][o[0].length-1];
    }
}
```