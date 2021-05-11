# String과 관련된 개념들

- 자바의 문자열은 java.lang 패키지의 String 클래스의 인스턴스로 관리된다. 소스상에서 문자열 리터럴은 String 객체로 자동 생성되지만, String 클래스의 다양한 생성자를 이용해서 직접 String 객체를 생성할 수도 있다.
- 자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록 되어 있다. 그래서 아래에서 strVar2와 strVar3은 동일한 String 객체를 참조한다. 그러나 strVar1은 new 연산자로 생성된 다른 String 객체를 참조한다.

```
String strVar1 = new String("신민철");
String strVar2 = "신민철";
String strVar3 = "신민철";

// strVar1 == strVar2 는 false
// strVar2 == strVar3 는 true

```

- 만약 String객체의 두 문자열만을 비교하고 싶다면 ==연산자 대신에 equals() 메소드를 사용해야 한다.

- String 객체의 문자열은 변경이 불가능한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 원래 문자열의 수정본이 아니라 완전히 새로운 문자열이다.

```
String oldStr = "자바 프로그래밍";
String newStr = oldStr.replace("자바", "JAVA");
```
