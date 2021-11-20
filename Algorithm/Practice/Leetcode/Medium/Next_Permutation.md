# Next_Permutation.md
- 타인 풀이(승지니어)도 외워서 풀었다고 함
- 순열이 주어졌을 때 다음 순열 반환하기

- [문제](https://leetcode.com/problems/next-permutation/description/)
- 풀이
    1. 2021.11.18 (실패)


# 내 풀이



# 타인 풀이
- https://www.youtube.com/watch?v=mbOl9qPedDo&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=25
- 순서
    1. 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인(a)
    2. 다시 뒤에서부터 탐색하면서 a보다 큰 첫번째 인덱스를 확인(b)
    3. a와 b 를 교체
    4. a+1 에서부터 끝까지를 오름차순 정렬
- 예시
```
1 3(a) 5 4 4(b)
-> a와 b를 swap
1 4 5 4 3 
-> a+1의 위치부터 끝까지를 오름차순 정렬
1 4 3 4 5 
```
- 풀이
```

```