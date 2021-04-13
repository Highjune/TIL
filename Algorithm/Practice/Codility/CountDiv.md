CountDiv

> [문제링크](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)


## 내 풀이. O(B-A), 50%
```
class Solution {
    public int solution(int A, int B, int K) {
        int num = 0;
		for (int i = A ; i <= B ; i++) {
			if (i % K == 0) {
				num++;
			}
		}		
		return num;
    }
}
```


## 다른 사람 풀이 100%
http://mingmi-programming.tistory.com/62
```
class Solution {
    public int solution(int A, int B, int K) {
                
        if (A == 0)
            return B / K + 1;
        else
            return B / K - (A - 1) / K;
    }
}
```