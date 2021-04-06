MaxProductOfThree

> [문제링크](https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/)


## 내 풀이, 100%, O(N * log(N))
- 그냥 수학처럼 풀어서 긴가민가하게 제출했는데 다행이었다.
- 최대값이 되는 경우를 2가지로 단순화함.
- 다른 사람(100%)도 이렇게 풀었음.
https://reddeco.tistory.com/entry/MaxProductOfThree
```
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
		int maxProduct = 0;
		int case1Product = 0;
		int case2Product = 0;
		
		Arrays.sort(A);
		
		case1Product = A[0]*A[1]*A[A.length-1];
		case2Product = A[A.length-1]*A[A.length-2]*A[A.length-3];
		
		maxProduct = Math.max(case1Product, case2Product);
		
		return maxProduct;
    }
}
```
