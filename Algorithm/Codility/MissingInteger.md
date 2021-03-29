MissingInteger

> [문제링크](https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)


## 내 풀이. 15분. 77%

```
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
		int result = -1;
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 1 ; i <= 100000 ; i++) {
			set.add(i);
		}
		
		for (int i = 0 ; i < A.length ; i++) {
			set.remove(A[i]);
		}
		
		result = Collections.min(set);		
		return result;
    }
}
```
