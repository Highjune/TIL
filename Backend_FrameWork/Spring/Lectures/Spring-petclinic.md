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


- @에너테이션은 사실 기능이 없다. 주석과도 같다. 그 주석을 단지 어디에 붙일 수 있느냐, 언제까지 주석을 유지할 수 있는지 속성이 있을 뿐, 그 자체로서는 기능이 없다. @에너테이션 자체를 마커로 사용해서 그 에너테이션을 처리하는 process들이 있는 것이다. 마찬가지로 @ComponentScan를 처리하는 애가 따로 있다.
- @ComponentScan은 @SpringBootApplicatoin이 붙어있는 메인클래스부터 시작해서 그 밑으로 모든 패키지, 클래스의 @Component이 붙어있는 것을 찾아서 Bean으로 등록 해준다. ex) @Controller 를 컨트롤+클릭 으로 들어가보면 @Component가 들어있다.
- 물론, 메인함수가 속해있는 패키지 밑으로 모든 패키지, 클래스들에서 @Component라고 붙어있는 것들을 찾을 뿐이지, 메인함수가 속해있는 패키지를 벗어나서 밖에서 @Component를 붙인다면 Bean으로 등록이 안된다. 

- 04:11분부터~ 