# Network
- https://programmers.co.kr/learn/courses/30/lessons/43162

# 문제
- 컴퓨터들이 연결되어있는 것들을 하나의 덩어리로 봤을 때, 즉 하나의 이어져있는 대륙(섬) 으로 봤을 때 그것의 덩어리들(하나의 군)이 총 몇개인가?

## 내 풀이
- 실패

## 타인 풀이
```
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            if (!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;              
    }
    
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for (int i = 0 ; i < computers.length; i++) {
            if (computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }   
        }
    }
}
```

