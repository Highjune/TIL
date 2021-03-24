FrogRiverOne

> [문제링크](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)


## 내 풀이 100%, O(N)
```
class Solution {
    public int solution(int X, int[] arr) {
    	int result = -1;
    	
    	Set<Integer> set = new HashSet<Integer>();
    	for (int i = 1 ; i <= X ; i++) { // 1, 2, 3, 4, 5
    		set.add(i);
    	}
    	
    	for(int i = 0 ; i < arr.length ; i++) {
    		set.remove(arr[i]);
    		if(set.isEmpty()) {
    			result = i;
    			break;
    		}
    	}
    	
    	return result;
    }
}
```

## 타인 풀이 1. 100%
- 같은 Set을 사용하긴 했지만 좀 더 간단함
- Set.add의 리턴 데이터 타입이 `boolean`인 줄 처음 알았음

```
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int X, int[] A) {
    
      Set<Integer> values = new HashSet<Integer>();
      
      for (int i = 0; i < A.length; i++) {
          if (values.add(A[i])) X--; 
          if (X == 0) return i;
      }
      return -1;
    }
}
```


## 타인 풀이 2. 
- 내가 처음에 배열로 풀려고 했던 방식
```
class Solution {
    public int solution(int X, int[] A) {
        
        int[] B = new int[X+1];
        int count = 0;
        
        for(int i=0; i<A.length; i++) {
            if(B[A[i]] == 0) {
                B[A[i]] = A[i];
                count++;
                
                if(count == X)
                    return i;
            }
        }
        
        return -1;
    }
}
```

