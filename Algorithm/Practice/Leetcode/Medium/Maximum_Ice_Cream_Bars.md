# Maximum Ice Cream Bars
- [문제](https://leetcode.com/problems/maximum-ice-cream-bars/)


# 내 풀이
- 시간복잡도 O(N)
```
import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) break;
            coins -= costs[i];
            result++;
        }
        return result;
    }
}

```