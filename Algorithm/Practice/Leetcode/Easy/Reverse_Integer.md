# Reverse_Integer
- [문제](https://leetcode.com/problems/reverse-integer/)


# 내 풀이
- 틀렸다.
- int의 범위가 넘어가서 오버플러우 되서 이상한 값(A)이 나오는데, 그 값(A)가 마지막의 if문을 통과하게 되는 범위 내의 값이라면 이상한 값이 도출된다.
    - ex) 1534236469 -> 9646324351 의 값은 int범위를 넘어서 0이 나와야 하는데 오버플로우 되서 1056389759 나오게 된다.
- 그리고 양수, 음수 나눌 필요 없었다. 몫 구하기(/) 는 똑같음. 
```
public class Solution {
    public int reverse(int x) {
        int result = 0;

        if (x >= 0) {
            int num = 0;
            while (x != 0) {
                num = num * 10 + x % 10;
                x /= 10;
            }
            result = num;

        } else {
            String str = String.valueOf(x);
            int num = Integer.parseInt(str.substring(1));
            int reverse_num = 0;
            while (num != 0) {
                reverse_num = reverse_num * 10 + num % 10;
                num /= 10;
            }

            result -= reverse_num;

        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return result;

    }
}
```
# 타인풀이
- 이 부분이 핵심
    - 오버플로우가 발생했는지 안했는지 검증하는 부분
```
if ((newResult - tail) / 10 != result) {
        return 0;
}
```
```
public class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }

            result = newResult;
            x /= 10;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123)); // 321
    }
}

```