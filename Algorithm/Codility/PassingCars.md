PassingCars

> [문제링크](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)


## 내 풀이.
https://mingmi-programming.tistory.com/63
- 처음에 문제 이해를 잘 못해서 풀이를 보고 다시 풀어봄 
```
class Solution {
    public int solution(int[] A) {
		int result = 0;
        int sum = 0 ;
        
        for (int i = 0 ; i < A.length ; i++) {
        	if (A[i] == 0) {
        		sum++; 
        	} else {
        		result += sum;
        	}
        }
        
        if (result > 100000 || result < -1) {
        	result = -1;
        }
        
        return result;
    }
}
```
