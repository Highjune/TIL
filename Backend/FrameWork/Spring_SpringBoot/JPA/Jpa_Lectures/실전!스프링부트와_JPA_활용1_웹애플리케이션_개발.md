# [실전! 스프링 부트와 JPA 활용 1 - 웹 애플리케이션 개발](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1/dashboard) 강의 듣고 정리한 강의

- [JPA 로드맵](https://www.inflearn.com/roadmaps/149) 에서 야생형 첫 번째 강의
- 생략된 부분들은 pdf 파일 꼭 보기!
- 꼭 필기에 집착하지 않기.

# 프로젝트 환경설정
## 프로젝트 생성
- build.gradle에 있는 plugins의 boot 플러그인은 라이브러리들의 디펜던시까지 다 관리해준다. 그래서 이 버전만 업그레이드 해주면 다른 라이브러리의 버전까지 동시에 업그레이드 된다. 
```
id 'org.springframework.boot' version '2.6.2' 를
id 'org.springframework.boot' version '2.6.3' 으로 변경 하면 ~
```
- 하나의 라이브러리를 들고오면 관련된 다른 라이브러리들은 알아서 다 당겨온다
```
implementation 'org.springframework.boot:spring-boot-starter-web' 라고 하면 관련된 라이브러리들을 자동으로 엄청 많이 들고온다. 용량 많음
```
- dependencies {} 에서 버전을 명시하는 것과 그렇지 않은 것
    - 기본적으로 스프링부트가 2.1.7에서는 자신과 궁합이 맞는 대부분의 라이브러리 버전들을 미리 다 세팅을 해놨다. 하지만 스프링 부트가 미리 지원하지 않는 라이브러리들은 버전 정보들을 직접 적어야 한다. 
## 라이브러리 살펴보기
- intelliJ의 프로젝트 External Libraries 를 살펴봐도 되고, 터미널로 프로젝트 디렉토리에 들어가서.
```
./gradlew dependencies
```
- 위처럼 하면 라이브러리들을 다 보여준다. 또는 아래처럼
```
./gradlew dependencies —configuration compileClasspath
```
- 라이브러리 샐명 생략(pdf 보기)

## View 환경 설정
- jsp 보다는 타임리프를 쓰는 것이 더 좋음
    - 권장되는 것들 : 타임리프, 프리마커, 머스타크 등
    - 마크업을 꺠지 않고 그대로 쓰는 것. jsp나 프리마커 등 같은 것들은 중간중간에 다른 코드들이(if문 등) 들어가 있으므로 웹에서 열리지 않는다. 그러나 타임리프는 열림. 그래서 타임리프는 네츄럴 템플릿이라고 불린다.

- 렌더링하는 파일들 위치
    - templates/hello.html
- 렌더링 하지 않고 순수한 html 보여주고 싶을 경우
    - static/index.html
- spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.
    - 인텔리J 컴파일 방법: 메뉴 build Recompile
    - devtools 가 제대로 설치되면 로그에 [ restartedMain] 이라고 뜬다.

## H2 데이터베이스 설치
- 윈도우, 맥, 리눅스 실행 버전: https://h2database.com/h2-2019-10-14.zip
- 다운받아서 압축 푼 후 bin 폴더에 들어가기.(맥에서는 아래 파일 실행) (자바로 실행되므로 자바가 설치되어 있어야 한다)
```
./h2.sh
```
- 그러면 아래 주소가 자동으로 뜨는데
```
http://218.38.137.27:8082/?key=dlkasjdflkajsdfkj
```
- 주소를 localhost로 변경해준다.(뒤의 세션 key 값을 유지해줘야 한다. 파일 생성시 권한이 필요하기 떄문에)
```
localhost:8082/?key=dlkasjdflkajsdfkj
```
- 그러면 접속설정 화면이 뜬다.
    - 데이터베이스 파일 생성 방법
    - JDBC URL는 DB 파일이 생성할 경로임
        - jdbc:h2:~/jpashop (최소 한번) - 이렇게 하면 파일 모드로 실행이 된다.
            - 이렇게만 하고 '연결'₩
            - 사용자명은 sa, 비밀번호는 공백으로 그대로 다 둬도 됨
        - ~/jpashop.mv.db 파일 생성 확인
            ```
            cd ~
            ls -arlth 
            ```
            - 확인해보면 jpashop.mv.db 생성된 것 확인 가능
        - 이후 부터는 jdbc:h2:tcp://localhost/~/jpashop 이렇게 접속
            - DB파일 생성시에만 파일 모드로 접근하고 그 후에는, 네트워크 모드로 접속하는 것(TCP).

- `./h2.sh` 를 항상 실행해 놓고 가동해야 한다.
    - 만약 ./h2.sh 를 실행한 상태에서 나가버리면(터미널에서 명령어 취소) H2 DB 실행 안됨

## JPA와 DB 설정, 동작확인
- main/resources/application.yml (application.properites 삭제)
```
spring:
  datasource:
    url: jdbc:h2:tcp://localhost/~/jpashop;MVCC=TRUE # MVCC=TRUE 는 여러개가 접근할 떄 속도 빠르게
    username: sa
    password:
    driver-class-name: org.h2.Driver

  jpa:
    hibernate:
      ddl-auto: create # 자동으로 테이블 만들어줌
    properties:
      hibernate:
        show_sql: true
        format_sql: true

logging-level: 
  org.hibernate.SQL: debug
```
- spring.jpa.hibernate.ddl-auto: create
    - 이 옵션은 애플리케이션 실행 시점에 테이블을 drop 하고, 다시 생성한다.
- 참고: 모든 로그 출력은 가급적 로거를 통해 남겨야 한다.
    - show_sql : 옵션은 System.out 에 하이버네이트 실행 SQL을 남긴다.
    - org.hibernate.SQL : 옵션은 logger를 통해 하이버네이트 실행 SQL을 남긴다. 그래서 이것을 통해 로그를 출력해야 한다.

- 주의
    - application.yml 같은 yml 파일은 띄어쓰기(스페이스) 2칸으로 계층을 만듭니다. 따라서 띄어쓰 기 2칸을 필수로 적어주어야 합니다.
    - 예를 들어서 위의 datasource 는 spring: 하위에 있고 앞에 띄어쓰기 2칸이 있으므로 spring.datasource 가 됩니다. 

- 위처럼 yml 설정 방법들의 규칙 등은?
    - https://spring.io/projects/spring-boot 스프링 공식 홈페이지에서 찾아서 공부하기. 




- 실제 동작하는지 확인하기
- 회원 엔티티
```
@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;
}

```
- 회원 리포지토리
    - 스프링부트가 @PersistenceContext가 있으면 엔티티매니저를 주입해준다.
    ```
    @Repository
    public class MemberRepository {

        @PersistenceContext
        private EntityManager em;

        public Long save(Member member) {
            em.persist(member);
            return member.getId();
        }

        public Member find(Long id) {
            return em.find(Member.class, id);
        }

    }
    ```

- 테스트
    ```
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class MemberRepositoryTest {

        @Autowired MemberRepository memberRepository;

        @Test
        @Transactional
        @Rollback(false)
        public void testMember() throws Exception {
            //given
            Member member = new Member();
            member.setUsername("memberA");

            //when
            Long saveId = memberRepository.save(member);
            Member findMember = memberRepository.find(saveId);

            //then
            Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
            Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
            Assertions.assertThat(findMember).isEqualTo(member);    // JPA 엔티티 동일성 보장
        }

    }
    ```
    - 테스트
        - @SpringBootTest 는 스프링부트로 테스트를 돌려야 하므로 필요
        - @RunWith(SpringRunner.class)는 Junit에게 스프링과 관련된 것으로 테스트할 것이라는 것을 알려주는 것임
        - @Transactional은 자바, 스프링 2개 모두 다 있는데 스프링 것을 사용하는 것이 더 옵션도 많은데다가 스프링 프레임웍을 사용하므로(종속적으로 설계를 하므로) 스프링 것을 사용
            - @Test 에 @Transactional을 사용하게 될 경우, 테스트가 끝난 후 DB를 롤백을 해버린다.(데이터가 남아있으면 다른 테스트가 안되므로)
            - @Rollback(false) 를 넣게 되면 롤백을 하지 않는다. 


- jar 빌드해서 동작 확인
    - 프로젝트로 이동해서
    ```
    /gradlew clean build         // 클린하고 다시 빌드하는 것임
    ```
    - ~프로젝트/build/libs 밑에 생성된 jar 파일 확인
    ```
    cd build
    cd libs
    ll
    ```
    - jar 파일 실행 (인텔리J에서 실행한 것이 아니라 터미널에서 실행한 것)
    ```
    java -jar jpashop-0.0.1-SNAPSHOT.jar
    ```
    - http://localhost:8080/ 으로 들어가서 프로젝트 띄워져있는지 확인
    - 나가기
    ```
    exit
    ```

- 참고
    - 스프링부트를통해복잡한설정이다자동화되었다.persistence.xml 도 없고, LocalContainerEntityManagerFactoryBean 도 없다. 스프링 부트를 통한 추가 설정은 스프링 부트 메뉴얼을 참고하고, 스프링 부트를 사용하지 않고 순수 스프링과 JPA 설정 방법은 자바 ORM 표준 JPA 프로그래밍 책을 참고하자.
    - 요즘에는 순수 스프링으로 설정하지 않고 스프링 부트 메뉴얼(스프링 홈페이지) 찾아보고 application.yml에 설정해서 쓰는 것을 권장


- 쿼리 파라미터 로그 남기기
    - 개발할 때 매우 좋은 꿀팁
    - Jpa를 사용할 때 어떤 타이밍에 쿼리가 발생하는지, 데이터베이스 커넥션을 들고 오는지 궁금할 때가 많다. 특히 쿼리문에서 ?로 찍히는 부분, 즉 쿼리 파라미터가 많이 궁금할 때가 많음
    - 크게 2가지 방법
    1. 로그에 다음을 추가하기 `org.hibernate.type: trace` : SQL 실행 파라미터를 로그로 남긴다.
        - 사용 후 로그 결과
            - 쿼리에는 그대로 ? 가 찍혀서 나오는 것이 맞다.
            - `binding parameter [1] as [VARCHAR] - [memberA]`, `binding parameter [2] as [BIGINT] - [1]` 처럼 찍혀서 나옴.
    2. 외부 라이브러리 사용
        - https://github.com/gavlyukovskiy/spring-boot-data-source-decorator
            - 설정들 찾아보고 상황에 따라 적용하면 된다.
        - 스프링 부트를 사용하면 이 라이브러리만 추가하면 된다.
        ```
        implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.6'
        ```
        - 사용 후 로그 결과
            - p6spy 로그를 확인하면 커넥션 얻어오는 정보, 쿼리 파라미터가 포함된 로그를 확인 가능
    - 참고
        - 쿼리 파라미터를 로그로 남기는 외부 라이브러리는 시스템 자원을 사용하므로, 개발 단계에서는 편하게 사용해도 된다. 하지만 운영시스템에 적용하려면 꼭 성능테스트를 하고 사용하는 것이 좋다.


# 도메인 분석 설계
## 요구사항 분석
