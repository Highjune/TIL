# [실전! 스프링 부트와 JPA 활용 1 - 웹 애플리케이션 개발](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1/dashboard) 강의 듣고 정리한 강의

- [JPA 로드맵](https://www.inflearn.com/roadmaps/149) 에서 야생형 첫 번째 강의
- 생략된 부분들은 pdf 파일 꼭 보기!
- 꼭 필기에 집착하지 않기.
- [코드](https://github.com/Highjune/Jpa_Lecture1_Use_Kim_Young_Han/tree/master)

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
- 기능 설명
    - save()
        - id 가 없으면 신규로 보고 persist() 실행
        - id 가 있으면 이미 데이터베이스에 저장된 엔티티를 수정한다고 보고, merge() 를 실행, 자세한 내용은 뒤에 웹에서 설명(그냥 지금은 저장한다 정도로 생각하자)

## 상품 서비스 개발
- 상품 서비스 코드
```
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}

```
- 상품 서비스는 상품 리포지토리에 단순히 위임만 하는 클래스

- 상품 기능 테스트
    - 상품 테스트는 회원 테스트와 비슷하므로 생략(영상에서 자체 생략함)


# 주문 도메인 개발
- 구현 기능 및 순서 생략

## 주문, 주문상품 엔티티 개발
- 주문 엔티티 개발
- 주문 엔티티 코드
    ```
    @Entity
    @Table(name = "orders")
    @Getter @Setter
    public class Order {

        @Id @GeneratedValue
        @Column(name = "order_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)  // 연관관계의 주인
        @JoinColumn(name = "member_id")
        private Member member;  // 여기에 값을 세팅하면 member_id(FK) 값이 변경된다.

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        private List<OrderItem> orderItems = new ArrayList<>();

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "delivery_id")
        private Delivery delivery;  // 배송 정보

        private LocalDateTime orderDate;    // 주문시간

        @Enumerated(EnumType.STRING)
        private OrderStatus status; // 주문상태 (ORDER, CANCEL)

        //==연관관계 편의 메서드 ===, Member와 Order
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

        //==생성 메서드==//
        public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
            Order order = new Order();
            order.setMember(member);
            order.setDelivery(delivery);
            for (OrderItem orderItem : orderItems) {
                order.addOrderItem(orderItem);
            }
            order.setStatus(OrderStatus.ORDER);
            order.setOrderDate(LocalDateTime.now());
            return order;
        }

        //==비즈니스 로직==//
        /**
        * 주문 취소
        */
        public void cancel() {
            if (delivery.getStatus() == DeliveryStatus.COMP) { // 이미 배송완료(COMP) 라면/
                throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
            }

            this.setStatus(OrderStatus.CANCEL);
            for (OrderItem orderItem : orderItems) {
                orderItem.cancel();
            }
        }

        //==조회 로직==//
        /**
        * 전체 주문 가격 조회
        */
        public int getTotalPrice() {
    //        return orderItems.stream()
    //                .mapToInt(OrderItem::getTotalPrice)
    //                .sum();
            int totalPrice = 0;
            for (OrderItem orderItem : orderItems) {
                totalPrice += orderItem.getTotalPrice();
            }
            return totalPrice;
        }

    }

    ```
    - 기능 설명
        - 생성 메서드( createOrder() ): 주문 엔티티를 생성할 때 사용한다. 주문 회원, 배송정보, 주문상품의 정보 를 받아서 실제 주문 엔티티를 생성한다.
        - 주문 취소( cancel() ): 주문 취소시 사용한다. 주문 상태를 취소로 변경하고 주문상품에 주문 취소를 알린다. 만약 이미 배송을 완료한 상품이면 주문을 취소하지 못하도록 예외를 발생시킨다.
        - 전체 주문 가격 조회: 주문 시 사용한 전체 주문 가격을 조회한다. 전체 주문 가격을 알려면 각각의 주문상품 가격을 알아야 한다. 로직을 보면 연관된 주문상품들의 가격을 조회해서 더한 값을 반환한다. (실무에서는 주로 주문에 전체 주문 가격 필드를 두고 역정규화 한다.)

- 주문상품 엔티티 개발
- 주문상품 엔티티 코드
    ```

    @Entity
    @Getter @Setter
    public class OrderItem {

        @Id @GeneratedValue
        @Column(name = "order_item_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_id")
        private Item item;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")  // 연관관계 주인
        private Order order;

        private int orderPrice; // 주문 가격
        private int count;  // 주문 수량

        //==생성 메서드==//
        public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setOrderPrice(orderPrice);
            orderItem.setCount(count);

            item.removeStock(count);
            return orderItem;
        }

        //==비즈니스 로직==//
        public void cancel() {
            getItem().addStock(count);
        }

        //==조회 로직==//

        /**
        * 주문상품 전체 가격 조회
        */
        public int getTotalPrice() {
            return getOrderPrice() * getCount();
        }
    }

    ```
    - 기능 설명
        - 생성 메서드( createOrderItem() ): 주문 상품, 가격, 수량 정보를 사용해서 주문상품 엔티티를 생성한다. 그리고 item.removeStock(count) 를 호출해서 주문한 수량만큼 상품의 재고를 줄인다.
        - 주문 취소( cancel() ): getItem().addStock(count) 를 호출해서 취소한 주문 수량만큼 상품의 재고를 증가시킨다.
        - 주문 가격 조회( getTotalPrice() ): 주문 가격에 수량을 곱한 값을 반환한다.


## 주문 리포지토리 개발
- 주문 리포지토리 코드
```
@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

//    public List<Order> findAll(OrderSearch orderSearch) {}
}
```
- 주문 리포지토리에는 주문 엔티티를 저장하고 검색하는 기능이 있다. 마지막의 findAll(OrderSearch orderSearch) 메서드는 조금 뒤에 있는 주문 검색 기능에서 자세히 알아보자.

## 주문 서비스 개발
- 주문 서비스 코드
```

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();
    }

    //검색
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}

```
- 주문 서비스는 주문 엔티티와 주문 상품 엔티티의 비즈니스 로직을 활용해서 주문, 주문 취소, 주문 내역 검색 기능을 제공한다.
- 참고: 예제를 단순화하려고 한 번에 하나의 상품만 주문할 수 있다.

- 주문( order() ): 주문하는 회원 식별자, 상품 식별자, 주문 수량 정보를 받아서 실제 주문 엔티티를 생성한 후 저장한다.
- 주문 취소( cancelOrder() ): 주문 식별자를 받아서 주문 엔티티를 조회한 후 주문 엔티티에 주문 취소를 요청한다.
    - JdbcTemplate이나 MyBatis나 쿼리를 직접 다루는 것들은 해당하는 곳들에 별도로 Update쿼리를 다 날려줘야 한다. 하지만 Jpa에서는 더티체킹으로 알아서 쿼리를 다 날려준다.
- 주문 검색( findOrders() ): OrderSearch 라는 검색 조건을 가진 객체로 주문 엔티티를 검색한다. 자세한 내용은 다음에 나오는 주문 검색 기능에서 알아보자.


- `orderRepository.save(order)`
    - Cascadetype.All 덕분에 OrderItem과 Delivery를 따로 persist 된다. order 만 save해주면 자동으로 OrderItem과 Delivery 가 persist 됨.
    - Cascade의 범위는 ?
        - 어디까지 해야하나의 고민. Order가 Delivery, OrderItem을 다 관리한다. 이 정도 영역에서만 써야 한다. Delivery와 OrderItem은 Order에서만 참조할 뿐 다른 곳에서 참조하지 않는다. 라이프 사이클적인 면에서 동일하게 관리를 할 때! 그리고 다른 곳에서 참조할 수 없는 private owner인 경우에 쓰면 좋다.
        - 만약 Order뿐 아니라 다른 곳에서도 Delivery를 참조하거나 하면 Cascade를 막 사용하면 안 된다. 왜냐하면 Order를 지울 때도 Delivery가 자동으로 지워지거나 하기 때문에 부가적인  문제가 발생할 수 있다.

- `OrderItem.createOrderItem(item, item.getPrice(), count);` 으로 상품 주문한 이유
    - 만약에 아래처럼 하게 되면 곳곳에서 다 이런식으로 하게 되니까 다 분산이 된다. 그리고 만약 필드를 추가한다던지 하는 생성로직을 변경하게 될 경우 모든 생성하는 곳의 코드를 변경해야 하므로 번거로워진다. 
    ```
    OrderItem orderItem1 = new OrderItem();
    orderItem1.setItem(item);
    ...
    ```
    - 그래서 위와 같이 기본생성자로 생성해서 따로 다 값을 넣게 할 수 있는 경우를 애초에 다 막아야 한다.(재약) Jpa에서는 Protected까지 기본생성자를 만들 수 있게 허용
    ```
    @Entity
    @Getter @Setter
    public class OrderItem {

        ...

        protected OrderItem() {

        }
        ...
    }
    ```
    - 또는 롬복으로 해결해도 된다.
    ```
    @Entity
    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class OrderItem {

        ...
    }
    ```
    - Order 클래스도 마찬가지
    - 그래서 이런식으로 항상 제약하는 방향대로 코드를 짜야 한다.
        - 기본생성자 써야지 -> 어? 안되네 -> 해당 클래스 들어가보니 어? 왜 protected로 막아놨지? -> 그럼 다른 방법으로 생성해야겠네? 


- 참고
    - 주문 서비스의 주문과 주문 취소 메서드를 보면 비즈니스 로직 대부분이 엔티티에 있다. 서비스 계층 은 단순히 엔티티에 필요한 요청을 위임하는 역할을 한다. 이처럼 엔티티가 비즈니스 로직을 가지고 객체 지 향의 특성을 적극 활용하는 것을 `도메인 모델 패턴`(http://martinfowler.com/eaaCatalog/ domainModel.html)이라 한다. 반대로 엔티티에는 비즈니스 로직이 거의 없고 서비스 계층에서 대부분 의 비즈니스 로직을 처리하는 것을 `트랜잭션 스크립트 패턴`(http://martinfowler.com/eaaCatalog/ transactionScript.html)이라 한다. 
    - sql을 직접 다뤘었던 것들은 대부분 트랜잭션 스크립트 패턴이다. 로직들이 엔티티 안에 있지 않고 바깥(Service)에 다 나와있다.
    - ORM을 다루게 되면 대부분 도메인 모델 패턴을 사용한다.
    - 문맥에 따라서 각각 트레이드 오프가 있어서 어느 것이 꼭 더 무조건 좋다고는 말할 수 없다.
    - 한 프로젝트 안에서 이 두 개의 패턴이 양립할 수 있다. 문맥에 어느 것이 더 맞는지를 사용하면 된다.


## 주문 기능 테스트
- 테스트 요구사항
    - 상품 주문이 성공해야 한다.
    - 상품을 주문할 때 재고 수량을 초과하면 안 된다.
    - 주문 취소가 성공해야 한다.

## 상품 주문 테스트 코드
- 참고
    - 사실 테스트하고 있는 것들은 Jpa를 자세하게 설명하게 위해서 스프링 부트를 가지고 와서 하고 있는 것인데 사실 이것은 좋은 테스트라고 볼 수는 없다. 좋은 테스트는 순수한 메서드로만 단위테스트 하는 것이 좋다. 여기서는 Jpa와 잘 엮여서 전체적으로 잘 동작하는지 보려고 하는 것이므로 통합 테스트하고 있는 것.

- 상품 주문 테스트 코드
    ```

    @RunWith(SpringRunner.class)
    @SpringBootTest
    @Transactional
    public class OrderServiceTest {

        @Autowired EntityManager em;
        @Autowired OrderService orderService;
        @Autowired OrderRepository orderRepository;

        @Test
        public void 상품주문() throws Exception {
            //given
            Member member = createMember();

            Item book = createBook("시골 JPA", 10000, 10);

            int orderCount = 2;
            //when
            Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

            //then
            Order getOrder = orderRepository.findOne(orderId);

            Assert.assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
            Assert.assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
            Assert.assertEquals("주문 가격은 가격 * 수량이다.", 10000 * orderCount, getOrder.getTotalPrice());
            Assert.assertEquals("주문 수량만큼 재고가 줄어야 한다.", 8, book.getStockQuantity());
        }

        private Item createBook(String name, int price, int stockQuantity) {
            Item book = new Book();
            book.setName(name);
            book.setPrice(price);
            book.setStockQuantity(stockQuantity);
            em.persist(book);
            return book;
        }

        private Member createMember() {
            Member member = new Member();
            member.setName("회원1");
            member.setAddress(new Address("서울", "경기", "123-123"));
            em.persist(member);
            return member;
        }
    }
    ```
    - 상품주문이 정상 동작하는지 확인하는 테스트다. Given 절에서 테스트를 위한 회원과 상품을 만들고 When 절에서 실제 상품을 주문하고 Then 절에서 주문 가격이 올바른지, 주문 후 재고 수량이 정확히 줄었는지 검증한다.

- 재고 수량 초과 테스트
    - 재고 수량을 초과해서 상품을 주문해보자. 이때는 NotEnoughStockException 예외가 발생해야 한다.
- 재고 수량 초과 테스트 코드
    ```
    @Test(expected = NotEnoughStockException.class) 
    public void 상품주문_재고수량초과() throws Exception {

        //Given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10); //이름, 가격, 재고

        int orderCount = 11; //재고보다 많은 수량 
        
        //When
        orderService.order(member.getId(), item.getId(), orderCount);
        
        //Then
        fail("재고 수량 부족 예외가 발생해야 한다."); 
    }

    ``` 
    - 코드를 보면 재고는 10권인데 orderCount = 11 로 재고보다 1권 더 많은 수량을 주문했다. 주문 초과로 다음 로직에서 예외가 발생한다.
    ```
    public abstract class Item {

        //...
        public void removeStock(int orderQuantity) {
            int restStock = this.stockQuantity - orderQuantity;
            if (restStock < 0) {
                throw new NotEnoughStockException("need more stock");
            }
            this.stockQuantity = restStock;
        }

    }
    ```

- 주문 취소 테스트
    - 주문 취소 테스트 코드를 작성하자. 주문을 취소하면 그만큼 재고가 증가해야 한다.
- 주문 취소 테스트 코드
```=
@Test
public void 주문취소() {

    //Given
    Member member = createMember();
    Item item = createBook("시골 JPA", 10000, 10); //이름, 가격, 재고
    int orderCount = 2;

    Long orderId = orderService.order(member.getId(), item.getId(),
    orderCount);

    //When
    orderService.cancelOrder(orderId);
    
    //Then
    Order getOrder = orderRepository.findOne(orderId); 
    
    assertEquals("주문 취소시 상태는 CANCEL 이다.",OrderStatus.CANCEL,
    getOrder.getStatus());
    
    assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야 한다.", 10,
    item.getStockQuantity());
}
```
- 주문을 취소하려면 먼저 주문을 해야 한다. Given 절에서 주문하고 When 절에서 해당 주문을 취소했다. Then 절에서 주문상태가 주문 취소 상태인지( CANCEL ), 취소한 만큼 재고가 증가했는지 검증한다.


## 주문 검색 기능 개발
- JPA에서 동적 쿼리를 어떻게 해결해야 하는가?
    - 조건(회원명, 주문상태)에 따라 동적쿼리가 만들어져야 되는 상황
- 실무에서는 동적 쿼리를 안 쓸 수가 없다.

- 검색 조건 파라미터 OrderSearch 
```
package jpabook.jpashop.domain;
public class OrderSearch {

    private String memberName; //회원 이름
    private OrderStatus orderStatus;//주문 상태[ORDER, CANCEL] 
    
    //Getter, Setter
}
```

- 검색을 추가한 주문 리포지토리 코드
    ```
    @Repository
    public class OrderRepository {

        @PersistenceContext
        EntityManager em;
        
        public void save(Order order) {
            em.persist(order);
        }
        
        public Order findOne(Long id) {
            return em.find(Order.class, id);
        }

        public List<Order> findAll(OrderSearch orderSearch) { 
            //... 검색 로직
        } 
    }
    ```
    - findAll(OrderSearch orderSearch) 메서드는 검색 조건에 동적으로 쿼리를 생성해서 주문 엔티티를 조회한다

- JPQL로 처리
    ```
    public List<Order> findAllByString(OrderSearch orderSearch) {
        //language=JPAQL
        String jpql = "select o From Order o join o.member m";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
        }

        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000); //최대 1000건

        if (orderSearch.getOrderStatus() != null) {
            query = query.setParameter("status", orderSearch.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query = query.setParameter("name", orderSearch.getMemberName());
        }

        return query.getResultList();

    }
    ```
    - JPQL 쿼리를 문자로 생성하기는 번거롭고, 실수로 인한 버그가 충분히 발생할 수 있다.

- JPA Criteria로 처리
    ```
    public List<Order> findAllByCriteria(OrderSearch orderSearch) {
            
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Order> cq = cb.createQuery(Order.class);
            Root<Order> o = cq.from(Order.class);
            Join<Order, Member> m = o.join("member", JoinType.INNER); //회원과 조인

            List<Predicate> criteria = new ArrayList<>();

            //주문 상태 검색
            if (orderSearch.getOrderStatus() != null) {
                Predicate status = cb.equal(o.get("status"),
                        orderSearch.getOrderStatus());
                criteria.add(status);
            }

            //회원 이름 검색
            if (StringUtils.hasText(orderSearch.getMemberName())) {
                Predicate name =
                        cb.like(m.<String>get("name"), "%" +
                                orderSearch.getMemberName() + "%");
                criteria.add(name);
            }

            cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
            TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000); //최대 1000건
            return query.getResultList();
        }

    ```
    - JPA Criteria는 JPA 표준 스펙이지만 실무에서 사용하기에 너무 복잡하다. 결국 다른 대안이 필요하다. 많 은 개발자가 비슷한 고민을 했지만, 가장 멋진 해결책은 Querydsl이 제시했다. Querydsl 소개장에서 간 단히 언급하겠다. 지금은 이대로 진행하자.

- 참고
    - JPA Criteria에 대한 자세한 내용은 자바 ORM 표준 JPA 프로그래밍 책을 참고하자

# 웹 계층 개발
## 홈 화면과 레이아웃
- 홈 컨트롤러 등록
```
@Controller
  @Slf4j
  public class HomeController {
      @RequestMapping("/")
      public String home() {
          log.info("home controller");
          return "home";
      }
}
```

- 스프링 부트 타임리프 기본 설정
```
spring:
    thymeleaf:
      prefix: classpath:/templates/
      suffix: .html
```


- 스프링 부트 타임리프 viewName 매핑
    - resources:templates/ +{ViewName}+ .html
    - resources:templates/home.html
- 반환한 문자( home )과 스프링부트 설정 prefix , suffix 정보를 사용해서 렌더링할 뷰( html )를 찾는다.
- 참고
    - https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/common- application-properties.html


- 타임리프 템플릿 등록
    - 생략

- 참고: Hierarchical-style layouts
    - 예제에서는 뷰 템플릿을 최대한 간단하게 설명하려고, header , footer 같은 템플릿 파일을 반복해서 포함한다. 다음 링크의 Hierarchical-style layouts을 참고하면 이런 부분도 중복을 제거할 수 있다.
    - https://www.thymeleaf.org/doc/articles/layouts.html

- 참고: 뷰 템플릿 변경사항을 서버 재시작 없이 즉시 반영하기
    1. spring-boot-devtools 추가
    2. html 파일 build-> Recompile

- view 리소스 등록
    - resources/static 하위에 css , js 추가
    - resources/static/css/jumbotron-narrow.css 추가
- jumbotron-narrow.css 파일
    - 생략


## 회원 등록
- 폼 객체를 사용해서 화면 계층과 서비스 계층을 명확하게 분리한다.
    - Entity 폼 객체로 대체하지 않는 이유는, 두 개가 미묘하게 맞지 않은 부분들이 많다. 예를 들어 필드값들도 한두개씩 맞지 않을 뿐더러, 인증을 위한 @NotEmpty 와 같은 것들을 Entity에 붙이기 시작하면 @Entity가 지저분해진다. 실무에서는 사실 이 2가지가 일치하는 경우가 거의 없다.
    - 그래서 화면에 최대한 맞는 Form 객체를 Entity와 따로 만드는 것이 좋다.
    - Jpa를 할 때는 Entity를 최대한 순수하게 유지하는 것이 매우 중요하다. 핵심 비즈니스 로직만 갖고 있고 화면 로직은 없어야 한다. 화면에 맞는 것은 폼 객체나 DTO를 사용해야 한다.


- 회언 등록 폼 객체
```
@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다") 
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
 
```
- 회원 등록 컨트롤러
```
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }
}
```

- 회원 등록 폼 화면( templates/members/createMemberForm.html )*
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments/header :: header" />
<style>
    .fieldError {
        border-color: #bd2130;
    }
</style>
<body>

<div class="container">
    <div th:replace="fragments/bodyHeader :: bodyHeader"/>

    <form role="form" action="/members/new" th:object="${memberForm}" method="post">
        <div class="form-group">
            <label th:for="name">이름</label>
            <input type="text" th:field="*{name}" class="form-control" placeholder="이름을 입력하세요"
                   th:class="${#fields.hasErrors('name')}? 'form-control fieldError' : 'form-control'">
            <p th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Incorrect date</p>
        </div>
        <div class="form-group">
            <label th:for="city">도시</label>
            <input type="text" th:field="*{city}" class="form-control"
                   placeholder="도시를 입력하세요"> </div>
        <div class="form-group">
            <label th:for="street">거리</label>
            <input type="text" th:field="*{street}" class="form-control" placeholder="거리를 입력하세요">
        </div>
        <div class="form-group">
            <label th:for="zipcode">우편번호</label>
            <input type="text" th:field="*{zipcode}" class="form-control"
                   placeholder="우편번호를 입력하세요"> </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <br/>

    <div th:replace="fragments/footer :: footer" />
</div> <!-- /container -->
</body>
</html>
```


## 회원 목록 조회
- 회원 목록 컨트롤러 추가
    ```
        @GetMapping("/members")
        public String list(Model model) {
            List<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            return "members/memberList";
        }
    }
    ```
    - 조회한 상품을 뷰에 전달하기 위해 스프링 MVC가 제공하는 모델( Model ) 객체에 보관
    - 실행할 뷰 이름을 반환

- 회원 목록 뷰( templates/members/memberList.html)
    ```
    <!DOCTYPE HTML>
    <html xmlns:th="http://www.thymeleaf.org">
    <head th:replace="fragments/header :: header" />
    <body>

    <div class="container">

        <div th:replace="fragments/bodyHeader :: bodyHeader" />

        <div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>이름</th> <th>도시</th> <th>주소</th> <th>우편번호</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="member : ${members}">
                    <td th:text="${member.id}"></td>
                    <td th:text="${member.name}"></td>
                    <td th:text="${member.address?.city}"></td>
                    <td th:text="${member.address?.street}"></td>
                    <td th:text="${member.address?.zipcode}"></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div th:replace="fragments/footer :: footer" />

    </div> <!-- /container -->

    </body>
    </html>

    ```
    - 타임리프에서 ?를 사용하면 null 을 무시한다. null 이면 그 뒤 코드가 진행이 안됨
    - 참고: 폼 객체 vs 엔티티 직접 사용
        -  요구사항이 정말 단순할 때는 폼 객체( MemberForm ) 없이 엔티티( Member )를 직접 등록과 수정 화면에서 사용해도 된다. 하지만 화면 요구사항이 복잡해지기 시작하면, 엔티티에 화면을 처리하기 위한 기능이 점점 증가한다. 결과적으로 엔티티는 점점 화면에 종속적으로 변하고, 이렇게 화면 기능 때문에 지저분해진 엔티티는 결국 유지보수하기 어려워진다. 실무에서 엔티티는 핵심 비즈니스 로직만 가지고 있고, 화면을 위한 로직은 없어야 한다. 화면이나 API에 맞 는 폼 객체나 DTO를 사용하자. 그래서 화면이나 API 요구사항을 이것들로 처리하고, 엔티티는 최대한 순수 하게 유지하자.

## 상품 등록
- 상품 등록 폼
```
@Getter @Setter
public class BookForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;
}
```
- 상품 등록 컨트롤러
    ```
    @Controller
    @RequiredArgsConstructor
    public class ItemController {

        private final ItemService itemService;

        @GetMapping("/items/new")
        public String createForm(Model model) {
            model.addAttribute("form", new BookForm());
            return "items/createItemForm";
        }

        @PostMapping("/items/new")
        public String create(BookForm form) {
            Book book = new Book();
            book.setName(form.getName());
            book.setPrice(form.getPrice());
            book.setStockQuantity(form.getStockQuantity());
            book.setAuthor(form.getAuthor());
            book.setIsbn(form.getIsbn());

            itemService.saveItem(book);
            return "redirect:/";
        }
    }

    ```
    - 상품 등록 폼에서 데이터를 입력하고 Submit 버튼을 클릭하면 /items/new 를 POST 방식으로 요청
    - 상품 저장이 끝나면 상품 목록 화면( redirect:/items )으로 리다이렉트


- 상품 등록 뷰( items/createItemForm.html )
    - 생략


## 상품 목록
- 상품 목록 컨트롤러
```
 @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }
```
- 상품 목록 뷰
    - 생략

## 상품 수정
- 상품 수정과 관련된 컨트롤러 코드
```

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable String itemId, @ModelAttribute("form") BookForm form) {

        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }
```

- 상품 수정 폼 화면(items/updateItemForm)
    - 생략

- 상품 수정 폼 이동
    1. 수정 버튼을 선택하면 /items/{itemId}/edit URL을 GET 방식으로 요청
    2. 그 결과로 updateItemForm() 메서드를 실행하는데 이 메서드는 itemService.findOne(itemId)를 호출해서 수정할 상품을 조회
    3. 조회결과를모델객체에담아서뷰(items/updateItemForm)에 전달

- 상품 수정 실행
    - 상품 수정 폼 HTML에는 상품의 id(hidden), 상품명, 가격, 수량 정보 있음
    1. 상품 수정 폼에서 정보를 수정하고 Submit 버튼을 선택
    2. /items/{itemId}/edit URL을 POST 방식으로 요청하고 updateItem() 메서드를 실행
    3. 이때 컨트롤러에 파라미터로 넘어온 item 엔티티 인스턴스는 현재 준영속 상태다. 따라서 영속성 컨텍스트의 지원을 받을 수 없고 데이터를 수정해도 변경 감지 기능은 동작X


## 변경 감지와 병합(merge)
- 참고: 정말 중요한 내용이니 꼭! 완벽하게 이해하셔야 합니다.
- 변경 감지와 병합의 차이를 잘 알아야 한다.
- 준영속 엔티티?
    - 영속성 컨텍스트가 더는 관리하지 않는 엔티티를 말한다.(여기서는 itemService.saveItem(book) 에서 수정을 시도하는 Book 객체다. Book 객체는 이미 DB 에 한번 저장되어서 식별자가 존재한다. 이렇게 임의로 만들어낸 엔티티도 기존 식별자를 가지고 있으면 준 영속 엔티티로 볼 수 있다.)

- 준영속 엔티티를 수정하는 2가지 방법
    - 변경 감지 기능 사용
    - 병합( merge ) 사용

- 변경 감지 기능 사용
    ```
    @Transactional
    void update(Item itemParam) { //itemParam: 파리미터로 넘어온 준영속 상태의 엔티티
        Item findItem = em.find(Item.class, itemParam.getId()); //같은 엔티티를 조회한다.
        findItem.setPrice(itemParam.getPrice()); //데이터를 수정한다. 
    }
    ```
    - 영속성 컨텍스트에서 엔티티를 다시 조회한 후에 데이터를 수정하는 방법
    - 트랜잭션 안에서 엔티티를 다시 조회, 변경할 값 선택 -> 트랜잭션 커밋 시점에 변경 감지(Dirty Checking) 이 동작해서 데이터베이스에 UPDATE SQL 실행


- 병합 사용
    - 병합은 준영속 상태의 엔티티를 영속 상태로 변경할 때 사용하는 기능이다.
    ```
    @Transactional
        void update(Item itemParam) { //itemParam: 파리미터로 넘어온 준영속 상태의 엔티티 
        Item mergeItem = em.merge(item);
    }
    ```

- 병합 : 기존에 있는 엔티티

    ![스크린샷 2022-01-03 오후 4 02 55](https://user-images.githubusercontent.com/57219160/147906098-6f5cb173-9028-46f1-935e-4787d004e763.png)
    
    - 병합 동작 방식
        1. merge()를실행한다.
        2. 파라미터로 넘어온 준영속 엔티티의 식별자 값으로 1차 캐시에서 엔티티를 조회한다.
            - 2-1. 만약 1차 캐시에 엔티티가 없으면 데이터베이스에서 엔티티를 조회하고, 1차 캐시에 저장한다.
        3. 조회한 영속 엔티티( mergeMember )에 member 엔티티의 값을 채워 넣는다. (member 엔티티의 모든 값을 mergeMember에 밀어 넣는다. 이때 mergeMember의 “회원1”이라는 이름이 “회원명변경”으로 바뀐다.)
        4. 영속 상태인 mergeMember를 반환한다.
        - 참고 : 책 자바 ORM 표준 JPA 프로그래밍 3.6.5


- 병합시 동작 방식을 간단히 정리
    1. 준영속 엔티티의 식별자 값으로 영속 엔티티를 조회한다.
    2. 영속 엔티티의 값을 준영속 엔티티의 값으로 모두 교체한다.(병합한다.)
    3. 트랜잭션 커밋 시점에 변경 감지 기능이 동작해서 데이터베이스에 UPDATE SQL이 실행

- 주의
    - 변경 감지 기능을 사용하면 원하는 속성만 선택해서 변경할 수 있지만, 병합을 사용하면 모든 속성이 변경된다. 병합시 값이 없으면 null 로 업데이트 할 위험도 있다. (병합은 모든 필드를 교체한다.) 


- 상품 리포지토리의 저장 메서드 분석 ItemRepository
    ```
    @Repository
    @RequiredArgsConstructor
    public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) { 
            em.persist(item); 
        } else {
            em.merge(item); 
        }
    }
    ```
    - save() 메서드는 식별자 값이 없으면( null ) 새로운 엔티티로 판단해서 영속화(persist)하고 식별자가 있 으면 병합(merge)
    - 지금처럼 준영속 상태인 상품 엔티티를 수정할 때는 id 값이 있으므로 병합 수행


- 새로운 엔티티 저장과 준영속 엔티티 병합을 편리하게 한번에 처리
    - 상품 리포지토리에선 save() 메서드를 유심히 봐야 하는데, 이 메서드 하나로 저장과 수정(병합)을 다 처 리한다. 코드를 보면 식별자 값이 없으면 새로운 엔티티로 판단해서 persist() 로 영속화하고 만약 식별자 값이 있으면 이미 한번 영속화 되었던 엔티티로 판단해서 merge() 로 수정(병합)한다. 결국 여기서의 저장 (save)이라는 의미는 신규 데이터를 저장하는 것뿐만 아니라 변경된 데이터의 저장이라는 의미도 포함한다. 이렇게 함으로써 이 메서드를 사용하는 클라이언트는 저장과 수정을 구분하지 않아도 되므로 클라이언트의 로직이 단순해진다.
    - 여기서 사용하는 수정(병합)은 준영속 상태의 엔티티를 수정할 때 사용한다. 영속 상태의 엔티티는 변경 감 지(dirty checking)기능이 동작해서 트랜잭션을 커밋할 때 자동으로 수정되므로 별도의 수정 메서드를 호 출할 필요가 없고 그런 메서드도 없다.
- 참고
    - save() 메서드는 식별자를 자동 생성해야 정상 동작한다. 여기서 사용한 Item 엔티티의 식별자는 자동으로 생성되도록 @GeneratedValue 를 선언했다. 따라서 식별자 없이 save() 메서드를 호출하면 persist() 가 호출되면서 식별자 값이 자동으로 할당된다. 반면에 식별자를 직접 할당하도록 @Id 만 선언 했다고 가정하자. 이 경우 식별자를 직접 할당하지 않고, save() 메서드를 호출하면 식별자가 없는 상태로 persist() 를 호출한다. 그러면 식별자가 없다는 예외가 발생한다.

- 참고
    - 실무에서는 보통 업데이트 기능이 매우 재한적이다. 그런데 병합은 모든 필드를 변경해버리고, 데이터 가 없으면 null 로 업데이트 해버린다. 병합을 사용하면서 이 문제를 해결하려면, 변경 폼 화면에서 모든 데 이터를 항상 유지해야 한다. 실무에서는 보통 변경가능한 데이터만 노출하기 때문에, 병합을 사용하는 것이 오히려 번거롭다.

- 가장 좋은 해결 방법
    - `엔티티를 변경할 때는 항상 변경 감지를 사용하세요`
        - 컨트롤러에서 어설프게 엔티티를 생성하지 마세요.
        - 트랜잭션이 있는 서비스 계층에 식별자( id )와 변경할 데이터를 명확하게 전달하세요.(파라미터 or dto)
        - 트랜잭션이 있는 서비스 계층에서 영속 상태의 엔티티를 조회하고, 엔티티의 데이터를 직접 변경하세요.
        - 트랜잭션 커밋 시점에 변경 감지가 실행됩니다.

    ```
    @Controller
    @RequiredArgsConstructor
    public class ItemController {

        private final ItemService itemService;

        /**
        *상품 수정,권장 코드
        */
        @PostMapping(value = "/items/{itemId}/edit")
        public String updateItem(@ModelAttribute("form") BookForm form) {
            itemService.updateItem(form.getId(), form.getName(), form.getPrice());
            return "redirect:/items";
        }
    }
    ```
    ```
    @Service
    @RequiredArgsConstructor
    public class ItemService {
    private final ItemRepository itemRepository;
    /**
    * 영속성 컨텍스트가 자동 변경
    */
        @Transactional
        public void updateItem(Long id, String name, int price) {
            Item item = itemRepository.findOne(id);
            item.setName(name);
            item.setPrice(price);
        } 
    }
    ```

## 상품 주문
- 상품 주문 컨트롤러
    ```
    @Controller
    @RequiredArgsConstructor
    public class OrderController {

        private final OrderService orderService;
        private final MemberService memberService;
        private final ItemService itemService;

        @GetMapping("/order")
        public String createForm(Model model) {

            List<Member> members = memberService.findMembers();
            List<Item> items = itemService.findItems();

            model.addAttribute("members", members);
            model.addAttribute("items", items);

            return "order/orderForm";
        }

        @PostMapping("/order")
        public String order(@RequestParam("memberId") Long memberId,
                            @RequestParam("itemId") Long itemId,
                            @RequestParam("count") int count) {

            orderService.order(memberId, itemId, count);
            return "redirect:/orders";
        }
    }

    ```
    - 주문 폼 이동
        - 메인 화면에서 상품 주문을 선택하면 /order 를 GET 방식으로 호출
        - OrderController 의 createForm() 메서드
        - 주문 화면에는 주문할 고객정보와 상품 정보가 필요하므로 model 객체에 담아서 뷰에 넘겨줌

    - 주문 실행
        - 주문할 회원과 상품 그리고 수량을 선택해서 Submit 버튼을 누르면 /order URL을 POST 방식으로 호출
        - 컨트롤러의 order() 메서드를 실행
        - 이 메서드는 고객 식별자( memberId ), 주문할 상품 식별자( itemId ), 수량( count ) 정보를 받아서 주문 서 비스에 주문을 요청
        - 주문이 끝나면 상품 주문 내역이 있는 /orders URL로 리다이트

- 상품 주문 폼(order/orderForm)
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments/header :: header" />
<body>
<div class="container">
    <div th:replace="fragments/bodyHeader :: bodyHeader"/>
    <form role="form" action="/order" method="post">
        <div class="form-group">
            <label for="member">주문회원</label>
            <select name="memberId" id="member" class="form-control">
                <option value="">회원선택</option> <option th:each="member : ${members}"
                                                       th:value="${member.id}"
                                                       th:text="${member.name}" />
            </select>
        </div>
        <div class="form-group">
            <label for="item">상품명</label>
            <select name="itemId" id="item" class="form-control"> <option value="">상품선택</option>
                <option th:each="item : ${items}"
                        th:value="${item.id}"
                        th:text="${item.name}" />
            </select>
        </div>
        <div class="form-group">
            <label for="count">주문수량</label>
            <input type="number" name="count" class="form-control" id="count"
                   placeholder="주문 수량을 입력하세요"> </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <br/>
    <div th:replace="fragments/footer :: footer" />
</div> <!-- /container -->
</body>
</html>
```

## 주문 목록 검색, 취소
- 주문 목록 검색 컨트롤러
```
package jpabook.jpashop.web;
@Controller
@RequiredArgsConstructor
public class OrderController {

    @GetMapping(value = "/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch
orderSearch, Model model) {

        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }
}

```
- 주문 목록 검색 화면( order/orderList )
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments/header :: header"/>
<body>
<div class="container">

    <div th:replace="fragments/bodyHeader :: bodyHeader"/>

    <div>
        <div>
            <form th:object="${orderSearch}" class="form-inline">
                <div class="form-group mb-2">
                    <input type="text" th:field="*{memberName}" class="form- control" placeholder="회원명"/>
                </div>
                <div class="form-group mx-sm-1 mb-2">
                    <select th:field="*{orderStatus}" class="form-control"> <option value="">주문상태</option>
                        <option th:each=
                                    "status : ${T(jpabook.jpashop.domain.OrderStatus).values()}"
                            th:value="${status}"
                            th:text="${status}">option
                        </option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary mb-2">검색</button>
            </form>

        </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>회원명</th> <th>대표상품 이름</th> <th>대표상품 주문가격</th>
                    <th>대표상품 주문수량</th> <th>상태</th> <th>일시</th> <th></th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="item : ${orders}">
                    <td th:text="${item.id}"></td>
                    <td th:text="${item.member.name}"></td>
                    <td th:text="${item.orderItems[0].item.name}"></td>
                    <td th:text="${item.orderItems[0].orderPrice}"></td>
                    <td th:text="${item.orderItems[0].count}"></td>
                    <td th:text="${item.status}"></td>
                    <td th:text="${item.orderDate}"></td>
                    <td>
                        <a th:if="${item.status.name() == 'ORDER'}" href="#"
                           th:href="'javascript:cancel('+${item.id}+')'"
                           class="btn btn-danger">CANCEL</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div th:replace="fragments/footer :: footer"/>
</div> <!-- /container -->

</body>

<script>
    function cancel(id) {
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "/orders/" + id + "/cancel");
        document.body.appendChild(form);
        form.submit();
    }
</script>
</html>
```

- 주문 취소
```

@Controller
@RequiredArgsConstructor
public class OrderController {
    
    @PostMapping(value = "/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {

        orderService.cancelOrder(orderId);
        
        return "redirect:/orders";
    } 
}
 
```
