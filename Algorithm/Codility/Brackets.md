Brackets

> [문제링크](https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)


## 내 풀이, 37%
- 원리는 일찍 알았는데 stack.pop()의 성질을 잘 몰라서 많이 헤맸다.
- if문 안에서 stack.pop()해서 특정 값과 비교하는 순간, 이미 마지막 값은 나왔기(pop) 때문에 다시 pop()할 필요 없다. pop()하면 그 다음 것이 튀어나옴(이미 기존 것 나왔으므로)
- 문제의 조건에서 빈 문자열 입력시에서 정상이라고 리턴했어야 했는데 그 처리를 못했음.(아래 처리를 못했음)
```
if (stack.isEmpty()) {
                return 0;
            }

```

- 내 코드
```
public int solution(String S) { 
		// {[()()]}
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0 ; i < S.length() ; i++) {
			
			if (S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {
				stack.push(S.charAt(i)); // {[(
				
			} else { // }, ], ) 인 경우
				char topElement = stack.pop();
				
				if (S.charAt(i) == '}' && topElement != '{') {
					return 0;
				}
					
				if (S.charAt(i) == ']' && topElement != '[') {
					return 0;
				}
					
				if (S.charAt(i) == ')' && topElement != '(') {
					return 0;
				}
			}
		}
		
		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
		
	}
```

## 타인 풀이, 100%
https://stroot.tistory.com/104
```
public int solution(String S) {
    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        }
        else {
            if (stack.isEmpty()) {
                return 0;
            }
            
            char lastC = stack.pop();
            
            if (c == ')' && lastC != '(') {
                return 0;
            }
            
            if (c == '}' && lastC != '{') {
                return 0;
            }
            
            if (c == ']' && lastC != '[') {
                return 0;
            }
        }
    }
    
    if (!stack.isEmpty()) {
        return 0;
    }
    
    return 1;
}
```