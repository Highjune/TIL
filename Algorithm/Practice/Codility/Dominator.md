Dominator

> [문제링크](https://app.codility.com/programmers/lessons/8-leader/dominator/)


## 내 풀이, 50% 
- 기초지만, 반복문과 제어문 속에서 적절한 return문의 위치에 대해서 다시 정리할 수 있었다.
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
## 내 풀이2, 75%(정확도가 62%라서)
- array의 범위가 작거나 아주 큰 경우에 대해서 고려하지 못한 것 같다.
- `half more than` 의 의미는, 8개 중 4개는 포함 안된다는 말.
    - 배열의 길이가 홀수 또는 짝수에 집착할 필요 없었다. 그래서 아래와 같이 표현 가능
    ```
    if(dominator_num <= A.length / 2) {
        return -1;
    }
    ```

```
import java.util.Arrays;

class Solution {

    public int solution(int[] A) {
    	int result = -1;
    	
    	int[] B = new int[A.length];
    	
    	// 미리 배열 복사
    	for (int k = 0 ; k < A.length ; k++) {
    		B[k] = A[k];
    	}
    	
    	Arrays.sort(A);
    	
    	int dominator = A[A.length/2 + 1];
        
    	int domi_occur = 0;
    	
    	for (int i = 0 ; i < A.length ; i++) {
    		if (A[i] == dominator) {
    			domi_occur++;
    		}
    	}
    	
    	if (domi_occur >= B.length/2 + 1) {
    		for (int j = 0 ; j < B.length ; j++) {
    			if (B[j] == dominator) {
    				result = j;
    				break;
    			}
    		}
    	} else {
    		result = -1;
    	}
    	
    	return result;
    }
}
```

## 내 풀이3, 83%(정확도가 75%라서)
- dominator 결정시 stack 활용
    - stack이 비어있으면 push
    - stack에 들어있는 값이 지금 값이랑 같으면 push
    - stack에 들어있는 값이 지금 값이랑 다르면 pop & 지금 값 삭제
```
class Solution {

    public int solution(int[] A) {
            int result = -1;
            
            int dominator = 0;
            
            Stack<Integer> stack = new Stack<Integer>();
            
            for (int i = 0 ; i < A.length ; i++) {
                if (stack.isEmpty()) {
                    stack.push(A[i]);
                } else if (stack.peek() != A[i]) {
                    stack.pop();
                } else if (stack.peek() == A[i]) {
                    stack.push(A[i]);
                }
            }
                
            if (stack.isEmpty()) {
                return -1;
            } else {
                dominator = stack.peek();
            }
            
            for (int i = 0 ; i < A.length ; i++) {
                if (A[i] == dominator) {
                    result = i;
                    break;
                }
            }
            
            return result;
        }
}
```

## 타인 풀이, 100%
https://rooted.tistory.com/47
- 깔끔쓰
- map.getOrDefault(값, 없으면 default) 유용한 함수를 알게 됨
```
import java.util.*;

class Solution {
    public int solution(int[] A) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        
        int max = 0;
        int maxKey = 0;
        for(Integer key : map.keySet()) {
            int count = map.get(key);
            if(count > max) {
                max = count;
                maxKey = key;
            }
        }
        
        if(max <= A.length / 2)
            return -1;
        
        for(int i=0; i<A.length; i++) {
            if(A[i] == maxKey)
                return i;
        }
        
        return -1;
    }
}
```