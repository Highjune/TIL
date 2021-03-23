TapeEquilibrium

> [문제링크](https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/)


## 내 풀이.
- 풀다가 중단
- 원래 알면 다 쉬운 것임. `Integer.MAX_VALUE` 란 것도 처음 알았고 몰랐어도 충분히 풀었어야 하는 문제

```
import java.util.*;

public class Solution {
    public int solution(int[] arr) {
    	int result = -1;
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for (int i = 1 ; i < arr.length ; i++) {
    		int sum1 = 0;
    		int sum2 = 0;
    		for (int j = 0 ; j < i ; j++) {
    			sum1 = arr[i];
    		}
    		
    		for (int k = i ; k < arr.length ; k++) {
    			sum2 = arr[k];
    		}
    		
    		list.add(Math.abs(sum1-sum2));
    	}
    	
    	result = Collections.min(list);
    	
    	return result;
    }
}
```

## 타인 풀이 100%
```
class Solution {
    public int solution(int[] A) {
        
        int left = 0;
        int right = 0;
        
        for(int i=0; i<A.length; i++) {
            right += A[i];
        }
        
        int gap = Integer.MAX_VALUE;
        
        for(int i=0; i<A.length-1; i++) {
            left += A[i];
            right -= A[i];
            
            gap = Math.min(gap, Math.abs(left-right));
        }
        
        return gap;   
    }
}
```

