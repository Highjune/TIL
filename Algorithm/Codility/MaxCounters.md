MaxCounters

> [문제링크](https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/)


## 내 풀이, O(N*M)
- 아쉬운 코드

```
import java.util.*;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
		
		int[] arr = new int[5];
		Set<Integer> set = new HashSet<Integer>();
//		Collections.max(set);
		
		for (int i = 0 ; i < A.length ; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				arr[A[i]-1]++;
				set.add(arr[A[i]-1]);
            } else if (A[i] == N+1) { // A[3] == 6			
				for (int j = 0 ; j < arr.length ; j++) {
					arr[j] = Collections.max(set);
				}
			}
		}
		
		return arr; 
    }
}
```

## 타인 풀이. 100% 아님. 나랑 비슷한 코드. O(N*M)
```
class Solution {
    public int[] solution(int N, int[] A) {

        // N+1일때의 연산
            // 최대값으로 counters 통일
        // 1~N일때의 연산
            // 해당 위치의 값 +1
        
        //A의 길이는 연산 횟수
        //N이 반환되는 배열 길이
        
        int[] result = new int[N];
        int max = 0;
        
        for(int i=0; i<A.length; i++) {
            
            if(A[i] <= N) {
                result[A[i]-1]++;
                if(result[A[i]-1] > max) {
                    max = result[A[i]-1];
                }
            }
                 
            if(A[i] == N+1) {
                for(int j=0; j<N; j++) {
                    result[j] = max;
                }
            }      
        }
        return result;    
    }
}
```

## 타인 풀이. 100%
https://stroot.tistory.com/93
```
class Solution {
    public int[] solution(int N, int[] A) {
        
        int[] counter = new int[N];
        int tmpMaxCounter = 0;
        int doneMaxCounter = 0;
     
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                doneMaxCounter = tmpMaxCounter;
            } else {
                if (counter[A[i] - 1] < doneMaxCounter) {
                    counter[A[i] - 1] = doneMaxCounter;
                }
     
                counter[A[i] - 1]++;
     
                if (counter[A[i] - 1] > tmpMaxCounter) {
                    tmpMaxCounter = counter[A[i] - 1];
                }
            }
        }
     
        if (doneMaxCounter > 0) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] < doneMaxCounter) {
                    counter[i] = doneMaxCounter;
                }
            }
        }
     
        return counter;
    }
}
```