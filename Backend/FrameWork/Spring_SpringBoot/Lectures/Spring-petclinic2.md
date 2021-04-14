## [예제로 배우는 스프링 입문(개정판)](https://www.inflearn.com/course/spring_revised_edition#)
## []()

- 로깅을 좀 더 자세히 보고 싶으면 INFO -> DEBUG모드로, `application.properties` 파일에다가 아래 작성
    ```
    // logging.level.org.springframework=INFO
    logging.level.org.springframework.web=DEBUG
    ```
- 로그 중에 `o.s.web.servlet.DispatcherServlet` 는 앞에 package가 다 생략되어 있는 것임
    - `org.springframework.web.servlet.DispatcherServlet` 임

### AOP 프록시 패턴
- [proxy설명 참고자료](https://refactoring.guru/design-patterns/proxy)

- Payment 인터페이스
```
public interface Payment {
    void pay(int amount);
}
```
- Store 클래스
```
public class Store {
    Payment payment;

    public Store(Payment payment) {
        this.payment = payment;
    }

    public void buySomething(int amount) {
        payment.pay(amount);
    }
}
```
- Cash 클래스
```
public class Cash implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " 현금 결제");
    }
}
```
- CashPerf 클래스
    - 프록시가 되는 것임
    - 

    
```
public class CashPerf implements Payment {

    Payment cash = new Cash();

    @Override
    public void pay(int amount) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        cash.pay(amount);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
```

- Storetest 클래스
    - Store코드는 변경되지 않았음. 그래서 Cash 코드도 그대로인데 CashPerf 클래스에서 cash 앞 뒤로 성능측정하는 코드가 들어가게 되는 것임. 그래서 "100 현금 결제" 라는 결과값 전 후로 성능 측정 값이 나오게 됨

    ```
    public class StoreTest {

        @Test
        public void testPay() {
            Payment cashPerf = new CashPerf();
            Store store = new Store(cashPerf);
            store.buySomething(100);
        }
    }
    ```
    - 원래는 아래와 같은 코드라서 성능 측정이 되지 않고 "100 현금 결제" 라는 결과값만 얻음
    ```
    public class StoreTest {

        @Test
        public void testPay() {
            Payment cashPerf = new Cash(); // CashPerf -> Cash
            Store store = new Store(cashPerf);
            store.buySomething(100);
        }
    }
    ```
- 이렇게 기존의 코드는 건드리지 않고 새로운 코드를 추가해서 결과값을 다르게 만들었음. AOP를 프록시패턴으로 구현한 것임. 이런 일들이 Spring AOP에서는 대부분 자동으로 이루어지는 것임. 
- 원래는 Cash가 bean으로 등록이 되어야 하는데 프록시가 대신에 등록이 되면서 client가 의도치 않게 Cash 말고 CashPerf를 쓰는 일이 스프링 내부에서 발생하게 됨