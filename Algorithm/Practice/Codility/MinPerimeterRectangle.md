MinPerimeterRectangle

> [문제링크](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/)


## 타인 풀이, 100%
- https://myung6024.tistory.com/72
```
class Solution {
    public int solution(int N) {
		int min = Integer.MAX_VALUE;
		int sq = (int)Math.sqrt(N);
		
		for (int i = 1 ; i <= sq ; i++) {
			if (N % i ==0) {
				if (min > ((i + N/i) * 2)) {
					min = (i + N/i) * 2;
				}
			}
		}
		
		return min;
	}
}
```

