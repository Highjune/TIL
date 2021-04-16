MaxSliceSum

> [문제링크](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/)


## 타인 풀이, 100%
- https://myung6024.tistory.com/57
- 카데인 알고리즘
    - https://sustainable-dev.tistory.com/23?category=809125
```
public int solution(int[] A) {
		if (A.length == 0) {
			return A[0];
		}
		
		int localMax = A[0];
		int globalMax = A[0];
		
		for (int i = 1 ; i < A.length ; i++) {
			localMax = Math.max(A[i],  localMax + A[i]);
			if (localMax > globalMax) {
				globalMax = localMax;
			}
		}
	
		return globalMax;
	}
```