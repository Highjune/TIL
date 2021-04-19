CountFactors

> [문제링크](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/)


## 내 풀이, 92%, O(sqrt(N)), TIMEOUT ERROR
- https://codility.com/media/train/8-PrimeNumbers.pdf 읽었어서 이해가 됨
- 36의 약수를 구한다고 가정했을 때, 제곱근36(=6) 까지만 약수를 구해도 된다. 단 제곱근36(=6)보다 작은 수들(1, 2, 3, 4, 5) 에서 36의 약수가 나오면 약수의 갯수는 X2를 해주면 된다.
    - A X B = 36 이라면 A나 B 중 적어도 1개는 제곱근36(=6)보다 작거나 같다. 
        ex) 6x6(해당), 18x2(2이 해당), 12x3(3이 해당)
    - 그래서 1x36 이라면 1만 해당하는지 보고 36은 따로 구하지 않고 +1만 더 해주면 된다.(총 2+), 단 6x6은 6을 2번 중복체크 할 필요 없으므로 `i * i < N`
```
class Solution {
    public int solution(int N) {
		int result = 0;

		for (int i = 1 ; i * i <= N ; i++) {
			if (N % i == 0) {
				result++;
				if (i * i < N) {
					result++;
				}
			}
		}		
		return result;
	}
}   
```

## 타인 풀이, 100%
- int -> long
- 주의할 점이 있는데 N의 범위는 int 범위로 [1 ~ 약 21억]까지이므로 i^2를 구하기 위해서는 더 큰 범위를 가지는 long 자료형을 사용해야 한다.
```
class Solution {
    public int solution(int N) {
		int result = 0;

		for (long i = 1 ; i * i <= N ; i++) {
			if (N % i == 0) {
				result++;
				if (i * i < N) {
					result++;
				}
			}
		}		
		return result;
	}
}   
```
