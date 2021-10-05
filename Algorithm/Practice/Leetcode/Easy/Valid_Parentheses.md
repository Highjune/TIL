# Valid Parentheses
- [문제](https://leetcode.com/problems/valid-parentheses/)


# 내 풀이
- 풀었는데 좀 비효율적으로.



# 타인 풀이
- https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
- 위 링크에서 처음에 아래 조건 추가
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