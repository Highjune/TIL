PermCheck

> [문제링크](https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)


## 내 풀이, O(N) or O(N * log(N)), 83%
```
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
		int result = 1;
		
		Arrays.sort(A); 
		
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i = 0 ; i < A.length ; i++) {
			list.add(A[i]); 
		}
		
		int arrayMaxNum = Collections.max(list); 
		
		for (int i = 0 ; i < arrayMaxNum ; i++) {
			if ((A[i] == i+1)) {
				continue;
			} else {
				result = 0;
				break;
			}
		}
		
		return result;
    }
}
```
## 타인풀이, O(N) or O(N * log(N)), 100%
http://stroot.tistory.com/90
- 완전한 순열이 안되는 조건 2가지만 체크
```
class Solution {
    public int solution(int[] A) {
        
        Set<Integer> check = new HashSet<>();
        
        for(int i=0; i<A.length; i++) {
            if(A[i] > A.length) {
                return 0;
            }
            
            if(check.contains(A[i])) {
                return 0;
            }
            
            check.add(A[i]);
        }
        return 1;
    }
}
```