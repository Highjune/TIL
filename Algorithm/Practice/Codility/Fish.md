Fish

> [문제링크](https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/)


## 타인 풀이, 100%
http://reddeco.tistory.com/entry/Fish
- stack을 쓰는 것까지는 알았는데 실제로 문제를 구현하는 것은 어려웠다.
- 풀이를 보고 한참이나 봐서야 해결이 되었다.
- pop()과 peek() 의 차이를 몰랏다.
- 내려가는 생선들을 down stack에 담고 while문으로 down stack이 비워질 때까지 비교한다. down stack에서 pop()은 올라오는 생선에 잡혀먹히는 것임
- 생선은 올라가는데 Stack이 비어있을때만 올라가는 생선 숫자를 ++하여 살아서 올라가는 생선 수와 Stack(살아서내려가는 생선들)의 사이즈를 합하여 반환한다.

```
import java.util.*;
 
class Solution {
    public int solution(int[] A, int[] B) {
        // A : fish size
        // B : direction (0-up, 1-down)
         
        int count = 0;
        Stack<integer> down = new Stack<integer>();
         
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) { // up
                if (down.empty()) {
                    count++;
                } else {
                    while (!down.empty()) {
                        if (down.peek() > A[i]) {
                            break;
                        } else {
                            down.pop();
                        }
                    }
                    if (down.empty()) {
                        count++;
                    }
                }
            } else { // down
                down.push(A[i]);
            }
        }
         
        return count + down.size();
    }
}
```