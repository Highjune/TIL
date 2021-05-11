# Class와 관련된 개념들

- 원래는 하나의 .java파일 안에 1개의 .class만 있어야 한다.
- 만약 하나의 .java파일 안에 여러 클래스가 있다면 그 중에서 public class는 반드시 있어야 하며, 그 안에 메인 메서드가 있어야 한다. public class는 다 소문자
- 만약 단순하게

```
//A.java 파일

class A {}

class B {}

class C {}

```

위와 같이 있다면 (이클립스) Run as - java Application 이라고 뜨지 않고 Run as - Run Configurations 라고 뜬다.

- 아래도 마찬가지. Run as - Run Configurations 에서 Main클래스를 class B로 설정해서 실행하면 가능.

```
//A class

class A {}

class B {
	public static void main(String[] args) {
	}
}

class C {}
```

- 아래와 같을 경우에는 컴파일 에러가 난다. (파일 이름과 일치하지 않는 클래스 선어넹 public 접근 제한자를 붙이면 컴파일 에러가 발생)

  - public class의 이름과 .java파일 이름과 동일해야 한다.
  - 만약 하나의 A.java 파일 안에 A class와 B class가 있다고 했을 때, B 안에 메인메서드가 있으면 안 된다.

  ```
  //A class
  class A {}

  public class B {
      public static void main(String[] args) {

      }
  }

  class C {}

  ```

- 2개 이상의 클래스가 선언된 소스 파일을 컴파일하면 바이트 코드 파일(.class)은 클래스를 선언한 개수만큼 생긴다. 결국 소스 파일은 클래스 선언을 담고 있는 저장 단위일뿐, 클래스 자체가 아니다. 아래 코드를 컴파일 하면 Car.class와 Tire.class가 각각 생성된다.

```
//Car.java 파일

public class Car {}

class Tire {}
```

- 클래스의 2가지 용도

  1. 라이브러리 용도 : 다른 클래스에서 이용할 목적으로 설계. ex) Student 클래스
  2. 실행용 ex) 메인 클래스

  - 대부분의 객체 지향 프로그램은 라이브러리(부품 객체 및 완성 객체)와 실행 클래스가 분리되어 있다
  - 프로그램 전체에서 사용되는 클래스가 100개라면 99개는 라이브러리 클래스이고, 단 하나가 실행 클래스이다.
  - 물론 Student에 main()메소드를 작성해서 라이브러린동시에 실행 클래스로 만들 수도 있다.

- Class객체를 얻기 위한 3가지 방법
  1. Class clazz = 클래스이름.class
  ```
  Class clazz = String.class;
  ```
  2. Class clazz = Class.forName("패키지...클래스이름")
  ```
  Class clazz1 = Class.forName("java.lang.String")
  Class clazz2 = Class.forName("com.company.June")
  ```
  3. Class clazz = 참조변수.getclass()
  ```
  String str = "June";
  Class clazz = str.getClass();
  ```
