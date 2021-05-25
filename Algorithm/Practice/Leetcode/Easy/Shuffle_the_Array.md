# Shuffle the Array
- [문제](https://leetcode.com/problems/shuffle-the-array/)


# 내 풀이
- 계산이 필요하므로 좋지 않음
```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] resultArr = new int[nums.length];

        for (int i = 0 ; i < nums.length ; i++) {
            if (i < n) {
                resultArr[2 * i] = nums[i];
            } else {
                resultArr[(i-n) * 2 + 1] = nums[i];
            }
        }
        return resultArr;
    }
}
```

# 타인 풀이1
- 계산필요없이 훨씬 깔끔
```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] resultArr = new int[2*n];

        for (int i = 0, j = n, idx = 0 ; i < nums.length ; i++, j++) {
            resultArr[idx++] = nums[i];
            resultArr[idx++] = nums[j];
        }

        return resultArr;
    }
}
```


# 타인 풀이2
```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];

        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n+i];
        }

        return res;
    }
}
```