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
- IntelliJ 로 압축푼 폴더(`hello-spring`)의 build.gradle 클릭 후 open
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

