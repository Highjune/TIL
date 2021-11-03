# Longest_Increasing_Subsequence
- [문제](https://leetcode.com/problems/longest-increasing-subsequence/description/)
- 다이나믹 프로그래밍
- 풀이
    1. 2021.11.02(실패)

# 내 풀이




# 타인 풀이
- https://www.youtube.com/watch?v=Hq7VjlZRT2Y&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=17
- `d[j] > max` 부분에 대한 이해가 중요한 포인트였다.
```
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;  
        
        int[] d = new int[nums.length];
        d[0] = 1;
        
        for (int i = 1 ; i < nums.length ; i++) {
            int max = 0;
            for (int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i] && d[j] > max) {
                    max = d[j];
                }
            }
            
            d[i] = max + 1;
        }
        
        int max = d[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (d[i] > max) max = d[i];
        }
        
        return max;

    }
}


```