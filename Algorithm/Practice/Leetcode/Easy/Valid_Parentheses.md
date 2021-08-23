# Valid Parentheses
- [문제](https://leetcode.com/problems/valid-parentheses/)


# 내 풀이1
- 아래 풀이는 런타임 에러
```
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char top = stack.peek();
                if (s.charAt(i) == ')') {
                    if (top != '(') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
                } else if (s.charAt(i) == '}') {
                    if (top != '{') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
                } else if (s.charAt(i) == ']') {
                    if (top != '[') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
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

# 내 풀이2
- while 문으로 다시 풀어봄


# 타인 풀이