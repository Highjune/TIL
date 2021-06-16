# Single_Number
- [문제](https://leetcode.com/problems/single-number/)


# 내 풀이1
- 더 좋은 방법이 있을듯
```
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            if (map.get(i) == 1) {
                ans = i;
            }
        }

        return ans;
    }
}
```


# 내 풀이2
- 생각남, 굳
```
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
```