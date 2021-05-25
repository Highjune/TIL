# Running Sum of 1d Array
- [문제](https://leetcode.com/problems/running-sum-of-1d-array/)


# 내 풀이
- 시간복잡도 O(N)

```
class Solution {
    public int[] runningSum(int[] nums) {
        int[] resultArr = new int[nums.length];
        int sum = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            resultArr[i] = sum;

        }
        return resultArr;
    }
}
```

# 정답1
- 시간복잡도 O(N)
- 좀 더 명확
```
class Solution {
public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        // Initialize first element of result array with first element in nums.
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
```


# 정답2
- 시간복잡도 O(N)
- 더 깔끔
```
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1 ; i < nums.length ; i++) {
            nums[i] += nums[i-1];
        }

        return nums;
    }
}
```
