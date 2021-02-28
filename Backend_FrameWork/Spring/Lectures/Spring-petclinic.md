# [백기선 - 스프링 프레임워크 입문](https://www.inflearn.com/course/spring#)

# IoC
Inversion of Control(제어의 역전)


```
class OwnerController{
    private OwnerRepository repository = new OwnerRepository();
}
```

- OwnerRepository는 OwnerController의 의존성이다
- OwnerRepository가 있어야 OwnerController를 제대로 사용할 수 있다. (아래처럼)
```
private final OwnerRepository owners; // 이것을 통해서

this.owners.save(owner); //owners를 통해서 저장도 하고 ~ 등등
```


- 하지만 제일 위의 OwnerRepository를 누가 관리하느냐가 바로 관건이다.
- 제일 위처럼 new를 통해서 만들게 되는 것은 직접 관리하는 것
- 하지만 내가 관리하지 않고 밖에서 누군가가 넣어주면 그것을 바로 `Inversion of Control(제어의 역전)`이라고 한다.


- 의존성 주입은 직접 만들지 않고 외부에서 만들어서 의존성을 주입해주는 것이고, 이렇게 외부에서 컨트롤 하는 것을 `Inversion of Control(제어의 역전)` 이라고 한다.
```
class OwnerController {
    private OwnerRepository repo; //직접 만들지 않고 변수만 선언한 후

    public OwnerController(OwnerRepository repo){ // 이렇게 외부에서 누군가가 ~ 넣어준다.
        this.repo = repo;
    }

    // 받았으니 이제 그냥 사용하면 됨
}

class OwnerControllerTest{
    @Test
    public void create(){
        OwnerRepository repo = new OwnerRepository();
        OwnerController controller = new OwnerController(repo); 이렇게 외부에서 만들어서 위로 넘겨준다. OwnerController 에게 의존성을 주입해주는 것이다.
    }
}
```

- 물론 의존성에 입각해서 IoC를 설명하지만(보통), Inversion of Dependency Control 이라고 하지 않는 이유는 Dependency 이외의 다른 제어권을 역전시키는 경우가 있기 때문이다. ex) 서블릿도 사실 스스로 직접 실행하지 않고 container가 서블릿 코드를 initialization 한 후에 get, post 에 반응을 하는데 이것도 사실 IoP 라고 볼 수 있다.(서블릿 자체가 아니라 container가 하므로)


# IoC(Inversion of Control) 컨테이너

- spring framework은 ioc용 컨테이너를 제공해준다. 컨테이너의 가장 핵심적인 인터페이스는 ApplicationContext(BeanFactory) 이다. ApplicationContext 이 바로 ioc용 컨테이너이다. 
    - 하지만 이것을 직접 쓸 일은 많지 않다. 직접 볼 일도 쓸 일도 없다.
        - 직접 사용하려면(보려면) 아래처럼 주입을 직접 받아오면 된다. IoC 컨테이너 자기 자신이 Bean으로 등록되어 있다. 
        - 하지만 아래처럼 쓸 일은 거의 없다. 예전에는 서블릿 어플리케이션 만들 때 web.xml에다가 ApplicationContext의 타입을 서블릿listner에다가 argument로 줬어야 했다.
        ```
        @Autowired
        ApplicationContext applicationContext;  

        @GetMapping("/context")
        public String context(){
            return "hello" + applicationContext.getBean(OwnerRepository.class);
        }
        ``` 
    - 어느 코드에서도 사실 ApplicationContext 를 찾아보기가 쉽지 않다.
- ApplicationContext는 사실 아래와 같은 코드를 동작하게 만들어준다.
    - OwnerController가 ioc 컨테이너 내부에서 OwnerController 객체를 만들어 준다. 그리고 OwnerRepository 객체도 만들어준다. (물론 만들어주는 이유도 좀 다르지만)
```
class OwnerController {
    private OwnerRepository repo; //직접 만들지 않고 변수만 선언한 후

    public OwnerController(OwnerRepository repo){ // 이렇게 외부에서 누군가가 ~ 넣어준다.
        this.repo = repo;
    }

    // 받았으니 이제 그냥 사용하면 됨
}
```
- Ioc 컨테이너는 이러한 bean들(컨테이너 내부에서 만든 객체들 - bean이라 부른다)의 의존성을 관리해준다. 즉, OwnerController와 OwnerRepository는 둘 다 ApplicationContext 내부에서 만들어 주는 Bean이다. 즉 이 둘의 의존성은 Ioc 컨테이너가 관리해준다. 오로지 Bean만 관리해 줄 수 있다. 하지만 Owner는 Bean이 아니다. 이것은 어떻게 알 수 있는가?
    - 클래스 선언하는 부분의 왼쪽에 표시가 있다. (초록색 완두콩 표시)
    - 에너테이션(@Controller, @RestController, @Service, @Repository, @Component 등) 이 붙으면 자동으로 Bean으로 등록이 된다. 이런 것들은 다 IoC 컨테이너 내부에서 다 객체를 만들고 의존성을 관리해준다. 의존성을 엮어준다. OwnerController 에 필요한 OwnerRepository 타입의 Bean을 찾아서 생성자에 주입해서 넣어준다. 그리고 위의 this.repo 는 null이 아니다. this.repo는 OwnerRepository의 Bean이 들어오게 되어있다.
    

# Bean
- 스프링 Ioc 컨테이너가 관리하는 객체. 오로지 이것만이 Bean이다. 
- Bean으로 등록하는 방법은 2가지가 있다.
    1. Component Scanning
        - @Component (메인 함수의 @SpringBootApplication를 따라가보면 @ComponentScan 을 확인 가능 알 수 있다.)
            - @Repository
            - @Service
            - @Controller
            - 등 @Component라고 직접 붙어있는 것들은 당연
    2. 직접 일일이 XML이나 자바 설정 파일에 등록
        1. 설정파일에 등록하는 방법
            - @Bean 어노테이션을 달아줌. 
            - 메서드 이름이 Bean의 이름이다
            - 반드시 @Configuration 어노테이션이 붙어있는 클래스 안에 선언해야 한다. 아래에서는 @SpringBootApplication이 @Configuration을 들고 있다.

            ```
            @SpringBootApplication
            public class PetClinicApplication{
                @Bean
                public String june(){
                    return "Ah, June";
                }

            }
            ```
            - 등록한 것을 쓰는 방법
            ```
            @RestController // @Component를 포함하고 있으므로 마찬가지로 Bean이다.
            public class SampleController{
                
                @Autowired
                String june; // 위의 Bean이다

                @GetMapping("/context")
                public String context(){
                    return "hello " + june; // 이렇게 그냥 사용하면 된다.
                }
            }
            ```

- @에너테이션은 사실 기능이 없다. 주석과도 같다. 그 주석을 단지 어디에 붙일 수 있느냐, 언제까지 주석을 유지할 수 있는지 속성이 있을 뿐, 그 자체로서는 기능이 없다. @에너테이션 자체를 마커로 사용해서 그 에너테이션을 처리하는 process들이 있는 것이다. 마찬가지로 @ComponentScan를 처리하는 애가 따로 있다.
- @ComponentScan은 @SpringBootApplicatoin이 붙어있는 메인클래스부터 시작해서 그 밑으로 모든 패키지, 클래스의 @Component이 붙어있는 것을 찾아서 Bean으로 등록 해준다. ex) @Controller 를 컨트롤+클릭 으로 들어가보면 @Component가 들어있다.
- 물론, 메인함수가 속해있는 패키지 밑으로 모든 패키지, 클래스들에서 @Component라고 붙어있는 것들을 찾을 뿐이지, 메인함수가 속해있는 패키지를 벗어나서 밖에서 @Component를 붙인다면 Bean으로 등록이 안된다. @ComponentScan이 찾지 못한다. 물론 @ComponentScan의 범위 설정을 변경하면 가능하긴 하다.
- 중요한 것은 오로지 Bean들의 의존성들만 관리해준다는 것이다. 위의 2.1에서 등록한 june()메서드 Bean과 SampleController Bean 두개를 서로 관리해줄 수 있으므로 @Autowired로 의존성을 주입해 줄 수 있는 것이다. 그래서 어떤 클래스가 의존성, bean들을 사용하고 싶으면 그 클래스가 우선 Bean이 되어야 한다. 오로지 Bean만 Bean을 의존받아서 사용할 수 있기 때문이다. 



# 의존성 주입(Dependency Injection)
- 보통 @Autowired 또는 @Inject를 사용해서 주입받아 사용한다. 
- 그럼 어디에 붙일까?
- 방법
    1. 생성자
        - Spring5부터 @Autowired 애너테이션이 없더라도 Bean으로 등록된 클래스에서 생성자가 오직 하나만 있고 그 생성자의 매개변수가 Bean으로 등록되어 있다면 이 Bean은 주입을 해준다. @Autowired가 생략되어 있다.
        - 
        ```
        @Controller
        class OwnerController{
            
            public OwnerController(OwnerRepository clinicService){ // @Autowired가 생략되어 있음
                this.owners = clinicService;
            }
        }
        ```
        - 아래에서도 PetRepisotory, OwnerRepisotory 둘 다 Bean인데, 그래서 주입이 가능하다. @Autowired 굳이 안 써도 됨
        - @Autowired를 쓰지 않고 생성자를 통해서 의존성을 주입하는 것이 훨씬 더 코드가 깔끔하다. (대신, 생성자가 하나이며 파라미터들이 다 Bean, 그리고 해당 클래스 역시 Bean이라면)
        ```
        @Controller
        class PetController{

            private final PetRepisotory pets;
            private final OwnerRepository owners ;

            public PetController(PetRepisotory pets, OwnerRepisotory owners){
                this.pets = pets;
                this.owners = owners;
            }
        }

        ```
    2. 필드
    
        ```
        @Controller
        class OwnerController{
            
            @Autowired
            private final OwnerRepository owners;
        }
        ```

    3. setter
- (우선순위 결론) 생성자가 1순위, 기존에 setter가 존재한다면 setter가 2순위, 그렇지 않다면 필드가 3순위. 만약 setter가 없는 상태인데 @Autowired를 붙이기 위해서 setter를 추가하는 것은 과하다.

- Jpa
    - SpringDataJpa에 있는 인터페이스
    - Jpa 인터페이스를 구현한 인터페이스 타입의 객체(Bean)를 만들어주는 것이 SpringDataJpa. 만들어서 ApplicationContext에 등록해 준다. 
    - 그래서 꼭 @ 어노테이션이 없더라도 Bean으로 등록이 된다.
    ```
    public interface PetRepository extends Repository<Pet, Integer>{
        
        ...

    }
    ```
    - 그래서 아래에서는 파라미터 타입 2개가 모두 Bean이므로 주입이 된다.
    ```    
    @Controller
    class PetController{

        private final PetRepisotory pets;
        private final OwnerRepository owners;

        public PetController(PetRepisotory pets, OwnerRepisotory owners){
            this.pets = pets;
            this.owners = owners;
        }
    }
    ```


# AOP
- 흩어진 코드를 한 곳으로 모으는 것

 ```
 class A{
     method a () {
         AAA
         오늘은 7월 4일 미국 독립 기념일이래요.
         BBBB
     }

     method b () {
        AAAA
        저는 아침에 운동을 다녀와서 밥먹고 빨래를 했습니다.
        BBBB

     }
 }

class B{
    method c() {
        AAAA
        점심은 이거 찍느라 제육볶음을 못 먹었습니다.
        BBBB
    }
}
 ```
 
 - 위에서 모아놓은 AAA와 BBBB
 ```
 class A{
     method a () {
         오늘은 7월 4일 미국 독립 기념일이래요.
     }

     method b () {        
        저는 아침에 운동을 다녀와서 밥먹고 빨래를 했습니다. 
     }
 }

class B{
    method c() {
        점심은 이거 찍느라 제육볶음을 못 먹었습니다.
    }
}

class AAAABBBB{
    method aaa(){ // 함수 이름은 aaabbb로 해도 되고 상관 없다. 그리고 이 메서드안에서 AAAA, BBBB 둘 다 다 뽑아도 된다.
        AAAA 
        
    }

    method bbb(){
        BBBB
    }
}
 ```
- 구현방법 크게 2가지
    1. 바이트 코드를 조작하는 방법
        - 컴파일된 .class 파일을 조작하는 것이다.
        - 이미 컴파일된 코드 안에다가 끼워넣는 것. 끼워넣어서 공통된 코드들의 마치 각각에 다 따로 존재하는 것처럼 동작하게 하는 것이다. 

    2. proxy 패턴 사용하는 것
        - 반복된 코드를 포함하고 있는 클래스를 상속받아서(extends) 해당 메서드들이 실행할 때마다 원래 포함하고 있었던 코드(AAAA)를 다 실행하게 한다.
        - spring에서는 이 proxy 패턴을 사용한다. 
        - (영상의 코드들은 생략 - 12분)
        - 사실 @Transactional 도 마커일 뿐, 트랜잭션을 붙인 곳마다(반복되는 곳) 트랜잭션이 적용되는 코드들이 따로 다 존재함. 그래서 트랜잭션 @ 어노테이션 붙이는 것만으로 다 적용되니까 매우 편리


# PSA(Portable Service Abstraction)
- PSA란?
    - 바꿔서 끼우기 좋은 추상화임
    - 잘 만든 인터페이스
    - 예를 들어 `나의 코드` - `확장성이 좋지 못한 코드 or 기술에 특화되어 있는 코드` 이렇게만 연결이 되어 있다면, 확장성이 좋지 못해서 테스트도 힘들고 기술에만 특화되어 있으므로이 코드들이 변경되면 나의 코드들도 변경 된다.
    - 하지만, `나의 코드` - `잘 만든 인터페이스(PSA)` - `확장성이 좋지 못한 코드 or 기술에 특화되어 있는 코드` 로 되어 있다면 테스트도 좋고 기술 자체를 다른 것으로 바꿀 수도 있다.(ex. jdbc -> hibernate, jpa 등으로 변경) 그렇게 해도 나의 코드를 변경하지 않아도 된다. 
    
    - 확장성이 좋지 못한 코드 or 기술에 특화되어 있는 코드 

- spring에서 제공해주는 PSA의 종류?
    - 사실 spring에서 제공해주는 대부분의 api가 다 PSA다.
    

- 스프링 트랜잭션
    - PSA의 예제
    - 트랜잭션의 과정 코딩을 담아놓은 것이 asepect
    - PlatformTransactionManager 이라는 인터페이스를 사용해서 코딩해 놓은 것임.
    - 이 인터페이스의 구현체들이 있는데, 그것들이 바뀌게 되더라도 트랜잭션의 aspect 코드는 바뀌지 않는다. 그리고 이 구현체는 Bean으로 등록이 된다. 예를 들어 SpringDataJpa를 사용하게 된다면 jpaTransactionManager가 등록이 된다(스프링부트의 자동설정에 의해서). 
    - 1.40초부터~