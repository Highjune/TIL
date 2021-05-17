# Two Sum
- [문제](https://leetcode.com/problems/two-sum/)


# 내 풀이
- 시간복잡도 O(N^2)

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
            
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j++) { // 조건은 j < num.length 로 해도 됨. 어차피 조건에 안 걸리므로.
                if (nums[i] + nums[j] == target) {
                     return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


```

# 정답1
- Hash Table
- 시간복잡도 O(N)
```
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0 ; i <nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("no two sum solution");
    }
}
```
# 정답2
- 위랑 같은데 좀 더 단순
- Hash Table
- 시간복잡도 O(N)
```
public class Solution {
    public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0 ; i <nums.length ; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{i, map.get(complement)};
                }
                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("no two sum solution");
        }
}
```

