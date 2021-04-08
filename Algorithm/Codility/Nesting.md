Nesting

> [문제링크](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)


## 내 풀이
```
public class Solution {
	public int solution(String S) {
        // write your code in Java SE 8
		// (()(())())
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0 ; i < S.length() ; i++) {
			char c = S.charAt(i);
			
			if (c == '(') {
				stack.push(c);
			} 
			
			char lastElement = stack.peek();
			
			
			
			
		}
		
		
		
		return -10;
    }
}
```