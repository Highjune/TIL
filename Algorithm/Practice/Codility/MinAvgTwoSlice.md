MinAvgTwoSlice

> [문제링크](https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/)

## 내 풀이
- 못 풀었음


## 타인 풀이
https://cheolhojung.github.io/posts/algorithm/Codility-MinAvgTwoSlice.html
https://nukeguys.tistory.com/175
- 평균의 성질을 잘 알고 있으면 해결할 수 있는 문제
    - a <= b일 때, a와 b의 평균은 a 이상이 된다. (a = b 일 때, a와 b의 평균은 a, 즉 두 수가 같은 경우는 a 혹은 b가 된다)
    - 마찬가지로, (a + b) <= (c + d)일 때, (a, b)와 (c, d)의 평균은 (a + b) 이상이 된다.
    - 결국, 원소가 4개(a, b, c, d)인 그룹은 (a, b)와 (c, d)를 나누었을 때, 각각의 평균의 작은 값 이상이 된다. 2개인 그룹이 작은 값이 되므로 4개의 그룹은 고려할 필요가 없어진다.
    - 예외로 원소가 3개인 그룹에서 2개인 그룹과 1개인 그룹의 경우를 확인해야 하지만, 문제에서 주어진 조건에 의하면 그룹의 원소는 최소 2개 이상이므로 2개와 3개인 그룹만 비교한다.
- 첫 2개 요소의 평균을 최소평균으로 정한 뒤, 이후 발생할 수 있는 모든 그룹(원소가 2개 혹은 3개인)에서 최소평균값을 구하여 P에 해당하는 인덱스를 반한한다.
```
public int solution(int[] A) {
    double minAvg = (A[0] + A[1]) / 2.0;
    int minStartIndex = 0;
 
    for (int i = 2; i < A.length; i++) {
        double avg = (A[i - 2] + A[i - 1] + A[i]) / 3.0;
 
        if (avg < minAvg) {
            minAvg = avg;
            minStartIndex = i - 2;
        }
 
        avg = (A[i - 1] + A[i]) / 2.0;
 
        if (avg < minAvg) {
            minAvg = avg;
            minStartIndex = i - 1;
        }
    }
 
    return minStartIndex;
}
```