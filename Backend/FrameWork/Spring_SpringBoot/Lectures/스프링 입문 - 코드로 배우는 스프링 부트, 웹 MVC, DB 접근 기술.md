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
    - Setting에서 Build, Exe.. - Bulid Toos - Gradle 에서 Build and run using 과 Run tests Using을 gradle -> IntellI IDEA 로 변경
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
- 이제껏은 그냥 intelli J 안에서 실행한 것이다. (8080포트 중복될 수 있으니 intelli J 안의 )
- 콘솔로 이동
- 해당 프로젝트로 이동해서 (~~/hello-spring)
- 맥에서 빌드, 실행
```
./gradlew build
cd build/libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```

- 윈도우에서 빌드, 실행 (cmd창, git bash 터미널 연결하지 않은 intelli J 의 터미널 창) 
    - gradlew.bat을 실행하면 된다. (2가지 방법)
        1. gradlew 엔터
        2. gradlew build
```
gradlew 
cd build/libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```
또는 
```
gradlew build
cd build/libs
java -jar  hello-spring-0.0.1-SNAPSHOT.jar
```
- 윈도우에서 빌드, 실행 (git bash 터미널 연결한 intelli J 의 터미널 창 - 맥처럼)
```
./gradlew build
cd build/libs
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
        - url 에서 http://localhost:8080/hello-mvc?name=june 하게 되면 templates/hello-templates.html이 열리면서 파라미터로 name=june이 들어간다. 화면에서 페이지 우클릭 - 소스보기로 확인가능. 만약에 ?name=june 이란 것(파라미터)을 넘기지 않고 http://localhost:8080/hello-mvc만 넣으면 에러난다. 왜냐하면 파라미터를 @RequestParam으로 반드시 받기로 했으므로, 파라미터를 포함(get메서드이므로 url에) 시켜줘야 한다.
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
        - 이렇게 스프링에서는 `객체 반환 & @ResponseBody` 를 사용하면 웹브라우저나 서버에게 JSON 형식의 데이터(http의 body에 실어서)를 리턴해주는 것이 기본.(물론 xml로 변환할 수도 있음)
        - @ResponseBody가 오면 `HttpMessageConverter`가 동작한다.
            - 기본 객체처리 : `MappingJackson2HttpMessageConverter`가 JSON 으로 변환할 수 있게 작동. `객체를 JSON으로 변환해주는 대표 라이브러리가 2개 있는데 jackson, gson`. 스프링에서는 jackson을 기본적으로 탑재하도록 세팅.(물론 gson으로 변경도 가능)
        - 기본 문자처리 : `StringHttpMessageConverter`가 작동



# 회원 리포지토리 테이스 케이스 작성
- 테스트는 왜 필요한가?
    - 개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.
    - 나 경험담) 모든 api들을 직접 확인하기 위해서 postman을 통해서 하나하나 직접 테스트 해볼 때의 고통과 시간 비효율성을 생각하자!!

- 각 메서드 단위로도 테스트 해볼 수 있고, 클래스 단위로도 테스트 해볼 수 있다.
- 테스트(메서드)는 서로 의존(순서 등) 하도록 설계하면 안된다. 다 `독립적으로` 수행할 수 있도록 해야 한다.
    

- 주의) 클래스 단위로 실행하게 되면 독립적으로 실행했을 때 `pass`이었던 것이 `fail` 로 갑자기 변경될 수도 있다. 
    - 그 이유는?        
        - 클래스 단위로 실행하게 되면 각각의 테스트들 순서는 임의대로 정해진다.
        - 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게 되면 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다.
        - 특정한 메서드가 실행이 되어서 다른 객체들이 미리 저장되어 있거나 하는 등 의 상황이 발생할 수 있다.
    - 해결책은?
        - 각 테스트들이 끝나면 데이터를 `clear`를 해줘야 한다.
        - 그래서 `@AfterEach` 가 필요. 각 테스트가 종료될 때 마다 이 기능을 실행한다. 여기서는 메모리 DB에 저장된 데이터를 삭제한다.

- 나중에 test가 수백개면?
    - test 밑 패키지 우클릭 - test 패키지명~  해도 되고
    - ./gradlew test 로 해도 됨

- 사실 위에서는 클래스를 먼저 구현하고 테스트 해봤는데, (원래는) 테스트를 먼저 하고 그에 맞게 개발하는 것을 `TDD` 라고 한다.
    - 나중에 협업시 코드가 몇 만, 몇십만 라인을 넘어가면 테스트 없이 개발하는 것은 불가능하다.

- 테스트 코드는 빌드될 때 포함되지 않는다.
    - 그래서 과감하게 한글로 해도 상관없다.
    ```
    @Test
    void 회원가입() {

    }
    ```

# 회원 서비스 개발
- service에서는 비즈니스 로직의 의미를 담은 메서드를 생성해야 한다. 그래야만 개발자든 기획자든 서로 소통하기가 편하다. 그래서 비즈니스에 의존적인 설계를 한다. 
    - ex) join(회원가입), findMembers(전체 회원 조회)
    - 비교) repository에는 save, findByid, findByName, findAll 등 단순히 데이터를 저장소에 넣었다 뺐다 하는 느낌만.


# 회원 서비스 테스트
- 테스트의 3가지 문법
    - given

    - when

    - then

- 
