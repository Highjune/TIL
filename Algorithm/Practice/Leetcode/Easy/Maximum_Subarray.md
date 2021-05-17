# Maximum_Subarray
- [문제](https://leetcode.com/problems/maximum-subarray/)


# 내 풀이
- Best_Time_to_Buy_and_Sell_StocK 와 유사한 문제
- [카데인 알고리즘](https://sustainable-dev.tistory.com/23)
- 



# 정답1
- O(n)
```
class Solution {
    public int maxSubArray(int[] nums) {

        int localMaxSum = nums[0];
        int finalMaxSum = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            localMaxSum = Math.max(nums[i], localMaxSum + nums[i]);

            if (localMaxSum > finalMaxSum) {
                finalMaxSum = localMaxSum;
            }
        }
        
        return finalMaxSum;
    }
}
```