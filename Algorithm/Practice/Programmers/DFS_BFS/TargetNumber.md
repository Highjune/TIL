# TargetNumber
- https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

## 문제
- n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```
- 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
- 제한사항
    - 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
    - 각 숫자는 1 이상 50 이하인 자연수입니다.
    - 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
- 입출력 예
    - numbers
        - [1, 1, 1, 1, 1]
    - target
        - 3
    - return
        - 5


## 내 풀이
- 실패

## 타인 풀이0
- https://programmers.co.kr/learn/courses/30/lessons/43165/solution_groups?language=java
- 제일 깔끔
```
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}

```

## 타인 풀이1
- https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4?category=929770
- BFS, DFS 로 푼 것.
- 원래 의도한 것이 BFS, DFS 인 것
- DFS 풀이
    - 재귀로 모든 경우의 수(더하고, 빼고) 로 다 넣어서 구한다. 만들어진 최종 값이 target 과 동일할 경우 1을 리턴하고 이 값을 누적한 것이 결과 값이다.
```
class Solution {

    public int dfs(int prev, int index, int[] numbers, int target) {

        if (index >= numbers.length) {
            if (target == prev) {
                return 1;
            }
            return 0;
        }

        int cur1 = prev + numbers[index];
        int cur2 = prev - numbers[index];

        int ans = 0;
        ans += dfs(cur1, index+1, numbers, target);
        ans += dfs(cur2, index+1, numbers, target);

        return ans;
    }

    public int solution(int[] numbers, int target) {
        int current = numbers[0];
        int answer = 0;
        answer += dfs(current, 1, numbers, target);
        answer += dfs(-current, 1, numbers, target);
        return answer;
    }
}
```

- BFS 풀이
    - dfs 를 while 문으로 풀어 쓴 것
```
import java.util.Queue;
import java.util.LinkedList;

class Solution {

    class Pair {
        int cur;
        int index;

        Pair(int cur, int index) {
            this.cur = cur;
            this.index = index;
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(numbers[0], 0));
        queue.offer(new Pair(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.index == numbers.length-1) {
                if (p.cur == target) {
                    answer += 1;
                }
                continue;
            }
            int c1 = p.cur + numbers[p.index+1];
            int c2 = p.cur - numbers[p.index+1];

            queue.add(new Pair(c1, p.index+1));
            queue.add(new Pair(c2, p.index+1));
        }

        return answer;
    }
}
```




## 타인 풀이2
- shift(>>) 연산자 이용
- https://programmers.co.kr/questions/14488
- 아직 잘 이해가..
```
class Solution {

    public int sign(int i) {
        return i == 1 ? 1 : -1;
    }

    public int solution(int[] numbers, int target) {
        int max = 1;        
        for(int i = 0 ; i < numbers.length; i++) {
            max*=2;
        }       
        int cur = 0;        
        int count = 0;      
        while(cur < max) {
            int val = 0;
            for(int i = 0 ; i < numbers.length ; i++) {
                int temp = cur;
                val+= sign ((temp >> i) & 1 ) * numbers[i];
            }

            if(val == target) {
                count++;
            }
            cur++;
        }               
        return count;
    }
}
```

