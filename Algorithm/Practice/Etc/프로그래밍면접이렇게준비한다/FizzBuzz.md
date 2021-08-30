# FizzBuzz
- 프로그래밍 면접 이렇게 준비한다 p70
- 1에서 100까지 숫자를 출력하는 프로그램을 만들어라. 숫자가 3으로 나누어 떨어지면 그 숫자 대신 Fizz를, 5로 나누어 떨어지면 그 숫자 대신 Buzz를, 3과 5 모두로 나누어 떨어지면 그 숫자 대신 FizzBuzz를 출력한다.

## 내 풀이
```
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        for (int i = 1 ; i <= 100 ; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}

```

## 책 풀이
- 아래처럼 선언한 것 참신
```
boolean divByThree = (i % 3 == 0);
boolean divByFive = (i % 5 == 0);
```
```
import java.util.Stack;

class Solution {

    public static void main(String[] args) {

        for (int i = 1 ; i <= 100 ; i++) {
            boolean divByThree = (i % 3 == 0);
            boolean divByFive = (i % 5 == 0);

            if (divByThree && divByFive) {
                System.out.println("FizzBuzz");
            } else if (divByThree) {
                System.out.println("Fizz");
            } else if (divByFive) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}

```