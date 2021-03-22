TapeEquilibrium

> [문제링크](https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/)


## 내 풀이.
- 풀다가 중단
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
