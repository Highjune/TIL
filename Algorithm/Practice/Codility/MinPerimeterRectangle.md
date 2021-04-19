MinPerimeterRectangle

> [문제링크](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/)


## 타인 풀이, 100%, O(sqrt(N))
https://myung6024.tistory.com/72
- 5 x 6 = 30 은 5 x (30/5) = 30 으로 표현가능
- https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/ 에서 한 번 더 응용
- 쉬운 문제였음.
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

