Nesting

> [문제링크](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)


## 내 풀이, 100%
```
public class Solution {
	public int solution(String S) {

		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0 ; i < S.length() ; i++) {
			char c = S.charAt(i);
			if (c == '(') {
				stack.push(c);
				continue;
			} 
			
			if (c == ')' && stack.isEmpty()) {
				return 0;
			} 
				
			char lastElement = stack.peek();		

			if (lastElement != '(') {
				return 0;
			} else {
				stack.pop();
			}
		}
		
		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
    }
}

```

## 타인 풀이, 100%
- 경우의 수 정리한 것이 좀 더 깔끔
```
import java.util.*;

class Solution {
    public int solution(String S) {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(') {
                stk.push(c);
            }
            else if(stk.isEmpty()) {
                return 0;
            }
            else {
                stk.pop();
            }
        }
        
        if(stk.isEmpty()) {
            return 1;
        }
        else
            return 0;
    }
}
```