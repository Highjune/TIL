# Two Sum
- [문제](https://leetcode.com/problems/intersection-of-two-arrays/)


# 내 풀이
- 시간복잡도 O(N X M)
- 이렇게 풀면 안되지만 생각이 안 날 경우에 코드 연습 겸 어떻게라도 풀어보기

```
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < nums1.length ; i++) {
            for (int j = 0 ; j < nums2.length ; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }

            }
        }
        
        int[] resultArr = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int k = 0;
        while (it.hasNext()) {
            resultArr[k] = it.next();
            k++;
        }

        for (int p : resultArr) {
            System.out.println(p);
        }

        return resultArr;
    }
}
```

# 정답 1
- 시간복잡도 O(N + M)
- set.retainAll() 함수의 존재를 이제 알았다. 교집합
    - ex) 반대로 set.removeAll(). 여집합
```

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] sum1 = new int[]{1, 2, 2, 1};
        int[] sum2 = new int[]{1, 2};
        s.intersection(sum1, sum2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        int[] resultArr = new int[set1.size()];
        int k = 0;
        for (int i : set1) {
            resultArr[k++] = i;
        }

        return resultArr;
    }
}
```

# 정답2
- 시간복잡도 O(N + M)
- Arrays.copyOf(복사할 배열, 범위)
    - ex) Arrays.copyOf(resultArr, 5); 는 resultArr 배열의 0 ~ 4까지
```
class Solution {

    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] result = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            if (set2.contains(s)) {
                result[idx++] = s;
            }
        }

        System.out.println("==========");
        for (int k : result) {
            System.out.println(k);
        }
        System.out.println("==========");

//        return result;

        return Arrays.copyOf(result, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        if (set1.size() < set2.size()) {
            return set_intersection(set1, set2);
        } else {
            return set_intersection(set2, set1);
        }

    }
}


```