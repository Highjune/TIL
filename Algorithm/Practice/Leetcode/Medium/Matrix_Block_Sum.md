# Matrix Block Sum
- [문제](https://leetcode.com/problems/matrix-block-sum/)


# 내 풀이
- 실패
- 좀 까다로운 문제




# 타인 풀이
- https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)
- 범위로 설정
- 이해를 덜함, 시간 가지고 다시 보기

```
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
                r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                ans[r][c] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return ans;
    }
}
```





