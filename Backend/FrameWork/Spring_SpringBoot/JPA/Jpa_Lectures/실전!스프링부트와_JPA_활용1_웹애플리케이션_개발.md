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
- 생략. pdf 16 참조
## 도메인 모델과 테이블 설계
- 생략. pdf 17 참조  
## 엔티티 클래스 개발1, 2
- 예제에서는 설명을 쉽게하기 위해 엔티티 클래스에 Getter, Setter를 모두 열고, 최대한 단순하게 설계
- 실무에서는 가급적 Getter는 열어두고, Setter는 꼭 필요한 경우에만 사용하는 것을 추천
- 참고
    - 이론적으로 Getter, Setter 모두 제공하지 않고, 꼭 필요한 별도의 메서드를 제공하는게 가장 이상적 이다. 하지만 실무에서 엔티티의 데이터는 조회할 일이 너무 많으므로, Getter의 경우 모두 열어두는 것이 편리하다. Getter는 아무리 호출해도 호출 하는 것 만으로 어떤 일이 발생하지는 않는다. 하지만 Setter는 문제가 다르다. Setter를 호출하면 데이터가 변한다. Setter를 막 열어두면 가까운 미래에 엔티티에가 도대 체 왜 변경되는지 추적하기 점점 힘들어진다. 그래서 엔티티를 변경할 때는 Setter 대신에 변경 지점이 명확하도록 변경을 위한 비즈니스 메서드를 별도로 제공해야 한다.

- 회원 엔티티
    - 내장타입은 해당하는 필드에 @Embedded를 붙이거나 해당하는 클래스(Address)에 @Embeddable를 붙이거나 둘 중 하나만 하면 되지만 보통 2개 다 명시해준다.
    ```
    @Entity
    @Getter
    @Setter
    public class Member {

        @Id @GeneratedValue
        @Column(name = "member_id")
        private Long id;

        private String name;

        @Embedded
        private Address address;

        @OneToMany(mappedBy = "member") // 연관관계의 주인이 아님. 매핑된 테이블의 거울일 뿐. 여기에 값을 넣는다고 해서 FK의 값의 변경되지 않는다.
        private List<Order> orders = new ArrayList<>();
    }
    ```
    - 참고: 엔티티의 식별자는 id 를 사용하고 PK 컬럼명은 member_id 를 사용했다. 엔티티는 타입(여기서는 Member )이 있으므로 id 필드만으로 쉽게 구분할 수 있다. 테이블은 타입이 없으므로 구분이 어렵다. 그리고 테이블은 관례상 테이블명 + id 를 많이 사용한다. 참고로 객체에서 id 대신에 memberId 를 사용해도 된다. 중요한 것은 일관성이다.

- 기타 엔티티 생략

- 참고
    - 실무에서는 @ManyToMany 를 사용하지 말자
    - @ManyToMany 는 편리한 것 같지만, 중간 테이블( CATEGORY_ITEM )에 컬럼을 추가할 수 없고(등록일, 수정일 등), 세밀하게 쿼리를 실행하기 어렵기 때문에 실무에서 사용하기에는 한계가 있다. 중간 엔티티( CategoryItem 를 만들고 @ManyToOne, @OneToMany 로 매핑해서 사용하자. 정리하면 대다대 매핑을 일대다, 다대일 매핑으로 풀어 내서 사용하자.

- 주소 값 타입
    ```
    @Embeddable
    @Getter
    public class Address {

        private String city;
        private String street;
        private String zipcode;

        protected Address() {
        }

        public Address(String city, String street, String zipcode) {
            this.city = city;
            this.street = street;
            this.zipcode = zipcode;
        }
    }
    ```
    - 값 타입은 변경 불가능하게 설계해야 한다.
        - @Setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자. JPA 스펙상 엔티티나 임베디드 타입( @Embeddable )은 자바 기본 생성자(default constructor)를 public 또는 protected 로 설정해야 한다. public 으로 두는 것 보다는 protected 로 설정하는 것이 그나마 더 안전하다.
        - JPA가 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을 사용할 수 있도록 지원해야 하기 때문이다.


- Foreign Key를 꼭 걸어야 하는가?
    - 시스템마다 다름. 실시간 트래픽 엄청 중요하고 정합성보다는 유연하게 잘 운영되는 서비스가 필요하면 Foreign Key 빼고 인덱스만 잘 잡아도 된다. 하지만 데이터가 항상 무조건 다 맞아야 하는(돈과 관련된) 것이라면 Foreign Key 걸기.

- cascade = CascadeType.All 옵션
    ```
    @Entity
    @Table(name = "orders")
    @Getter @Setter
    public class Order {

        ...

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        private List<OrderItem> orderItems = new ArrayList<>();
        ...

    }
    ```
    - cascade = CascadeType.ALL 옵션이 들어가게 되면 orderItem에 데이터를 넣어두고, Order를 저장하게 되면 Order가 저장이 될 때 orderItem도 동시에 저장이 다 된다. 원래는 orderItems를 저장한 후 그 후에 Order가 저장이 된다. 그리고 ALL이므로 delete할 때도 다 같이 지워진다.
    ```
    // 기존
    persist(orderItemA)
    persist(orderItemB)
    persist(orderItemC)
    persist(order)

    // 옵션 적용 후 코드가 간략하게 됨
    persist(order)
    ```

- 연관관계 편의 메서드
    - Order와 Member 관계에서 결국 둘 다 값을 넣어야 할 텐데(물론 DB에서는 연관관계의 주인인 Order쪽만 값을 넣으면 되지만) 로직상 어느 한 쪽을 빼거나 할 수도 있다. 그렇기 때문에 원자화 해서 둘을 묶어두는 것
    - 원래는 아래 처럼 해야 하지만!
    ```
    Member member = new Membmer();
    Order order = new Order();

    member.getOrders().add(order);
    order.setMember(member);
    ```
    - 아래처럼 다 묶어두기!
    ```
    //==연관관계 편의 메서드 ===, Member와 Order의 관계 //
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    
    //==연관관계 편의 메서드 ===, Order와 OrderItem
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    //==연관관계 편의 메서드 ===, Delivery와 Order
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    ```
    - 연관관계 메서드의 위치는 양쪽 중에서 핵심적으로 컨트롤 하는 곳에 두는 것이 낫다.


## 엔티티 설계시 주의점
- 엔티티에는 가급적 Setter를 사용하지 말자
    - 현재까지 코드들은 Setter가 모두 열려있다. 변경 포인트가 너무 많아서, 유지보수가 어렵다. 나중에 리펙토링으로 Setter 제거

- (매우 중요) 모든 연관관계는 지연로딩으로 설정! 해야 한다.
    - 무조건 암기
    - 즉시로딩( EAGER )은 예측이 어렵고, 어떤 SQL이 실행될지 추적하기 어렵다. 특히 JPQL을 실행할 때 N+1 문제가 자주 발생한다.
    - 실무에서 모든 연관관계는 지연로딩( LAZY )으로 설정해야 한다.
    - 연관된 엔티티를 함께 DB에서 조회해야 하면, fetch join 또는 엔티티 그래프 기능을 사용한다.
    - @XToOne(OneToOne, ManyToOne) 관계는 기본이 즉시로딩이므로 직접 지연로딩으로 설정해야 한다.

- 컬렉션은 필드에서 초기화 하자. 컬렉션은 필드에서 바로 초기화 하는 것이 안전하다.
    - null 문제에서 안전하다.
    - 즉 아래에서 생성자보다는 필드에서 바로 초기화 하는 것이 낫다.
    ```
    // 필드에서 바로 초기화
    @OneToMany(MappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    ```
    ```
    // 생성자 초기화
    @OneToMany(MappedBy = "member")
    private List<Order> orders;

    public MembeR() {
        orderes = new ArrayList<>();
    }
    ```
    - 하이버네이트는 엔티티를 영속화 할 때, 컬랙션을 감싸서 하이버네이트가 제공하는 내장 컬렉션으로 변경한다. 만약 getOrders() 처럼 임의의 메서드에서 컬력션을 잘못 생성하면 하이버네이트 내부 메커니즘에 문 제가 발생할 수 있다. 따라서 필드레벨에서 생성하는 것이 가장 안전하고, 코드도 간결하다.
    ```
    Member member = new Member();
    System.out.println(member.getOrders().getClass());
    em.persist(team);
    System.out.println(member.getOrders().getClass());

    //출력 결과
    class java.util.ArrayList
    class org.hibernate.collection.internal.PersistentBag
    ```
    - 위에서 보면 변경되어 있음. hibernate는 컬렉션이 변경된 것을 추적해야 하므로 hibernate가 추적할 수 있는 것(ex. PersistentBag) 으로 변경함. 그런데 기껏 PersistentBag로 변경했는데 다시 setOrders() 해서 변경해버리면 hibernate가 원하는 메커니즘으로 돌아가지 않는다. 그래서 orders 커넥션을 가급적 꺼내지도 말고 꺼냈으면 수정하면 안된다. 


- 테이블, 컬럼명 생성 전략
    - 스프링 부트에서 하이버네이트 기본 매핑 전략을 변경해서 실제 테이블 필드명은 다름
    - https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#howto- configure-hibernate-naming-strategy
    - http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/ Hibernate_User_Guide.html#naming


    - SpringPhysicalNamingStrategy 클래스에 변경 로직이 들어가 있음
    - 하이버네이트 기존 구현: 엔티티의 필드명을 그대로 테이블의 컬럼명으로 사용 
    - 스프링 부트 신규 설정(엔티티(필드) -> 테이블(컬럼))
        1. 카멜 케이스 -> 언더스코어 (memberPoint -> member_point, orderDate -> order_date)
        2. .(점) -> _(언더스코어)
        3. 대문자 -> 소문자

    - 적용 2단계
        1. 논리명 생성 : 명시적으로 컬럼, 테이블명을 직접 적지 않으면 ImplicitNamingStrategy 사용.
            - spring.jpa.hibernate.naming.implicit-strategy : 테이블이나, 컬럼명을 명시하지 않을 때 논리명 적용,

        2. 물리명 적용 
            - spring.jpa.hibernate.naming.physical-strategy : 모든 논리명에 적용됨, 실제 테이블에 적용 (username -> usernm 등으로 회사 룰로 바꿀 수 있음)


- 스프링 부트 기본 설정
```
spring.jpa.hibernate.naming.implicit-strategy:
org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy

spring.jpa.hibernate.naming.physical-strategy:
org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy 
```

# 애플리케이션 구현 준비
## 구현 요구사항
- 생략. pdf 32 참조
## 애플리케이션 아키텍쳐 
- 생략. pdf 33 참조

# 회원 도메인 개발
## 회원 리포지토리 개발
- 회원 리포지토리 코드
```
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

```
- 기술 설명
    - @Repository : 스프링 빈으로 등록, JPA 예외를 스프링 기반 예외로 예외 변환
    - @PersistenceContext : 엔티티 메니저( EntityManager ) 주입
    - @PersistenceUnit : 엔티티 메니터 팩토리( EntityManagerFactory ) 주입

- 기능 설명
    - save()
    - findOne()
    - findAll()
    - findByName()
## 회원 서비스 개발
- 회원 서비스 코드
```
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
```
- 기술 설명
    - @Transactional : 트랜잭션, 영속성 컨텍스트
        - 클래스 단위에 @Transactional(readOnly = true) 붙이면 public 메서드에 다 적용. 
        - readOnly=false 가 기본값이다. 클래스 단위로 만약 @Transactional(readOnly = true) 붙이고 특정한 메서드에 @Transactional 만 붙이면 우선권을 가지게 된다. 그래서 readOnyl=false가 그 메서드에 적용되는 것임
        - readOnly=true : 데이터의 변경이 없는 읽기 전용 메서드에 사용, 영속성 컨텍스트를 플러시 하지 않 으므로 약간의 성능 향상(읽기 전용에는 다 적용). 쓰기에는 사용하면 안됨(데이터 변경이 안됨)
        - 데이터베이스 드라이버가 지원하면 DB에서 성능 향상
    - @Autowired
        - 생성자 Injection 많이 사용, 생성자가 하나면 생략 가능
        - 스프링부트 라이브러리를 사용하면 EntityManager 에 @PersistenceContext 대신 @Autowired를 붙여도 주입이 된다. 스프링부트 Jpa 가 지원을 해주는 것임. 원래 사실은 EntityManager는 @Autowired로 안되고 무조건 @PersistenceContext가 있어야 주입이 되는데 스프링부트 Jpa 가 지원해줌

- 기능 설명
    - join()
    - findMembers()
    - findOne()

- 참고
    - 실무에서는 검증 로직이 있어도 멀티 쓰레드 상황을 고려해서 회원 테이블의 회원명 컬럼에 유니크 제약 조건을 추가하는 것이 안전하다. 
    - 스프링 필드 주입 대신에 생성자 주입을 사용하자.

## 회원 기능 테스트
- 테스트 요구사항
    - 회원가입을 성공해야 한다.
    - 회원가입 할 때 같은 이름이 있으면 예외가 발생해야 한다.

- 회원가입 테스트 코드
    ```

    @RunWith(SpringRunner.class)
    @SpringBootTest
    @Transactional // 롤백을 위해
    public class MemberServiceTest {

        @Autowired MemberService memberService;
        @Autowired MemberRepository memberRepository;
        @Autowired EntityManager em;

        @Test
        public void 회원가입() throws Exception {
            //given
            Member member = new Member();
            member.setName("kim");

            //when
            Long savedId = memberService.join(member);

            //then
            assertEquals(member, memberRepository.findOne(savedId));
        }

        @Test(expected = IllegalStateException.class)
        public void 중복_회원_예외() throws Exception {
            //given
            Member member1 = new Member();
            member1.setName("kim");

            Member member2 = new Member();
            member2.setName("kim");

            //when
            memberService.join(member1);
            memberService.join(member2); // 예외가 발생해야 한다!!

            //then
            fail("예외가 발생해야 한다.");

        }
    }
    ```
    - 기술 설명
        - @RunWith(SpringRunner.class) : 스프링과 테스트 통합
        - @SpringBootTest : 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
        - @Transactional : 반복 가능한 테스트 지원, 각각의 테스트를 실행할 때마다 트랜잭션을 시작하고 테스트가 끝나면 트랜잭션을 강제로 롤백 (이 어노테이션이 테스트 케이스에서 사용될 때만 롤백)

    - 기능 설명
        - 회원가입 테스트
        - 중복 회원 예외처리 테스트

- 참고: 테스트 케이스 작성 고수 되는 마법: Given, When, Then(http://martinfowler.com/bliki/GivenWhenThen.html)
    - 이 방법이 필수는 아니지만 이 방법을 기본으로 해서 다양하게 응용하는 것을 권장한다.

- 테스트 케이스를 위한 설정
    - 테스트는 케이스 격리된 환경에서 실행하고, 끝나면 데이터를 초기화하는 것이 좋다. 그런 면에서 메모리 DB를 사용하는 것이 가장 이상적이다. 지금껏 사용해온 것인 외부적인 DB(h2) 를 설치하고 터미널에서 가동해서 사용한 것이다.
    - 그래서 메모리에서만 테스트가 가능할 수 있도록 h2 메모리 DB를 사용하면 된다. 그러면 설치도 필요없음.
    - 추가로 테스트 케이스를 위한 스프링 환경과, 일반적으로 애플리케이션을 실행하는 환경은 보통 다르므로 설정 파일을 다르게 사용하자. 파일을 따로 두는 것이 맞다!
    - 다음과 같이 간단하게 테스트용 설정 파일을 추가하면 된다.

- test/resources/application.yml
    - 이 곳에 설정 파일을 두면 test는 src/main/resources/application.yml을 우선하는 것이 아니라 이 곳에 있는 설정 파일에 우선순위를 둔다.
    - h2 메모리 DB를 사용하기 위해서는 https://h2database.com/html/cheatSheet.html 에서 In-Memory 설정값 들고오면 됨.   
    ```
    spring:
    datasource:
        url: jdbc:h2:mem:test
        username: sa
        password:
        driver-class-name: org.h2.Driver

    jpa:
        hibernate:
        ddl-auto: create # 자동으로 테이블 만들어줌
        properties:
        hibernate:
    #        show_sql: true   # System.out을 통해서 출력
            format_sql: true

    logging.level:
    org.hibernate.SQL: debug  # log를 통해서 출력
    org.hibernate.type: trace
    ```
    - 그래서 위와 같이 한 후 기존의 설치한 h2 DB 내린 후에 다시 테스트하면 다 통과가 된다.
    - 로그에서 p6spy에서 찍은 커넥션 정보를 보면 url jdbc:h2:mem:test 가 나온다.

- 하지만 !! 
    - 아래처럼 다 설정을 없애더라도 스프링부트가 기본적으로 메모리 모드로 가동한다.
    - 스프링 부트는 datasource 설정이 없으면, 기본적을 메모리 DB를 사용하고, driver-class도 현재 등록된 라이브러를 보고 찾아준다. (극단적으로 텅 빈 application.yml이어도 마찬가지임)
    ```
    spring:
    #  datasource:
    #    url: jdbc:h2:mem:test
    #    username: sa
    #    password:
    #    driver-class-name: org.h2.Driver

    #  jpa:
    #    hibernate:
    #      ddl-auto: create # 자동으로 테이블 만들어줌
    #    properties:
    #      hibernate:
    #        show_sql: true   # System.out을 통해서 출력
    #        format_sql: true

    logging.level:
    org.hibernate.SQL: debug  # log를 통해서 출력
    org.hibernate.type: trace
    ```
    - 똑같이 테스트가 다 통과가 되고 로그를 보면 마찬가지로 url jdbc:h2:mem:test 가 나온다.

- 추가로 ddl-auto 도 create-drop 모드로 동작한다. 따라서 데이터소스나, JPA 관련된 별도의 추가 설정을 하지 않아도 된다.
    - create는 가지고 있는 Entity 다 드랍한 후에 create 하고 애플리케이션 실행
    - create-drop는 create와 똑같은데 애플리케이션 종료 시점에 drop 쿼리 다 날리고 완전히 깨끗하게 없앰.


# 상품 도메인 개발
## 상품 엔티티 개발(비즈니스 로직 추가)
- 상품 엔티티 코드
```

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)// 상속관계 전략 중 싱글테이블 전략
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//

    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     *
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity -= quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
```
- 예외 추가
    - 그냥 오버라이딩 메서드만 나열한 것임
    ```

    public class NotEnoughStockException extends RuntimeException{

        public NotEnoughStockException() {
            super();
        }

        public NotEnoughStockException(String message) {
            super(message);
        }

        public NotEnoughStockException(String message, Throwable cause) {
            super(message, cause);

        }

        public NotEnoughStockException(Throwable cause) {
            super(cause);
        }

        protected NotEnoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
    ```
- 비즈니스 로직 분석
    - addStock() 메서드는 파라미터로 넘어온 수만큼 재고를 늘린다. 이 메서드는 재고가 증가하거나 상품 주 문을 취소해서 재고를 다시 늘려야 할 때 사용한다.
    - removeStock() 메서드는 파라미터로 넘어온 수만큼 재고를 줄인다. 만약 재고가 부족하면 예외가 발생한다. 주로 상품을 주문할 때 사용한다.
    - 보통은 setter를 사용해서 item의 재고를 조정하는 식으로 보통 코딩을 많이 할 텐데, 이런 식으로 그 객체 자체에서 그냥 add, remove 비즈니스 메서드를 만들어서 처리하는 것이 훨씬 더 응집력 있는 객체지향적 코드라고 할 수 있다.

## 상품 리포지토리 개발
- 상품 리포지토리 코드
```

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) { // item은 jpa에 저장하기 전까지 id값이 없으므로.
            em.persist(item); // 신규 등록
        } else {
            em.merge(item); // 이미 DB에 한 번 등록이 된 것을 가져오는 것. 즉 update와 비슷한 개념
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}

```