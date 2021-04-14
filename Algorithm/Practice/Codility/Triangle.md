Triangle

> [문제링크](https://app.codility.com/programmers/lessons/6-sorting/triangle/)


## 타인 풀이 100%
https://wildcatsy.blogspot.com/2017/05/codility-lesson-6-sorting-triangle-100.html
- 정렬을 하면 삼각형이 되는 조건 3가지 중 2가지(2, 3번)는 자동으로 참이 된다. 즉 1번만 확인하면 된다.
    1. 5 + 8 < 10 
    2. 5 < 8 + 10
    3. 8 < 5 + 8
- 인접한 값들만 비교하는 이유는 중간 값(8) 기준으로 다른 값들(5, 10)이 양쪽으로 멀어지면 멀어질수록 삼각형이 되는 조건에서 더 위배될 가능성이 높다. (삼각형을 그려서 확인해보면 된다. 5길이의 변이 짧아질수록 10길이의 변 역시 짧아질 수밖에 없음). 그래서 8을 기준으로 가장 가까이 있는 두 수만 확인하면 된다. 만약 5, 8, 10 의 조합이 안되면 5보다 작은 수와, 10보다 큰 수의 조합은 당연히 안되는 것임
- (long)처리는 두 개의 합을 진행할 때 오버플로어가 발생할 수도 있으므로.
    - Integer.MAX_VALUE = 2147483647 
```
import java.util.Arrays;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
                
        for( int i = 0 ; i < A.length-2 ; i++){
            if(A[i] < 0 ) continue;
            if((long)A[i] + A[i+1] > A[i+2]) return 1;
        }
        return 0;
    }
}
```