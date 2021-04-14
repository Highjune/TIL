PermMissingElem

> [문제링크](https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/)


## 내 풀이 15min, 50%
- 정렬까지 해 놓고 굳이 -(마이너스) 연산을 해버린 멍청함
```
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        int result = -1;
        for (int i = 0 ; i < A.length ; i++) {
            if (A[i+1] - A[i] != 1) {
                return i+2;
            }
        }
        return result;
    }
}
```

## 타인 풀이 100%
```
import java.util.*;

class Solution {
    public int solution(int[] A) {

    Arrays.sort(A);
    
    for(int i=0; i<A.length; i++) {
        if(A[i] != i+1) {
            return i+1;
        }
    }
    
    return A.length+1;

    }
}
```