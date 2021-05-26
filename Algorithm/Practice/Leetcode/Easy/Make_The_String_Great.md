# Make The String Great
- [문제](https://leetcode.com/problems/make-the-string-great/)


# 내 풀이
- 시간복잡도 O(N)

```
import java.util.Stack;

class Solution {
  
    public String makeGood(String s) {
        String result = "";

        char[] charArr = s.toCharArray(); 
        Stack<Character> stack = new Stack<>();
        stack.push(charArr[0]);

        for (int i = 1; i < charArr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(charArr[i]);
                continue;
            }
            if (stack.peek() == (char)(charArr[i] + 32) || stack.peek() == (char)(charArr[i] - 32)) {
                stack.pop();
            } else {
                stack.push(charArr[i]);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        StringBuffer sb = new StringBuffer(result);
        String reversedStr = sb.reverse().toString();

        return reversedStr;
    }
}
```

# 타인 풀이
- https://leetcode.com/problems/make-the-string-great/discuss/781009/Java-Simple-Solution-using-Stack-Explained
```
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        char res[] = new char[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return new String(res);
    }

```

