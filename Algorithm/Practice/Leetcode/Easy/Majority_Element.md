# Majority Element
- [문제](https://leetcode.com/problems/majority-element/)
- 풀이
    1. 2021.05.31(성공) - Codility에서도 Boyer-Moore 알고리즘 봤었는데도 생각 못함
    2. 2021.11.14(성공) - 또 Boyer-Moore 알고리즘 생각못함.

# 내 풀이
- 속도가 늦음. 비효율
- 이전에 codility에서 같은 문제를 풀어봤는데도 좀 헷갈려서 찾아봄
- 하지만 이렇게 푸는 것 아님

```
import java.util.HashMap;
import java.util.Map;

class Solution {
 
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +  1);
        }

        int max = 0;
        int maxKey = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                maxKey = i;
            }
        }

        if (max <= nums.length / 2) {
            return -1;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == maxKey){
                return nums[i];
            }
        }
        return -1;

    }
}
```

# 정답1
- https://leetcode.com/problems/majority-element/solution/
- 정렬시 중간값일 수밖에 없다. 매우 간단하지만 최상의 효율은 아니다
- O(nlogn)
```
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); // O(nlogn) 의 시간복잡도
        return nums[nums.length/2];
    }
}
```

# 정답2(최상)
- O(N)
- https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
- Boyer-Moore Majority Vote Algorithm
```
public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}
```
