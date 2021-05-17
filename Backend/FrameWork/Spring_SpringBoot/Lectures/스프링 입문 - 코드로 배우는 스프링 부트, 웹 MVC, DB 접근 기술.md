[스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8#) 듣고 필기한 내용

- 아래 강의 시리즈 중 첫번째 

1. [인프런(김영한) - 강의 6개짜리 로드맵](https://www.inflearn.com/roadmaps/373)
   1. [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8#)
   1. [스프링 핵심 원리 - 기본편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8#)
   1. [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#)
   1. 실전! 스프링 웹 MVC - 출시 예정
   1. 실전! 스프링 DB 접근 기술 - 출시 예정
   1. 실전! 스프링 부트 - 출시 예정


# 프로젝트 생성과 메인 메서드 실행 
- https://start.spring.io/ 접속
- 스프링 부트의 버전에서는 SNAPSHOT(만들고 있는 것)이나 M1(정식 release 버전 x) 등은 아직 안정화 X. 그래서 정식버전 중 가장 최신화
- gradle
- java 11
- Project Metadata
    - Group : 보통 회사 도메인, `hello`
        - 메인 함수의 이름은 group의 첫 글자를 대문자로 변경해서 `Hello` + `SpringApplication` = `HelloSpringApplication` 이 된다.
    - Artifact : 빌드의 결과물, 프로젝트 이름, `hello-spring`
- dependencies    
    - spring web, thymeleaf 2개만
- GENERATE
- IntelliJ 로 압축푼 폴더(`hello-spring`)의 build.gradle 파일 클릭 후 open
- 스프링 부트는 톰캣 웹 서버를 내장하고 있다.
- 메인 메서드 실행할 때 바로 자바를 실행하지 않고 gradle을 통해서 실행하게 된다면? 좀 느릴 때가 있음
    - Preferences - Setting에서 Build, Exe.. - Bulid Toos - Gradle 에서 Build and run using 과 Run tests Using을 gradle -> IntellI IDEA 로 변경
    - 바로 intelli J 에서 자바를 바로 띄워서 돌리기 때문에 빠르다. gradle을 통하지 않고 바로 실행 


# 라이브러리 살펴보기
- gradle이나 maven과 같은 빌드 툴들은 의존관계를 다 관리해준다. `spring-boot-starter-web` 하나만 명시하더라도 그와 관계된, 즉 spring-boot-starter-web 이것이 필요한 다른 것들을 알아서 다 들고와준다. 이런 것들은 `External Libraries` 에 다 나와 있다. 난 단순하게 spring-web, thymeleaf 2개만 명시했는데도 그것들이 각각 또 필요(의존)로 하는 것(B-C-D...)들을 알아서 다 들고오는 것.
- 오른쪽의 gradle을 클릭해보면 계층구조로 서로 필요한 것들을 층위구조로 다 보여준다. *는 반복을 제거한 것
- 예전에는 웹서버(was)를 직접 서버에 설치(tomcat같은 것). 거기에 자바코드를 밀어넣는 식. 그래서 웹서버와 개발 library가 분리가 되어 있었다. 그래서 tomcat서버에 들어가서 설치하는 번거로운 작업이 필요 했었다.
- 하지만 요즘에는 source library 에서 웹서버(tomcat)을 들고(embeded) 있다. 그래서 메인 메서드 실행만 해도 웹서버(8080) 이 뜬다. 그래서 빌드해서 웹서버에 올리면 끝. 
- 로그
    - slf4j 는 인터페이스이며 logback 이 구현체
    - 2가지 병행
- 테스트
    - 자바에서는 보통 JUnit 라이브러리를 쓴다. 4버전까지 엄청 오래쓰다가 이제 5로 넘어가는 추세. 


# View 환경설정
- 일반 url에 치고 들어오면 그냥 get방식
- 아래에서 파라미터 (Model model)은 스프링이 만들어서 넣어주는 것임
```
@GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
```


# 빌드하는 법, 실행 
- 이제껏은 그냥 intelli J 안에서 실행한 것이다. (8080포트 중복될 수 있으니 intelli J 안의 프로젝트는 꺼야 한다.)
- 콘솔로 이동
- 해당 프로젝트로 이동해서 (~~/hello-spring)
- 맥에서 빌드, 실행
```
./gradlew build
cd build.libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```

- 윈도우에서 빌드, 실행 (cmd창, git bash 터미널 연결하지 않은 intelli J 의 터미널 창) 
    - gradlew.bat을 실행하면 된다. (2가지 방법)
        1. gradlew 엔터
        2. gradlew build
```
gradlew 
cd build.libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```
또는 
```
gradlew build
cd build.libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```
- 윈도우에서 빌드, 실행 (git bash 터미널 연결한 intelli J 의 터미널 창 - 맥처럼)
```
./gradlew build
cd build.libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```
- 실행확인
    - http://localhost:8080/  들어가서 확인해보기

- 그래서 서버 배포할 떄는 빌드된 .jar 파일만 복사해서 `java jar ~~~.jar` 로 실행만 하면 된다. 그러면 서버에서 스프링이 동작하게 된다.

- 잘 안되면 clean   
    - 아래 명령어 실행하면 build 디렉토리 자체가 없어진다. 
    - 후에 다시 위의 명렁어들로 build
```
./gradlew clean
```


# 스프링 웹 개발 기초
- 정적 컨텐츠  
    - 그냥 정적인 페이지 자체만 브라우저로 보여주는 것
    - 스프링부트에서는 정적컨텐츠 기능을 자동으로 제공한다.
    - 특정한 페이지를 그대로 보여주는 것(`변환하지 않고`)
        - 해당 요청에 대한 것은 컨트롤러가 우선순위를 가진다. 없으면 정적인 곳에서 자원 찾아서 반환.
        - resources/static/index.html 작성 후 -> localhost:8080 들어가면 자동으로 index.html 찾음
        - resources/static/hello-static.html 작성 후 -> localhost:8080/hello-static.html 들어가면 확인 가능. (localhost:8080/hello-static.html 요청을 받으면 스프링 컨테이너는 컨트롤러에서 먼저 찾는다. 그런데 없으면 여기서 찾아서 반환)
        
    - 말 그대로 정적인 페이지만 보여주기 때문에 프로그래밍을 할 수는 없다. 
- MVC와 템플릿 엔진.
    - Model, View, Controller
    - 서버에서 동적인 컨텐츠를 컨트롤
    - 과거에는 View와 Controller가 분리되어 있지 않았다. 
        - ex) JSP
        - 소위 모델1 방식이라고 한다. view 파일 하나 안에서 db에도 접근하고 비즈니스 로직, controller 역할도 다 존재
        - 하지만 `책임분리`를 위해 나눠지게 되었다. view는 화면을 그리는데 집중. 그리고 controller나 model과 관련된 부분들은 비즈니스 로직이나 내부적인 것을 처리하는데 집중해야 한다. 
    - templates
        - 타임리프의 장점은 서버 없이 그 파일 껍데기를 그대로 열 수 있다. 예를 들어 templates/hello-templates.html 이라는 파일의 우클릭 - copy path - absolute path 얻은 후 브라우저에 복붙 하면 확인 가능
    - 작동
        - Controller
        ```  
        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
            model.addAttribute("name", name);
            return "hello-template";
        }
        ```
        - url 에서 http://localhost:8080/hello-mvc?name=june 하게 되면 templates/hello-templates.html이 열리면서 파라미터로 name=june이 들어간다. 화면에서 페이지 우클릭 - 소스보기로 확인가능
        - `viewResolver`(view를 찾아주고 템플릿 엔진 연결해줌) 가 /templates/hello-templates.html 찾아서 Thymeleaf템플릿 엔진에게 연결. 그러면 템플릿 엔진은 렌더링해서 `변환된` html을 웹브라우저에 넘겨준다. 
        ```
        <p th:text="'hello ' + ${name}">hello! empty</p>
        ```
        위에서 hello! empty 의 내용은 없어지고 hello + #{name} 으로 변환된다. 

- API
    - html 파일을 보내는 것이 아니라 프런트 쪽(view) 에 JSON 형식의 데이터를 보내주는 것. ex) client쪽(android 개발, react 등)
    - 서버끼리의 통신. 서버끼리는 html이 필요한 것이 아니라 데이터가 필요하므로.
    - 작동1(기본 - String 리턴. 잘 안 쓰지만 원리만 확인하기)
        - Controller
            - @ResponseBody가 꼭 필요하다
        ```
        @GetMapping("hello-string")
        @ResponseBody
        public String helloString(@RequestParam("name") String name) {
            return "hello " + name; // name에 highjune 넣으면 "hello highjune"이 그대로 나간다.
        }
        ```
        - url 에서 http://localhost:8080/hello-string?name=highjune 해서 들어가보면 화면에는 "hello highjune" 나온다. 그런데 중요한 점은 우클릭 페이지 소스 보기로 확인해보면 다른 것은 전혀 없고 `오직 "hello highjune" 문자 그대로 나온다.` 데이터만.
        - 물론 컨트롤러의 String 리턴값에 html 태그들을 직접 써넣으면 되긴 하지만 너무 비효율적이다.

    - @ResponseBody
        - html의 `<body></body>` 태그가 아니다.
        - http의 `body`에 데이터를 직접 넣어준다는 의미. 
    - 작동2(data 리턴해주기 - 실전)
        
        - 리턴해줄 Hello 객체 생성
        ```
        static class Hello {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        ```
        - Controller
            - 객체를 리턴해줌
        ```
        @GetMapping("hello-api")
        @ResponseBody
        public Hello helloApi(@RequestParam("name") String name) {
            Hello hello = new Hello();
            hello.setName(name);
            return hello;
        }
        ```

        - url 로 http://localhost:8080/hello-api?name=hellohellojune 로 접속하게 되면 `JSON` 형식의 데이터 리턴
        ```
        {"name":"hellohellojune"}
        ```
        - 과거에는 xml를 많이 썼지만, 무겁고 태그를 열고 닫고 등의 번거로움 존재. 요즘에는 훨씬 더 깔끔한 JSON 데이터 형식으로 주고받음. 
        - 이렇게 스프링에서는 `객체 반환 & @ResponseBody` 를 사용하여 웹브라우저나 서버에게 JSON 형식의 데이터(http의 body에 실어서)를 리턴해주는 것이 기본.(물론 xml로 변환할 수도 있음)
        - @ResponseBody가 오면 `HttpMessageConverter`가 동작한다.
            - 기본 객체처리 : `MappingJackson2HttpMessageConverter`가 JSON 으로 변환할 수 있게 작동. `객체를 JSON으로 변환해주는 대표 라이브러리가 2개 있는데 jackson, gson`. 스프링에서는 jackson을 기본적으로 탑재하도록 세팅.(물론 gson으로 변경도 가능)
        - 기본 문자처리 : `StringHttpMessageConverter`가 작동



# 회원 리포지토리 테이스 케이스 작성
- 테스트는 왜 필요한가?
    - 개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.

- 각 메서드 단위로도 테스트 해볼 수 있고, 클래스 단위로도 테스트 해볼 수 있다.
- 테스트(메서드)는 서로 의존(순서 등) 하도록 설계하면 안된다. 다 독립적으로 수행할 수 있도록 해야 한다.

- 현업에서는 빌드 툴이랑 테스트를 엮어서 빌드시, 빌드 툴에서 빌드시 테스트가 통과하지 않으면 그냥 빌드 자체를 막아버린다. 

- 클래스 단위로 여러 테스트를 실행하게 되면 독립적으로 실행했을 때의 값이 `pass`이었던 것이 `fail` 로 갑자기 변경될 수도 있다. 
    - 그 이유는?        
        - 클래스 단위로 실행하게 되면 각각의 테스트들 순서는 임의대로 정해진다.
        - 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다.
        - 특정한 메서드가 실행이 되어서 ex) 다른 객체들이 미리 저장되어 있거나 하는 등 의 상황이 발생할 수 있다.
    - 해결책은?
        - 각 테스트들이 끝나면 데이터를 `clear`를 해줘야 한다.
        - 그래서 `@AfterEach` 가 필요. 각 메서드 테스트가 종료될 때 마다 이 기능을 실행한다. 여기서는 메모리 DB에 저장된 데이터를 삭제한다.

- 나중에 test가 수백개면?
    - test 밑 패키지 우클릭 - test 패키지명~  해도 되고
    - ./gradlew test 로 해도 됨

- 위 연습에서는 클래스를 먼저 구현하고 테스트 해봤는데, 테스트를 먼저 하고 그에 맞게 개발하는 것을 `TDD` 라고 한다.
    - 나중에 협업시 코드가 몇 만, 몇십만 라인을 넘어가면 테스트 없이 개발하는 것은 불가능하다.

- 테스트 코드는 빌드될 때 포함되지 않는다.
    - 그래서 과감하게 한글로 해도 상관없다.
    ```
    @Test
    void 회원가입() {

    }
    ```
- 테스트는 정상flow 도 중요하지만 예외flow가 훨씬 더 중요하다.


# 회원 서비스 개발
- service에서는 비즈니스 로직의 의미를 담은 메서드를 생성해야 한다. 그래야만 개발자든 기획자든 서로 소통하기가 편하다. 그래서 비즈니스에 의존적인 설계를 한다. 
    - ex) join(회원가입), findMembers(전체 회원 조회)
    - 비교) repository에는 save, findByid, findByName, findAll 등 단순히 데이터를 저장소에 넣었다 뺐다 하는 느낌으로. 기계적, 개발적


# 회원 서비스 테스트
- 테스트의 3가지 문법 (주석으로 미리 영역표시하고 나서 하기)
    - given (필요한 데이터)

    - when (검증하고자 하는 것)
 
    - then (결과 값)


# 회원 서비스 개발
- @BeforeEach 설정
    - 테스트클래스마다 새로운 Repository를 생성하게 되면 각각 다 다른 메모리 Repository를 사용하는 것이므로 부적합. 그래서 하나의 객체(bean)을 만들어서 주입받는 식으로 서로 공유해서 쓴다.
    - 기존에는 회원 서비스가 메모리 회원 리포지토리를 직접 생성하게 함 -> 회원 리포지토리의 코드가 회원 서비스 코드를 DI 가능하게 변경한다.
    - 기존
    ```
    public class MemberService {
        private final MemberRepository memberRepository = new MemoryMemberRepository();
    }
    ```
    - 변경 후
    ```
    public class MemberService {
        private final MemberRepository memberRepository;

        public MemberService(MemberRepository memberRepository) {
            this.memberRepository = new memberRepository;
        }
    }
    ```

# 컴포넌트 스캔과 자동 의존관계 설정
- 컨트롤러는 서비스를 통해서 로직을 수행해야 하고(회원가입) 서비스를 통해서 데이터를 조회(회원조회)헤야 한다. -> `컨트롤러가 서비스를 의존한다.`
- spring이 동작을 할 때 spring container라는 통이 생기는데, @Controller 등을 설정해주면 해당 어노테이션들이 붙어있는 클래스들을 객체를 생성해서 그 통에 넣어둔다. 그리고 스프링이 관리한다.(=스프링에서 bean이 관리된다고 표현한다)
- 스프링이 관리를 하게 되면 다 spring container에 등록을 하고 그 spring container 로부터 다 받아서 쓸 수 있도록 변경해야 한다. 그래야만 하나의 객체를 등록만 하고 공용으로 그것만 쓰면 되는데, controller 마다 `new ~` 를 통해 생성하게 되면 비효율적
- 스프링이 뜰 때 아래에서 스프링이 관리하고 있는 MemberService를 아래 생성자에 넣어준다. 생성자가 1개만 있으면 @Autowired 는 생략할 수 있다.
```
@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
```
- 그런데 에러(`Parameter 0 of constructor in hello.hellospring.controller.MemberController required a bean of type 'hello.hellospring.service.MemberService' that could not be found.`) 라는 에러가 난다. MemberService 를 Bean으로 등록하라는 `Consider defining a bean of type 'hello.hellospring.service.MemberService' in your configuration.` 메시지가 있는데, 즉 MemberService 는 순수한 자바 클래스이므로 스프링이 알 수 있는 방법 자체가 없다.
- 그래서 `@Service` 애너테이션을 MemberService 클래스에 붙여줘야 한다. 또한 `@Repository` 애너테이션을 MemoryMemberRepository 클래스에 붙여준다. 그래야만 스프링이 뜰 때 이들을 스프링 컨테이너에 객체로 등록 후 관리를 하는 것이다.
- 의존성(`Dependency Injection`)
    - 스프링이 뜰 때 @Controller, @Service 에너테이션이 붙은 클래스를 컨테이너에 객체에 등록하고 그 생성자를 호출한다. 그런데 그 생성자에 `@Autowired`가 있으면 스프링 컨테이너에 있는 객체를 넣어준다(의존), 생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.

- 스프링을 쓰게 되면 웬만한 것들은 다 스프링 빈으로 등록해서 하는 것이 편하다. 그래야 이점이 많으므로.
- 컴포넌트 스캔의 범위는?
    - 메인 메서드가 존재하는 패키지(메인메서드가 있는 메인클래스의 package `선언부`) 를 포함한 그 하위 패키지에서만 `@Component` 를 scan한다. 물론 따로 설정으로 그 범위를 수정할 수는 있다.
    - 그래서 이 패키지를 벗어난 곳의 특정한 패키지와 클래스에 @Component 스캔을 붙인다고 해도 의미가 없다. 
    - 참고) `@SpringBootApplication` 애너테이션에 들어가보면 `@ComponentScan` 이 붙어있고 이것이 동작.

- 스프링 빈은 `싱글톤` 이다.
    - 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다. 유일하게 하나만 등록해서 공유. 따라서 같은 스프링 빈이면 모두 같은 인스턴스다. 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용한다. 메모리 절약면에서 좋음.
    - 그래서 여러 서비스들이 하나의 리포지토리를 의존했을 때, 여러 서비스들은 단 하나의 리포지토리 객체를 공유하는 것이다. 
- 의존성 주입하는 방법이 크게 2가지 (2가지 방법 다 알아야 한다) 
    1. 컴포넌트 스캔과 자동 의존관계 설정
        - 위에서 @Controller, @Service 등으로 한 것이 바로 이 방법
        - @Controller, @Service, @Repisotory 등의 어노테이션 내부에 들어가보면 다 `@Component`라는 것이 붙어있다. 스프링은 이것이 붙어있는 것들을 다 스프링 객체로 생성해서 컨테이너에 등록.
        - @Autowired 는 서로 의존관계를 설정해줌으로써 서로를 사용하게 할 수 있게끔 해주는 것이다. 


    2. 자바 코드로 직접 스프링 빈 등록하기
        - @Service, @Repository, @Autowired 애노테이션 제거
    ```
    @Configuration  
    public class SpringConfig {

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
    }        
    ```
    3. (추가) XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않으므로 생략한다.

- 참고) DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다. 의존관계가 실행중에 동적으로 변하는 경우는 거의(사실 아예) 없으므로 생성자 주입을 권장한다. (실행중에 동적으로 변한다는 것은 서버가 run되어 있는 상태에서 중간에 변경된다는 의미이다. 만약 그럴 일이 있을 때는 config 파일을 수정하고 서버를 다시 올리면 된다.) 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.  
    - 생성자 주입이 제일 좋다. application 이 처음에 실행이 될 때 조립(세팅)이 되는데, 그 후로 변경될 일이 없음으로 애초에 다 끝나는 것이 제일 좋다. 처음 조립시점에 생성자로 조립을 끝내는 것이 좋다. 
    - setter주입은 비추천, setter는 public으로 열려있어야 하기 때문에 여기저기서 불필요하게 호출될 위험이 있다. 
    - 필드주입도 비추천, 왜냐하면 중간에 바꿀 수 있는 방법이 없다. 
- 그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
- @Autowired 를 통한 DI는 helloConroller , memberService 등과 같이 스프링이 관리하는 객체에서만(컨테이너에 올라가는) 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다. 즉 @Service도 붙이지 않고 @Configuration 붙어있는 클래스에서도 직접 생성하지 않은 클래스에서 @Autowired 를 사용하면 동작하지 않는다. 
    

# 회원 웹 기능 - 홈 화면 추가
- 컨트롤러에서 아래와 같이 지정하고, `localhost:8080` 으로 들어가면 templates/home.html 이 나온다.
```
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
```
- 그런데 만약 `localhost:8080`으로 들어갔는데 컨트롤러에서 "/" 에 대한 설정이 되어 있지 않으면 static/index.html 을 찾아간다.

# 회원 웹 기능 - 등록
- 컨트롤러에서의 String return 경로
    - 아래에서 createMembersForm.html 의 위치는 templates/members/createMembersForm.html 이다.
```
@GetMapping("/members/new")
    public String createForm() {
        return "members/createMembersForm";
    }
```

- 웹 등록 화면에서 데이터를 전달 받을 폼 객체
```
package hello.hellospring.controller;
public class MemberForm {

    private String name;
    
    public String getName() {
       return name;
    }
    
    public void setName(String name) {
       this.name = name;
    }
}
```

- 한 컨트롤러 안에서 경로는 완전 동일한데 메서드가 같을 때
    - 아래에서 GetMapping("/members/new") 는 uri 에 localhost:8080/members/new 라고 입력하면 templates/members 밑에 있는 createMembersForm.html 가 연결되는 것이고, @PostMapping("/members/new") 는 말 그대로 어디에선가 Post방식으로 /members/news 로 방향을 지정했을 경우에 작동된다.
    ```
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }
    ```
    - createMembersForm.html
    ```
    ...
    <form action="/members/new" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을입력하세요">
        </div>
        <button type="submit">등록</button>
    </form>
    ...
    ```

- http 메서드 중 get은 조회할 때 주로 사용하고, post는 데이터를 폼에 넣어서 전달할 때 주로 씀

# 회원 웹 기능 - 조회
- 템플릿 언어가 렌더링 해서 여러 데이터들을 테이블에 넣어서 보여주는 것
```
<table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>이름</th>
                </tr>3
            </thead>
            <tbody>
                <tr th:each="member : ${members}">
                    <td th:text="${member.id}"></td>
                    <td th:text="${member.name}"></td>
                </tr>
            </tbody>
</table>
```
- member.id, member.name 에서는 실제 member 객체의 필드인 id, name은 private 이므로 getter 를 통해서 들고 온다. 

# H2 데이터베이스 설치
- jdbc:h2:tcp://localhost/~/test
    - 여러 곳에서 다 접속할 수 있다.
    - 파일에 직접 접근하는 것이 아니라 소켓을 통해서 접근하는 것

- h2 콘솔에서 테이블 생성
    - 자바에서의 long -> 디비에서의 bigint
    - `generated by default as identity` -> 데이터가 없이 들어오게 되면 자동으로 데이터를 채워준다.
```
drop table if exists member CASCADE;
create table member
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
```

# 순수 JDBC
- db에 접속하려면 datasource라는 것이 필요하다. 
- application.propertiedp 
```
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
```
- 위와 같이 세팅해놓으면 스프링이 datasource를 준비해놓는다. 그러면 datasource를 주입받아서 사용하면 됨. 
    - 주의) 스프링부트 2.4부터는 spring.datasource.username=sa 를 꼭 추가해주어야 한다. 그렇지 않으면 Wrong user name or password 오류가 발생한다. 참고로 다음과 같이 마지막에 공백이 들어가면 같은 오류가 발생한다. spring.datasource.username=sa 공백 주의, 공백은 모두 제거해야 한다.
- JdbcMemberRepository
```
import javax.sql.DataSource;
import java.util.List;

public class JdbcMemberRepository implements MemberRepository{

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
```

- 하드코딩 시작(JdbcMemberRepository)

- 중요) 메모리db -> 실제db 교체
    - 다른 코드는 손도 안 대고 하나만 수정해도 된다.
    - 주의) h2를 실행하고 있는 중이어야 연결가능하다. `./h2.sh`
    - 수정 전 SpringConfig
    ```
    @Configuration
    public class SpringConfig {

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
    }
    ```
    - 수정 후 SpringConfig
    ```
    @Configuration
    public class SpringConfig {

        private DataSource dataSource;

        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean 
        public MemberRepository memberRepository() {
             return new JdbcMemberRepository(dataSource);
        }
    }
    ```
    - @Configuration 도 스프링이 Bean 으로 관리하고 위처럼 생성자로 dataSource를 주입해 놓으면 dataSource 역시 스프링이 관리한다.
    - 매우 중요) 위처럼 다른 코드는 손도 안 대고 Bean 관리하는 부분만 이렇게 수정하면 JdbcMemberRepository 로 수정 연결. 즉, `다형성` 을 이용하는 것. 인터페이스를 구현한 구현체만 `쉽게 교체` 하는 것이다. 객체지향적으로 설계 한 것임. `스프링을 사용하는 이유` 가 이 과정을 쉽게 할 수 있도록 스프링 컨테이너가 지원해주는 것이다. (DI 덕분에)
    - 매우 중요) 만약 과거처럼 스프링을 사용하지 않았다면 ? MemberService가 의존하는 것이 바뀌었으므로 (memoryMemberRepisotry -> JdbcMemberRepository) MemberSerivce의 코드가 다 바뀌어야 한다. 그런데 만약 Repository(변경된) 를 의존하는 Service 들이 여러개라면?? 모든 Service들 안에서 (memoryMemberRepisotry -> JdbcMemberRepository)에 관련된 모든 코드들을 수정해야 한다. 그래서 스프링을 쓰면 assembly(조립코드)코드만 수정.
    - 이런 것을 개방-폐쇄 원칙 (ocp, open-closed principle)이라 한다. 확장에는 열려있고, 수정, 변경에는 닫혀있다. 
    - DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다. 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다. 그래서 DI를 받을 수 있다.

# 스프링 통합 테스트
- 이제 db랑 연결을 해서 테스트를 해보려고 한다. 위에서 한 test들은 다 순수한 java 코드 테스트들이었다. 그런데 db connection 정보들을 spring이 다 들고 있으므로 자바로만 할 수 없다.
- @SpringBootTest, @Transactional 를 붙이기
    - @SpringBootTest 는 스프링 컨테이너와 테스트를 함께 실행한다.
    - @Transactional 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
- 테스트 코드를 만들 때는 제일 편한 방법을 사용하면 된다. 이 테스트 코드들을 다른 곳에서 가져다가 쓰는 것이 아니므로. 그래서 의존성들을 굳이 생성자로 안해도 되고 단순 필드 주입으로 해도 된다.
- 실제로는 테스트 db용을 따로 구축해 둔다.
- 테스트를 해보면 이전에 순수한 자바코드로 테스트한 것과는 별개로 스프링이 띄워지면서(@Configuration 등 다 포함) 테스트 되는 것임.  
- @Transactional 을 붙이는 이유?
    - 테스트는 반복적으로 시행이 되어야 한다. 하지만 매번 모든 테스트들을 시행함과 동시에 @AfterEach 을 하려면 추가적인 코딩이 필요하다. 
    - 그래서 테스트에 @Transactional 를 붙이게 된다면 모든 테스트(db에 insert 등)마다 실행이 끝난 후 commit 하기 전에 rollback 을 해준다. 그래서 db에 데이터가 반영이 안되거 지워진다.

- 단위테스트?  
    - 진짜 필요하고 좋은 테스트임
    - 순수한 자바코드로만 구현한 것(최소한의 단위)
    - 어차피 db를 쓸 것인데 이것은 필요없지 않나? 절대 그렇지 않다. 순수한 단위테스트가 훨씬 더 좋은 테스트이다. 
    - 속도가 빨라서 수백개 이상의 단위테스트들을 확인하기에 편함.

- 통합테스트?
    - 스프링 컨테이너와 같이 통합하여 테스트하는 것. 꼭 스프링 컨테이너와 같이 올려야 하는 테스트라면 오히려 잘못된 테스트일 확률이 높다. 
    - 단위테스트에 비해 시간이 오래 걸린다.
    
# 스프링 JdbcTemplate
- RowMapper 사용하는 것
- 순수 Jdbc와 동일한 환경설정
```
implementation 'org.springframework.boot:spring-boot-starter-jdbc'
```
- 실무에서 많이 사용함
- 스프링 JdbcTemplate와 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.(단점 -> 그래서 jpa사용이유)

- 코드 생략
- 조립(SpringConfig)
    - 수정 전
    ```
    @Configuration
    public class SpringConfig {

        private DataSource dataSource;

        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new JdbcMemberRepository(dataSource);
     }
    ```
    - 수정 후
    ```
    @Configuration
    public class SpringConfig {

        private DataSource dataSource;

        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new JdbcTemplateMemberRepository(dataSource);
        }
    }

    ```

- db를 jdbc -> jdbctemplate 으로 수정했으니, 통합테스트만 돌려보면 된다. 매우 단순

# jpa
- JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
- JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다. 
- JPA를 사용하면 개발 생산성을 크게 높일 수 있다.
- 의존성 추가. build.gradle에 추가(아래 의존성은 jdbc도 다 포함)
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```
- application.properties
    - 아래를 추가하면 jpa가 날리는 sql문을 직접 확인할 수 있다. 왜냐하면 결국의 db에는 쿼리가 날아가야 된다. 
    ```
    spring.jpa.show-sql=true
    ```
    - 객체에 대한 테이블 자동생성을 취소. jpa는 객체를 보고 테이블을 자동으로 다 만든다. 그런데 여기에서는 이미 테이블 다 만들어놨기 때문에 자동생성을 none으로 전환. create를 사용하면 엔티티 정보를 바탕으로 테이블도 직접 생성해준다.
    ```
    spring.jpa.hibernate.ddl-auto=none
    ```
- jpa 는 인터페이스, hibernate는 구현체
    - jpa는 자바진영의 표준인터페이스, 구현은 여러업체들이라 생각하면 된다. 
- jpa를 쓰기 위해서는 Entity를 맵핑해야 한다.
    - ORM(Object - Relational - Mapping)    
    - @Entity를 붙이면 jpa가 관리하는 객체가 된다.
    - @GeneratedType(strategy = GenerationType.IDENTITY) 는 db에서 자동생성 해주는 값 설정. cf) db가 알아서 생성해주는 것을 identity 라고 한다.
    ```
    @Entity
    public class Member {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String name;

        public Long getId() {
            return id;
        }
        ...
    ```

- Repository
    - EntityManager를 주입받아야 한다. jpa는 모든 것들이 다 `EntityManager`를 통해서 동작한다. application.properties에서 `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'` 해주면 스프링부트가 알아서 EntityManager를 생성주고 db와 연결을 해준다. 이 만들어진 것을 Injection 받으면 된다. 
    - findByName일 경우에는 `jpql`이라는 객체지향 쿼리를 사용해야 한다.
        - 객체를 대상으로 쿼리를 날리는 것. 그러면 이것이 sql로 번역이 된다. from의 대상이 객체(member)이며 select도 m.id 와 같은 것이 아니라 객체(m, 즉 Member) 자체를 select한다. 
        - 원래는 m.id, m.name 등을 select 해와서 따로 mapping을 해야 하는데 jpa에서는 자동적으로 맵핑을 다 해준다.
        ```
        select m from Member m
        ```
        - 조회, 저장, 업데이트와 같은 것들은 sql(jpql) 을 짤 필요 없다. 하지만 pk 기반이 아닌 것들은 필요. 하지만 `jpa`말고 스프링으로 다시 감싼 `스프링 데이터 JPA`는 pk 기반이 아닌 것들도 필요가 없다. 

    - 코드
    ```
    package hello.hellospring.repository;

    import hello.hellospring.domain.Member;

    import javax.persistence.EntityManager;
    import java.util.List;
    import java.util.Optional;

    public class JpaMemberRepository implements MemberRepository{

        private final EntityManager em;

        public JpaMemberRepository(EntityManager em) {
            this.em = em;
        }

        @Override
        public Member save(Member member) {
            em.persist(member);
            return member;
        }

        @Override
        public Optional<Member> findById(Long id) {
            Member member = em.find(Member.class, id);
            return Optional.ofNullable(member);
        }

        @Override
        public Optional<Member> findByName(String name) {
            List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                    .setParameter("name", name)
                    .getResultList();

            return result.stream().findAny();
        }

        @Override
        public List<Member> findAll() {
            return em.createStoredProcedureQuery("select m from Member m", Member.class)
                    .getResultList();
        }
    }
    ```

- jpa 를 쓰려면 항상 트랜잭션이 있어야 한다. 그래서 Service에 @Transactional 추가
JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
```

@Transactional
public class MemberService {
    ...

```
- jpa를 세팅하면 기본적으로 jpa인터페이스의 구현체는 hibernate로 세팅이 된다.

- SpringConfig에 인터페이스 구현체 교체하기
    - 전
    ```
    @Configuration
    public class SpringConfig {

        private DataSource dataSource;

        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new JdbcTemplateMemberRepository(dataSource);
        }
        
    }
    ```

    - 후
    ```
    @Configuration
    public class SpringConfig {

        private DataSource dataSource;
        private EntityManager em;

        public SpringConfig(DataSource dataSource, EntityManager em) {
            this.dataSource = dataSource;
            this.em = em;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository() {
            return new JpaMemberRepository(em);
        }
    ```

# 스프링 데이터 JPA
- 주의) 스프링 데이터 JPA는 JPA를 편리하게 사용하도록 도와주는 기술이다. 따라서 JPA를 먼저 학습한 후에 스프링 데이터 JPA를 학습해야 한다.
- 실무에서는 JPA와 스프링 데이터 JPA를 기본으로 사용하고, 복잡한 동적 쿼리는 Querydsl이라는 라이브러리를 사용하면 된다. Querydsl을 사용하면 쿼리도 자바 코드로 안전하게 작성할 수 있고, 동적 쿼리도 편리하게 작성할 수 있다. 이 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리(일반 sql) 를 사용하거나, 앞서 학습한 스프링 JdbcTemplate를 사용하면 된다. 
- 실무에서는 jpa, spring data jpa, Querydsl 을 다 조합해서 사용한다. 
- SpringDataMemberRepository 인터페이스
    - JpaRepository 인터페이스를 받으면, 스프링 데이터 JPA가 SpringDataMemberRepository 의 구현체를 자동으로 만들어 주고 스프링 빈으로 자동 등록을 해준다. 그래서 그것을 그대로 사용하면 된다. 
```
public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
```
- SpringConfig에서 스프링 데이터 JPA가 만든 것을 그대로 사용하면 된다.
```
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
```

- 테스트를 돌려서 로그를 살펴보면 JPA와 마찬가지로 hibernate를 사용한다. 즉, 스프링 데이터 JPA는 JPA의 기술을 가져다가 사용하는 것임

- 스프링 데이터 JPA 내부에 공통적으로 사용할 수 있는 기본메서드들이 다 존재한다. 그런데 공통으로 존재할 수 없는 메서드들은?
    - 인터페이스 명명 규칙에 비밀이 있다. findByName 이라고 하면 이것은 `select m from Member m where m.name = ?` 와 같은 의미를 가지게 된다. 쿼리는 대략적으로 단순한 것들(80%) + 복잡한 것들(20%)가 있을텐데, 이 중에서 단순한 것들은 인터페이스 정의만으로 다 해결이 된다.

- 스프링 데이터 JPA 제공 기능
    - 인터페이스를 통한 기본적인 CRUD
    - findByName(), findByEmail() 처럼 메서드 이름만으로 조회 기능 제공
    - 페이징 기능 자동 제공



# AOP
- AOP가 필요한 상황
    - 모든 메소드의 호출 시간을 측정하고 싶다면?
    - 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
    - 회원 가입 시간, 회원 조회 시간을 측정하고 싶다면?
- MemberService 수정 전 (매번 시간 측정하는 로직 넣기 전)
```
...
public Long join(Member member) {
            // 같은 이름이 있는 중복 회원X
            validateDuplicateMember(member); // 중복회원 검증
            memberRepository.save(member);
            return member.getId();
    }

...

public List<Member> findMembers() {
            return memberRepository.findAll();
        }
    }
```

- MemberService 수정 후 (매번 시간 측정하는 로직 넣기) 
```    
public Long join(Member member) {

...
        long start = System.currentTimeMillis();
        try {
            // 같은 이름이 있는 중복 회원X
            validateDuplicateMember(member); // 중복회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

...

public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }

```

- 이렇게 되면 문제점은? 위와 같은 메서드가 999개라면??..
    - 회원가입, 회원 조회에 시간을 측정하는 기능은 핵심 관심 사항이 아니다. 
    - 시간을 측정하는 로직은 공통 관심 사항이다.
    - 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어렵다. 
    - 시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어렵다.
    - 시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 한다.


# AOP 적용
- AOP: Aspect Oriented Programming
- 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리

- 위에서 각각 메서드에 작업한 시간 측정 로직을 한 곳에 모으고 원하는 곳에 공통 관심 사항 적용

- aop 코드  
    - 아래 클래스를 스프링 빈으로 등록해야 하는데, @Component를 붙여도 되는데 보통은 따로 `스프링 빈으로 직접 등록`한다. 왜냐하면 단순하게 @Component를 달아서 사용하는 것은 정형화된 것들에 붙인다. 그런데 AOP같은 경우에는 정형화 된 것이라기보다 좀 특별한 것이기 때문에 따로 bean 으로 등록하는 것이 더 옳다. 그래야지 따로 `AOP가 등록되어 쓰이는구나`라고 인지하기 쉬움.
```
@Aspect
@Component
public class TimeTraceAop {

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
```

- SpringConfig 
    - 이곳에 직접 등록
    - 그런데 이 프로젝트에서는 그냥... TimeTraceAop 클래스에 간단하게 @Component 붙임
```
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    ...

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
```

- AOP의 타겟팅 설정
    - TimeTraceAop 클래스의 execute위에 어노테이션 설정
    - `@Around("execution(* hello.hellospring..*(..))")`의 의미는 hello.hellospring 패키지 밑으로 다 적용했다는 의미.  
        - 보통 패키지 레벨로 많이 한다.
        - 만약에 `@Around("execution(* hello.hellospring.service..*(..))")` 로 하게 되면 service 패키지 밑에 있는 애들만 적용된다. 
```
@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
```

- 해결
    - 회원가입, 회원 조회등 핵심 관심사항과 시간을 측정하는 공통 관심 사항을 분리한다.
    - 시간을 측정하는 로직을 별도의 공통 로직으로 만들었다.
    - 핵심 관심 사항을 깔끔하게 유지할 수 있다.
    - 변경이 필요하면 이 로직만 변경하면 된다.
    - 원하는 적용 대상을 선택할 수 있다.

- 원리  
    - 실제 클래스들의 복제라고 할 수 있는 프록시객체를 서로 의존관계들이 가리키게 되어서 AOP가 이루어진다. 물론 프록시 동작 이후에는 `joinPoint.proceed()`를 통해서 진짜 클래스 객체들이 실행되긴 한다. 
    - 이 모든 것들은 스프링 컨테이너 안에서 `DI` 이루어지기 때문에 가능한 것이다. 왜냐하면 가짜를 만들어서 DI를 해줄 수 있기 때문이다. 이것이 바로 `DI의 장점` 이라고 볼 수 있다. DI를 사용하지 않고 직접 new를 해서 사용하게 된다면 이런 작업들을 할 수 없다. 각각의 빈들은 뭐가 DI 되는지 모르는 상태에서 프록시가 들어오고 그냥 그대로 사용하게 된다. 
