MaxProfit

> [문제링크](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/)


## 내 풀이, 66% (타임아웃 에러)
- 단순 for문으로 풀면 안된다는 것을 알았으나 다른 풀이법을 생각해내지 못했다.
- 알고나면 너무 쉬운 문제
```

public class Solution {
	public int solution(int[] A) {
		int max = 0;
		
		for (int i = 0 ; i < A.length - 1 ; i++) {
			for (int j = i + 1 ; j < A.length ; j++) {
				int result = A[i] - A[j];
				if (A[j] - A[i] > max) {
					max = A[j] - A[i];
				}
			}
		}
		
		return max;
	}
}
``` 

## 타인 풀이1, 100%
https://myung6024.tistory.com/52
```
 class Solution {
	public int solution(int[] A) {
		if (A.length < 2) {
			return 0;
		}
		
		int max = A[1];
		int min = A[0];
		int profit = max - min;
		
		for (int i = 0 ; i < A.length ; i++) {
			if (A[i] < min) {
				min = A[i];
			} else {
				profit = Math.max(profit, A[i] - min);
			}
		}
		
		return profit;
	}
}
```

## 타인 풀이2, 100%
https://myung6024.tistory.com/52
```
class Solution {
	public int solution(int[] A) {
		int min = (A.length > 0) ? A[0] : 0;
		int result = 0;
		for(int num : A) {
			if(num <= min) {
				min = num;
			}
			if(result < num - min) {
				result = num - min;
			}
		}
		return result;
	}
}
```