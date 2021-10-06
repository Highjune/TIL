# Two Sum
- [문제](https://leetcode.com/problems/two-sum/)
- 풀이
    - 2021.05 (비효율로 품)
    - 2021.10.06 (비효율로 품)
- 개념에 대한 좋은 설명
    - [유튜브 승지니어](https://www.youtube.com/watch?v=ly-zKS3ubYo&t=27s)


# 내 풀이
- 비효율 풀이
- 시간복잡도 O(N^2)
- 공간보갑도 O(1)
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
        throw new IllegalArgumentException("No two sum solution"); // return null; 로 해도 됨
    }
}


```

# 정답1
- Hash Table
- 시간복잡도 O(N)
- 공간복잡도 O(N), 다 넣어야 하므로
```
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0 ; i < nums.length ; i++) {
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
- Good
- 위랑 같은데 좀 더 단순
- Hash Table
    - 루프 1개 돌면서 이미 봤던 값을 해쉬맵에 넣음
- 시간복잡도 O(N)
- 공간복잡도 O(N), 다 넣어야 하므로
```
public class Solution {
    public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0 ; i < nums.length ; i++) {
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


# 정답3
- 정답1, 정답2와 같음
- [유튜브 승지니어](https://www.youtube.com/watch?v=ly-zKS3ubYo&t=27s)
```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            int cur = nums[i];
            if (map.containsKey(target - cur)) {
                return new int[]{i, map.get(target - cur)};
            } else {
                map.put(cur, i);
            }
        }

        return null;

    }
}
```