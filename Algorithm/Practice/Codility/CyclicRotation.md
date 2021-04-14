CyclicRotation

> [문제링크](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/)

## 내 풀이. 77min / 87%
```
class Solution {
    public int[] solution(int[] A, int K) {
        int arrayLength = A.length;
        
        for (int i = 1 ; i <= K ; i++) {
            int temp = -1;
            temp = A[arrayLength-1];
            
            for (int j = 1 ; j <= arrayLength-1 ; j++) {
                A[arrayLength-j] = A[arrayLength-j-1];
            }

            A[0] = temp;
        }
        return A;
    }
        
}
```

## 타인 풀이1 100% (나랑 거의 유사)
https://mingmi-programming.tistory.com/53
```
class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;

        for (int i = 0 ; i < K; i++) {
            int temp = A[A.length - 1];

            for (int j = A.length - 1 ; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }        

        return A;
    }
    
}
```

## 타인 풀이2 100%
http://blog.naver.com/PostView.nhn?blogId=netrance&logNo=220690184441
```
class Solution {
    public int[] solution(int[] A, int K) {
        
        int[] B = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
          B[(i+K) % A.length] = A[i];
        }
        
        return B;
    }
}
```