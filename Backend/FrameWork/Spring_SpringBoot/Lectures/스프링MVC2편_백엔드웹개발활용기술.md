## 스프링 MVC 2편 - 백엔드웹개발활용기술
- [강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-2/dashboard)
- 프로젝트 코드
	- [타임리프](https://github.com/Highjune/Spring_MVC_Lecture1_Thymeleaf_Basic_Kim_Young_Han-)
	- [타임리프 + 스프링](https://github.com/Highjune/Spring_MVC_Lecture2_Form_Kim_Young_Han-/tree/master)
	- [메시지, 국제화](https://github.com/Highjune/message/tree/master)


# 타임리프 - 기본 기능
## 프로젝트 생성
- Java 11 설치
- 스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성
    - https://start.spring.io
- 프로젝트 선택
    - Project: Gradle Project
    - Language: Java
    - Spring Boot: 2.5.x
- Project Metadata
    - Group: hello
    - Artifact: thymeleaf-basic
    - Name: thyme-leaf-basic
    - Package name: hello.thymeleaf
    - Packaging: Jar
    - Java: 11
- dencies: Spring Web, Lombok , Thymeleaf

- build.gradle
```
plugins {
	id 'org.springframework.boot' version '2.5.5'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}

```
- 동작 확인
    - 기본 메인 클래스 실행( ThymeleafBasicApplication.main() )
    - http://localhost:8080 호출해서 Whitelabel Error Page가 나오면 정상 동작
- 홈 화면
    - /resources/static/index.html
```
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body> <ul>
    <li>텍스트 <ul>
        <li><a href="/basic/text-basic">텍스트 출력 기본</a></li>
        <li><a href="/basic/text-unescaped">텍스트 text, utext</a></li> </ul>
    </li>
    <li>표준 표현식 구문
        <ul>
            <li><a href="/basic/variable">변수 - SpringEL</a></li>
            <li><a href="/basic/basic-objects?paramData=HelloParam">기본 객체들</a></li>
            <li><a href="/basic/date">유틸리티 객체와 날짜</a></li> <li><a href="/basic/link">링크 URL</a></li>
            <li><a href="/basic/literal">리터럴</a></li>
            <li><a href="/basic/operation">연산</a></li>
        </ul>
    </li>
    <li>속성 값 설정
        <ul>
             <li><a href="/basic/attribute">속성 값 설정</a></li>
        </ul>
    </li>
    <li>반복
        <ul>
            <li><a href="/basic/each">반복</a></li>
        </ul>
    </li>
    <li>조건부 평가
        <ul>
            <li><a href="/basic/condition">조건부 평가</a></li>
        </ul>
    </li>
    <li>주석 및 블록
        <ul>
            <li><a href="/basic/comments">주석</a></li>
            <li><a href="/basic/block">블록</a></li>
        </ul>
    </li>
    <li>자바스크립트 인라인
        <ul>
            <li><a href="/basic/javascript">자바스크립트 인라인</a></li>
        </ul>
    </li>
    <li>템플릿 레이아웃
        <ul>
            <li><a href="/template/fragment">템플릿 조각</a></li>
            <li><a href="/template/layout">유연한 레이아웃</a></li>
            <li><a href="/template/layoutExtend">레이아웃 상속</a>
            </li>
        </ul>
    </li>
</ul>
</body>
</html>
```
- 실행
    - http://localhost:8080
- IntelliJ Gradle 대신에 자바 직접 실행
    - 최근 IntelliJ 버전은 Gradle을 통해서 실행 하는 것이 기본 설정이다. 이렇게 하면 실행속도가 느리다. 다음과 같이 변경하면 자바로 바로 실행해서 실행속도가 더 빠르다
    - Preferences Build, Execution, Deployment Build Tools Gradle
        - Build and run using: Gradle IntelliJ IDEA
        - Run tests using: Gradle IntelliJ IDEA
    - 윈도우는 File -> Setting
- 롬복 적용
    1. Preferences -> plugins -> lombok 검색 실행(재시작)
    2. Preferences -> Annotation Processors 검색 -> Enable annotation processing 체크(재시작)
    3. 임의의 테스트 클래스를 만들고 @Getter, @Setter 확인
- Postman을 설치하자
    - 다음 사이트에서 Postman을 다운로드 받고 설치해두자
    - https://www.postman.com/downloads

## 타임리프 소개
- 공식 사이트: https://www.thymeleaf.org/
- 공식 메뉴얼 - 기본 기능: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
- 공식 메뉴얼 - 스프링 통합: https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
- 이전 강의인 스프링 MVC 1편에서 타임리프를 간단히 사용해보고, 그 특징들도 알아보았다.
- 이번 시간에는 타임리프의 개념은 간단히 소개하고, 실제 동작하는 기본 기능 위주로 알아보겠다.

- 타임리프 특징
    1. 서버 사이드 HTML 렌더링 (SSR)
        - 타임리프는 백엔드 서버에서 HTML을 동적으로 렌더링 하는 용도로 사용된다.
    2. 네츄럴 템플릿
        - 타임리프는 순수 HTML을 최대한 유지하는 특징이 있다.
        - 타임리프로 작성한 파일은 HTML을 유지하기 때문에 웹 브라우저에서 파일을 직접 열어도 내용을 확인할 수 있고, 서버를 통해 뷰 템플릿을 거치면 동적으로 변경된 결과를 확인할 수 있다.
        - JSP를 포함한 다른 뷰 템플릿들은 해당 파일을 열면, 예를 들어서 JSP 파일 자체를 그대로 웹 브라우저에서 열어보면 JSP 소스코드와 HTML이 뒤죽박죽 섞여서 웹 브라우저에서 정상적인 HTML 결과를 확인할 수 없다. 오직 서버를 통해서 JSP가 렌더링 되고 HTML 응답 결과를 받아야 화면을 확인할 수 있다.
        - 반면에 타임리프로 작성된 파일은 해당 파일을 그대로 웹 브라우저에서 열어도 정상적인 HTML 결과를 확인할 수 있다. 물론 이 경우 동적으로 결과가 렌더링 되지는 않는다. 하지만 HTML 마크업 결과가 어떻게 되는지 파일만 열어도 바로 확인할 수 있다.
        - 이렇게 순수 HTML을 그대로 유지하면서 뷰 템플릿도 사용할 수 있는 타임리프의 특징을 네츄럴 템플릿 (natural templates)이라 한다.
    3. 스프링 통합 지원
        - 타임리프는 스프링과 자연스럽게 통합되고, 스프링의 다양한 기능을 편리하게 사용할 수 있게 지원한다. 이 부분은 스프링 통합과 폼 장에서 자세히 알아보겠다.

- 타임리프 기본 기능
    - 타임리프를 사용하려면 다음 선언을 하면 된다.
    - `<html xmlns:th="http://www.thymeleaf.org">`
    - 기본 표현식
        - 타임리프는 다음과 같은 기본 표현식들을 제공한다. 지금부터 하나씩 알아보자.
        ```
        • 간단한 표현:
            ◦ 변수 표현식: ${...}
            ◦ 선택 변수 표현식: *{...}
            ◦ 메시지 표현식: #{...}
            ◦ 링크 URL 표현식: @{...}
            ◦ 조각 표현식: ~{...}
        • 리터럴
            ◦ 텍스트: 'one text', 'Another one!',...
            ◦ 숫자: 0, 34, 3.0, 12.3,...
            ◦ 불린: true, false
            ◦ 널: null
            ◦ 리터럴 토큰: one, sometext, main,...
        • 문자 연산:
            ◦ 문자합치기:+
            ◦ 리터럴 대체: |The name is ${name}|
        • 산술 연산:
            ◦ Binary operators: +, -, *, /, %
            ◦ Minus sign (unary operator): -
         • 불린 연산:
            ◦   Binary operators: and, or
        ◦ Boolean negation (unary operator): !, not
        • 비교와 동등:
        ◦ 비교:>,<,>=,<=(gt,lt,ge,le)
        ◦ 동등 연산: ==, != (eq, ne)
        • 조건 연산:
            ◦   If-then: (if) ? (then)
        ◦ If-then-else: (if) ? (then) : (else)
            ◦   Default: (value) ?: (defaultvalue)
        • 특별한 토큰:
            ◦   No-Operation: _
        ```
        - 참고 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard- expression-syntax

## 텍스트 - text, utext
- 타임리프의 가장 기본 기능인 텍스트를 출력하는 기능 먼저 알아보자.
- 타임리프는 기본적으로 HTML 테그의 속성에 기능을 정의해서 동작한다. HTML의 콘텐츠(content)에 데이터를 출력할 때는 다음과 같이 th:text 를 사용하면 된다.
    - `<span th:text="${data}">`
- HTML 테그의 속성이 아니라 HTML 콘텐츠 영역안에서 직접 데이터를 출력하고 싶으면 다음과 같이 [[...]] 를 사용하면 된다.
    - `컨텐츠 안에서 직접 출력하기 = [[${data}]]`
- BasicController
```
@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }
}
```

- /resources/templates/basic/text-basic.html
    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
    <h1>컨텐츠에 데이터 출력하기</h1>
    <ul>
        <li>th:text 사용 <span th:text="${data}"></span></li> 
        <li>컨텐츠 안에서 직접 출력하기 = [[${data}]]</li>
    </ul>
    </body>
    </html>
    ```
    - th:text="${data}" 는 항상 태그가 있어야 함. 여기서는 span

- 실행
    - http://localhost:8080/basic/text-basic

- Escape
    - HTML문서는 <,> 같은특수문자를기반으로정의된다.따라서뷰템플릿으로HTML화면을생성할 때는 출력하는 데이터에 이러한 특수 문자가 있는 것을 주의해서 사용해야 한다. 앞에서 만든 예제의 데이터를 다음과 같이 변경해서 실행해보자.
    - 변경 전
        - `Hello Spring!`
    - 변경 후
        - `Hello <b>Spring!</b>`
    - `<b>` 테그를 사용해서 Spring!이라는 단어가 진하게 나오도록 해보자.
    - 웹 브라우저에서 실행결과를 보자.
        - 웹 브라우저
            - `Hello <b>Spring!</b>`
        - 소스보기
            - `Hello &lt;b&gt;Spring!&lt;/b&gt;`
    - 개발자가 의도한 것은 `<b>` 가 있으면 해당 부분을 강조하는 것이 목적이었다. 그런데 `<b>` 테그가 그대로 나온다.
    - 소스보기를 하면 < 부분이 `&lt;`로 변경된 것을 확인할 수 있다.
    - HTML 엔티티
        - 웹브라우저는 `<` 를 HTML 테그의 시작으로 인식한다.따라서 `<` 를 테그의 시작이 아니라 문자로 표현 할 수 있는 방법이 필요한데, 이것을 `HTML 엔티티`라 한다. 그리고 이렇게 HTML에서 사용하는 특수 문자를 HTML 엔티티로 변경하는 것을 이스케이프(escape)라 한다. 그리고 타임리프가 제공하는 th:text , [[...]] 는 기본적으로 이스케이스(escape)를 제공한다.
        - 타임리프가 `<b>` 태그를 출력할 때 그대로 출력하지 않고 `HTML 엔티티`로 변경해서 출력한다.
        - `<` -> `&lt;`
        - `>` -> `&gt;`
        - 기타 수 많은 HTML 엔티티가 있따.
    - 참고
        - HTML 엔티티와 관련해서 더 자세한 내용은 HTML 엔티티로 검색해보자.

- Unescape
    - 이스케이프 기능을 사용하지 않으려면 어떻게 해야할까? 즉. 우리가 원래 원하는대로 `<b></b>` 태그를 걸어서 글씨를 굵게 하려면?
    - 타임리프는 다음 두 기능을 제공한다.
        - th:text -> th:utext
        - [[...]] -> [(...)]

- BasicController에 추가
```
@GetMapping("/text-unescaped")
public String textUnescaped(Model model) {
    model.addAttribute("data", "Hello <b>Spring!</b>");
    return "basic/text-unescaped";
}
```
- /resources/templates/basic/text-unescape.html
    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="UTF-8">
    <title>Title</title>
    </head>
    <body>

    <h1>text vs utext</h1>

    <ul>
    <li>th:text = <span th:text="${data}"></span></li>
    <li>th:utext = <span th:utext="${data}"></span></li>
    </ul>

    <h1><span th:inline="none">[[...]] vs [(...)]</span></h1>

    <ul>
    <li><span th:inline="none">[[...]] = </span>[[${data}]]</li>
    <li><span th:inline="none">[(...)] = </span>[(${data})]</li>
    </ul>

    </body>
    </html>
    ```
    - `th:inline="none"` 
        - 타임리프는 [[...]] 를 해석하기 때문에, 화면에 [[...]] 글자를 보여줄 수 없다. 이 테그 안에서는 타임리프가 해석하지 말라는 옵션이다.
- 실행
    - http://localhost:8080/basic/text-unescaped
    - 실행해보면 다음과 같이 정상 수행되는 것을 확인할 수 있다.
        - 웹 브라우저: Hello Spring!
        - 소스보기: Hello `<b>Spring!</b>`
- 주의
    - 실제 서비스를 개발하다 보면 escape를 사용하지 않아서 HTML이 정상 렌더링 되지 않는 수 많은 문제가 발생한다. escape를 기본으로 하고, 꼭 필요한 때만 unescape를 사용하자.
    - 예를 들어 사용자가 게시판에 글을 쓸 때 임의로 여러 태그들을 막 사용할 수도 있는데, 그런 경우에 그것들을 그냥 그대로 다 태그로 받아들인다면, HTML이 다 깨진다.

## 변수 - SpringEL
- 타임리프에서 변수를 사용할 때는 변수 표현식을 사용한다.
- Object, Map, List 종류의 데이터를 프런트(타임리프) 쪽으로 넘겼을 시 데이터 사용법
- 변수 표현식 : ${...}
    - 그리고 이 변수 표현식에는 `스프링 EL`이라는 스프링이 제공하는 표현식을 사용할 수 있다.

- BasicController 추가
```
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }
```
- /resources/templates/basic/variable.html
    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="UTF-8">
    <title>Title</title>
    </head>
    <body>
    <h1>SpringEL 표현식</h1>

    <ul>Object
        <li>${user.username} = <span th:text="${user.username}"></span></li>
        <li>${user['username']} = <span th:text="${user['username']}"></span></li>
        <li>${user.getUsername()} = <span th:text="${user.getUsername()}"></span></li>
    </ul>

    <ul>List
        <li>${users[0].username}    = <span th:text="${users[0].username}"></span></li>
        <li>${users[0]['username']} = <span th:text="${users[0]['username']}"></span></li>
        <li>${users[0].getUsername()} = <span th:text="${users[0].getUsername()}"></span></li>
    </ul>

    <ul>Map
        <li>${userMap['userA'].username} =  <span th:text="${userMap['userA'].username}"></span></li>
        <li>${userMap['userA']['username']} = <span th:text="${userMap['userA']['username']}"></span></li>
        <li>${userMap['userA'].getUsername()} = <span th:text="${userMap['userA'].getUsername()}"></span></li>
    </ul>

    </body>
    </html>

    ```
    - SpringEL 다양한 표현식 사용
        - 스프링이 내부에서 객체에 접근하는 문법이 있는데, 타임리프에서 이것을 그대로 가져다가 사용함

    - `Object`
        - user.username : user의 username을 프로퍼티 접근 -> user.getUsername()
        - user['username'] : 위와 같음 -> user.getUsername()
        - user.getUsername() : user의 getUsername() 을 직접 호출
    - `List`
        - users[0].username : List에서 첫 번째 회원을 찾고 username 프로퍼티 접근 -> list.get(0).getUsername()
        - users[0]['username'] : 위와 같음
        - users[0].getUsername() : List에서 첫 번째 회원을 찾고 메서드 직접 호출
    - `Map`
        - userMap['userA'].username : Map에서 userA를 찾고, username 프로퍼티 접근 -> map.get("userA").getUsername()
        - userMap['userA']['username'] : 위와 같음
        - userMap['userA'].getUsername() : Map에서 userA를 찾고 메서드 직접 호출

- 실행
    - http://localhost:8080/basic/variable

- 지역 변수 선언
    - 타임리프 안에서 지역변수 선언
    - `th:with` 를 사용하면 지역 변수를 선언해서 사용할 수 있다. 지역 변수는 선언한 테그 안에서만 사용할 수 있다.
    - /resources/templates/basic/variable.html 추가
    ```
    <h1>지역 변수 - (th:with)</h1>

    <div th:with="first=${users[0]}">
        <p>처음 사람의 이름은 <span th:text="${first.username}"></span></p>
    </div>
    ``` 
    - users 리스트의 0번째 객체를 first 라는 객체에 넣어서 사용


## 기본 객체들
- 타임리프는 기본 객체들을 제공한다.
    - ${#request}
    - ${#response}
    - ${#session}
    - ${#servletContext}
    - ${#locale}
- 그런데 #request 는 HttpServletRequest 객체가 그대로 제공되기 때문에 데이터를 조회하려면 request.getParameter("data") 처럼 불편하게 접근해야 한다.
- 이런 점을 해결하기 위해 편의 객체도 제공한다.
    - HTTP 요청 파라미터 접근: param
        - 예) ${param.paramData}
        - 그러면 쿼리 파라미터 형식. 즉 ~(url)~?paramData=100 처럼 데이터가 들어올 때 간단하게 param.paramData 로서 10의 값을 얻을 수 있다.
    - HTTP 세션 접근: session
        - 예) ${session.sessionData}
    - 스프링 빈 접근: @
        - 예) ${@helloBean.hello('Spring!')}
- BasicController 추가
```
@GetMapping("/basic-objects")
public String basicObjects(HttpSession session) {
    session.setAttribute("sessionData", "Hello Session");
    return "basic/basic-objects";
}

@Component("helloBean")
static class HelloBean {
    public String hello(String data) {
        return "Hello " + data;
    } 
}
```

- /resources/templates/basic/basic-objects.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<h1>식 기본 객체 (Expression Basic Objects)</h1>

  <ul>
    <li>request = <span th:text="${#request}"></span></li>
    <li>response = <span th:text="${#response}"></span></li>
    <li>session = <span th:text="${#session}"></span></li>
    <li>servletContext = <span th:text="${#servletContext}"></span></li>
    <li>locale = <span th:text="${#locale}"></span></li>
  </ul>

<h1>편의 객체</h1>

  <ul>
    <li>Request Parameter = <span th:text="${param.paramData}"></span></li>
    <li>session = <span th:text="${session.sessionData}"></span></li>
    <li>spring bean = <span th:text="${@helloBean.hello('Spring!')}"></span></li>
  </ul>

</body>
</html>
```
- 실행
    - http://localhost:8080/basic/basic-objects?paramData=HelloParam
    - 실행해서 보면 `request = org.apache.catalina.connector.RequestFacade@3af46ecb` 와 같은 객체가 있다. HttpServletRequest 객체를 구현해 놓은 것이, Tomcat을 사용하면 `RequestFacade` 라는 것이 기본적으로 들어온다.

- 물론 위에서 사용하는 기본 객체들, request 등 객체들은 Controller 에서 직접 request 객체를 받아서 model.addAttribute에 담아서 넘겨도 되긴 한다. 그런데 자주 쓰는 것이므로 타임리프가 기본 객체들로 가지고 있는 것임
```
@GetMapping("/basic-objects")
public String basicObjects(HttpSession session, HttpServletRequest request) { // 직접 request 받아서.
    session.setAttribute("sessionData", "Hello Session");
    model.addAttribute("request", request); // 여기에 담아서 보냄.
    return "basic/basic-objects";
}
```


## 유틸리티 객체와 날자
- 타임리프는 문자, 숫자, 날짜, URI등을 편리하게 다루는 다양한 유틸리티 객체들을 제공한다.
- 타임리프 유틸리티 객체들
    - #message : 메시지, 국제화 처리
    - #uris : URI 이스케이프 지원
    - #dates : java.util.Date 서식 지원 #calendars : java.util.Calendar 서식 지원 #temporals : 자바8 날짜 서식 지원
    - #numbers : 숫자 서식 지원
    - #strings : 문자 관련 편의 기능
    - #objects : 객체 관련 기능 제공
    - #bools : boolean 관련 기능 제공
    - #arrays : 배열 관련 기능 제공
    - #lists , #sets , #maps : 컬렉션 관련 기능 제공 #ids : 아이디 처리 관련 기능 제공, 뒤에서 설명

- 타임리프 유틸리티 객체
    - https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility- objects
- 유틸리티 객체 예시
    - https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#appendix-b-expression- utility-objects
- 참고
    - 이런 유틸리티 객체들은 대략 이런 것이 있다 알아두고, 필요할 때 찾아서 사용하면 된다. 메뉴얼, 예시가 잘 나와있다.

- 자바8 날짜
    - 타임리프에서 자바8 날짜인 LocalDate , LocalDateTime , Instant 를 사용하려면 추가 라이브러리가 필요하다. 스프링 부트 타임리프를 사용하면 해당 라이브러리가 자동으로 추가되고 통합된다.
- 타임리프 자바8 날짜 지원 라이브러리
    - thymeleaf-extras-java8time
- 자바8 날짜용 유틸리티 객체
    - #temporals
- 사용 예시
```
<span th:text="${#temporals.format(localDateTime, 'yyyy-MM-dd HH:mm:ss')}"></span>
```
- BasicController 추가
```
@GetMapping("/date")
public String date(Model model) {
    model.addAttribute("localDateTime", LocalDateTime.now());
    return "basic/date";
}
```
- /resources/templates/basic/date.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<h1>LocalDateTime</h1>

<ul>
    <li>default = <span th:text="${localDateTime}"></span></li>
    <li>yyyy-MM-dd HH:mm:ss = <span th:text="${#temporals.format(localDateTime, 'yyyy-MM-dd HH:mm:ss')}"></span></li>
</ul>

<h1>LocalDateTime - Utils</h1>

<ul>
    <li>${#temporals.day(localDateTime)} = <span th:text="${#temporals.day(localDateTime)}"></span></li>
    <li>${#temporals.month(localDateTime)} = <span th:text="${#temporals.month(localDateTime)}"></span></li>
    <li>${#temporals.monthName(localDateTime)} = <span th:text="${#temporals.monthName(localDateTime)}"></span></li>
    <li>${#temporals.monthNameShort(localDateTime)} = <span th:text="${#temporals.monthNameShort(localDateTime)}"></span></li>
    <li>${#temporals.year(localDateTime)} = <span th:text="${#temporals.year(localDateTime)}"></span></li>
    <li>${#temporals.dayOfWeek(localDateTime)} = <span th:text="${#temporals.dayOfWeek(localDateTime)}"></span></li>
    <li>${#temporals.dayOfWeekName(localDateTime)} = <span th:text="${#temporals.dayOfWeekName(localDateTime)}"></span></li>
    <li>${#temporals.dayOfWeekNameShort(localDateTime)} = <span th:text="${#temporals.dayOfWeekNameShort(localDateTime)}"></span></li>
    <li>${#temporals.hour(localDateTime)} = <span th:text="${#temporals.hour(localDateTime)}"></span></li>
    <li>${#temporals.minute(localDateTime)} = <span th:text="${#temporals.minute(localDateTime)}"></span></li>
    <li>${#temporals.second(localDateTime)} = <span th:text="${#temporals.second(localDateTime)}"></span></li>
    <li>${#temporals.nanosecond(localDateTime)} = <span th:text="${#temporals.nanosecond(localDateTime)}"></span></li>
</ul>

</body>
</html>
```

## URL 링크
- 타임리프에서 URL을 생성할 때는 @{...} 문법을 사용하면 된다.
- BasicController 추가
```
@GetMapping("/link")
public String link(Model model) {
    model.addAttribute("param1", "data1");
    model.addAttribute("param2", "data2");
    return "basic/link";
}
```
- /resources/templates/basic/link.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>URL 링크</h1>
<ul>
    <li><a th:href="@{/hello}">basic url</a></li>
    <li><a th:href="@{/hello(param1=${param1}, param2=${param2})}">hello query param</a></li>
    <li><a th:href="@{/hello/{param1}/{param2}(param1=${param1}, param2=${param2})}">path variable</a></li>
    <li><a th:href="@{/hello/{param1}(param1=${param1}, param2=${param2})}">path variable + query parameter</a></li>
</ul>
</body>
</html>
```
- 단순한 URL
    - @{/hello} -> /hello
- 쿼리 파라미터
    - @{/hello(param1=${param1}, param2=${param2})}
        - -> /hello?param1=data1&param2=data2
        - () 에 있는 부분은 쿼리 파라미터로 처리된다.
- 경로 변수
    - @{/hello/{param1}/{param2}(param1=${param1}, param2=${param2})}
        - -> /hello/data1/data2
        - URL 경로상에 변수가 있으면 () 부분은 경로 변수로 처리된다.
- 경로 변수 + 쿼리 파라미터
    - @{/hello/{param1}(param1=${param1}, param2=${param2})}
        - -> /hello/data1?param2=data2
        - 경로 변수와 쿼리 파라미터를 함께 사용할 수 있다.

- 상대경로, 절대경로, 프로토콜 기준을 표현할 수 도 있다.
    - /hello : 절대 경로
    - hello : 상대 경로
- 참고 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#link-urls

## 리터럴
- Literals
- 리터럴은 소스 코드상에 고정된 값을 말하는 용어이다.
- 예를 들어서 다음 코드에서 "Hello" 는 문자 리터럴, 10 , 20 는 숫자 리터럴이다.
```
String a = "Hello"
int a = 10 * 20
```

- 참고
    - 이 내용이 쉬워 보이지만 처음 타임리프를 사용하면 많이 실수하니 잘 보아두자.
- 타임리프는 다음과 같은 리터럴이 있다.
    - 문자 : 'hello'
    - 숫자 : 10
    - 불린 : true, false
    - null : null

- 타임리프에서 문자 리터럴은 항상 `'` (작은 따옴표)로 감싸야 한다.
```
<span th:text="'hello'">
```

- 그런데문자를항상 `'`로감싸는것은너무귀찮은일이다.공백없이쭉이어진다면하나의의미있는 토큰으로 인지해서 다음과 같이 작은 따옴표를 생략할 수 있다.
    - 룰 : `A-Z`, `a-z`, `0-9`, `[]`, `.`, `-`, `_`
    - `<span th:text="hello">`
- 오류
    - `<span th:text="hello world!"></span>`
    - 문자 리터럴은 원칙상 `'` 로 감싸야 한다. 중간에 공백이 있어서 하나의 의미있는 토큰으로도 인식되지 않는다.
- 수정
    - `<span th:text="'hello world!'"></span>`
    - 이렇게 `'` 로 감싸면 정상 동작한다.
- BasicController 추가
```
@GetMapping("/literal")
public String literal(Model model) {
    model.addAttribute("data", "Spring!");
    return "basic/literal";
}
```
- /resources/templates/basic/literal.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body> <h1>리터럴</h1>
<ul>
    <!--주의! 다음 주석을 풀면 예외가 발생함-->
    <!--    <li>"hello world!" = <span th:text="hello world!"></span></li>-->
    <li>'hello' + ' world!' = <span th:text="'hello' + ' world!'"></span></li>
    <li>'hello world!' = <span th:text="'hello world!'"></span></li>
    <li>'hello ' + ${data} = <span th:text="'hello ' + ${data}"></span></li>
    <li>리터럴 대체 |hello ${data}| = <span th:text="|hello ${data}|"></span></li>
</ul>

</body>
</html>
```
- 리터럴 대체(Literal substitutions)
    - `<span th:text="|hello ${data}|">`
    - 마지막의 리터럴 대체 문법을 사용하면 마치 템플릿을 사용하는 것처럼 편리하다.

## 연산
- 타임리프 연산은 자바와 크게 다르지 않다. HTML안에서 사용하기 때문에 HTML 엔티티를 사용하는 부분만 주의하자.
- BasicController 추가
```
@GetMapping("/operation")
public String operation(Model model) {
    model.addAttribute("nullData", null);
    model.addAttribute("data", "Spring!");
    return "basic/operation";
}
```
- /resources/templates/basic/operation.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<ul>

  <li>산술 연산
    <ul>
      <li>10 + 2 = <span th:text="10 + 2"></span></li>
      <li>10 % 2 == 0 = <span th:text="10 % 2 == 0"></span></li>
    </ul>
  </li>

  <li>비교 연산
    <ul>
      <li>1 > 10 = <span th:text="1 &gt; 10"></span></li>
      <li>1 gt 10 = <span th:text="1 gt 10"></span></li>
      <li>1 >= 10 = <span th:text="1 >= 10"></span></li>
      <li>1 ge 10 = <span th:text="1 ge 10"></span></li>
      <li>1 == 10 = <span th:text="1 == 10"></span></li>
      <li>1 != 10 = <span th:text="1 != 10"></span></li>
    </ul>
  </li>

  <li>조건식
    <ul>
      <li>(10 % 2 == 0)? '짝수':'홀수' = <span th:text="(10 % 2 == 0)?'짝수':'홀수'"></span></li>
    </ul>
  </li>

  <li>Elvis 연산자
    <ul>
      <li>${data}?: '데이터가 없습니다.' = <span th:text="${data}?: '데이터가 없습니다.'"></span></li>
      <li>${nullData}?: '데이터가 없습니다.' = <span th:text="${nullData}?:'데이터가 없습니다.'"></span></li>
    </ul>
  </li>

  <li>No-Operation
    <ul>
      <li>${data}?: _ = <span th:text="${data}?: _">데이터가 없습니다.</span></li>
      <li>${nullData}?: _ = <span th:text="${nullData}?: _">데이터가 없습니다.</span></li>
    </ul>
  </li>

</ul>
</body>
</html>
```
- 비교연산: HTML 엔티티를 사용해야 하는 부분을 주의하자
    - `>` (gt), `<` (lt), `>=` (ge), `<=` (le), `!` (not), `==` (eq), `!=` (neq, ne)
- 조건식: 자바의 조건식과 유사하다.
- Elvis 연산자: 조건식의 편의 버전
-No-Operation: _ 인 경우 마치 타임리프가 실행되지 않는 것 처럼 동작한다. 이것을 잘 사용하면 HTML 의 내용 그대로 활용할 수 있다. 마지막 예를 보면 데이터가 없습니다. 부분이 그대로 출력된다.

## 속성 값 설정
- 타임리프 태그 속성(Attribute)
- 타임리프는 주로 HTML 태그에 th:* 속성을 지정하는 방식으로 동작한다. th:* 로 속성을 적용하면 기존 속성을 대체한다. 기존 속성이 없으면 새로 만든다.
- BasicController 추가
```
@GetMapping("/attribute")
public String attribute() {
    return "basic/attribute";
}
```
- /resources/templates/basic/attribute.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>속성 설정</h1>

<input type="text" name="mock" th:name="userA" />

<h1>속성 추가</h1>
- th:attrappend = <input type="text" class="text" th:attrappend="class=' large'" /><br/>
- th:attrprepend = <input type="text" class="text" th:attrprepend="class='large '" /><br/>
- th:classappend = <input type="text" class="text" th:classappend="large" /><br/>

<h1>checked 처리</h1>
- checked o <input type="checkbox" name="active" th:checked="true" /><br/>
- checked x <input type="checkbox" name="active" th:checked="false" /><br/>
- checked=false <input type="checkbox" name="active" checked="false" /><br/>

</body>
</html>
```
- 속성 설정
    - th:* 속성을 지정하면 타임리프는 기존 속성을 th:* 로 지정한 속성으로 대체한다. 기존 속성이 없다면 새로 만든다.
    - ` <input type="text" name="mock" th:name="userA" />`
    - -> `타임리프 렌더링 후 <input type="text" name="userA" />`
    - 그런데 절대 경로로 파일을 그대로 열 경우에는 둘 다 그대로 다 나오고 th:name 속성 말고 name 이 적용된다. 왜냐하면 순수한 HTML은 타임리프 th 자체가 뭔지도 잘 모른다.
- 속성 추가
    - th:attrappend : 속성 값의 뒤에 값을 추가한다.(띄워쓰기 신경써줘야 한다. 아니면 text large가 아니라 textlarge 로 붙어버린다)
    - th:attrprepend : 속성 값의 앞에 값을 추가한다.(띄워쓰기 신경써줘야 한다. 아니면 text large가 아니라 textlarge 로 붙어버린다)
    - th:classappend : class 속성에 자연스럽게 추가한다. (띄워쓰기 자동으로 넣어줌)
- checked 처리
    - HTML에서는 `<input type="checkbox" name="active" checked="false" />` -> checked 속성이 있기 때문에(true든 false든 checked 속성만 있으면) checked 처리가 되어버린다. 
    - HTML에서 checked 속성은 checked 속성의 값과 상관없이 checked 라는 속성만 있어도 체크가 된다.(절대경로로 순수한 html 열어도 체크가 애초부터 되어 있다.) 이런 부분이 true , false 값을 주로 사용하는 개발자 입장에서는 불편하다.
    - 타임리프의 th:checked 는 값이 false 인 경우 checked 속성 자체를 제거한다. 
        - `<input type="checkbox" name="active" th:checked="false" />`
        - -> 타임리프 렌더링 후 : `<input type="checkbox" name="active" />`
        - 보통 `checked o <input type="checkbox" name="active" th:checked="${isChecked}"` 이런식으로 변수를 넣어서 사용한다.
    - 그래서 th:checked 를 사용하면 훨씬 더 편하다. 왜냐하면 false 경우에는 체크자체가 해제되어 있어야 하는데 checked 속성 자체가 존재만 해도 체크가 되어 버리기 때문에 원하는 대로 개발한다면 if 절을 넣어서 있으면 checked 속성 넣고 등의 로직이 들어가야 해서 훨씬 불편하다.
    

## 반복
- 타임리프에서 반복은 th:each 를 사용한다. 추가로 반복에서 사용할 수 있는 여러 상태 값을 지원한다.
- BasicController 추가
```
    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/each";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("UserA", 10));
        list.add(new User("UserB", 20));
        list.add(new User("UserC", 30));

        model.addAttribute("users", list);
    }
```

- /resources/templates/basic/each.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>기본 테이블</h1>

<table border="1">
  <tr>
    <th>username</th>
    <th>age</th>
  </tr>

  <tr th:each="user : ${users}">
    <td th:text="${user.username}">username</td>
    <td th:text="${user.age}">0</td>
  </tr>
</table>

<h1>반복 상태 유지</h1>

<table border="1">
  <tr>
    <th>count</th>
    <th>username</th>
    <th>age</th>
    <th>etc</th>
  </tr>

  <tr th:each="user, userStat : ${users}">
    <td th:text="${userStat.count}">username</td>
    <td th:text="${user.username}">username</td>
    <td th:text="${user.age}">0</td>
    <td>
      index = <span th:text="${userStat.index}"></span>
      count = <span th:text="${userStat.count}"></span>
      size = <span th:text="${userStat.size}"></span>
      even? = <span th:text="${userStat.even}"></span>
      odd? = <span th:text="${userStat.odd}"></span>
      first? = <span th:text="${userStat.first}"></span>
      last? = <span th:text="${userStat.last}"></span>
      current = <span th:text="${userStat.current}"></span>
    </td>
  </tr>
</table>

</body>
</html>
```
- 반복 기능
    - `<tr th:each="user : ${users}">`
    - 반복시 오른쪽 컬렉션( ${users} )의 값을 하나씩 꺼내서 왼쪽 변수( user )에 담아서 태그를 반복 실행합니다.
    - th:each 는 List 뿐만 아니라 배열, java.util.Iterable , java.util.Enumeration 을 구현한 모든 객체를 반복에 사용할 수 있습니다. Map 도 사용할 수 있는데 이 경우 변수에 담기는 값은 Map.Entry 입니다.
- 반복 상태 유지
    - `<tr th:each="user, userStat : ${users}">`
    - 반복의 두번째 파라미터를 설정해서 반복의 상태를 확인 할 수 있습니다.
    - 두번째 파라미터는 생략 가능한데, 생략하면 지정한 변수명( user ) + Stat 가 됩니다. 여기서는 user + Stat = userStat 이므로 생략 가능합니다.
    - 반복 상태 유지 기능
        - index : 0부터 시작하는 값
        - count : 1부터 시작하는 값
        - size : 전체 사이즈
        - even , odd : 홀수, 짝수 여부( boolean )
        - first , last :처음, 마지막 여부( boolean )
        - current : 현재 객체

## 조건부 평가
- 타임리프의 조건식
    - if, unless(if의 반대)
- BasicController 추가
```
 @GetMapping("/condition")
  public String condition(Model model) {
      addUsers(model);
      return "basic/condition";
  }
```

- /resources/templates/basic/condition.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>if, unless</h1>
<table border="1">

  <tr>
    <th>count</th>
    <th>username</th>
    <th>age</th>
  </tr>

  <tr th:each="user, userStat : ${users}">
    <td th:text="${userStat.count}">1</td>
    <td th:text="${user.username}">username</td>
    <td>
      <span th:text="${user.age}">0</span>
      <span th:text="'미성년자'" th:if="${user.age lt 20}"></span>
      <span th:text="'미성년자'" th:unless="${user.age ge 20}"></span>
    </td>
  </tr>

</table>

<h1>switch</h1>

<table border="1">

  <tr>
    <th>count</th>
    <th>username</th>
    <th>age</th>
  </tr>

  <tr th:each="user, userStat : ${users}">
    <td th:text="${userStat.count}">1</td>
    <td th:text="${user.username}">username</td>
    <td th:switch="${user.age}">
      <span th:case="10">10살</span>
      <span th:case="20">20살</span>
      <span th:case="*">기타</span>
    </td>
  </tr>

</table>

</body>
</html>
```
- if, unless
    - 타임리프는 해당 조건이 맞지 않으면 태그 자체를 렌더링하지 않는다.
    - 만약 다음 조건이 false 인 경우 `<span>...<span>` 부분 자체가 렌더링 되지 않고 사라진다. 
    - `<span th:text="'미성년자'" th:if="${user.age lt 20}"></span>`
- switch
    - `*` 은 만족하는 조건이 없을 때 사용하는 디폴트이다.


## 주석
- BasicController 추가
```
@GetMapping("/comments")
  public String comments(Model model) {
      model.addAttribute("data", "Spring!");
      return "basic/comments";
  }

```

- /resources/templates/basic/comments.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body> 

<h1>예시</h1>
<span th:text="${data}">html data</span>

<h1>1. 표준 HTML 주석</h1>
<!--
<span th:text="${data}">html data</span> -->

<h1>2. 타임리프 파서 주석</h1> <!--/* [[${data}]] */-->
<!--/*-->
<span th:text="${data}">html data</span>
<!--*/-->

<h1>3. 타임리프 프로토타입 주석</h1>
<!--/*/
<span th:text="${data}">html data</span> /*/-->
</body>
</html
```

- 결과
```
<h1>예시</h1> 
<span>Spring!</span>

<h1>1. 표준 HTML 주석</h1>
<!--
<span th:text="${data}">html data</span> 
-->

<h1>2. 타임리프 파서 주석</h1> 

<h1>3. 타임리프 프로토타입 주석</h1>
<span>Spring!</span>
```
1. 표준 HTML 주석
- 자바스크립트의 표준 HTML 주석은 타임리프가 렌더링 하지 않고, 그대로 남겨둔다.
2. 타임리프 파서 주석
- 타임리프 파서 주석은 타임리프의 진짜 주석이다. 렌더링에서 주석 부분을 제거한다.
3. 타임리프 프로토타입 주석
- 타임리프 프로토타입은 약간 특이한데, HTML 주석에 약간의 구문을 더했다.
- `HTML 파일`을 웹 브라우저에서 그대로 열어보면 HTML 주석이기 때문에 이 부분이 웹 브라우저가 렌더링하지 않는다.
- `타임리프 렌더링`을 거치면 이 부분이 정상 렌더링 된다.
- 쉽게 이야기해서 HTML 파일을 그대로 열어보면 주석처리가 되지만, 타임리프를 렌더링 한 경우에만 보이는 기능이다.

## 블록
- `<th:block>` 은 HTML 태그가 아닌 타임리프의 유일한 자체 태그다.
- BasicController 추가
```
@GetMapping("/block")
public String block(Model model) {
    addUsers(model);
    return "basic/block";
}
```
- /resources/templates/basic/block.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<th:block th:each="user : ${users}">

  <div>
    사용자 이름1 <span th:text="${user.username}"></span>
    사용자 나이1 <span th:text="${user.age}"></span>
  </div>
  <div>
    요약
    <span th:text="${user.username} + ' / ' + ${user.age}"></span>
  </div>

</th:block>
</body>
</html>

```
- 실행결과
```
<div>
사용자 이름1 <span>userA</span> 사용자 나이1 <span>10</span> </div>
<div>
요약 <span>userA / 10</span> </div>
<div>
사용자 이름1 
<span>userB</span> 
사용자 나이1 <span>20</span> 
</div>
<div>
요약 <span>userB / 20</span> 
</div>

<div>
사용자 이름1 <span>userC</span> 사용자 나이1 <span>30</span> </div>
<div>
요약 <span>userC / 30</span> </div>
```

- 타임리프의 특성상 HTML 태그안에 속성으로 기능을 정의해서 사용하는데, 위 예처럼 이렇게 사용하기 애매한 경우에 사용하면 된다. `<th:block>`은 렌더링시 제거된다.
- div 덩어리 2개를 한 묶음으로 반복하고 싶은데, 그 전체를 묶어서 새로운 태그 block 을 활용하기!. div 하나에 th:each 를 넣으면 div 하나만 반복이 되므로.

## 자바스크립트 인라인
- 타임리프는 자바스크립트에서 타임리프를 편리하게 사용할 수 있는 자바스크립트 인라인 기능을 제공한다. 자바스크립트 인라인 기능은 다음과 같이 적용하면 된다.
- `<script th:inline="javascript">`
- BasicController 추가
```
    @GetMapping("/javascript")
    public String javascript(Model model) {

        model.addAttribute("user", new User("UserA", 10));
        addUsers(model);

        return "basic/javascript";
    }
```
- /resources/templates/basic/javascript.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<!-- 자바스크립트 인라인 사용 전 -->
<script>

  var username = [[${user.username}]];
  var age = [[${user.age}]];

  //자바스크립트 내추럴 템플릿
  var username2 = /*[[${user.username}]]*/ "test username";

  //객체
  var user = [[${user}]];
</script>

<!-- 자바스크립트 인라인 사용 후 -->
<script th:inline="javascript">

  var username = [[${user.username}]];
  var age = [[${user.age}]];

  //자바스크립트 내추럴 템플릿
  var username2 = /*[[${user.username}]]*/ "test username";

  //객체
  var user = [[${user}]];
</script>

</body>
</html>
```

- 자바스크립트 인라인 사용 전 - 결과
```
<script>
  var username = userA;
  var age = 10;

//자바스크립트 내추럴 템플릿
var username2 = /*userA*/ "test username";

//객체
var user = BasicController.User(username=userA, age=10);
</script>
```

- 자바스크립트 인라인 사용 후 - 결과
```
자바스크립트 인라인 사용 후
  <script>
  var username = "userA";
  var age = 10;

//자바스크립트 내추럴 템플릿 
var username2 = "userA";

//객체
var user = {"username":"userA","age":10};
</script>
```

- 자바스크립트 인라인을 사용하지 않은 경우 어떤 문제들이 있는지 알아보고, 인라인을 사용하면 해당 문제들이 어떻게 해결되는지 확인해보자.
- 텍스트 렌더링
    - var username = [[${user.username}]];
        - 인라인 사용 전 -> var username = userA;
        - 인라인 사용 후 -> var username = "userA";

    - 인라인 사용 전 렌더링 결과를 보면 userA 라는 변수 이름이 그대로 남아있다. 타임리프 입장에서는 정확하게 렌더링 한 것이지만 아마 개발자가 기대한 것은 다음과 같은 "userA"라는 문자일 것이다. 결과적으로 userA가 변수명으로 사용되어서 자바스크립트 오류가 발생한다.(개발자도구로 확인하면 에러 확인 가능) 다음으로 나오는 숫자 age의 경우에는 " 가 필요 없기 때문에 정상 렌더링 된다.
    - 인라인사용후렌더링결과를보면문자타입인경우 "를포함해준다.추가로자바스크립트에서문제가될 수 있는 문자가 포함되어 있으면 이스케이프 처리도 해준다. 예) " \"

- 자바스크립트 내추럴 템플릿
    - 타임리프는 HTML 파일을 직접 열어도 동작하는 내추럴 템플릿 기능을 제공한다. 자바스크립트 인라인 기능을 사용하면 주석을 활용해서 이 기능을 사용할 수 있다.
    - var username2 = /*[[${user.username}]]*/ "test username";
        - 인라인 사용 전 -> var username2 = /*userA*/ "test username";
        - 인라인 사용 후 -> var username2 = "userA";
    - 인라인 사용 전 결과를 보면 정말 순수하게 그대로 해석을 해버렸다. 따라서 내추럴 템플릿 기능이 동작하지 않고, 심지어 렌더링 내용이 주석처리 되어 버린다.
    - 인라인 사용 후 결과를 보면 주석 부분이 제거되고, 기대한 "userA"가 정확하게 적용된다.
- 객체
    - 타임리프의 자바스크립트 인라인 기능을 사용하면 객체를 JSON으로 자동으로 변환해준다.
    - var user = [[${user}]];
        - 인라인 사용 전 -> var user = BasicController.User(username=userA, age=10);
        - 인라인 사용 후 -> var user = {"username":"userA","age":10};
    - 인라인 사용 전은 객체의 toString()이 호출된 값이다.
    - 인라인 사용 후는 객체를 JSON으로 변환해준다.


- 자바스크립트 인라인 each
    - 자바스크립트 인라인은 each를 지원하는데, 다음과 같이 사용한다.
    - /resources/templates/basic/javascript.html 에 추가
    ```
    <!-- 자바스크립트 인라인 each -->
    <script th:inline="javascript">
    [# th:each="user, stat : ${users}"]
    var user[[${stat.count}]] = [[${user}]];
    [/]
    </script>
    ```
    - 자바스크립트 인라인 each 결과
    ```
    <script>
    var user1 = {"username":"userA","age":10};
    var user2 = {"username":"userB","age":20};
    var user3 = {"username":"userC","age":30};
    </script>
    ```
## 템플릿 조각
- 웹 페이지를 개발할 때는 공통 영역이 많이 있다. 예를 들어서 상단 영역이나 하단 영역, 좌측 카테고리 등등 여러 페이지에서 함께 사용하는 영역들이 있다. 이런 부분을 코드를 복사해서 사용한다면 변경시 여러 페이지를 다 수정해야 하므로 상당히 비효율 적이다. 타임리프는 이런 문제를 해결하기 위해 템플릿 조각과 레이아웃 기능을 지원한다.

- 주의! 템플릿 조각과 레이아웃 부분은 직접 실행해보아야 이해된다.
- 템플릿 조각
```
@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }
}

```
- /resources/templates/template/fragment/footer.html
    - th:fragment 가 있는 태그는 다른곳에 포함되는 코드 조각으로 이해하면 된다.
    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <body>

    <footer th:fragment="copy">
        푸터 자리 입니다.
    </footer>

    <footer th:fragment="copyParam (param1, param2)">
        <p>파라미터 자리 입니다.</p>
        <p th:text="${param1}"></p>
        <p th:text="${param2}"></p>
    </footer>

    </body>
    </html>
    ```

- /resources/templates/template/fragment/fragmentMain.html
    - `template/fragment/footer :: copy` => `template/fragment/footer.html` 템플릿에 있는 `th:fragment="copy"`라는 부분을 템플릿 조각으로 가져와서 사용한다는 의미이다.
    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="UTF-8">
    <title>Title</title>
    </head>
    <body>

    <h1>부분 포함</h1>
    <h2>부분 포함 insert</h2>
    <div th:insert="~{template/fragment/footer :: copy}"></div>

    <h2>부분 포함 replace</h2>
    <div th:replace="~{template/fragment/footer :: copy}"></div>

    <h2>부분 포함 단순 표현식</h2>
    <div th:replace="template/fragment/footer :: copy"></div>

    <h1>파라미터 사용</h1>
    <div th:replace="~{template/fragment/footer :: copyParam ('데이터1', '데이터 2')}"></div>

    </body>
    </html>
    ```

- footer.html 의 copy 부분
```
<footer th:fragment="copy">
    푸터 자리 입니다.
 </footer>
```
- 부분 포함 insert
    - `<div th:insert="~{template/fragment/footer :: copy}"></div>`
    ```
    <h2>부분 포함 insert</h2> <div>
    <footer>
    푸터 자리 입니다.
    </footer>
    </div>
    ```
    - th:insert 를 사용하면 현재 태그( div ) 내부에 추가한다.

- 부분 포함 replace
    - `<div th:replace="~{template/fragment/footer :: copy}"></div>`
    ```
    <h2>부분 포함 replace</h2>
    <footer>
    푸터 자리 입니다. 
    </footer>
    ```
    - th:replace 를 사용하면 현재 태그( div )를 대체한다.

- 부분 포함 단순 표현식
    - `<div th:replace="template/fragment/footer :: copy"></div>`
    ```
    <h2>부분 포함 단순 표현식</h2> 
    <footer>
    푸터 자리 입니다. 
    </footer>
    ```
    - `~{...}` 를 사용하는 것이 원칙이지만 템플릿 조각을 사용하는 코드가 단순하면 이 부분을 생략할 수 있다.
- 파라미터 사용
    - 다음과 같이 파라미터를 전달해서 동적으로 조각을 렌더링 할 수도 있다.
    - ` <div th:replace="~{template/fragment/footer :: copyParam ('데이터1', '데이터2')}"></div>`
    ```
    <h1>파라미터 사용</h1> 
    <footer>
    <p>파라미터 자리 입니다.</p> 
    <p>데이터1</p> 
    <p>데이터2</p>
    </footer>
    ```
    - footer.html 의 copyParam 부분
    ```
    <footer th:fragment="copyParam (param1, param2)">
    <p>파라미터 자리 입니다.</p>
    <p th:text="${param1}"></p> 
    <p th:text="${param2}"></p>
    </footer>
    ```


## 템플릿 레이아웃1
- 템플릿 레이아웃
- 이전에는 일부 코드 조각을 가지고와서 사용했다면, 이번에는 개념을 더 확장해서 코드 조각을 레이아웃에 넘겨서 사용하는 방법에 대해서 알아보자.
- 예를 들어서 `<head>` 에 공통으로 사용하는 css , javascript 같은 정보들이 있는데, 이러한 공통 정보들을 한 곳에 모아두고, 공통으로 사용하지만, 각 페이지마다 필요한 정보를 더 추가해서 사용하고 싶다면 다음과 같이 사용하면 된다.
- TemplateController
```
@GetMapping("/layout")
  public String layout() {
      return "template/layout/layoutMain";
  }
```
- /resources/templates/template/layout/base.html
```
<html xmlns:th="http://www.thymeleaf.org">
<head th:fragment="common_header(title,links)">

    <title th:replace="${title}">레이아웃 타이틀</title>

    <!-- 공통 -->
    <link rel="stylesheet" type="text/css" media="all" th:href="@{/css/awesomeapp.css}">
    <link rel="shortcut icon" th:href="@{/images/favicon.ico}">
    <script type="text/javascript" th:src="@{/sh/scripts/codebase.js}"></script>

    <!-- 추가 -->
    <th:block th:replace="${links}" />

</head>
```
- /resources/templates/template/layout/layoutMain.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="template/layout/base :: common_header(~{::title},~{::link})">
    <title>메인 타이틀</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
    <link rel="stylesheet" th:href="@{/themes/smoothness/jquery-ui.css}">
</head>
<body>
메인 컨텐츠
</body>
</html>
```

- 결과
```
<!DOCTYPE html>
<html>
<head>
<title>메인 타이틀</title> 

<!-- 공통 -->
<link rel="stylesheet" type="text/css" media="all" href="/css/awesomeapp.css">
<link rel="shortcut icon" href="/images/favicon.ico">
<script type="text/javascript" src="/sh/scripts/codebase.js"></script>

<!-- 추가 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/themes/smoothness/jquery-ui.css">

</head> 
<body> 
메인 컨텐츠 
</body> 

</html>
 ```

- `common_header(~{::title},~{::link})` 이 부분이 핵심이다.
    - ::title 은 현재 페이지의 title 태그들을 전달한다.
    - ::link 는 현재 페이지의 link 태그들을 전달한다.
- 결과를 보자.
    - 메인 타이틀이 전달한 부분으로 교체되었다.
    - 공통 부분은 그대로 유지되고, 추가 부분에 전달한 `<link>` 들이 포함된 것을 확인할 수 있다.
    - 이 방식은 사실 앞서 배운 코드 조각을 조금 더 적극적으로 사용하는 방식이다. 쉽게 이야기해서 레이아웃 개념을 두고, 그 레이아웃에 필요한 코드 조각을 전달해서 완성하는 것으로 이해하면 된다.

## 템플릿 레이아웃2
- 템플릿 레이아웃 확장
- 앞서 이야기한 개념을 `<head>` 정도에만 적용하는게 아니라 `<html>` 전체에 적용할 수도 있다.
- TemplateController
```
@GetMapping("/layoutExtend")
  public String layoutExtends() {
      return "template/layoutExtend/layoutExtendMain";
  }
```
- /resources/templates/template/layoutExtend/layoutFile.html
    - 우리가 홈페이지를 운영하고 있다고 가정. 100페이지 모두다 같은 레이아웃을 가지고 있다고 가정. (layoutFile.html) 
    - head의 타이틀(title) 부분과 body의 div 부분만(content) 서로 다름
    - 만약 footer의 한 부분을 수정해야 하는데, layout개념이 없다면 모든 100페이지의 footer를 다 수정해야 한다. 그런데 layout이 존재한다면 그 layout의 footer를 수정하고, 나머지 다른 부분들은 자신만이 가지고 있는 부분들을 넘기면서 html자체를 layout파일로 교체.
    ```
    <!DOCTYPE html>
    <html th:fragment="layout (title, content)" xmlns:th="http://www.thymeleaf.org">

    <head>
    <title th:replace="${title}">레이아웃 타이틀</title> </head>
    <body>

    <h1>레이아웃 H1</h1>

    <div th:replace="${content}">
    <p>레이아웃 컨텐츠</p>
    </div>

    <footer>
    레이아웃 푸터
    </footer>

    </body>
    </html>
    ```


- /resources/templates/template/layoutExtend/layoutExtendMain.html
    - html자체를 layoutFile.html로 replace 해버린다. 
        - 그런데 그냥 교체하지 않고, 현재 layoutExtendMain.html이 가지고 있는 title, section이 넘어간다. 
    ```
    <!DOCTYPE html>
    <html th:replace="~{template/layoutExtend/layoutFile :: layout(~{::title},~{::section})}"
        xmlns:th="http://www.thymeleaf.org">
    <head>
    <title>메인 페이지 타이틀</title>
    </head>
    <body>

    <section>
    <p>메인 페이지 컨텐츠</p>
    <div>메인 페이지 포함 내용</div>
    </section>

    </body>
    </html>
    ```
- 생성결과
```
<!DOCTYPE html>
<html>
<head>
    <title>메인 페이지 타이틀</title> 
</head>

<body>
<h1>레이아웃 H1</h1>

<section>
    <p>메인 페이지 컨텐츠</p> 
    <div>메인 페이지 포함 내용</div> 
</section>

<footer> 
    레이아웃 푸터
</footer>

</body>
</html>
```
- layoutFile.html 을 보면 기본 레이아웃을 가지고 있는데, `<html>` 에 th:fragment 속성이 정의되어 있다. 이 레이아웃 파일을 기본으로 하고 여기에 필요한 내용을 전달해서 부분부분 변경하는 것으로 이해하면 된다.
- layoutExtendMain.html 는 현재 페이지인데, `<html>` 자체를 th:replace 를 사용해서 변경하는 것을 확인할 수 있다. 결국 layoutFile.html 에 필요한 내용을 전달하면서 `<html>` 자체를 layoutFile.html 로 변경한다.

- 그래서 보통 2가지 중 선택을 한다. 레이아웃 방법1처럼 fragment로 조각조각부분을 서로 넘기거나, 아니면 html 페이지 자체를 넘겨서 정리하거나.
    - 간단할 때는 레이아웃 방법1이 쉽기는 한데, 중복이 좀 많아진다. 레이아웃을 단숨에 바꿀 때는 좀 귀찮아진다. 그래서 페이지가 많아지거나 관리가 많아지면 레이아웃 방법 2처럼 페이지 자체를 넘기는 식으로.

# 타임리프 - 스프링 통합과 폼
## 프로젝트 설정
- 스프링 MVC 1편에서 마지막에 완성했던 상품 관리 프로젝트를 떠올려보자. 지금부터 이 프로젝트에 스프링이 지원하는 다양한 기능을 붙여가면서 스프링 MVC를 깊이있게 학습해보자. MVC1 편에서 개발한 상품 관리 프로젝트를 약간 다듬어서 form-start 라는 프로젝트에 넣어두었다.
- 프로젝트 설정 순서
1. form-start 의 폴더 이름을 form 로 변경하자.
2. 프로젝트 임포트
- File Open 해당 프로젝트의 build.gradle 을 선택하자. 그 다음에 선택창이 뜨는데, Open as Project를 선택하자.
3. ItemServiceApplication.main() 을 실행해서 프로젝트가 정상 수행되는지 확인하자.


- 실행
    - http://localhost:8080
    - http://localhost:8080/form/items

## 타임리프 스프링 통합

- 타임리프는 크게 2가지 메뉴얼을 제공한다.
    - 기본 메뉴얼: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
        - 스프링과 무관한 타임리프 기능들
    - 스프링 통합 메뉴얼: https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
        - 타임리프와 스프링이 통홥된 기능들
- 타임리프는 스프링 없이도 동작하지만, 스프링과 통합을 위한 다양한 기능을 편리하게 제공한다. 그리고 이런 부분은 스프링으로 백엔드를 개발하는 개발자 입장에서 타임리프를 선택하는 하나의 이유가 된다.

- 스프링 통합으로 추가되는 기능들
    - 스프링의 SpringEL 문법 통합
    - ${@myBean.doSomething()} 처럼 스프링 빈 호출 지원
    - 편리한 폼 관리를 위한 추가 속성
        - th:object (기능 강화, 폼 커맨드 객체 선택)
        - th:field , th:errors , th:errorclass
    - 폼 컴포넌트 기능
        - checkbox, radio button, List 등을 편리하게 사용할 수 있는 기능 지원
    - 스프링의 메시지, 국제화 기능의 편리한 통합
    - 스프링의 검증, 오류 처리 통합
    - 스프링의 변환 서비스 통합(ConversionService)

- 설정 방법
    - 타임리프 템플릿 엔진을 스프링 빈에 등록하고, 타임리프용 뷰 리졸버를 스프링 빈으로 등록하는 방법
    - 메뉴얼
        - https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#the-springstandard- dialect
        - https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#views-and-view- resolvers

- 스프링 부트는 이런 부분을 모두 자동화 해준다. build.gradle 에 다음 한줄을 넣어주면 Gradle은 타임리프와 관련된 라이브러리를 다운로드 받고, 스프링 부트는 앞서 설명한 타임리프와 관련된 설정용 스프링 빈을 자동으로 등록해준다.
- build.gradle
```
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```

- 타임리프 관련 설정을 변경하고 싶으면 다음을 참고해서 application.properties 에 추가하면 된다.
    - 스프링 부트가 제공하는 타임리프 설정, thymeleaf 검색 필요
    - https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application- properties.html#common-application-properties-templating

## 입력 폼 처리
- 지금부터 타임리프가 제공하는 입력 폼 기능을 적용해서 기존 프로젝트의 폼 코드를 타임리프가 지원하는 기능을 사용해서 효율적으로 개선해보자.
- th:object : 커맨드 객체를 지정한다.
- *{...} : 선택 변수 식이라고 한다. th:object 에서 선택한 객체에 접근한다.
- th:field
    - HTML 태그의 id , name , value 속성을 자동으로 처리해준다.
- 렌더링 전
`<input type="text" th:field="*{itemName}" />`
- 렌더링 후
`<input type="text" id="itemName" name="itemName" th:value="*{itemName}" />`
- 등록 폼
    - th:object 를 적용하려면 먼저 해당 오브젝트 정보를 넘겨주어야 한다. 등록 폼이기 때문에 데이터가 비어있는 빈 오브젝트를 만들어서 뷰에 전달하자.

- FormItemController 변경
```
@GetMapping("/add")
public String addForm(Model model) {
    model.addAttribute("item", new Item());
    return "form/addForm";
}
```
- 이제 본격적으로 타임리프 등록 폼을 변경하자.
    - form/addForm.html 변경 코드 부분
    ```
    <form action="item.html" th:action th:object="${item}" method="post">

    <div>
        <label for="itemName">상품명</label>
        <input type="text" id="itemName" th:field="*{itemName}" class="form-
        control" placeholder="이름을 입력하세요"> 
    </div>
    
    <div>
        <label for="price">가격</label>
        <input type="text" id="price" th:field="*{price}" class="form-control" placeholder="가격을 입력하세요">
    </div> 

    <div>
        <label for="quantity">수량</label>
        <input type="text" id="quantity" th:field="*{quantity}" class="form-control" placeholder="수량을 입력하세요"> 
    </div>
    ```
    - th:object="${item}" : `<form>` 에서 사용할 객체를 지정한다. 선택 변수 식( *{...} )을 적용할 수 있다
    - th:field="*{itemName}"
        - *{itemName} 는 선택 변수 식을 사용했는데, ${item.itemName} 과 같다. 앞서 th:object 로 item을 선택했기 때문에 선택 변수 식을 적용할 수 있다.
        - th:field 는 id , name , value 속성을 모두 자동으로 만들어준다.
            - id : th:field 에서 지정한 변수 이름과 같다. 
            - id="itemName" name : th:field 에서 지정한 변수 이름과 같다. name="itemName" 
            - value : th:field 에서 지정한 변수의 값을 사용한다. value=""

        - 참고로 해당 예제에서 id 속성을 제거해도 th:field 가 자동으로 만들어준다.
    - 렌더링 전
    ```
     <input type="text" id="itemName" th:field="*{itemName}" class="form-control" placeholder="이름을 입력하세요">
    ```
    - 렌덜이 후
    ```
    <input type="text" id="itemName" class="form-control" placeholder="이름을 입력하세요" name="itemName" value="">
    ```

- 수정 폼
    - FormItemController 유지
    - form/editForm.html 변경 코드 부분
    ```
    <form action="item.html" th:action th:object="${item}" method="post">
    <div>
        <label for="id">상품 ID</label>
        <input type="text" id="id" class="form-control" th:field="*{id}" readonly>
    </div>
    <div>
        <label for="itemName">상품명</label>
        <input type="text" id="itemName" class="form-control" th:field="*{itemName}">
    </div>
    <div>
        <label for="price">가격</label>
        <input type="text" id="price" class="form-control" th:field="*{price}">
    </div>
    <div>
        <label for="quantity">수량</label>
        <input type="text" id="quantity" class="form-control" th:field="*{quantity}">
    </div>
    ```
    - 수정 폼은 앞서 설명한 내용과 같다. 수정 폼의 경우 id , name , value 를 모두 신경써야 했는데, 많은 부분이 th:field 덕분에 자동으로 처리되는 것을 확인할 수 있다.
    - 렌더링 전
    ```
    <input type="text" id="itemName" th:field="*{itemName}" class="form-control">
    ```
    - 렌더링 후
    ```
    <input type="text" id="itemName" class="form-control" name="itemName" value="itemA">
    ```
    - 정리
        - th:object , th:field 덕분에 폼을 개발할 때 약간의 편리함을 얻었다.
        - 쉽고 단순해서 크게 어려움이 없었을 것이다.
        - 사실 이것의 진짜 위력은 뒤에 설명할 검증(Validation)에서 나타난다. 이후 검증 부분에서 폼 처리와 관련된 부분을 더 깊이있게 알아보자.

## 요구사항 추가
- 타임리프를 사용해서 폼에서 체크박스, 라디오 버튼, 셀렉트 박스를 편리하게 사용하는 방법을 학습해보자. 기존 상품 서비스에 다음 요구사항이 추가되었다.

- 판매 여부
    - 판매 오픈 여부
    - 체크 박스로 선택할 수 있다.
- 등록 지역
    - 서울, 부산, 제주
    - 체크 박스로 다중 선택할 수 있다. 
- 상품 종류
    - 도서, 식품, 기타
    - 라디오 버튼으로 하나만 선택할 수 있다. 
- 배송 방식
    - 빠른 배송
    - 일반 배송
    - 느린 배송
    - 셀렉트 박스로 하나만 선택할 수 있다.

- 예시 이미지
![image](https://user-images.githubusercontent.com/57219160/136965360-594a360d-1bdd-4e21-8c07-310d06079751.png)

- ItemType - 상품 종류
    ```
    public enum ItemType {

        BOOK("도서"), FOOD("음식"), ETC("기타");

        private final String description;

        ItemType(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }

    ```
    - 상품 종류는 ENUM을 사용한다. 설명을 위해 description 필드를 추가했다.

- 배송 방식 - DeliveryCode
    ```
    /**
    * FAST : 빠른 배송
    * NORMAL : 일반 배송
    * SLOW : 느린 배송
    */
    @Data
    @AllArgsConstructor
    public class DeliveryCode {

        private String code;
        private String displayName;
    }
    ```
    - 배송 방식은 DeliveryCode 라는 클래스를 사용한다. code 는 `FAST` 같은 시스템에서 전달하는 값이고, displayName 은 `빠른 배송` 같은 고객에게 보여주는 값이다.

- Item - 상품
    ```
    @Data
    public class Item {

        private Long id;
        private String itemName;
        private Integer price;
        private Integer quantity;

        private Boolean open; // 판매 여부
        private List<String> regions; // 등록 지역
        private ItemType itemType; // 상품 종류
        private String deliveryCode; // 배송 방식

        public Item() {
        }

        public Item(String itemName, Integer price, Integer quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }
    }
    ```
    - ENUM , 클래스, String 같은 다양한 상황을 준비했다. 각각의 상황에 어떻게 폼의 데이터를 받을 수 있는지 하나씩 알아보자.

## 체크 박스 - 단일1
- 단순 HTML 체크 박스
- resources/templates/form/addForm.html 추가
```
<hr class="my-4">

<!-- single checkbox -->
<div>판매 여부</div>
<div>
    <div class="form-check">
        <input type="checkbox" id="open" name="open" class="form-check-input">
        <label for="open" class="form-check-label">판매 오픈</label>
    </div>
</div>
```
- 상품이 등록되는 곳에 다음과 같이 로그를 남겨서 값이 잘 넘어오는지 확인해보자.
- FormItemController 추가
    - FormItemController 에 @Slf4j 애노테이션 추가
    ```
    @PostMapping("/add")
    public String addItem(Item item, RedirectAttributes redirectAttributes) {
        log.info("item.open={}", item.getOpen());
        ... 
    }
    ```

- 실행 로그
    - 아래는 콘솔에 찍힌 로그
    ```
    FormItemController : item.open=true //체크 박스를 선택하는 경우 
    FormItemController : item.open=null //체크 박스를 선택하지 않는 경우
    ```
    - 체크 박스를 체크하면 HTML Form에서 open=on 이라는 값이 넘어간다. 스프링은 on 이라는 문자를 true 타입으로 변환해준다. (스프링 타입 컨버터가 이 기능을 수행하는데, 뒤에서 설명한다.)
- 주의 - 체크 박스를 선택하지 않을 때
    - 개발자 도구로 확인해서 form data 넘어오는 것 보면, 체크 박스 선택을 하지 않으면 애초에 open 값 자체가 넘어오지 않는다.
- HTTP 요청 메시지 로깅
    - HTTP 요청 메시지를 서버에서 보고 싶으면 다음 설정을 추가하면 된다.
    - application.properties
    ```
    logging.level.org.apache.coyote.http11=debug
    ```
    - HTTP 메시지 바디를 보면 open 의 이름도 전송이 되지 않는 것을 확인할 수 있다.
    ```
    itemName=itemA&price=10000&quantity=10
    ``` 
    - 서버에서 Boolean 타입을 찍어보면 결과가 null 인 것을 확인할 수 있다.
    ```
    log.info("item.open={}", item.getOpen());
    ```

- HTML checkbox는 선택이 안되면 클라이언트에서 서버로 값 자체를 보내지 않는다. 수정의 경우에는 상황에 따라서 이 방식이 문제가 될 수 있다. 사용자가 의도적으로 체크되어 있던 값을 체크를 해제해도 저장시 아무 값도 넘어가지 않기 때문에, 서버 구현에 따라서 값이 오지 않은 것으로 판단해서 값을 변경하지 않을 수도 있다.

- 이런 문제를 해결하기 위해서 스프링 MVC는 약간의 트릭을 사용하는데, 히든 필드를 하나 만들어서, _open처럼 기존 체크 박스 이름 앞에 언더스코어(_)를 붙여서 전송하면 체크를 해제했다고 인식할 수 있다. 히든 필드는 항상 전송된다. 따라서 체크를 해제한 경우 여기에서 open 은 전송되지 않고, _open 만 전송되는데, 이 경우 스프링 MVC는 체크를 해제했다고 판단한다.

- 체크 해제를 인식하기 위한 히든 필드
```
<input type="hidden" name="_open" value="on"/>
```

- 기존 코드에 히든 필드 추가
```
<hr class="my-4">

<!-- single checkbox -->
<div>판매 여부</div>
<div>
    <div class="form-check">
        <input type="checkbox" id="open" name="open" class="form-check-input">
        <input type="hidden " name="_open" value="on"/> <!--히든 필드 추가 -->
        <label for="open" class="form-check-label">판매 오픈</label>
    </div>
</div>
```
- 실행 로그
```
FormItemController : item.open=true //체크 박스를 선택하는 경우
FormItemController : item.open=false //체크 박스를 선택하지 않는 경우
```

- 체크 박스 체크
    - `open=on&_open=on` 
    - 체크 박스를 체크하면 스프링 MVC가 open 에 값이 있는 것을 확인하고 사용한다. 이때 _open 은 무시한다.

- 체크 박스 미체크
    - `_open=on`
    - 체크 박스를 체크하지 않으면 스프링 MVC가 _open 만 있는 것을 확인하고, open 의 값이 체크되지 않았다고 인식한다.
    - 이 경우 서버에서 Boolean 타입을 찍어보면 결과가 null 이 아니라 false 인 것을 확인할 수 있다. log.info("item.open={}", item.getOpen());

- 그런데 매번 이렇게 히든으로 값을 추가해서 넘기면 너무 번거롭다. 그래서 타임리프가 제공하는 편리한 기능을 다음과 같이 사용하면 된다(체크 박스 - 단일2)


## 체크 박스 - 단일2
- 타임리프
- 개발할 때 마다 이렇게 히든 필드를 추가하는 것은 상당히 번거롭다. 타임리프가 제공하는 폼 기능을 사용하면 이런 부분을 자동으로 처리할 수 있다.

- 타임리프 - 체크 박스 코드 추가
    - 체크 박스의 기존 코드를 제거하고 타임리프가 제공하는 체크 박스 코드로 변경하자.
    ```
    <!-- single checkbox -->
    <div>판매 여부</div>
    <div>
        <div class="form-check">
            <input type="checkbox" id="open" th:field="*{open}" class="form-check-input">
            <label for="open" class="form-check-label">판매 오픈</label>
        </div>
    </div>
    ```

- 타임리프 체크 박스 HTML 생성 결과
    ```
    <!-- single checkbox -->
    <div>판매 여부</div> <div>
        <div class="form-check">
            <input type="checkbox" id="open" class="form-check-input" name="open" value="true">
            <input type="hidden" name="_open" value="on"/>
            <label for="open" class="form-check-label">판매 오픈</label>
        </div>
    </div>
    ```
    - `<input type="hidden" name="_open" value="on"/>`
    - 타임리프를 사용하면 체크 박스의 히든 필드와 관련된 부분도 함께 해결해준다. HTML 생성 결과를 보면 히든 필드 부분이 자동으로 생성되어 있다.

- 실행 로그
```
FormItemController          : item.open=true  // 체크 박스를 선택하는 경우
FormItemController          : item.open=false // 체크 박스를 선택하지 않는 경우
```

- 상품 상세에 적용하자.
    - item.html
    ```
    <hr class="my-4">

    <!-- single checkbox -->
    <div>판매 여부</div> 
    <div>
        <div class="form-check">
            <input type="checkbox" id="open" th:field="${item.open}" class="form-check-input" disabled>
            <label for="open" class="form-check-label">판매 오픈</label>
        </div>
    </div>
    ```
    - 주의: item.html 에는 th:object 를 사용하지 않았기 때문에 th:field 부분에 ${item.open} 으로 적어주어야 한다.
    - disabled 를 사용해서 상품 상세에서는 체크 박스가 선택되지 않도록 했다.
- HTML 생성 결과
```
<hr class="my-4">
<!-- single checkbox -->
<div class="form-check">
    <input type="checkbox" id="open" class="form-check-input" disabled name="open" value="true" checked="checked">
    <label for="open" class="form-check-label">판매 오픈</label> 
</div>
```
- 타임리프의 체크 확인
    - checked="checked"
    - 체크 박스에서 판매 여부를 선택해서 저장하면, 조회시에 checked 속성이 추가된 것을 확인할 수 있다. 이런 부분을 개발자가 직접 처리하려면 상당히 번거롭다. 타임리프의 th:field 를 사용하면, 값이 true 인 경우 체크를 자동으로 처리해준다.


- 상품 수정에도 적용하자.
    - editForm.html
    ```
    <hr class="my-4">

    <!-- single checkbox -->
    <div>판매 여부</div> 
    <div>
        <div class="form-check">
            <input type="checkbox" id="open" th:field="*{open}" class="form-check-input">
        <label for="open" class="form-check-label">판매 오픈</label>
        </div>
    </div>
    ...
    ```
    - 상품 수정도 th:object , th:field 를 모두 적용해야 한다.
- 실행해보면 체크 박스를 수정해도 반영되지 않는다. 실제 반영되도록 다음 코드를 수정하자.
    - ItemRepository - update() 코드를 다음과 같이 수정하자
    ```
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setItemType(updateParam.getItemType());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
    }
    ```
    - open 이외에 나머지 필드도 업데이트 되도록 미리 넣어두자.

## 체크 박스 - 멀티
- 체크 박스를 멀티로 사용해서, 하나 이상을 체크할 수 있도록 해보자.

- 등록 지역
    - 서울, 부산, 제주
    - 체크 박스로 다중 선택할 수 있다.

- FormItemController - 추가
    ```
    @ModelAttribute("regions")
    public Map<String, String> regions() {
    Map<String, String> regions = new LinkedHashMap<>(); regions.put("SEOUL", "서울");
    regions.put("BUSAN", "부산");
    regions.put("JEJU", "제주");
        return regions;
    }
    ```
    - @ModelAttribute의 특별한 사용법
        - 등록 폼, 상세화면, 수정 폼에서 모두 서울, 부산, 제주라는 체크 박스를 반복해서 보여주어야 한다. 이렇게 하려면 각각의 컨트롤러에서 model.addAttribute(...) 을 사용해서 체크 박스를 구성하는 데이터를 반복해서 넣어주어야 한다.
        - @ModelAttribute 는 이렇게 컨트롤러에 있는 별도의 메서드에 적용할 수 있다.
        - 이렇게하면 해당 컨트롤러를 요청할 때 regions 에서 반환한 값이 자동으로 모델( model )에 담기게 된다. 
        - 물론 이렇게 사용하지 않고, 각각의 컨트롤러 메서드에서 모델에 직접 데이터를 담아서 처리해도 된다.
    - LinkedHashMap 을 사용하는 이유
        - HashMap을 사용하면 순서 보장이 되지 않으므로

- addForm.html - 추가
    ```
    <!-- multi checkbox -->
    <div>
        <div>등록 지역</div>
        <div th:each="region : ${regions}" class="form-check form-check-inline">
            <input type="checkbox" th:field="*{regions}" th:value="${region.key}" class="form-check-input">
            <label th:for="${#ids.prev('regions')}" th:text="${region.value}" class="form-check-label">서울</label>
        </div>
    </div>
    ```
    - `th:for="${#ids.prev('regions')}"`
        - 멀티 체크박스는 같은 이름의 여러 체크박스를 만들 수 있다. 그런데 문제는 이렇게 반복해서 HTML 태그를 생성할 때, 생성된 HTML 태그 속성에서 name 은 같아도 되지만, id 는 모두 달라야 한다. 따라서 타임리프는 체크박스를 each루프 안에서 반복해서 만들 때 임의로 1,2,3 숫자를 뒤에 붙여준다.
        - th:fiel=*{regions}; 에서 들고 나올 때 번호를 하나씩 붙여서 나온다.
- each로 체크박스가 반복 생성된 결과 - id 뒤에 숫자가 추가
    ```
    <input type="checkbox" value="SEOUL" class="form-check-input" id="regions1" name="regions">
    <input type="checkbox" value="BUSAN" class="form-check-input" id="regions2" name="regions">
    <input type="checkbox" value="JEJU" class="form-check-input" id="regions3" name="regions">
    ```
    - HTML의 id 가 타임리프에 의해 동적으로 만들어지기 때문에 `<label for="id 값">` 으로 label 의 대상이 되는 id 값을 임의로 지정하는 것은 곤란하다. 타임리프는 ids.prev(...) , ids.next(...) 을 제공해서 동적으로 생성되는 id 값을 사용할 수 있도록 한다.


- 타임리프 HTML 생성 결과
    ```
    <!-- multi checkbox -->
    <div>
        <div>등록 지역</div>
        <div class="form-check form-check-inline">
            <input type="checkbox" value="SEOUL" class="form-check-input" id="regions1" name="regions"><input type="hidden" name="_regions" value="on"/>
            <label for="regions1" class="form-check-label">서울</label>
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" value="BUSAN" class="form-check-input" id="regions2" name="regions"><input type="hidden" name="_regions" value="on"/>
            <label for="regions2" class="form-check-label">부산</label>
        </div>
        <div class="form-check form-check-inline">
            <input type="checkbox" value="JEJU" class="form-check-input" id="regions3" name="regions"><input type="hidden" name="_regions" value="on"/>
            <label for="regions3" class="form-check-label">제주</label>
        </div>
    </div>
    ```
    - `<label for="id 값">` 에 지정된 id 가 checkbox 에서 동적으로 생성된 regions1 , regions2 , regions3 에 맞추어 순서대로 입력된 것을 확인할 수 있다.

- 로그 출력
    - FormItemController.addItem() 에 코드 추가
    ```
    log.info("item.regions={}", item.getRegions());
    ```
    - 서울, 부산 선택
    ```
    regions=SEOUL&_regions=on&regions=BUSAN&_regions=on&_regions=on
    ```
    - 로그: item.regions=[SEOUL, BUSAN]
    - 지역 선택X
    ```
    _regions=on&_regions=on&_regions=on
    ```
    - 로그: item.regions=[] // null이 아님
    -  _regions 는 앞서 설명한 기능이다. 웹 브라우저에서 체크를 하나도 하지 않았을 때, 클라이언트가 서버에 아무런 데이터를 보내지 않는 것을 방지한다. 참고로 _regions 조차 보내지 않으면 결과는 null 이 된다. _regions 가 체크박스 숫자만큼 생성될 필요는 없지만, 타임리프가 생성되는 옵션 수 만큼 생성해서 그런 것이니 무시하자.

- item.html - 추가
    ```
    <!-- multi checkbox -->
    <div>
        <div>등록 지역</div>
        <div th:each="region : ${regions}" class="form-check form-check-inline">
            <input type="checkbox" th:field="${item.regions}" th:value="${region.key}" class="form-check-input" disabled>
            <label th:for="${#ids.prev('regions')}" th:text="${region.value}" class="form-check-label">서울</label>
        </div>
    </div
    ```
    - 주의: item.html 에는 th:object 를 사용하지 않았기 때문에 th:field 부분에 ${item.regions} 으로 적어주어야 한다. disabled 를 사용해서 상품 상세에서는 체크 박스가 선택되지 않도록 했다. 
    - 타임리프의 체크 확인
        - checked="checked"
        - 멀티 체크 박스에서 등록 지역을 선택해서 저장하면, 조회시에 checked 속성이 추가된 것을 확인할 수 있다.
        - 타임리프는 th:field 에 지정한 값과 th:value 의 값을 비교해서 체크를 자동으로 처리해준다.
            - th:field="${item.regions}" 에 값이 SEOUL, BUSAN (2개를 클릭했다고 가정) 이 있는데, th:value="${region.key}" 에는 애초에 우리가 넣어둔 전체 데이터 SEOUL, BUSAN, JEJU가 있다. th:value에서 제일 처음에 SEOUL 을 확인하는데, 만약 th:field 에 SEOUL 이 들어가 있으면 checked를 넣어준다. th:value의 다음에는 BUSAN을 똑같이 확인해서 있으니 checked 넣어주고, 마지막으로 JEJU를 꺼냈는데, th:field에는 클릭 안해서 담겨있지 않으므로 checked를 넣지 않는다.

- editForm.html - 추가
```
<!-- multi checkbox -->
<div>
    <div>등록 지역</div>
    <div th:each="region : ${regions}" class="form-check form-check-inline">
        <input type="checkbox" th:field="${item.regions}" th:value="${region.key}" class="form-check-input" disabled>
        <label th:for="${#ids.prev('regions')}" th:text="${region.value}" class="form-check-label">서울</label>
    </div>
</div
```

## 라디오 버튼
- 라디오 버튼은 여러 선택지 중에 하나를 선택할 때 사용할 수 있다. 이번시간에는 라디오 버튼을 자바 ENUM을 활용해서 개발해보자.
- 상품 종류
    - 도서, 식품, 기타
    - 라디오 버튼으로 하나만 선택할 수 있다.

- FormItemController - 추가
    ```
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
    }
    ```
    - itemTypes 를 등록 폼, 조회, 수정 폼에서 모두 사용하므로 @ModelAttribute 의 특별한 사용법을 적용하자.
    - Enum.values()를 하면 enum의 값들을 배열로 반환한다.
        - ItemType.values() 를 사용하면 해당 ENUM의 모든 정보를 배열로 반환한다. 예) [BOOK, FOOD, ETC]
- 상품 등록 폼에 기능을 추가해보자.
- addForm.html - 추가
    ```
    <!-- radio button -->
    <div>
        <div>상품 종류</div>
        <div th:each="type : ${itemTypes}" class="form-check form-check-inline">
            <input type="radio" th:field="*{itemType}" th:value="${type.name()}" class="form-check-input">
            <label th:for="${#ids.prev('itemType')}" th:text="${type.description}" class="form-check-label">BOOK</label>
        </div>
    </div>
    ```
    - `th:each="type : ${itemTypes}"`에서 itemTypes은 컨트롤러에서 return ItemType.values(); 로 넘긴 값들임
    - `th:field="*{itemType}"` 에서 itemType은 Item 클래스에서 `private ItemType itemType;` 을 얘기하는 것임

- 로그 추가
```
 @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {

        log.info("item.open={}", item.getOpen());
        log.info("item.regions={}", item.getRegions());
        log.info("item.itemType={}", item.getItemType()); // 추가

        ...

```
- 실행 로그
```
item.itemType=FOOD: 값이 있을 때 item.itemType=null: 값이 없을 때
```

- 실행 결과, 폼 전송
    ```
    itemType=FOOD //음식 선택시 로그에 뜨는 값, 만약 선택하지 않으면 아무 값도 넘어가지 않는다.(null이 넘어온다)
    ```
    - 체크 박스는 수정시 체크를 해제하면 아무 값도 넘어가지 않기 때문에, 별도의 히든 필드로 이런 문제를 해결했다. 라디오 버튼은 이미 선택이 되어 있다면, 수정시에도 항상 하나를 선택하도록 되어 있으므로 체크 박스와 달리 별도의 히든 필드를 사용할 필요가 없다.

- 상품 상세와 수정에도 라디오 버튼을 넣어주자.

- item.html
    ```
    <!-- radio button -->
    <div>
        <div>상품 종류</div>
        <div th:each="type : ${itemTypes}" class="form-check form-check-inline">
            <input type="radio" th:field="${item.itemType}" th:value="${type.name()}" class="form-check-input" disabled>
            <label th:for="${#ids.prev('itemType')}" th:text="${type.description}" class="form-check-label">BOOK</label>
        </div>
    </div>
    ```
    - 주의: item.html 에는 th:object 를 사용하지 않았기 때문에 th:field 부분에 ${item.itemType} 으로 적어주어야 한다.
    - disabled 를 사용해서 상품 상세에서는 라디오 버튼이 선택되지 않도록 했다.
    - 등록 후 수정 버튼을 눌러보면 체크가 되어있다
        - th:value 와 th:field의 값이 같으면 checked를 타임리프가 자동으로 넣어준다. 
        - 소스보기를 통해서 볼 수 있다.  `checked="checked"`

- editForm.html
```
<!-- radio button -->
<div>
    <div>상품 종류</div>
    <div th:each="type : ${itemTypes}" class="form-check form-check-inline">
        <input type="radio" th:field="*{itemType}" th:value="${type.name()}" class="form-check-input">
        <label th:for="${#ids.prev('itemType')}" th:text="${type.description}" class="form-check-label">
            BOOK
        </label>
    </div>
</div>
```


- 타임리프로 생성된 HTML
    ```
    <!-- radio button -->
    <div>
        <div>상품 종류</div>
        <div class="form-check form-check-inline">
            <input type="radio" value="BOOK" class="form-check-input" id="itemType1" name="itemType">
            <label for="itemType1" class="form-check-label">도서</label>
        </div>
        <div class="form-check form-check-inline">
            <input type="radio" value="FOOD" class="form-check-input" id="itemType2" name="itemType" checked="checked">
            <label for="itemType2" class="form-check-label">식품</label>
        </div>
        <div class="form-check form-check-inline">
            <input type="radio" value="ETC" class="form-check-input" id="itemType3" name="itemType">
            <label for="itemType3" class="form-check-label">기타</label> 
        </div>
    </div>
    ```
    - 선택한 식품( FOOD )에 checked="checked" 가 적용된 것을 확인할 수 있다.

- 타임리프에서 ENUM 직접 사용하기(비추천)
    - 이렇게 모델에 ENUM을 담아서 전달하는 대신에 타임리프는 자바 객체에 직접 접근할 수 있다.
    ```
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
    }
    ```
    - 타임리프에서 ENUM 직접 접근. editForm.html 수정하기
    ```
    <div th:each="type : ${T(hello.itemservice.domain.item.ItemType).values()}">
    ```
    - `${T(hello.itemservice.domain.item.ItemType).values()}` 스프링EL 문법으로 ENUM을 직접 사용할 수 있다. ENUM에 values() 를 호출하면 해당 ENUM의 모든 정보가 배열로 반환된다.
    - 이것을 사용하면 values()들의 값들을 Model 로 안 담아와도 된다.
    - 그런데 이렇게 사용하면 ENUM의 패키지 위치가 변경되거나 할때 자바 컴파일러가 타임리프까지 컴파일 오류를 잡을 수 없으므로 추천하지는 않는다. Model에서 넘기는 것이 더 깔끔하다.


## 셀렉트 박스
- 셀렉트 박스는 여러 선택지 중에 하나를 선택할 때 사용할 수 있다. 이번시간에는 셀렉트 박스를 자바 객체를 활용해서 개발해보자.
- 배송 방식
    - 빠른 배송
    - 일반 배송
    - 느린 배송
    - 셀렉트 박스로 하나만 선택할 수 있다.

- FormItemController - 추가
    ```
    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        List<DeliveryCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
        deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
        deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
        return deliveryCodes;
    }
    ```
    - DeliveryCode 라는 자바 객체를 사용하는 방법으로 진행하겠다. (다양하게 연습하는 것임. 위에서는 Enum으로 했고 여기서는 자바 객체로~)
    - DeliveryCode 를 등록 폼, 조회, 수정 폼에서 모두 사용하므로 @ModelAttribute 의 특별한 사용법을 적용하자.
    - 참고: @ModelAttribute 가 있는 deliveryCodes() 메서드는 컨트롤러가 호출 될 때 마다 사용되므로 deliveryCodes 객체도 계속 생성된다. 이런 부분은 다른 곳에서 미리 static 으로 생성해두고 공유해서, 사용할 때만 들고와서 재사용하는 것이 더 효율적이다. 매번 메모리를 사용안해도 된다는 의미.(지웠다가 다시 생성 반복)


- addForm.html - 추가
    ```
    <!-- SELECT -->
    <div>
        <div>배송 방식</div>
        <select th:field="*{deliveryCode}" class="form-select">
            <option value="">==배송 방식 선택==</option>
            <option th:each="deliveryCode : ${deliveryCodes}" th:value="${deliveryCode.code}" th:text="${deliveryCode.displayName}">FAST</option>
        </select>
    </div>
    ```
    - `th:field="*{deliveryCode}"` 는 Item 클래스의 `private String deliveryCode; // 배송 방식` 임

- 타임리프로 생성된 HTML
```
<!-- SELECT -->
<div>
    <DIV>배송 방식</DIV>
        <select class="form-select" id="deliveryCode" name="deliveryCode"> <option value="">==배송 방식 선택==</option>
        <option value="FAST">빠른 배송</option>
        <option value="NORMAL">일반 배송</option>
        <option value="SLOW">느린 배송</option> 
    </select>
</div>
```
- 상품 상세와 수정에도 셀렉트 박스를 넣어주자.
- item.html
    ```
    <!-- SELECT -->
    <div>
        <div>배송 방식</div>
        <select th:field="${item.deliveryCode}" class="form-select" disabled>
            <option value="">==배송 방식 선택==</option>
            <option th:each="deliveryCode : ${deliveryCodes}" th:value="${deliveryCode.code}" th:text="${deliveryCode.displayName}">FAST</option>
        </select>
    </div>

    <hr class="my-4">
    ```
    - 주의: item.html 에는 th:object 를 사용하지 않았기 때문에 th:field 부분에 $ {item.deliveryCode} 으로 적어주어야 한다.
    - disabled 를 사용해서 상품 상세에서는 셀렉트 박스가 선택되지 않도록 했다.

- editForm.html
    ```        
    <!-- SELECT -->
    <div>
        <div>배송 방식</div>
        <select th:field="*{deliveryCode}" class="form-select">
            <option value="">==배송 방식 선택==</option>
            <option th:each="deliveryCode : ${deliveryCodes}" th:value="${deliveryCode.code}" th:text="${deliveryCode.displayName}">FAST</option>
        </select>
    </div>

    <hr class="my-4">
    ```
    - 상품 등록 후 수정을 눌러서 소스를 보면 `selected="selected"` 코드가 들어가 있다.
        - `th:field="*{deliveryCode}"`와 `th:value="${deliveryCode.code}"`를 비교해서 값이 같은 것이 있으면 선택을 넣어둔다. 
        - 원래도 개발자가 이런 코드 로직을 하나하나 다 넣어야 하고 엄청 귀찮은데 타임리프가 깔끔하게 다 해준다.

# 메시지, 국제화
## 프로젝트 설정
- 이전 프로젝트에 이어서 메시지, 국제화 기능을 학습해보자.
- 스프링 통합과 폼에서 개발한 상품 관리 프로젝트를 일부 수정해서 message-start 라는 프로젝트에 넣어두었다.
- 참고로 메시지, 국제화 예제에 집중하기 위해서 복잡한 체크, 셀렉트 박스 관리 기능은 제거했다.

- 프로젝트 설정 순서
    1. message-start 의 폴더 이름을 message 로 변경하자.
    2. 프로젝트 임포트
    - File Open 해당 프로젝트의 build.gradle 을 선택하자. 그 다음에 선택창이 뜨는데, Open as Project를 선택하자.
    3. ItemServiceApplication.main() 을 실행해서 프로젝트가 정상 수행되는지 확인하자.
- 실행
    - http://localhost:8080
    - http://localhost:8080/message/items

## 메시지, 국제화 소개
- 메시지
    - 악덕? 기획자가 화면에 보이는 문구가 마음에 들지 않는다고, `상품명`이라는 단어를 모두 `상품이름`으로 고쳐달라고 하면 어떻게 해야할까? 여러 화면에 보이는 상품명, 가격, 수량 등, label 에 있는 단어를 변경하려면 다음 화면들을 다 찾아가면서 모두 변경해야 한다. 지금처럼 화면 수가 적으면 문제가 되지 않지만 화면이 수십개 이상이라면 수십개의 파일을 모두 고쳐야 한다.
    - addForm.html , editForm.html , item.html , items.html
    - 왜냐하면 해당 HTML 파일에 메시지가 하드코딩 되어 있기 때문이다.
    - 이런 다양한 메시지를 한 곳에서 관리하도록 하는 기능을 `메시지 기능`이라 한다.
- 예를 들어서 messages.properteis 라는 메시지 관리용 파일을 만들고
```
item=상품 
item.id=상품 ID 
item.itemName=상품명 
item.price=가격 
item.quantity=수량
```
- 각 HTML들은 다음과 같이 해당 데이터를 key 값으로 불러서 사용하는 것이다. 그러면 수정요구 사항이 있을 경우 이 파일의 내용에서만 `상품명` -> `상품이름` 으로 수정하면 된다.
- 작은 application이면 상관없는데 큰 프로젝트 같은 경우에는 이런식으로 관리하는 것이 중요하다.
- addForm.html
```
<label for="itemName" th:text="#{item.itemName}"></label>
```
- editForm.html
```
<label for="itemName" th:text="#{item.itemName}"></label>
```


## 국제화
- 메시지에서 한 발 더 나가보자.
- 메시지에서 설명한 메시지 파일( messages.properteis )을 각 나라별로 별도로 관리하면 서비스를 국제화 할 수 있다.
- 예를 들어서 다음과 같이 2개의 파일을 만들어서 분류한다.
- messages_en.propertis
```
item=Item
item.id=Item ID
item.itemName=Item Name
item.price=price
item.quantity=quantity
```
- messages_ko.propertis
```
item=상품
item.id=상품 ID 
item.itemName=상품명 
item.price=가격 
item.quantity=수량
```
- 영어를 사용하는 사람이면 messages_en.propertis 를 사용하고, 한국어를 사용하는 사람이면 messages_ko.propertis 를 사용하게 개발하면 된다.
- 이렇게 하면 사이트를 국제화 할 수 있다.
- 한국에서 접근한 것인지 영어에서 접근한 것인지는 인식하는 방법은 (여러가지가 있지만) HTTP accept-language 해더 값을 사용하거나 사용자가 직접 언어를 선택하도록 하고, 쿠키 등을 사용해서 처리하면 된다.
- 메시지와 국제화 기능을 직접 구현할 수도 있겠지만, 스프링은 기본적인 메시지와 국제화 기능을 모두 제공한다. 그리고 타임리프도 스프링이 제공하는 메시지와 국제화 기능을 편리하게 통합해서 제공한다. 지금부터 스프링이 제공하는 메시지와 국제화 기능을 알아보자.

## 스프링 메시지 소스 설정
- 스프링은 기본적인 메시지 관리 기능을 제공한다.
- 메시지 관리 기능을 사용하려면 스프링이 제공하는 MessageSource 를 스프링 빈으로 등록하면 되는데, MessageSource 는 인터페이스이다. 따라서 구현체인 ResourceBundleMessageSource 를 스프링 빈으로 등록하면 된다. 다른 구현체들도 있는데 기본 구현체가 ResourceBundleMessageSource 이다.
- 직접 등록(굳이 직접 등록하겠다면)
    ```
    @SpringBootApplication  
    public class ItemServiceApplication {  // 메인 클래스

        public static void main(String[] args) {
            SpringApplication.run(ItemServiceApplication.class, args);
        }

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new
            ResourceBundleMessageSource();
            messageSource.setBasenames("messages", "errors");
            messageSource.setDefaultEncoding("utf-8");
            return messageSource;
        }

    }
    ```
    - basenames : 설정 파일의 이름을 지정한다.
        - messages 로 지정하면 resources 밑에 있는 messages.properties 파일을 읽어서 사용한다.
        - 추가로 국제화 기능을 적용하려면 messages_en.properties , messages_ko.properties 와 같이 파일명 마지막에 언어 정보를 주면된다. 만약 찾을 수 있는 국제화 파일이 없으면 messages.properties (언어정보가 없는 파일명)를 기본으로 사용한다.
        - 파일의 위치는 /resources/messages.properties 에 두면 된다.
        - 여러 파일을 한번에 지정할 수 있다. 여기서는 messages , errors 둘을 지정했다. ex) messages.properties, errros.properties 2개를 읽어들인다.
    - defaultEncoding : 인코딩 정보를 지정한다. utf-8 을 사용하면 된다.

- 스프링 부트
    - 스프링 부트를 사용하면 스프링 부트가 MessageSource 를 자동으로 스프링 빈으로 등록한다.
- 스프링 부트 메시지 소스 설정
    - 스프링 부트를 사용하면 다음과 같이 메시지 소스를 설정할 수 있다.
    - application.properties
    ```
    spring.messages.basename=messages,config.i18n.messages
    ```
    - 위와 같이 등록하면 2개 등록됨
        - /resources/messages.properties
        - /resources/config/i18n/messages.properties

- 스프링 부트 메시지 소스 기본 값
    ```
    spring.messages.basename=messages
    ```
    - MessageSource 를 스프링 빈으로 등록하지 않고, 스프링 부트와 관련된 별도의 설정을 하지 않으면 messages 라는 이름으로 기본 등록된다(messages.properties를 자동으로 읽어들인다). 따라서 messages_en.properties , messages_ko.properties , messages.properties 파일만 등록하면 자동으로 인식된다.
- 메시지와 관련된 spring 공식 문서에서 application.properties 에 관해서 많이 확인해 볼 수 있다.
    - https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties
- 메시지 파일 만들기
    - 메시지 파일을 만들어보자. 국제화 테스트를 위해서 messages_en 파일도 추가하자.
    - messages.properties :기본 값으로 사용(한글)
    - messages_en.properties : 영어 국제화 사용
- 주의! 파일명은 massage가 아니라 messages다! 마지막 s에 주의하자
    - /resources/messages.propertie
        - messages.properties
        ```
        hello=안녕 
        hello.name=안녕 {0}
        ```
    - /resources/messages_en.properties
        - messages_en.properties
        ```
        hello=hello
        hello.name=hello {0}
        ```


## 스프링 메시지 소스 사용
- 직접 등록이든 자동 등록이든(스프링 부트가 자동으로 해줌) 결국에는 MessageSource가 스프링 빈으로 등록이 되어있다. 등록한 메시지 파일이나(자동이든) 그런것들에 대한 설정을 스프링 빈이 다 가지고 있다. MessageSource를 불러다가 메시지를 읽어들이는 기능을 사용하면 된다. 
- MessageSource 인터페이스
    ```
    public interface MessageSource {

        String getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale);

        String getMessage(String code, @Nullable Object[] args, Locale locale) throws NoSuchMessageException;
    ```
    - MessgaeSource 인터페이스를 보면 코드를 포함한 일부 파라미터로 메시지를 읽어오는 기능을 제공한다.
    - 스프링이 제공하는 메시지 소스를 어떻게 사용하는지 테스트 코드를 통해서 학습해보자.
- test/java/hello/itemservice/message.MessageSourceTest.java
    ```
    @SpringBootTest
    public class MessageSourceTest {

        @Autowired
        MessageSource ms;

        @Test
        void helloMessage() {
            String result = ms.getMessage("hello", null, null); 
            assertThat(result).isEqualTo("안녕");
        } 
    }
    ```
    - ms.getMessage("hello", null, null)    
        - code: hello
        - args: null
        - locale: null

    - 가장 단순한 테스트는 메시지 코드로 hello 를 입력하고 나머지 값은 null 을 입력했다. locale 정보가 없으면 basename 에서 설정한 기본 이름 메시지 파일을 조회한다. basename 으로 messages 를 지정 했으므로 messages.properties 파일에서 데이터 조회한다.

- MessageSourceTest 추가 - 메시지가 없는 경우, 기본 메시지
    - 만약 찾았는데 값이 없을 경우에 사용할 수 있다.
    ```
    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
              .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("no_code", null, "기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지"); }s
    ```
    - 메시지가 없는 경우에는 NoSuchMessageException 이 발생한다.
    - 메시지가 없어도 기본 메시지( defaultMessage )를 사용하면 기본 메시지가 반환된다.


- MessageSourceTest 추가 - 매개변수 사용
    ```
    @Test
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(message).isEqualTo("안녕 Spring");
    }
    ```
    - 다음 메시지의 {0} 부분은 매개변수를 전달해서 치환할 수 있다.
    - hello.name=안녕 {0} -> Spring 단어를 매개변수로 전달 -> 안녕 Spring
- 국제화 파일 선택
    - locale 정보를 기반으로 국제화 파일을 선택한다.
    - Locale이 en_US 의 경우 messages_en_US -> messages_en -> messages 순서로 찾는다.
    - Locale 에 맞추어 구체적인 것이 있으면 구체적인 것을 찾고, 없으면 디폴트를 찾는다고 이해하면 된다.
        - 아래에서 첫번째는 locale 정보가 없으므로 기본값인 messages 를 사용, 두번째는 locale 정보가 있지만, message_ko 가 없으므로 messages 를 사용
    - MessageSourceTest 추가 - 국제화 파일 선택1
    ```
    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }
    ```
    - MessageSourceTest 추가 - 국제화 파일 선택2
    ```
    @Test
    void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
    ```
    - 위에서 ms.getMessage("hello", null, Locale.ENGLISH) : locale 정보가 Locale.ENGLISH 이므로 messages_en 을 찾아서 사용


- 이런 설정들을 실제로 웹 어플리케이션에서 어떻게 사용하는지 다음 강의!

## 웹 애플리케이션에 메시지 적용하기
- 실제 웹 애플리케이션에 메시지를 적용해보자
- 먼저 메시지를 추가 등록하자.
    - messages.properties
    ```
    label.item=상품 
    label.item.id=상품 ID 
    label.item.itemName=상품명 
    label.item.price=가격 
    label.item.quantity=수량

    page.items=상품 목록 
    page.item=상품 상세 
    page.addItem=상품 등록 
    page.updateItem=상품 수정

    button.save=저장 
    button.cancel=취소
    ```

- 타임리프 메시지 적용
    - 타임리프의 메시지 표현식 #{...} 를 사용하면 스프링의 메시지를 편리하게 조회할 수 있다. 
    - 예를 들어서 방금 등록한 상품이라는 이름을 조회하려면 #{label.item} 이라고 하면 된다.
- 렌더링 전
```
<div th:text="#{label.item}"></h2>
```

- 렌더링 후
```
<div>상품</h2>
```

- 타임리프 템플릿 파일에 메시지를 적용해보자.
    - 적용대상
        - addForm.html, editForm.html, item.html, items.html