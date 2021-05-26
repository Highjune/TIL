# Find Center of Star Graph
- [문제](https://leetcode.com/problems/find-center-of-star-graph/)


# 내 풀이
- O(1)
```
import java.util.*;

class Solution {
public int findCenter(int[][] edges) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < 2 ; i++) {
            for (int j = 0 ; j < 2 ; j++) {
                int num  = map.getOrDefault(edges[i][j], 0);
                map.put(edges[i][j], ++num);
            }
        }

        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (map.get(val) != 1) {
                result = val;
            }
        }

        return result;
    }
}
```

# 타인 풀이
- https://leetcode.com/problems/find-center-of-star-graph/discuss/1108319/C%2B%2BJava-O(1)-or-O(1)-or-1-liner
- 엄청 간단
```
public int findCenter(int[][] e) {
    return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
}

```