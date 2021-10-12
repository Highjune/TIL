# Hamming Distance
- [문제](https://leetcode.com/problems/hamming-distance/)
- 풀이
    - 2021.10.12(실패)
    


# 내 풀이
- 실패
- 비트 연산 풀이 처음 풀어봄




# 타인 풀이
- https://www.youtube.com/watch?v=KNs8KhLIOdc&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW&index=3
- 이론
```
a = 3 -> 11
b = 2 -> 10

a & b = 10 ; 두비트가 모두 1이면 1, 아니면 0
a | b = 11 ; 두비트 중 하나라도 1이면 1, 아니면 0
a ^ b = 01 ; 두비트가 다르면 1, 아니면 0

a >> 1 = 01 ; a의 모든 비트를 오른쪽만큼 i만큼 밀고, 맨 왼쪽을 0으로 채움
a << 1 = 10 ; a의 모든 비트를 왼쪽으로 i만큼 밀고, 맨 오른쪽을 0으로 채움

```
- 풀이
```
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        for (int i = 0 ; i < 32 ; i++) {
            cnt += (xor >> i) & 1;
        }
        
        return cnt;
    }
}
```