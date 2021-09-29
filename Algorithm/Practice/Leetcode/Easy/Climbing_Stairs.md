# Climbing_Stairs
- [문제](https://leetcode.com/problems/climbing-stairs/)
- 기록
    - 2번째 2021.09.29 실패

# 내 풀이
- 실패
- recursion으로 풀어야 한다는 것은 알고 있었는데 잘못함


# 정답1
- https://leetcode.com/problems/climbing-stairs/solution/
- recursive
- 시간복잡도 O(2^n) - 사실상 실패
- 효율적이진 않더라도 recursion 이해하기에 간단하고 좋음
```
class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
```

# 정답2
- https://leetcode.com/problems/climbing-stairs/solution/
- recursive
- 시간복잡도 O(N), 공간복잡도 O(N)
- recursive 아직 익숙치 않다.
- 많이 풀어보자..
```
public class Solution {

    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
```

# 정답3
- https://leetcode.com/problems/climbing-stairs/solution/
- 다이나믹 프로그래밍(중요★★★)
- 시간복잡도 O(N), 공간복잡도 O(N)
```
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

# 정답4
- https://leetcode.com/problems/climbing-stairs/solution/
- 피보나치
- 시간복잡도 O(N), 공간복잡도 O(1)
```
class Solution {
    public int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        
        int first = 1;
        int second = 2;
        for (int i = 3 ; i <= n ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
```