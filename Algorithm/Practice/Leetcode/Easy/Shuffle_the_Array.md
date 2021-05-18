# Shuffle the Array
- [문제](https://leetcode.com/problems/shuffle-the-array/)


# 내 풀이
```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] resultArr = new int[nums.length];

        for (int i = 0 ; i < nums.length ; i++) {
            if (i < n) {
                resultArr[2 * i] = nums[i];
            } else {
                nums[i]
            }
        }
    }

}

```