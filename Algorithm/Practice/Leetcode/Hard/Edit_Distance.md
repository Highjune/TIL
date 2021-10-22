# Edit_Distance

- [문제](https://leetcode.com/problems/edit-distance/description/)
- 풀이
  1. 2021.10.22
- 다이나믹 프로그래밍 교과서적인 문제, 수정거리
- 매우 자주 나오는 문제

# 내 풀이

- 실패

# 타인 풀이

- https://www.youtube.com/watch?v=dY_dZohgVa8&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=10
- [해외유투버 해설 매우 굿](https://www.youtube.com/watch?v=b6AGUjqIPsA)

```class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] d = new int[len1 + 1][len2 + 1];

        // 초기화
        for (int i = 0 ; i <= len1 ; i++)
            d[i][0] = i;

        for (int j = 0 ; j <= len2 ; j++)
            d[0][j] = j;

        // 루프
        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1])) + 1;
                }
            }
        }

        // 리턴
        return d[len1][len2];
    }
}
```
