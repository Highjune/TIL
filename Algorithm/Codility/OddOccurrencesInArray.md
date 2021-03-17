OddOccurrencesInArray

> [문제링크](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/)

## (문제를 잘못 이해해서 푼 풀이) 내 풀이 25min 
- 원래 문제는 짝이 없는 것을 반환하는 것
- 나는 (반드시) 홀수가 홀수개 배열에 들어있고 그 중에서 짝이 없는 것을 반환.(아래와 같은 풀이로 가능)

```
class Solution {
    public int solution(int[] A) {
        
        for (int i = 0 ; i <= A.length - 2 ; i++) {
            for (int j = i+1 ; j <= A.length - 1 ; j++) {
                if (A[i] == A[j]) {
                    A[i] = A[i] + 1;
                    A[j] = A[j] + 1;
                    break;
                }
            }
        }
        int lastOdd = -1;
        for (int i = 0 ; i < A.length ; i++) {
            if (A[i] % 2 != 0){
                lastOdd = A[i];
            }
        }

        return lastOdd;
    }
}

```


## (문제 의도대로) 내 풀이
```


```