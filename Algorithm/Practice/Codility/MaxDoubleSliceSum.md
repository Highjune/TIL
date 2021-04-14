MaxDoubleSliceSum

> [문제링크](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/)


## 타인 풀이, 100%
- https://github.com/Mickey0521/Codility/blob/master/MaxDoubleSliceSum.java
- https://sustainable-dev.tistory.com/25
- 이해하는데 시간이 좀 걸렸다. 
- 배열을 생성했을 때 해당하는 데이터 타입으로 자동 초기화(interger일 경우 0) 되는 것 깜빡.
- Math.max(0, value) 에서 0과 비교해주는 이유는, X,Y가 인접한 경우와 Y,Z가 인접한 경우 값이 0이므로 값으로 넣을 수 있는 가장 작은 값이기 때문. 따라서 0과 이전 인덱스 까지의 최대 부분합 + 현재 인덱스 값과 비교해서 더 큰 값을 넣어줌.

```
class Solution {
    public int solution(int[] A) {

        // (X, Y, Z)
        // 1st slice: A[X+1] + ... + A[Y-1] 
        // 2nd slice: A[Y+1] + ... + A[Z-1]
        // Key Point:
        // The array will be split at "Y" 
        
        // main idea:
        // if the middle point is "Y",
        // find "maxLeft" and "maxRight"
        
        int maxLeft[] = new int[A.length];
        int maxRight[] = new int[A.length];
        
        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i 
        // note: because it is "contiguous", we only need the ending index (important)
        for(int i=1; i< A.length ;i++){   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = Math.max(0, maxLeft[i-1]+A[i] ); //golden slice algorithm: Math.max(0, maxLeft[i-1]+A[i] )
        } 
        
        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i 
        // note: because it is "contiguous", we only need the starting index (important)
        for(int i=A.length-2; i >=0; i--){   // be careful: from i=A.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(0, maxRight[i+1]+A[i] ); //golden slice algorithm: Math.max(0, maxRight[i+1]+A[i] )
        } 
        
        // 3) find the maximum of "maxLeft + maxRight"
        int maxDoubleSlice =0;
        for(int i=1; i < A.length-1; i++){ // where "i" means "Y" in this problem
            if(maxLeft[i-1] + maxRight[i+1] > maxDoubleSlice)   // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice = maxLeft[i-1] + maxRight[i+1];  // be careful: "not" maxLeft[i] + maxRight[i]
        } 
        
        return maxDoubleSlice;
    }
}
```