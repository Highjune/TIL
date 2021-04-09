Dominator

> [문제링크](https://app.codility.com/programmers/lessons/8-leader/dominator/)


## 내 풀이, 50% 다시 풀어보기
```
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
    	Arrays.sort(A);
    	
    	int dominator = A[A.length/2 + 1];
    	int domi_occur = 0;
    	
    	for (int i = 0 ; i < A.length ; i++) {
    		if (A[i] == dominator) {
    			domi_occur++;
    		}
    	}
    	
    	for (int j = 0 ; j < A.length ; j++) {
    		if (domi_occur >= A.length/2 + 1) {
    			if (A[j] == dominator) {
    				return j;
    			}
    		} else {
    			return -1;
    		}
    	}
    	
    	return -1;
    }
}
```