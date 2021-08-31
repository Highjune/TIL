# 중첩 괄호
- 프로그래밍 면접 이렇게 준비한다 p74
- 왼쪽과 오른쪽 괄호 문자가 포함된 문자열이 주어졌다. 괄호가 제대로 중첩되어 있는지 판단하는 코드를 작성하라. 예를 들어 (())와 ()() 에서는 괄호가 제대로 중첩돼 있지만 (()()니 )( 에서는 그렇지 않다.
- 여기서는 () 괄호만 해당하는 것이라서 내 풀이나 타인 풀이처럼 꼭 풀지 않아도 된다.


# 내 풀이
- Stack 으로 풀기
- 매번 풀때마다 이런식으로 코드가 길어진다.
```
class Solution {

    public boolean isBalancingParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            Character curr = parentheses.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
                continue;
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character top = stack.peek();

                if (curr == ')') {
                    if (top == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (curr == '}') {
                    if (top == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (curr == ']') {
                    if (top == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
```
# 타인 풀이
- 아래 풀이 보고 다시 풀어봄. 처음엔 기억 안 났음. 
- LeetCode에서 예전에 봤던 것
- https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
- 위 링크에서 처음에 아래 조건 추가했다.
```
 if(s.length() % 2 == 1)
        return false;
```
```
 public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        if(s.length() % 2 == 1)
                return false;

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{'){
                stack.push('}');
            } else if (c == '['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
```

# 책 풀이
- ( 가 나오면 +1, )가 나오면 -1. 그래서 0이 되면 끝.
- 그리고 최종 코드에서도 아래 코드가 들어가면 좋을 것 같다.
```
if(s.length() % 2 == 1)
        return false;
```
```
class Solution {
    public static boolean checkNesting(String s) {
        int count = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
```
