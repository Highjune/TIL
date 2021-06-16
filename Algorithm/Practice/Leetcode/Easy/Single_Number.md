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
- 제일 베스트, 이전에 풀어본 적이 있어서 기억남
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


# 타인 풀이1
- https://leetcode.com/problems/single-number/solution/
- 내 풀이2보다 좋은 건 아니지만, list의 특성으로 중복 해결하는 것 생각하기.
- list.contains() 함수
- list.remove(Object o) 함수 
    - index로 지우는 것이 아니라 그 객체 자체를 지우는 것. `no_duplicate_list.remove(new Integer(i));`
```
class Solution {
  public int singleNumber(int[] nums) {
    List<Integer> no_duplicate_list = new ArrayList<>();

    for (int i : nums) {
      if (!no_duplicate_list.contains(i)) {
        no_duplicate_list.add(i);
      } else {
        no_duplicate_list.remove(new Integer(i));
      }
    }
    return no_duplicate_list.get(0);
  }
}
```

# 타인 풀이2
- https://leetcode.com/problems/single-number/solution/
- 수학적으로 푸는 것
- 2 * (a + b + c) - (a + a + b + b + c) = c
- 위에서 (a + b + c) 는 set으로.
```
class Solution {
    public int singleNumber(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                sumOfSet += i;
            }
            sumOfNums += i;
        }

        return sumOfSet * 2 - sumOfNums;
    }
}
```