# Array Partition I
- [문제](https://leetcode.com/problems/array-partition-i/)


# 내 풀이
- 정답이랑 완전 일치
```
import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;

        for (int i = 0 ; i < nums.length ; i += 2) {
            maxSum += nums[i];
        }

        return maxSum;
    }
}
```

