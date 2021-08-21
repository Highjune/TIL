## 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술
- [강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1/dashboard) 들은 것 필기

# 웹 애플리케이션 이해
## 웹 서버, 웹 애플리케이션 서버
- 웹은 모든 것이 HTTP 기반으로 동작한다.
    - 클라이언트가 웹 브라우저에서 URL을 입력하면 인터넷을 통해서 서버에 접근.
    - 서버는 HTML을 만들어서 클라이언트에게 내려주면 웹 브라우저는 그 HTML을 받아서 보여준다.
    - 클라이언트 <--> 서버 상호간에 데이터를 주고받을 때 모든 것이 다 HTTP 로 움직인다.


- 웹 서버란?
    - HTTP 기반으로 동작
    - 정적 리소스 제공, 기타 부가기능 
    - 정적(파일) HTML, CSS, JS, 이미지, 영상
        - 특정 폴더에 파일들을 두면 -> `서버가 정적인 파일들을 서빙`. 그래서 특정 사용자마다 다르게 보여주거나 할 수가 없다. (정적)
    - 예) NGINX, APACHE

- 웹 애플리케이션 서버(WAS - Web Application Server)
    - HTTP 기반으로 동작
    - 웹 서버 기능 포함 + (정적 리소스 제공 가능)
    - `(웹서버와 차이) 프로그램 코드를 실행`해서 애플리케이션 로직 수행 (프로그래밍이 가능)
        - 동적 HTML, HTTP API(JSON)
        - 서블릿, JSP, 스프링 MVC
        - 사람들에 따라서 다르게 보여줄 수 있다.(동적)
    - 예) 톰캣(Tomcat), Jetty, Undertow

- 웹 서버, 웹 애플리케이션 서버(WAS) 의 차이는?
    - `웹 서버는 정적 리소스(파일), WAS는 애플리케이션 로직`
    - 사실은 둘의 용어도 경계도 모호함
        - 웹 서버도 프로그램을 실행하는 기능을 포함하기도 함
        - 웹 애플리케이션 서버도 웹 서버의 기능을 제공함
    - 자바는 서블릿 컨테이너 기능을 제공하면 WAS
        - 서블릿 없이 자바코드를 실행하는 서버 프레임워크도 있긴 함
    - `WAS는 애플리케이션 코드를 실행하는데 더 특화`

- 웹 시스템 구성 - WAS, DB 으로 구성한다면?
    - WAS, DB 만으로 시스템 구성 가능
    - WAS는 정적 리소스, 애플리케이션 로직 모두 제공 가능
    - 그런데!
        - WAS가 너무 많은 역할을 담당, 서버 과부하 우려
        - 가장 비싼 애플리케이션 로직이 정적 리소스 때문에 수행이 어려울 수 있음
        - WAS 장애시 오류 화면도 노출 불가능(혼자서 다 수행하는데 자신이 뻗어버리면)
        - 그래서 작은 시스템은 괜찮은데 큰 시스템은 WAS 혼자서 좀 부담스럽다
- 그래서
    - 정적 리소스는 웹 서버가 처리(HTML, CSS, JS, 이미지)
    - 웹 서버는 애플리케이션 로직같은 동적인 처리가 필요하면 WAS에 요청을 위임
    - WAS는 중요한 애플리케이션 로직 처리 전담에 집중(장점)
    
- 웹 시스템 구성 - WEB, WAS, DB 으로 구성한다면?
    - 효율적인 리소스 관리 
        - 정적 리소스가 많이 사용되면 Web만 서버 증설(ex. 4배로)
        - 애플리케이션 리소스가 많이 사용되면 WAS 증설(ex. 8배로)
    - 정적 리소스만 제공하는 웹 서버는 잘 죽지 않음
        - 왜냐하면 정적인 파일들만 읽어서 그냥 보여주는 것이기 때문에
    - 애플리케이션 로직이 동작하는 WAS 서버는 잘 죽음
    - WAS, DB 장애시 WEB 서버가 오류 화면 제공 가능(Web Server에서 오류화면 HTML 보여줌)
    - 그런데 (화면 없이) 데이터를 뿌려주는 API 서버를 제공하게 되면 그때는 굳이 Web Server 가 별도로 필요하진 않다. 

## 서블릿
- 서블릿이 없을 경우 웹 애플리케이션 서버에서 처리해야 하는 업무들을 직접 구현해야 한다.
    - HTML Form 데이터 전송
        - 클라이언트가 POST 전송 - 저장
            - UI : username : kim , age : 20 . 전송
        ```
        <form action="/save" method = "post">
            <input type = "text" name = "username" />
            <input type = "text" name = "age" />
            <button type = "submit">전송</button>
        </form>
        ```
        - 웹 브라우저가 생성한 요청 HTTP 메시지
        ```
        POST /save HTTP/1.1
        Host: localhost:8080
        Content-Type: application/x-www-form-urlencoded  // 폼 양식으로 보내면 이런 타입으로 형성

        username=kim&age=20  // 폼 양식으로 보내면 데이터가 이렇게 넘어간다.
        ```
        - 서버에서 HTTP 응답 메시지 생성
        ```
        HTTP/1.1 200 OK
        Content-Type: text/html;charset=UTF-8
        Content-Length: 3423

        <html>
            <body>...</body>
        </html>
        ```
        - 그런데!!! `서블릿이 없다면` 위와 같은 응답 메시지를 바로 만들어내지 않고 
            - 서버가 받은 위의 요청 메시지를 다 파싱해서 만들어야 한다.(위의 요청 메시지는 그냥 단순 다 텍스트임)
            - 즉 아래의 전체 단계에서 실질적으로는 `비즈니스 로직 실행`, `데이터베이스에 저장` 요청 2가지만 하면 되는데 전 후의 모든 전체 단계를 다 진행해서 HTTP 응답 메시지를 생성해야 한다.
            - 모든 단계를 다 거쳐서야(번거롭게) 서버에서 아래의 HTTP 응답 메시지 생성 

            ![서블릿 기능](https://user-images.githubusercontent.com/57219160/130053883-6cf8fac9-8128-4a2f-9265-404c0107454f.PNG)



      
- 서블릿을 지원하는 WAS 사용
    - 위의 모든 단계들을 직접 다 구현해야 하면 번거로우니까 서블릿 등장!
    - 위의 단계들에서 실질적으로 의미있는 비즈니스 로직은 아래밖에 없다.
    ```
    - 비즈니스 로직 실행
        - 데이터베이스에 저장 요청
    ```
    - 중요) `서블릿은 위의 필수적인 비즈니스 로직을 제외한 모든 것들을 대신 해준다.`

- 서블릿
    - 특징
        ![서블릿코드](https://user-images.githubusercontent.com/57219160/130054105-5ae0d3c5-b729-4a8e-a108-2abf09b529d4.PNG)
        - urlPatterns(/hello)의 URL 이 호출되면 서블릿 코드(위 코드에서 serivce 메서드)가 실행
        - HTTP 요청 정보를 편리하게 사용할 수 있는 HttpServletRequest
            - 요청 정보를 하나하나 다 파싱해서 사용하면 힘드니까!
            - 그래서 그냥 이 request 객체를 사용하면 된다.
            - ex) `request.getParameter("username");` 이런식
        - HTTP 응답 정보를 편리하게 제공할 수 있는 HttpServletResponse
            - 응답 메시지를 하나하나 다 작성하려면 너무 어렵다. 
        - 개발자는 HTTP 스펙을 매우 편리하게 사용


- 서블릿, HTTP 요청, 응답 흐름 (강의다시듣기)

    ![서블릿구조](https://user-images.githubusercontent.com/57219160/130054404-77953ef6-415f-4204-a02d-cca04a47dac4.PNG)
    - HTTP 요청시
        - WAS는 Request, Response 객체를 새로 만들어서 서블릿 객체 호출
            - 고객마다 데이터가 다 다르므로 HTTP 요청이 올 때마다 매번 새로 다 생성한다(싱글톤 아님)
        - 개발자는 Request 객체에서 HTTP 요청 정보를 편리하게 꺼내서 사용
        - 개발자는 Response 객체에 HTTP 응답 정보를 편리하게 입력
        - WAS는 Response 객체에 담겨있는 내용으로 HTTP 응답 정보를 생성
        
        
- 서블릿 컨테이너
    
    ![서블릿컨테이너](https://user-images.githubusercontent.com/57219160/130054697-4fd2841f-8c7b-4414-8661-46a4f230411d.PNG)
    - `WAS 안에는 서블릿을 지원하는 서블릿 컨테이너가 있다.`
    - 톰캣처럼 서블릿을 지원하는 WAS를 서블릿 컨테이너라고 함
    - 서블릿 컨테이너는 서블릿 객체를 생성, 초기화, 호출, 종료하는 생명주기 관리
    - 서블릿 객체는 `싱글톤`으로 관리(자바 JVM안에서 1개만 존재)
        - 고객의 요청이 올 때 마다 계속 객체를 생성하는 것은 비효율
        - 최초 로딩 시점에 서블릿 객체를 미리 만들어두고 재활용
        - `모든 고객 요청은 동일한 서블릿 객체 인스턴스에 접근`
        - `공유 변수 사용 주의`
            - 멤버 변수 사용할 때 조심
        - 서블릿 컨테이너 종료시 함께 종료
    - JSP도 서블릿으로 변환되어서 사용
    - 동시 요청을 위한 멀티 쓰레드 처리 지원
        - 개발자가 따로 의식하지 않아도 WAS가 자동으로 처리


## 동시 요청 - 멀티 쓰레드
- 서버에 요청이 왔을 때 연결(커넥션 연결) 후 servlet 객체를 호출하는데, 서블릿 객체를 누가 호출하나? 바로 쓰레드
![서블릿객체 호출](https://user-images.githubusercontent.com/57219160/130055072-8a82f673-7b4c-48f2-a75b-fd13a0a777f4.PNG)

- 쓰레드
    - 애플리케이션 코드를 하나하나 순차적으로 실행하는 것은 쓰레드
        - cf) 프로세스는 프로그램 실행하는 것
    - 자바 메인 메서드를 처음 실행하면 main이라는 이름의 쓰레드가 실행
    - 쓰레드가 없다면 자바 애플리케이션 실행이 불가능
    - 쓰레드는 한번에 하나의 코드 라인만 수행
    - 동시 처리가 필요하면 쓰레드를 추가로 생성해 줘야 한다.

- 단일 요청
        
    ![1](https://user-images.githubusercontent.com/57219160/130055291-70ef5af3-e1a8-4c8a-8f07-3ff31854e82b.PNG)
    
    ![2](https://user-images.githubusercontent.com/57219160/130055294-07b30ca0-239e-4053-a1fa-c27259955973.PNG)

    - 쓰레드는 휴식 상태이다가, 요청이 오면 connection 연결 후에 쓰레드를 할당해준다.
    - 이 쓰레드를 통해서 서블릿 코드를 하나씩 실행해준다.
    - 응답 후에는 쓰레드가 다시 휴식

- 다중 요청
    - 쓰레드 하나 사용일 때
        ![3](https://user-images.githubusercontent.com/57219160/130055633-a10c190d-a67c-44e9-b177-0cd49a817ff6.PNG)
        ![4](https://user-images.githubusercontent.com/57219160/130055640-265fff5f-e07d-4f5c-b4c1-96925b847628.PNG)

        - 요청1이 들어와서 쓰레드A가 할당이 된 후 서블릿 코드를 실행한다. 그런데 실행 중에 뜻밖의 이유로 처리가 지연이 된다.
        - 그러는 중에 요청2가 들어오게 되면 쓰레드를 할당해줘야 하는데, 쓰레드는 A밖에 없는 상태다. 그래서 쓰레드A를 사용하기 위해 계속 기다려야 한다. 
        - 이렇게 되면 결과는? 둘 다 죽게 된다. 즉 요청1도 처리가 안돼서 지연이 되고 있는 중에(원래는 빨리 다 쓰고 쓰레드A를 반환해줘야 하는데...) 요청2가 수행자체가 안된다.
        - 그래서 결국에는 둘 다 타임아웃이 되면서 죽게 된다.
    - 쓰레드 여럿일 때(요청마다 쓰레드 생성)
        ![5](https://user-images.githubusercontent.com/57219160/130055795-1fa96efb-eb26-47c1-aadf-ae6afbeace0f.PNG)
        - 위의 상황과 마찬가지로, 요청1이 들어와서 쓰레드A가 할당이 된 후 서블릿 코드를 실행한다. 그런데 실행 중에 뜻밖의 이유로 처리가 지연이 된다.
        - 그러는 중에 요청2가 들어오는데, 아까와는 달리 기다리지 않고 신규 쓰레드B를 생성한다.
        - 그래서 쓰레드A가 요청 1 처리하는 중에 쓰레드B는 요청2에 대한 응답2를 보내주고 난 후 다시 휴식.
- 요청 마다 쓰레드 생성
    - 장점
        - 동시 요청을 처리할 수 있다.
        - 리소스(CPU, 메모리)가 허용할 때까지 처리가능
        - 하나의 쓰레드가 지연되어도, 나머지 쓰레드는 정상 동작한다.

    - 단점
        - 쓰레드는 생성 비용은 매우 비싸다(CPU도 많이 사용한다)
            - 고객의 요청이 올 때마다 쓰레드를 생성하면, 응답 속도가 늦어진다.(생성하는데 시간이 걸리기 때문에)
        - 쓰레드는 컨텍스트 스위칭 비용이 발생한다.
            - CPU가 사실 몇 코어 정도로 많이 없는데, 하나의 코어가 있다고 가정. 하나의 CPU는 2개의 쓰레드를 계속 왔다갔다 하면서 실행(동시에 실행하는 것이 아니다)
            - 쓰레드가 많을수록 스위칭 비용 증가
        - 쓰레드 생성에 제한이 없다.
            - 고객 요청이 너무 많이 오면, CPU, 메모리 임계점을 넘어서 서버가 죽을 수 있다.
    - 이러한 단점을 보완하기 위해서 대다수의 WAS는 쓰레드 풀을 쓰도록 구현이 되어 있다.

- 쓰레드 풀

    ![6](https://user-images.githubusercontent.com/57219160/130056108-85178553-8e76-4d79-9b8d-1e2263612198.PNG)
    - 특징
        - 필요한 쓰레드를 쓰레드 풀에 보관하고 관리한다.
        - 쓰레드 풀에 생성 가능한 쓰레드의 최대치를 관리한다. 톰캣은 최대 200개 기본 설정 (변경 가능)
    - 사용
        - 쓰레드가 필요하면, 이미 생성되어 있는 쓰레드를 쓰레드 풀에서 꺼내서 사용한다.
        - 사용을 종료하면 쓰레드 풀에 해당 쓰레드를 반납한다.
        - 최대 쓰레드가 모두 사용중이어서 쓰레드 풀에 쓰레드가 없으면?
            - 기다리는 요청은 `거절`하거나 특정 숫자만큼 `대기`하도록 설정할 수 있다.
    - 장점
        - 쓰레드가 미리 생성되어 있으므로, 쓰레드를 생성하고 종료하는 비용(CPU)이 절약되고, 응답 시간이 빠르다.
        - 생성 가능한 쓰레드의 최대치가 있으므로 너무 많은 요청이 들어와도 기존 요청은 안전하게 처리할 수 있다.(당연히 서버를 늘리긴 해야 함)
    - 실무 팁
        - WAS의 주요 튜닝 포인트는 최대 쓰레드(max thread) 수이다. 
            - 문제 해결시 이걸 통해서 극적인 효과를 보는 경우가 많다.
        - 이 값을 너무 낮게 설정하면?
            - 동시 요청이 많으면, 서버 리소스는 여유롭지만, 클라이언트는 금방 응답 지연
        - 이 값을 너무 높게 설정하면?
            - 동시 요청이 많으면, CPU, 메모리 리소스 임계점 초과로 서버 다운
        - 장애 발생시?
            - 클라우드면 일단 서버부터 늘리고(일단 서비스는 살아있어야 하니까), 이후에 튜닝
            - 클라우드가 아니면(클라우드처럼 서버를 쉽게 늘릴 수 없으니) 열심히 튜닝


- 쓰레드 풀을 낮게 설정했을 경우(반대의 경우는 다 반대)
    - 남은 90개는 다 기다려야 한다.
    - CPU 를 5%밖에 사용안한다? -> 개발자가 셋팅을 잘못한 것임. 그런데 그것도 모르고 막 서버를 늘리는 경우가 종종 있다. 원래 이럴 경우에는 CPU 사용률의 한 50%는 써줘야 한다. 그 말은 하나의 서버로 기존보다 10배의 효과를 낼 수 있다는 말.

    ![쓰레드풀 낮게](https://user-images.githubusercontent.com/57219160/130056294-43e7fa5e-92cc-4100-a538-3de731e8d172.PNG)

- 쓰레드 풀의 적정 숫자
    - 적정 숫자는 어떻게 찾나요?
    - 애플리케이션 로직의 복잡도, CPU, 메모리, IO 리소스 상황에 따라 모두 다름
        - 꼭 200개 이런건 절대 아니다. 답이 없다.
    - 성능 테스트
        - 오픈하기 전에 꼭 해야 한다.
        - 최대한 실제 서비스와 유사하게 성능 테스트 시도
        - 툴: 아파치 ab, 제이미터, nGrinder(네이버껀데 되게 좋다)

- WAS의 멀티 쓰레드 지원이 핵심
    - `멀티 쓰레드에 대한 부분은 WAS가 처리` -> 이게 제일 핵심이다.
        - 만약 개발자가 직접 멀티 쓰레드를 구현하려고 하면 자바 concurrency 공부해야 하고...매우 힘듦
    - 개발자가 멀티 쓰레드 관련 코드를 신경쓰지 않아도 됨
        - 우리는 서블릿 코드 안에 비즈니스 로직만 넣으면 된다.
    - 개발자는 마치 싱글 쓰레드 프로그래밍을 하듯이 편리하게 소스 코드를 개발
    - 멀티 쓰레드 환경이므로 싱글톤 객체(서블릿, 스프링 빈)는 주의해서 사용
        - 공유 변수 조심

## HTML, HTTP API, CSR, SSR
- 정적 리소스
    - 고정된 HTML 파일, CSS, JS, 이미지, 영상 등을 제공
    - 주로 웹 브라우저
    <img width="888" alt="스크린샷 2021-08-20 오전 12 06 34" src="https://user-images.githubusercontent.com/57219160/130093248-85546981-ce5c-4a96-b79e-e0b214292d53.png">
- HTML 페이지
    - 동적으로 필요한 HTML 파일을 생성해서 전달
        - 주문 내역 보여달라~
    - 웹 브라우저: HTML 해석(렌더링)
    <img width="1015" alt="스크린샷 2021-08-20 오전 12 08 25" src="https://user-images.githubusercontent.com/57219160/130093484-5e613edc-795f-456d-bd8b-204acd06e2f5.png">
- HTTP API
    - HTML이 아니라 데이터를 전달
        - 이렇게 데이터를 전달하는 것을 HTTP API라고 한다. 
        - HTML 을 주고 받는 것을 제외한 모든 곳에서 사용
    - 주로 JSON 형식 사용
    - 다양한 시스템에서 호출
    <img width="1085" alt="스크린샷 2021-08-20 오전 12 09 26" src="https://user-images.githubusercontent.com/57219160/130093642-3b948d75-54c8-416c-9fc4-01500ccd6dcb.png">
    - 데이터만 주고 받음, UI 화면이 필요하면, 클라이언트가 별도 처리
    - 주로 3가지 상황에서 사용이 된다.
        1. 앱
        2. 웹 클라이언트
        3. 서버 to 서버
    <img width="1084" alt="스크린샷 2021-08-20 오전 12 10 35" src="https://user-images.githubusercontent.com/57219160/130093846-88cb640c-086e-4948-84af-b052ad56926c.png">
- HTTP API 다양한 시스템 연동
    - 주로 JSON 형태로 데이터 통신
    - UI 클라이언트 접점
        1. 앱 클라이언트(아이폰, 안드로이드, PC 앱)
        2. 웹 브라우저에서 자바스크립트를 통한 HTTP API 호출
        3. React, Vue.js 같은 웹 클라이언트 (2번에서 발전된 형태)
    - 서버 to 서버
        - 주문 서버 -> 결제 서버
            - 서로 HTML을 주고 받을 필요 자체가 없으니까 데이터만 주고 받는다.
        - 기업간 데이터 통신
            - MSA 방식에서 많이 사용. 기업안에서 모든 서비스들이 다 작게 나눠져 있음

- 그래서 백엔드 개발자가 서비스를 제공할 때 고민해야 할 것들이 총 3가지다.(HTTP로 주고받을 때)
    - 정적 리소스
    - 동적인 HTML 페이지
    - HTTP API 


- 서버사이드 렌더링, 클라이언트 사이드 렌더링
    - SSR (서버 사이드 렌더링)
        <img width="1039" alt="스크린샷 2021-08-20 오전 12 34 28" src="https://user-images.githubusercontent.com/57219160/130098020-6cb410a4-edaf-4378-bd80-692d4cf6b1ae.png">
        - HTML 최종 결과를 서버에서 만들어서 웹 브라우저에 전달
        - 주로 정적인 화면에 사용(구글 지도 등에 비해서 페이지 자체로만 본다면 정적인 페이지를 보여주는 것이므로 상대적으로 정적임)
        - 관련기술 : JSP, 타임리프 -> `백엔드 개발자`
    - CSR (클라이언트 사이드 렌더링)
        <img width="1061" alt="스크린샷 2021-08-20 오전 12 35 19" src="https://user-images.githubusercontent.com/57219160/130098152-ca6046f2-0a1d-41ee-b5af-7406b66a6d7a.png">
        - HTML 결과를 자바스크립트를 사용해 웹 브라우저에서 동적으로 생성해서 적용
        - 주로 동적인 화면에 사용, 웹 환경을 마치 앱처럼 필요한 부분부분 변경할 수 있음
        - ex) 구글 지도, GMail, 구글 캘린더
        - 관련기술 : React, Vue.js -> `웹 프론트엔드 개발자`
    - 참고
        - React, Vue.js 를 CSR + SSR 동시에 지원하는 웹 프레임워크도 있음
        - SSR을 사용하더라도, 자바스크립트를 사용해서 화면 일부를 동적으로 변경 가능
    
- 어디까지 알아야 하나(백엔드 개발자 입장에서 UI 기술)
    - 백엔드 - 서버 사이드 렌더링 기술
        - JSP, 타임리프
            - JSP는 거의 사장. 타임리프 추천
        - 화면이 정적이고, 복잡하지 않을 때 사용
        - 백엔드 개발자는 서버 사이드 렌더링 기술 학습 `필수`
            - 왜나하면 간단한 admin 화면이나 고객에게 보여지는 간단한 페이지 같은 것들은 쉽게 만들줄 알아야 한다.
    - 웹 프론드엔드 - 클라이언트 사이드 렌더링 기술
        - React, Vue.js
        - 복잡하고 동적인 UI 사용
        - 웹 프론트엔드 개발자의 전문 분야
    - 선택과 집중
        - 백엔드 개발자의 웹 프론트엔드 기술 학습은 `옵션`
        - 백엔드 개발자는 서버, DB, 인프라 등등 수많은 백엔드 기술을 공부해야 한다.
            - 그렇기 때문에 웹 프론트엔드 기술 공부할 시간 등이 별로 없다.
        - 웹 프론트엔드도 깊이있게 잘 하려면 숙련에 오랜 시간이 필요하다.

- 자바 웹 기술 역사
    - 과거 기술
        - 서블릿 - 1997
            - TCP 연결 등 다양한 면에서 지원을 많이 해줌.
            - 그러나 HTML 생성이 어려움(자바 코드로 짜야하기 때문에 동적으로 매우 까다로움)
        - JSP - 1999
            - HTML 생성은 편리하지만, 비즈니스 로직까지 너무 많은 역할 담당
        - 서블릿, JSP 조합 MVC 패턴 사용
            - 모델, 뷰 컨트롤러로 역할을 나누어 개발(핵심은 비즈니스 로직부분과 화면렌더링 부분을 크게 2가지로 나누는 것)
        - MVC 프레임워크 춘추 전국 시대 - 2000년 초 ~ 2010년 초
            - MVC 패턴 자동화, 복잡한 웹 기술을 편리하게 사용할 수 있는 다양한 기능 지원
            - 스트럿츠, 웹워크, 스프링 MVC(과거 버전)
    - 현재 사용 기술
        - 애노테이션 기반의 스프링 MVC 등장
            - @Controller
            - MVC 프레임워크의 춘추 전국 시대 마무리
            - 기본이 서블릿 기반으로 동작. 서블릿에 MVC를 얹어서 동작하는 방식
        - 스프링 부트의 등장
            - 스프링 부트는 서버를 내장(수많은 자동화를 해주지만 그 중에서도 가장 강력한 기능)
            - 과거에는 서버에 WAS(ex. 톰캣)를 직접 설치, 실행하고, 소스는 War 파일을 만들어서 설치한 WAS에 배포
            - 스프링 부트는 빌드 결과(Jar)에 WAS 서버 포함 -> 빌드 배포 단순화(서버에 톰캣을 설치할 필요가 없다)
            - 빌드된 Jar 파일을 아무 서버에 넣고 jar로 실행하기만 하면 된다. 그럼 서버가 뜨고 내가 만든 코드들이 실행이 된다. 
    - 최신 기술
        - 스프링 웹 기술의 분화(2가지로)
        1. Web Servlet - Spring MVC
        2. Web Reactive - Spring WebFlux(스프링 웹 플럭스)
            - 완전 최신 기술
                - 특징
                    - 비동기 넌 블러킹 처리
                    - 최소 쓰레드로 최대 성능 - 쓰레드 컨텍스트 스위칭 비용 효율화
                        - 만약 CPU의 코어가 4개라면 쓰레드도 4개나 +1 해서 CPU 개수에 맞춤. 그러면 고효율로 쓰레드를 CPU 개수에 맞췄기 때문에 이 쓰레드들은 계속 돌아갈 수 있는 것.그러면 컨텍스트 스위칭 비용이 거의 들지 않는다.
                    - 함수형 스타일로 개발 - 동시처리 코드 효율화
                        - 코드 자체가 깔끔해지기 때문에, 상품, 회원 조회등 여러가지 api 들을 다 통해서 한번에 처리해야 할 때 효율높다
                    - 서블릿 기술 사용X
                        - Netty라는 프레임워크로 동작
                - 그런데
                    - 웹 플럭스는 기술적 난이도 매우 높음
                    - 아직은 RDB 지원 부족
                        - 그래서 redis 등 다른 것들 사용해야 한다.
                    - 일반 MVC의 쓰레드 모델도 충분히 빠르다.
                    - 실무에서 아직 많이 사용하지는 않음(전체 1% 이하)
- 자바 뷰 템플릿 역사
    - 뷰 템플릿?
        - HTML을 편리하게 생성. 백엔드에서 동적으로 생성하는 것.
    - JSP
        - 속도 느림, 기능 부족
        - 스프링부트에서 권장하지 않는다.
    - 프리마커(Freemarker), Velocity(벨로시티)
        - 속도 문제 해결, 다양한 기능
    - 타임리프(Thymelaf)
        - 내추럴 템플릿: HTML의 모양을 유지하면서 뷰 템플릿 적용 가능
            - JSP, 프리마커, 벨로시티는 중간에 코드들이 섞여있어서 불편
            - 타임리프는 HTML의 태그에다가 속성을 추가해서 문제를 해결해서 깔끔하다.
        - 스프링 MVC와 강력한 기능 통합
            - 스프링 진영의 예제코드들은 다 타임리프. 즉 타임리프를 밀어준다.
        - `최선의 선택`, 단 성능은 프리마커, 벨로시티가 더 빠름


## 서블릿
- 코딩하면서 진행
- 서블릿이란 결국 개발자가 HTTP 요청을 어떻게 받고 HTTP 응답을 어떻게 내려줄 것인가를 어떻게 편하게 구현할까에 대한 것
- 프로젝트 생성
    - 스프링 부트로 생성.
        - 사실 서블릿은 스프링, 스프링부트가 전혀 필요없다. 대신 스프링부트가 환경설정도 편하고 톰캣 WAS서버를 내장하고 있기에 편리.
        - 실제로 스프링은 거의 사용하지 않을 예정
    - 프로젝트 선택
        - Prjoject: Gradle Project
        - Language : Java
        - Spring Boot: 2.4.x(나는 2.5.x 그냥 최신버전 하면 된다)
    - Project metadata
        - Group: hello
        - Artifact: servlet
        - Name: servlet
        - Package name: hello.servlet
        - Packaging: War(주의)!
            - 보통은 jar로 하는데 JSP를 사용하기 위해서(공부목적) War를 선택해야 한다.
            - 그리고 War로 하게 되면 Jar도 가능하고 War도 가능. 또한 톰캣을 내장하는 것도 가능하다.
        - Java : 11
    - Dependencies
        - Spring Web
        - lombk
    - Genarate
- 다운받은 파일 압축 풀고, intelliJ 에서 오픈 - 해당폴더에서 build.gradle 열기 - open as project
- 프로젝트 열어서 War인 것 확인하기 
    - build.gradle에서 확인
    ```
    plugins {
        id 'org.springframework.boot' version '2.4.3'
        id 'io.spring.dependency-management' version '1.0.11.RELEASE'
        id 'java'
        id 'war'
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
        implementation 'org.springframework.boot:spring-boot-starter-web'
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }
    test {
        useJUnitPlatform()
    }

    ```
- 동작확인
    - 기본 메인 클래스 실행( ServletApplication.main() 
    - http://localhost:8080 호출해서 Whitelabel Error Page가 나오면 정상 동작

- IntelliJ Gradle 대신에 자바 직접 실행
    - 최근 IntelliJ 버전은 Gradle을 통해서 실행 하는 것이 기본 설정이다. 이렇게 하면 실행속도가 느리다. 
다음과 같이 변경하면 자바로 바로 실행해서 실행속도가 더 빠르다

    - Preferences Build, Execution, Deployment Build Tools Gradle
        - Build and run using: Gradle IntelliJ IDEA
        - Run tests using: Gradle IntelliJ IDEA
    - 만약) 윈도우 사용자 (File -> Setting)

    - 주의) IntelliJ 무료 버전의 경우 해당 설정을 IntelliJ IDEA가 아니라 Gradle로 설정해야 한다
        -  Jar 파일의 경우는 문제가 없는데, War의 경우 톰캣이 정상 시작되지 않는 문제가 발생한다. 유료 버전은 모두 정상 동작한다.
        - 또는 > 또는 build.gradle 에 있는 다음 코드를 제거해도 된다. 
        ```
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat
        ```
- 롬복 적용
    - Preferences plugin lombok 검색 실행 (intelliJ 재시작)
    - Preferences Annotation Processors 검색 Enable annotation processing 체크 (재시작)
    - 임의의 테스트 클래스를 만들고 @Getter, @Setter 확인
    - 윈도우 사용자는 (File -> Setting)

- Postman 설치
    - https://www.postman.com/downloads

## Hello 서블릿
- 참고
    - 서블릿은 톰캣 같은 웹 애플리케이션 서버를 직접 설치하고,그 위에 서블릿 코드를 클래스 파일로 빌드해서 올린 다음, 톰캣 서버를 실행하면 된다. 하지만 이 과정은 매우 번거롭다. 스프링 부트는 톰캣 서버를 내장하고 있으므로, 톰캣 서버 설치 없이 편리하게 서블릿 코드를 실행할 수 있다.

- 스프링 부트 서블릿 환경 구성
    - `ServletComponentScan`
        - 스프링 부트는 서블릿을 직접 등록해서 사용할 수 있도록 @ServletComponentScan 을 지원한다. 다음과 같이 추가하자.
        - 추가하면 현재의 패키지 `package hello.servlet` 포함하여 하위패키지 다 찾아서 서블릿을 다 찾아서 자동으로 등록해서 실행할 수 있도록 도와준다.
    ```
    package hello.servlet;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.boot.web.servlet.ServletComponentScan;

    @ServletComponentScan //서블릿 자동 등록
    @SpringBootApplication
    public class ServletApplication {
        public static void main(String[] args) {
                SpringApplication.run(ServletApplication.class, args);
            }
        }   
    ```

- HelloServlet 클래스
    - HttpServlet 상속받아야 한다.
    - @WebServlet - 서블릿 애노테이션 (아래 2개는 다른 것들과 겹치면 안된다)
        - name : 서블릿 이름
        - urlPattenrs : URL 매핑
    
    ```
    @WebServlet(name = "helloServlet", urlPatterns = "/hello")
    public class HelloServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse 
        response) throws ServletException, IOException {
            System.out.println("HelloServlet.service");
        }
    }
    ```
- HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
    - command + o -> service 검색 -> 자물쇠 표시의 service 메서드 클릭하면 자동생성(아니면 하나하나 새로 다 입력해도 된다)
```
protected void service(HttpServletRequest request, HttpServletResponse response)
```
- 웹 브라우저 실행
    - localhost:8080/hello
    - 콘솔에 찍힌다.
    - `http요청이 오면 WAS(서블릿 컨테이너)가 request, response 객체를 만들어서 서블릿에 준다.`
        - 톰캣 라이브러리 객체들
    - 웹 브라우저에 요청 -> 브라우저가 HTTP요청 메시지 만듬 -> 그걸 서버에 전송
    
- request, response 객체 확인. 
    - 코드 추가해서 찍어보기
    ```
    @WebServlet(name = "helloServlet", urlPatterns = "/hello")
    public class HelloServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse 
        response) throws ServletException, IOException {  
            System.out.println("HelloServlet.service");
            System.out.println("request = " + request);
            System.out.println("response = " + response);
        }
    }
    ```
    - 로그보기
        - org.apache.catalina.connector 이것들은 톰캣 라이브러리
        - HttpServletRequest, HttpServletResponse -> 다 인터페이스임. 톰캣이나 제티 등등 WAS서버가 많은데, 그 WAS 서버들이 이 서블릿 표준스펙(HttpServletRequest, HttpServletResponse)을 구현하는 것. 그래서 밑에 로그에 찍힌 것들은 그 구현체들이다.
    ```
    HelloServlet.service
    request = org.apache.catalina.connector.RequestFacade@35e2e52
    response = org.apache.catalina.connector.ResponseFacade@35e2e52
    ```

- 쿼리파라미터 넣어보기
    - 서블릿은 쿼리파라미터를 굉장히 편하게 읽도록 지원해준다.
    - 엄청 편리. 만약에 내가 직접 HTTP 스펙 메시지들을 다 파싱해야 한다면 너무 까다롭다. 그런데 이런것보다도 더 편리하게 나중에 MVC 프레임워크가 나오게 된 것
    ```
    @WebServlet(name = "helloServlet", urlPatterns = "/hello")
    public class HelloServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse 
        response) throws ServletException, IOException {  
            System.out.println("HelloServlet.service");
            System.out.println("request = " + request);
            System.out.println("response = " + response);

            String username = request.getParameter("username");
            System.out.println("username = " + username);
        }
    }
    ```
    - localhost:8080/hello?username=kim 으로 접속하면 로컬에 찍힌다
    ```
    HelloServlet.service
    request = org.apache.catalina.connector.RequestFacade@35e2e52
    response = org.apache.catalina.connector.ResponseFacade@35e2e52
    username = kim
    ``` 
- 응답메시지 보내보기
    - response에 값을 넣으면 HTTP 응답메시지에 데이터가 담겨서 나가게 된다.
    - `response.setContentType("text/plain")`
        - 응답 메시지 데이터타입 설정. Header에 들어감
    - `response.setCharacterEncoding("utf-8");`
        - 응답 메시지 캐릭터 셋 설정. Header에 들어감
    - `response.getWriter().write();`
        - 응답 메시지의 Body에 내용을 쓴다.
    ```
    @WebServlet(name = "helloServlet", urlPatterns = "/hello")
    public class HelloServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse 
        response) throws ServletException, IOException {  
            System.out.println("HelloServlet.service");
            System.out.println("request = " + request);
            System.out.println("response = " + response);

            String username = request.getParameter("username");
            System.out.println("username = " + username);

            response.setContentType("text/plain"); 
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("hello " + username);
        }
    }
    ```
    - 서버 재시작 후 가능.
    - localhost:8080/hello?username=kim 새로고침
    - hello kim만 보이고 페이지 소스보기 해도 똑같다.
    - f12로 개발자도구로 보면 Response, Request 다 볼 수 있다.
        - 내가 보낸 것 다 확인가능
        ```
        Content-Type: text/plain;charset=utf-8
        ```
    - localhost:8080/hello?username=`김` 한글로도 가능

- HTTP 요청 메시지 로그로 확인하기
    - 개발할 때 HTTP요청 메시지 전체를 다 보고 싶을 때
    - application.properties에 설정 추가하기
    ```
    logging.level.org.apache.coyote.http11=debug
    ```
    - 서버를 다시 시작하고, 요청해보면 서버가 받은 HTTP 요청 메시지를 출력하는 것을 확인할 수 있다. (콘솔에)
    ```
    ...o.a.coyote.http11.Http11InputBuffer: Received [GET /hello?username=servlet 
    HTTP/1.1
    Host: localhost:8080

    Connection: keep-alive
    Cache-Control: max-age=0
    sec-ch-ua: "Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99"
    sec-ch-ua-mobile: ?0
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_1) AppleWebKit/537.36 
    (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/
    webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
    Sec-Fetch-Site: same-origin
    Sec-Fetch-Mode: navigate
    Sec-Fetch-User: ?1
    Sec-Fetch-Dest: document
    Referer: http://localhost:8080/basic.html
    Accept-Encoding: gzip, deflate, br
    Accept-Language: ko,en-US;q=0.9,en;q=0.8,ko-KR;q=0.7
    ]
    ```
    - 참고
        - 운영서버에 이렇게 모든 요청 정보를 다 남기면 성능저하가 발생할 수 있다. 개발 단계에서만 적용하자

- 서블릿 컨테이너 동작 방식 설명
    - `스프링 부트가 실행되면서 내장된 톰캣 서버가 실행. 톰캣 서버는 내부에 서블릿 컨테이너 기능을 갖고 있어서 서블릿을 생성해준다.`
    ![톰캣서버](https://user-images.githubusercontent.com/57219160/130194799-edf0c72d-4720-4d87-9aab-99dbc749ffae.PNG)
    ![2](https://user-images.githubusercontent.com/57219160/130194850-3febcb13-56f5-4422-bb2a-7859e350fd30.PNG)

    - 참고) HTTP 응답에서 Content-Length 등 부가정보들은 WAS(웹 애플리케이션 서버)가 자동으로 생성해준다.

- welcome 페이지 추가
    - 지금부터 개발할 내용을 편리하게 참고할 수 있도록 welcome 페이지를 만들어두자
    - 폴더 만들기
        - src/main/webapp 폴더 만들기(new Directory로)
        - 그 밑에 index.html 만들기
    - webapp 경로에 index.html 을 두면 http://localhost:8080 호출시 index.html 페이지가 열린다.
    - index.html
        - (코드생략)
    - basic.html
        - (코드생략)
    - 서버 재시작 후 localhost:8080 으로 접속 (localhost:8080/index.html 들어와도 똑같다)

## HelloServletRequest - 개요
- HttpServletRequest 역할
    - HTTP 요청 메시지를 개발자가 직접 파싱해서 사용해도 되지만, 매우 불편할 것이다. 서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다. 그리고 그 결과를 HttpServletRequest 객체에 담아서 제공한다.
- HTTP 요청 메시지
    ```
    POST /save HTTP/1.1
    Host: localhost:8080
    Content-Type: application/x-www-form-urlencoded

    username=kim&age=20
    ```
    - START LINE
        - HTTP 메서드
        - URL
        - 쿼리 스트링
        - 스키마, 프로토콜
    - 헤더
        - 헤더 조회
    - 바디  
        - form 파라미터 형식 조회
        - message body 데이터 직접 조회
    
- HttpServletRequest 객체는 추가로 여러가지 부가기능도 함께 제공한다.
    - 임시 저장소 기능
        - 해당 HTTP 요청이 시작부터 끝날 때 까지(생존기간) 유지되는 임시 저장소 기능
            - 저장 : request.setAttribute(name, value)
            - 조회 : request.getAttribute(name)
    - 세션 관리 기능
        - request.getSession(create: true)
    - 중요
        - HttpServletRequest, HttpServletResponse를 사용할 때 가장 중요한 점은 이 객체들이 HTTP 요청 메시지, HTTP 응답 메시지를 편리하게 사용하도록 도와주는 객체라는 점이다. 따라서 이 기능에 대해서 깊이있는 이해를 하려면 HTTP 스펙이 제공하는 요청, 응답 메시지 자체를 이해해야 한다.


## HttpServletRequest - 기본 사용법
- hello.servlet.basic.request.RequestHeaderServlet
```
package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//http://localhost:8080/request-header?username=hello
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
    public class RequestHeaderServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse 
    response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
        response.getWriter().write("ok");
    }
}
```
- start-line 정보
```
//start line 정보
private void printStartLine(HttpServletRequest request) {
    System.out.println("--- REQUEST-LINE - start ---");

    System.out.println("request.getMethod() = " + request.getMethod()); //GET
    System.out.println("request.getProtocal() = " + request.getProtocol()); //
    HTTP/1.1
    System.out.println("request.getScheme() = " + request.getScheme()); //http
    // http://localhost:8080/request-header
    System.out.println("request.getRequestURL() = " + request.getRequestURL());
    // /request-test
    System.out.println("request.getRequestURI() = " + request.getRequestURI());
    //username=hi
    System.out.println("request.getQueryString() = " +
    request.getQueryString());
    System.out.println("request.isSecure() = " + request.isSecure()); //https 
    사용 유무
    System.out.println("--- REQUEST-LINE - end ---");
    System.out.println();
}
```
- start-line 정보 결과
```
--- REQUEST-LINE - start ---
request.getMethod() = GET
request.getProtocal() = HTTP/1.1
request.getScheme() = http
request.getRequestURL() = http://localhost:8080/request-header
request.getRequestURI() = /request-header
request.getQueryString() = username=hello
request.isSecure() = false
--- REQUEST-LINE - end ---
```

- 헤더 정보
    - 만약 하나만 딱 조회하고 싶으면 request.getHeader("host"); 같이.
```
//Header 모든 정보
private void printHeaders(HttpServletRequest request) {
    System.out.println("--- Headers - start ---");

    /* 예전 방식
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        System.out.println(headerName + ": " + request.getHeader(headerName));
    }
    */

    // 요즘 방식
    request.getHeaderNames().asIterator()
    .forEachRemaining(headerName -> System.out.println(headerName + ": 
    " + request.getHeader(headerName)));

    System.out.println("--- Headers - end ---");
    System.out.println();
}

```
- 헤더 정보 결과
    - 이렇게나 많은 이유는 웹 브라우저가(f12 개발자 도구로 확인 가능) 이렇게 많은 정보를 보내는 것
```
--- Headers - start ---
host: localhost:8080
connection: keep-alive
cache-control: max-age=0
sec-ch-ua: "Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99"
sec-ch-ua-mobile: ?0
upgrade-insecure-requests: 1
user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_0) AppleWebKit/537.36 
(KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/
webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: none
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
accept-encoding: gzip, deflate, br
accept-language: ko,en-US;q=0.9,en;q=0.8,ko-KR;q=0.7
--- Headers - end ---
```

- Header 편리한 조회
```
//Header 편리한 조회
private void printHeaderUtils(HttpServletRequest request) {
    System.out.println("--- Header 편의 조회 start ---");

    System.out.println("[Host 편의 조회]");
    System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
    System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
    System.out.println();

    System.out.println("[Accept-Language 편의 조회]");

    request.getLocales().asIterator()
         .forEachRemaining(locale -> System.out.println("locale = " +
    locale));

    System.out.println("request.getLocale() = " + request.getLocale()); // 여러 Locale중에 가장 위에 있는 것(우선순위 젤 빠른 것. ko)를 들고옴
    System.out.println();

    System.out.println("[cookie 편의 조회]");
    if (request.getCookies() != null) {
        for (Cookie cookie : request.getCookies()) {
        System.out.println(cookie.getName() + ": " + cookie.getValue());
        }
    }
    System.out.println();

    System.out.println("[Content 편의 조회]");
    System.out.println("request.getContentType() = " + request.getContentType());
    System.out.println("request.getContentLength() = " + request.getContentLength());
    System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

    System.out.println("--- Header 편의 조회 end ---");
    System.out.println();
}
```
- Header 편리한 조회 결과
    - https://localhost:8080/request-header 브라우저에서 조회
        - 브라우저에서 조회하면 기본이 Get 메서드이다.
    - 쿠키 정보는 지금 없어서 안 나오는 것
    - request.getContentType() = null 인 이유는, get방식이므로 body에 무엇인가 담겨있어야 그에 대한 타입이 있는데 애초에 데이터가 없으니까.
        - 포스트맨으로 확인할 수 있다(내용이 있으면 ContentType이 뜨는지)
            - POST방식, https://localhost:8080/request-header
            - Body에 raw의 text로 해서 "hello" 찍으면.
            - Headers에 Content-Type에 text/plain이 자동으로 설정된다.
            - send 버튼 누르면 콘솔에 request.getContentType() = text/plain 찍힌다
            
```
--- Header 편의 조회 start ---
[Host 편의 조회]
request.getServerName() = localhost
request.getServerPort() = 8080

[Accept-Language 편의 조회]
locale = ko
locale = en_US
locale = en
locale = ko_KR
request.getLocale() = ko  

[cookie 편의 조회]

[Content 편의 조회]
request.getContentType() = null
request.getContentLength() = -1
request.getCharacterEncoding() = UTF-8
--- Header 편의 조회 end ---
```

- 기타 정보
    - 기타 정보는 HTTP 메시지의 정보는 아니다.(내부에서 네트워크 커넥션 맺어진 정보)
    - Remote 정보는 요청이 온 것에 대한 정보.
    - Local 정보는 내 서버에 대한 정보.
```
// 기타 정보
private void printEtc(HttpServletRequest request) {
    System.out.println("--- 기타 조회 start ---");

    System.out.println("[Remote 정보]");
    System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
    System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
    System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
    System.out.println();

    System.out.println("[Local 정보]");
    System.out.println("request.getLocalName() = " + request.getLocalName()); //
    System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
    System.out.println("request.getLocalPort() = " + request.getLocalPort()); //

    System.out.println("--- 기타 조회 end ---");
    System.out.println();
}
```
- 기타 정보 결과
```
--- 기타 조회 start ---
[Remote 정보]
request.getRemoteHost() = 0:0:0:0:0:0:0:1
request.getRemoteAddr() = 0:0:0:0:0:0:0:1
request.getRemotePort() = 54305

[Local 정보]
request.getLocalName() = localhost
request.getLocalAddr() = 0:0:0:0:0:0:0:1
request.getLocalPort() = 8080
--- 기타 조회 end ---
```

- 참고
    - 로컬에서 테스트하면 IPv6 정보가 나오는데, IPv4 정보를 보고 싶으면 다음 옵션을 VM options에 넣어주면 된다.
    ```
    -Djava.net.preferIPv4Stack=true
    ```

- 지금까지 HttpServletRequest를 통해서 HTTP 메시지의 start-line, header 정보 조회 방법을
이해했다. 이제 본격적으로 HTTP 요청 데이터를 어떻게 조회하는지 알아보자


## HTTP 요청 데이터 - 개요
- HTTP 요청 메시지를 통해 `클라이언트에서 -> 서버로 데이터를 전달하는 방법`을 알아보자.

- 주로 다음 3가지 방법을 사용(이 3가지 안에 다 들어있음)
    - `GET - 쿼리 파라미터`
        - /url`?username=hello&age=20`
        - 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
        - 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
        - 구글 검색엔진에서 'hello'라고 검색했을 때 url에 수많은 쿼리 파라미터 넘어가는 것 확인가능 
    - `POST - HTML Form`
        - content-type: application/x-www-form-urlencoded
        - 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20
        - 예) 회원 가입, 상품 주문, HTML Form 사용
    - `HTTP message body`에 데이터를 직접 담아서 요청
        - HTTP API에서 주로 사용, JSON, XML, TEXT
        - 데이터 형식은 주로 JSON 사용
        - POST, PUT, PATCH
        - 참고
            - HTML 의 Form 데이터를 보낼 때는 POST만 가능(HTML의 스펙상 Form데이터를 바디로 전송할 때는 POST만 가능). 물론 스프링은 input에 히든 필드를 하나 넣어둔다. 그래서 put이면 서버에서 마치 put인 것처럼 처리를 해주기도 한다. 실제로는 POST로 전송이 되는 것이고, 스프링이 히든 필드에 put이면 컨트롤러에서 put과 관련된 컨트롤러가 호출됨. 

- 하나씩 알아보기!

## HTTP 요청 데이터 - GET 쿼리 파라미터
- 다음 데이터를 클라이언트에서 서버로 전송해보자
- 전달 데이터
    - username=hello
    - age=20
- 메시지 바디 없이, URL의 쿼리 파라미터를 사용해서 데이터를 전달하자.
    - 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
- 쿼리 파라미터는 URL에 다음과 같이 `?` 를 시작으로 보낼 수 있다. 추가 파라미터는 `&` 로 구분하면 된다.
    - http://localhost:8080/request-param?username=hello&age=20
- 서버에서는 `HttpServletRequest` 가 제공하는 다음 메서드를 통해 쿼리 파라미터를 편리하게 조회할 수
있다.
- 쿼리 파라미터 조회 메서드
```
String username = request.getParameter("username"); //단일 파라미터 조회
Enumeration<String> parameterNames = request.getParameterNames(); //파라미터 이름들
모두 조회
Map<String, String[]> parameterMap = request.getParameterMap(); //파라미터를 Map
으로 조회
String[] usernames = request.getParameterValues("username"); //복수 파라미터 조회
```

- RequestParamServlet 클래스
```
/**
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
* <p>
* 2. 동일한 파라미터 전송 가능
* http://localhost:8080/request-param?username=hello&username=kim&age=20
*/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

 @Override
 protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

    System.out.println("[전체 파라미터 조회] - start");

    /*  // 예전 방식
    Enumeration<String> parameterNames = request.getParameterNames(); // 모든 파라미터 다 꺼낼 수 있음
    while (parameterNames.hasMoreElements()) {
    String paramName = parameterNames.nextElement();
    System.out.println(paramName + "=" + 
    request.getParameter(paramName));
    }
    */

    // 요즘 방식
    request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
    System.out.println("[전체 파라미터 조회] - end");
    System.out.println();

    System.out.println("[단일 파라미터 조회]");
    String username = request.getParameter("username");  // 값이 2개일 경우 첫번째 값만 나온다.
    System.out.println("request.getParameter(username) = " + username);

    String age = request.getParameter("age");
    System.out.println("request.getParameter(age) = " + age);
    System.out.println();

    System.out.println("[이름이 같은 복수 파라미터 조회]");
    System.out.println("request.getParameterValues(username)");
    String[] usernames = request.getParameterValues("username");
    for (String name : usernames) {
        System.out.println("username=" + name); // hello, kim 둘 다 나온다. 모든 것이니.
    }
    
    resp.getWriter().write("ok");
 }

}
```
- 실행 - 파라미터 전송하기
```
http://localhost:8080/request-param?username=hello&age=20
```
- 결과
```
[전체 파라미터 조회] - start

username=hello
age=20
[전체 파라미터 조회] - end
[단일 파라미터 조회]
request.getParameter(username) = hello
request.getParameter(age) = 20

[이름이 같은 복수 파라미터 조회]
request.getParameterValues(username)
username=hello
username=kim
```

- 실행 - 동일 파라미터 전송
    - 똑같은 username 값을 2번 전송(hello, kim)
    - 그러면 첫번째 값 반환
    ```
    http://localhost:8080/request-param?username=hello&username=kim&age=20
    ```
    - 결과
    ```
    [전체 파라미터 조회] - start
    username=hello
    age=20
    [전체 파라미터 조회] - end
    [단일 파라미터 조회]
    request.getParameter(username) = hello
    request.getParameter(age) = 20
    [이름이 같은 복수 파라미터 조회]
    request.getParameterValues(username)
    username=hello
    username=kim
    ```

- 복수 파라미터에서 단일 파라미터 조회
    - `username=hello&username=kim` 과 같이 파라미터 이름은 하나인데, 값이 중복이면 어떻게 될까?request.getParameter() 는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다. 지금처럼 중복일 때는 request.getParameterValues() 를 사용해야 한다. 참고로 이렇게 중복일 때 request.getParameter() 를 사용하면 request.getParameterValues() 의 첫번째 값을 반환한다.
    - 그런데 이런 경우는 잘 없다.


## HTTP 요청 데이터 - POST HTML Form
- 이번에는 HTML의 Form을 사용해서 클라이언트에서 서버로 데이터를 전송해보자. 주로 회원 가입, 상품 주문 등에서 사용하는 방식이다.
- 특징
    - content-type: `application/x-www-form-urlencode`
    - 응답 메시지 바디에 쿼리 파리미터 형식으로 데이터를 전달한다. `username=hello&age=20`

- src/main/webapp/basic/hello-form.html 생성
```
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/request-param" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>
```

- 실행
    - 정적 html이 제공되는 것
    ```
    https://localhost:8080/basic/hello-form.html
    ```
- 주의
    - 웹 브라우저가 결과를 캐시하고 있어서, 과거에 작성했던 html 결과가 보이는 경우도 있다. 이때는 웹 브라우저의 새로 고침을 직접 선택해주면 된다. 물론 서버를 재시작 하지 않아서 그럴 수도 있다.

- POST의 HTML Form을 전송하면 웹 브라우저는 다음 형식으로 HTTP 메시지를 만든다. (웹 브라우저
개발자 모드 확인
    - 요청 URL: http://localhost:8080/request-param
    - content-type: application/x-www-form-urlencoded
    - message body: username=hello&age=20
- 그러면 위에서 미리 만들어 둔 /request-param 패턴에 상응하는 RequestParamServlet클래스의 service 메서드가 실행
- application/x-www-form-urlencoded 형식은 앞서 GET에서 살펴본 쿼리 파라미터 형식과 같다. 따라서 `쿼리 파라미터 조회 메서드`를 그대로 사용하면 된다.
- 클라이언트(웹 브라우저) 입장에서는 두 방식에 차이가 있지만, 서버 입장에서는 둘의 형식이 동일하므로, request.getParameter() 로 편리하게 구분없이 조회할 수 있다.
- 정리하면 request.getParameter() 는 GET URL 쿼리 파라미터 형식도 지원하고, POST HTML Form 
형식도 둘 다 지원한다.


- 참고
    - content-type은 HTTP 메시지 바디의 데이터 형식을 지정한다.
    - `GET URL 쿼리 파라미터 형식`으로 클라이언트에서 서버로 데이터를 전달할 때는 HTTP 메시지 바디를 사용하지 않기 때문에 content-type이 없다.
    - `POST HTML Form 형식`으로 데이터를 전달하면 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기 때문에 바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야 한다. 이렇게 폼으로 데이터를 전송하는 형식을 application/x-www-form-urlencoded 라 한다.

- Postman의 등장
    - Postman을 사용한 테스트
    - 이런 간단한 테스트에 HTML form을 만들기는 귀찮다. 이때는 Postman을 사용하면 된다
- Postman 테스트 주의사항
    - 위의 것 테스트 해보기
    - POST메서드, https://localhost:8080/request-param
    - POST 전송시
        - Body x-www-form-urlencoded 선택
            - username : kim
            - age : 20
        - Headers에서 content-type: application/x-www-form-urlencoded 로 지정된 부분 꼭 확인
    
    - send
    - 콘솔 확인(HTML Form에서 보내는 것과 같은 결과)
- 이렇게 HTML Form 에서 웹 브라우저가 하는 일과 포스트맨에서 하는 일이랑 보내는 HTTP 메시지가 동일하다.


## HTTP 요청 데이터 - API 메시지 바디 - 단순 텍스트
- 이전의 GET의 쿼리 파라미터, Form의 POST방법으로 보내는 것은 일반적으로 웹 브라우저에서 HTML을 사용할 때 사용하는 방식인 반면, 지금부터 하는 것은 바디에 직접 데이터를 넣어서 서버에 보내는 API방식

- HTTP message body에 데이터를 직접 담아서 요청
    - HTTP API에서 주로 사용, JSON, XML, TEXT
    - 데이터 형식은 주로 JSON 사용
    - POST, PUT, PATCH

- 먼저 가장 단순한 텍스트 메시지를 HTTP 메시지 바디에 담아서 전송하고, 읽어보자
- HTTP 메시지 바디의 데이터를 InputStream을 사용해서 직접 읽을 수 있다
    - 메시지 바디의 내용을 바이트 코드로 받아올 수 있다.
- RequestBodyStringServlet 클래스
```
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-bodystring")
public class RequestBodyStringServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        ServletInputStream inputStream = request.getInputStream(); // 메시지 바디의 내용을 바이트 코드로 받을 수 있음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
} 
```


- 참고
    - inputStream은 byte 코드를 반환한다. byte 코드를 우리가 읽을 수 있는 문자(String)로 보려면 문자표(Charset)를 지정해주어야 한다.(반대도 마찬가지) 여기서는 UTF_8 Charset을 지정해주었다.
    - 항상 이렇게 바이트 -> 문자열 변환할 때는 인코딩 정보(UTF-8)를 알려줘야 한다.
    - InputStream으로 텍스트를 읽어들일 수 있다는 것만 알아두자.
- Postman을 사용해서 테스트 해보자
    - 문자 전송
        - POST, http://localhost:8080/request-body-string
        - content-type: text/plain
        - message body(raw - text): hello
        - 결과(로컬): messageBody = hello

- 원래는 이렇게 문자(TEXT)로 주고 받지 않는다. 보통은 JSON으로 주고 받기 때문에 다음 강의!

## HTTP 요청 데이터 - API 메시지 바디 - JSON
- 이번에는 HTTP API에서 주로 사용하는 JSON 형식으로 데이터를 전달해보자.
- JSON 형식 전송
    - POST http://localhost:8080/request-body-json
    - content-type: application/json
    - message body: {"username": "hello", "age": 20}
    - 결과: messageBody = {"username": "hello", "age": 20}


- JSON 형식 파싱 추가
    - JSON 형식으로 파싱할 수 있게 객체를 하나 생성하자
        - JSON 형식의 데이터를 객체로 바꿀 수 있도록 객체 클래스 생성(원래 JSON 그대로 쓰지 않고 객체로 바꿔서 쓴다)
    - hello.servlet.basic.HelloData
    - Lombok의 @Geter, Setter 덕분에 눈에 보이지는 않지만 메서드가 생성되어 있다.
    - 참고: 만약 잘 동작하지 않는다면 프로젝트 생성에 롬복 부분을 다시 확인하자.
    ```
    package hello.servlet.basic;

    import lombok.Getter;
    import lombok.Setter;

    @Getter @Setter
    public class HelloData {
        private String username;
        private int age;
    }
    ``` 
- RequestBodyJsonServlet 클래스
```

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

    }
}

```
- 서버 실행 후 Postman 으로 실행
    - POST / http://localhost:8080/request-body-json
    - content-type: application/json (Body raw, 가장 오른쪽에서 JSON 선택)
        - 그럼 Headers 부분에 자동으로 Content-Type 이 들어가 있다. 그런데 수동으로 Content-Type: application/json으로 넣게 되면 충돌이 발생할 수도 있어서 하나를 삭제하거나 해줘야 한다.
    - 출력결과
    ```
    messageBody = 
            {
                "username" : "june",
                "age" : 20
            }
    ```
- 결국 JSON도 그냥 문자임. 
- RequestBodyJsonServlet 클래스에 코드 추가
    - JSON 결과를 파싱해서 사용할 수 있는 자바 객체로 변환하려면 Jackson, Gson 같은 JSON 변환 라이브러리를 추가해서 사용해야 한다. 스프링 부트로 Spring MVC를 선택하면 기본으로 Jackson 라이브러리( ObjectMapper )를 함께 제공한다.
    - 인텔리 J의 왼쪽에 External Libraries 에 검색하면 다 뜬다.
    ```
    @WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
    public class RequestBodyJsonServlet extends HttpServlet {

        private ObjectMapper objectMapper = new ObjectMapper(); // jackson 라이브러리

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ServletInputStream inputStream = request.getInputStream();
            String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

            // System.out.println("messageBody = " + messageBody);

            HelloData helloData = objectMapper.readValue(messageBody, HelloData.class); // 이렇게 변환, JSON 형식으로 들어와야 한다. 만약에 다른 형식(HTML의 Form, 일반 TEXT)을 넣게 되면 JSON이 아니라 파싱이 안되서 에러남

            System.out.println("helloData.username() = " + helloData.getUsername());
            System.out.println("helloData.age() = " + helloData.getAge());

            response.getWriter().write("ok");
        }
    }
    ```
    - 포스트맨으로 똑같이 전송
    - 출력결과
    ```
    helloData.username() = june
    helloData.age() = 20
    ```
    - 이렇게 JSON을 객체로 변환 가능.

- 사실 나중에 스프링MVC 패턴으로 하게 되면 애초에 파라미터를 `protected void service(HelloData helloData) throws ServletException, IOException {..중략..}` 으로 아주 편하게 받을 수 있다.(중간의 변환과정 코드를 다 생략할 수 있다) 그런데 지금은 그 전의 과정을 공부하는 중!

- 참고)
    - HTML form 데이터도 메시지 바디를 통해 전송되므로 직접 읽을 수 있다.(위의 InputStream으로) 하지만 편리한 파리미터 조회 기능( request.getParameter(...) )을 이미 제공하기 때문에 파라미터 조회 기능을 사용하면 된다.

- 이렇게 요청 메시지 3가지를 알아봤는데 모든 것은 여기에서 벗어나지 않는다.
4

## HttpServletResponse - 기본 사용법
- HttpServletResponse 역할
    - `HTTP 응답 메시지 생성` (개발자들이 직접 다 만들면 번거로우니까 쉽게 넣을 수 있도록 메서드들 제공하고, 그 값들을 서블릿이 자동으로 응답 메시지 만들 때 사용하게 된다)
        - HTTP 응답코드 지정
        - 헤더 생성
        - 바디 생성
    - `편의 기능 제공`
        - Content-Type
        - 쿠키
        - Redirect

- ResponseHeaderServlet 클래스
    - start-line, response-headers 메서드 부분들
    ```
    @WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
    public class ResponseHeaderServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // [status-line]
            response.setStatus(HttpServletResponse.SC_OK); // response.setStatus(200); 보다 더 명확
    //        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            // [response-headers]
            response.setHeader("Content-Type", "text/plain;charset=utf-8");
            response.setHeader("Cache-Cotnrol", "no-cache, no-store, must-revalidate"); // 캐시 완전 무효화
            response.setHeader("Pragma", "no-cache"); // 예전 버전의 캐시 무효화
            response.setHeader("my-header", "hello"); // 내가 만드는 임의의 헤더를 만들 수 있다.


            // [Header 편의 메서드]
            content(response);
            cookie(response);
            redirect(response); // 이 메서드 안에서 302 코드를 반환하는데, 위에서 SC_OK(200) 으로 설정했으나 여기서 덮어버림

            // [meesage Body]
            PrintWriter writer = response.getWriter();
            writer.println("ok");
        }
    }
    ```
- 포스트맨으로 실행
    - POST / http://localhost:8080/response-header
    - 실행 후 response 부분의 Headers 에서 우리가 지정한 값들을 다 확인할 수 있다.
    - charset을 지정하지 않으면 WAS 에서 자동으로 지정. 그래서 딱 정해주는 것이 좋다.
    - 웹 브라우저에서 실행하고 개발자 도구에서 확인해도 똑같이 확인가능하다
        - 참고로 웹 브라우저에서 조회하면 기본적으로 GET 방식으로 호출
    
- Content편의 메서드
    - 위에서처럼 `response.setHeader("Content-Type", "text/plain;charset=utf-8");` 이렇게 지정해줘도 되고 아래처럼 `response.setContentType("text/plain"); response.setCharacterEncoding("utf-8");` 으로 지정해줘도 된다.
    ``` 
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // response.setContentLength(2); //(생략시 자동 생성)
    }
    ```


- 쿠키 편의 메서드
    ```
    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600; 
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); 
        Cookie cookie = new Cookie("myCookie", "good"); 
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }
    ```
    - 브라우저에서 전송(개발자 도구로 확인), response 에 우리의 쿠키가 들고있는 것을 확인할 수 있다.
    - 다시 한번 더 하면!?
        - 브라우저가 request에 금방 받았던 쿠키를 다시 전송하는 것을 확인가능
        - 그럼 이것을 서버에서 쿠키 값 읽어서 사용할 수 있다.
    
- redirect 편의 메서드
    ```
    private void redirect(HttpServletResponse response) throws IOException {
      //Status Code 302                     // 이 코드를 만들고 
      //Location: /basic/hello-form.html    // 이쪽으로 보낼 것임


      //response.setStatus(HttpServletResponse.SC_FOUND); // 302
      //response.setHeader("Location", "/basic/hello-form.html");

      response.sendRedirect("/basic/hello-form.html"); // 위의 개 보다 훨씬 더 간단함
    }
    ```
    - 브라우저에서 전송하면!? (localhost:8080/response-header로 접속)
        - localhost:8080/basic/hello-form.html 으로 리다이렉션
        <img width="877" alt="스크린샷 2021-08-21 오후 2 43 11" src="https://user-images.githubusercontent.com/57219160/130311925-f8bc8cdd-99ab-426f-8d2b-45f87283802f.png">
        - 위 사진처럼, 먼저 response-header 로 302 코드로 갔고, 그 뒤에 다시 리다이렉션되어서 hello.form.html 로 잘 도착(200 OK) 한 것을 확인할 수 있다.
        - 각각을 클릭해서 General(코드 값, 메서드 확인가능), 헤더의 값들을 볼 수 있다.


## HTTP 응답 데이터 - 단순 텍스트, HTML
- HTTP 응답 메시지는 주로 다음 내용을 담아서 전달한다.
- 크게 3가지
    1. 단순 텍스트 응답
        - 앞에서 살펴봄 `writer.println("ok");`
    2. HTML 응답
    3. HTTP API - MessageBody JSON 응답
- 단순 텍스트 응답은 앞에서 살펴봤으니 패스
- HttpServletResponse - HTLM 응답
    - 자바 코드로 하려면 정말 힘든 작업
    - 여기에 자바의 if문 등을 넣게 된다면 동적으로 바꿀 수도 있음.
    ```
    @WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
    public class ResponseHtmlServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Content-Type: text/html;charset=utf-8
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.println(" <div>안녕?</div>");
            writer.println("</body>");
            writer.println("</html>");

        }
    }

    ```
    - HTTP 응답으로 HTML을 반환할 때는 content-type을 text/html 로 지정해야 한다.
        - 그래야만 웹 브라우저가 정상적인 html이구나 ~ 하고 렌더링 한다
    - charset=utf-8 로 잡아줘야만 한글이 깨지지 않는다.
    - 실행
        - http://localhost:8080/response-html
        - 화면에는 `안녕?` 만 있다.
        - 페이지 소스보기를 사용하면 결과 HTML 을 확인할 수 있다.

## HTTP 응답 데이터 - API JSON
- 우리가 주로 사용하는 HTTP API(용어에 따라 Rest API라고도 한다) 에 이용되는 방식
- 응답 데이터를 JSON으로 보내는 방법(HTTP메세지 바디에)
- ResponseJsonServlet 클래스
```
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        // {"username":"kim","age":20}
        String result = objectMapper.writeValueAsString(data); // (객체->문자로 변환) JSON도 문자임
        response.getWriter().write(result);
    }
}
```
- HTTP 응답으로 JSON을 반환할 때는 content-type을 application/json 로 지정해야 한다. Jackson 라이브러리가 제공하는 objectMapper.writeValueAsString() 를 사용하면 객체를 JSON 문자로 변경할 수 있다.
- 웹 브라우저에 http://localhost:8080/response-json 접속해서 실행결과 확인 
    - JSON으로 확인가능(페이지 소스보기로도 확인할 수 있다.)
    - 개발자도구로 Content-Type 등 다 확인가능
- 그런데 나중에 스프링MVC를 사용하게 되면 중간의 저런 코드들도 다 사라진다.
    - 중간코드 다 사라지고 그냥 HelloData 객체만 리턴해버리면 된다.(뒤의 수업에서 확인가능)
    ```
    @Override
    protected HelloData service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        return data;
    }
    ```

- 참고)
    - application/json 은 스펙상 utf-8 형식을 사용하도록 정의되어 있다. 그래서 스펙에서 charset=utf-8과 같은 추가 파라미터를 지원하지 않는다. 따라서 application/json 이라고만 사용해야지 application/json;charset=utf-8 이라고 전달하는 것은 의미 없는 파라미터를 추가한 것이 된다. > response.getWriter()를 사용하면 추가 파라미터를 자동으로 추가해버린다. 이때는 response.getOutputStream()으로 출력하면 그런 문제가 없다.


# 서블릿, JSP, MVC 패턴
## 회원 관리 웹 애플리케이션 요구사항
- 회원 정보
    - 이름 : `username`
    - 나이 : `age`
- 기능 요구사항 (2가지만)
    - 회원 저장
    - 회원 목록 조회
- Member 클래스
```
@Getter
@Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

```
- MemberRepository 클래스
    ```
    /**
    * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    */
    public class MemberRepository {

        private static Map<Long, Member> store = new HashMap<>();
        private static long sequence = 0L;

        private static final MemberRepository instatnce = new MemberRepository(); // 싱글톤

        public static MemberRepository getInstance() { // 무조건 이것으로만 조회될 수 있도록
            return instatnce;
        }
        private MemberRepository() { // 이렇게 싱글톤으로 만들 떄는 생성자를 private 으로 막아야 된다.
        }

        public Member save(Member member) {
            member.setId(++sequence);
            store.put(member.getId(), member);
            return member;
        }

        public Member findById(Long id) {
            return store.get(id);
        }

        public List<Member> findAll() {
            return new ArrayList<>(store.values()); // store에 있는 모든 값들을 꺼내서 새로운 ArrayList에 담아서 넘겨준다.
        }

        public void clearStore() {
            store.clear();
        }

    }
    ```
    - 메모리저장소로 만듬.
    - store, sequence 를 static 으로 만든 이유는 MemberRepository 를 여러번 new해서 생성하더라도 오직 하나만 유지하기 위해서. (사실 MemberRepository을 싱글톤으로 했기 때문에 static 빼도 되긴 한다.)
    - 회원 저장소는 싱글톤 패턴을 적용했다. 스프링을 사용하면 스프링 빈으로 등록하면 되지만, 지금은 최대한 스프링 없이 순수 서블릿 만으로 구현하는 것이 목적이다. 싱글톤 패턴은 객체를 단 하나만 생생해서 공유해야 하므로 생성자를 private 접근자로 막아둔다.
    - 싱글톤(MemberRepository을 싱글톤 객체로 만들기 위해서)
        - 우리는 지금 스프링 컨테이너를 띄워서 하는 것이 아니므로. 만약 스프링 쓰면 자동으로 싱글톤 객체이므로 신경 쓸 필요 없다.
        ```
        private static final MemberRepository instatnce = new MemberRepository(); // final 

        public static MemberRepository getInstance() { // 무조건 이것으로만 조회될 수 있도록
            return instatnce;
        }
        private MemberRepository() { // 이렇게 싱글톤으로 만들 떄는 생성자를 private 으로 막아야 된다.

        }
        ```
    - store안의 값들을 건드리고 싶지 않아서 아래처럼 리턴
        - new ArrayList의 값을 조작해도 밖의 store 의 value를 건드리고 싶지 않아서다. 물론 이렇게 해도 store 안의 값을 가지고 나와서 수정하면 수정이 되어버리긴 한다. 이것은 store 그 자체를 보호하기 위해서 이렇게 한 것이다.
    ```
    public List<Member> findAll() {
            return new ArrayList<>(store.values()); // store에 있는 모든 값들을 꺼내서 새로운 ArrayList에 담아서 넘겨준다.
        }
    ```
    - clearStore()
        - 테스트 때 사용하기 위해서(깔끔하게 초기화하려고)

- MemberRepository 클래스
    - 클래스 앞에 public 없애도 된다(Junit 5부터)
    ```
    public class MemberRepositoryTest {

        MemberRepository memberRepository = MemberRepository.getInstance();

        @AfterEach // 매 Test 가 끝나면 실행되는 것. 
        void afterEach() {
            memberRepository.clearStore();
        }

        @Test
        void save() {
            //give
            Member member = new Member("hello", 20);

            //when
            Member savedMember = memberRepository.save(member);

            //then
            Member findMember = memberRepository.findById(savedMember.getId());
            Assertions.assertThat(findMember).isEqualTo(savedMember);
        }

        @Test
        void findAll() {
            //given
            Member member1 = new Member("member1", 20);
            Member member2 = new Member("member2", 30);

            memberRepository.save(member1);
            memberRepository.save(member2);
            //when
            List<Member> result = memberRepository.findAll();

            //then
            Assertions.assertThat(result.size()).isEqualTo(2);
            Assertions.assertThat(result).contains(member1, member2);
        }
    
    ```
    - 회원을 저장하고, 목록을 조회하는 테스트를 작성했다. 각 테스트가 끝날 때, 다음 테스트에 영향을 주지 않도록 각 테스트의 저장소를 clearStore() 를 호출해서 초기화했다.
## 서블릿으로 회원 관리 웹 애플리케이션 만들기
- 이제 본격적으로 서블릿으로 회원 관리 웹 애플리케이션을 만들어보자.
- 가장 먼저 서블릿으로 회원 등록 HTML 폼을 제공해보자.
- MemberFormServlet (회원 등록 폼)
    - 회원이름 등록하는 폼을 서블릿으로 만드는 것임!!
    - HTTP 메서드 응답으로 HTML이 나가야 하므로 컨텐츠 바디를 잡아줘야 한다.
    -  MemberFormServlet 은 단순하게 회원 정보를 입력할 수 있는 HTML Form을 만들어서 응답한다. 자바 코드로 HTML을 제공해야 하므로 쉽지 않은 작업이다.(그냥 pdf 복붙하기)
    ```
    @WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/member/new-form")
    public class MemberFormServlet extends HttpServlet {

        private MemberRepository memberRepository = MemberRepository.getInstance();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            PrintWriter w = response.getWriter();
            w.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                    "    username: <input type=\"text\" name=\"username\" />\n" +
                    "    age:      <input type=\"text\" name=\"age\" />\n" +
                    " <button type=\"submit\">전송</button>\n" + "</form>\n" +
                    "</body>\n" +
                    "</html>\n");
        }

    }
    ```
- 실행 (ServletApplication 클래스 실행해서 스프링 컨테이너 띄우기)
    - http://localhost:8080/servlet/member/new-form 접속
    - HTML Form 데이터를 POST로 전송해도, 전달 받는 서블릿을 아직 만들지 않았다. 그래서 오류가 발생하는 것이 정상이다.

- MemberSaveServlet 클래스
    - MemberFormServlet 클래스에서 만든 폼에서 보내는 데이터를 받는 곳. 즉 form의 action인 부분이다.
    - 이번에는 들어오는(request) 값을 가져와서 읽어야 한다.
    - `request.getParameter();` 로 꺼내는 것은 Get의 쿼리스트링에서 꺼내던 Form의 Post 방식으로 보내든 간에 그 값들을 가져올 수 있다. 둘 다 쿼리 스트링 형식이므로(username=kim&age=20).
        - request.getParameter() 의 리턴값을 항상 문자다. 그래서 request.getParameter("age"); 라고 값을 들고 오더라도 String 으로 받게 되는 것을 주의.
    ```
    @WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
    public class MemberSaveServlet extends HttpServlet {

        private MemberRepository memberRepository = MemberRepository.getInstance();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("MemberSaveServlet.service");
            String username = request.getParameter("username");         // 조회
            int age = Integer.parseInt(request.getParameter("age"));    // 조회, // 폼에서 숫자 말고 다른 걸로 넣으면 에러난다.

            Member member = new Member(username, age);  // 객체 생성
            System.out.println("member = " + member);   
            memberRepository.save(member);              // 객체 저장

            // 위에서 잘 저장했으니까 응답을 Html 코드로 내려보내기.
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter w = response.getWriter();

            w.write("<html>\n" +
                    "<head>\n" +
                    " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                    "<body>\n" +
                    "성공\n" +
                    "<ul>\n" +
                    "    <li>id="+member.getId()+"</li>\n" +                // 여기에 동적 코드
                    "    <li>username="+member.getUsername()+"</li>\n" +    // 여기에 동적 코드
                    " <li>age="+member.getAge()+"</li>\n" + "</ul>\n" +     // 여기에 동적 코드
                    "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                    "</html>");
        }
    }
    ``` 
    - 실행
        - 스프링 컨테이너 다시 띄우고
        - http://localhost:8080/servlet/member/new-form 접속해서 데이터 전송
        - http://localhost:8080/servlet/members/save 페이지에서 그 데이터들을 받아서 보여줌
    - MemberSaveServlet 은 다음 순서로 동작한다.
        - 파라미터를 조회해서 Member 객체를 만든다.
        - Member 객체를 MemberRepository를 통해서 저장한다.
        - Member 객체를 사용해서 결과 화면용 HTML을 동적으로 만들어서 응답한다.
    - 스프링 띄운 상태에서 http://localhost:8080/servlet/members/new-form 로 접속해서 여러 명 정보 입력하면 메모리 유지되고 있으니까 다 저장하고 있다.

- MemberListServlet
    - 이번에는 저장된 모든 회원 목록을 조회하는 기능을 만들어보자.
    ```
    @WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
    public class MemberListServlet extends HttpServlet {

        private MemberRepository memberRepository = MemberRepository.getInstance();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Member> members = memberRepository.findAll();

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            PrintWriter w = response.getWriter();
            w.write("<html>");
            w.write("<head>");
            w.write("    <meta charset=\"UTF-8\">");
            w.write("    <title>Title</title>");
            w.write("</head>");
            w.write("<body>");
            w.write("<a href=\"/index.html\">메인</a>");
            w.write("<table>");
            w.write("    <thead>");
            w.write("    <th>id</th>");
            w.write("    <th>username</th>");
            w.write("    <th>age</th>");
            w.write("    </thead>");
            w.write("    <tbody>");

            /* 아래코드는 정적임
            w.write("    <tr>");
            w.write("        <td>1</td>");
            w.write("        <td>userA</td>");
            w.write("        <td>10</td>");
            w.write("    </tr>");
            */

            // 동적으로
            for (Member member : members) {
                w.write("    <tr>");
                w.write("        <td>" + member.getId() + "</td>");
                w.write("        <td>" + member.getUsername() + "</td>");
                w.write("        <td>" + member.getAge() + "</td>");
                w.write("    </tr>");
            }

            w.write("    </tbody>");
            w.write("</table>");
            w.write("</body>");
            w.write("</html>");
        }
    }
    ```
    - 실행
        - http://localhost:8080/servlet/members
        - 저장된 회원 목록을 확인할 수 있다. 
    - MemberListServlet 은 다음 순서로 동작한다.
        - http://localhost:8080/servlet/members/new-form 에서 회원 몇명 저장하기
        - memberRepository.findAll() 을 통해 모든 회원을 조회한다.
        - 회원 목록 HTML을 for 루프를 통해서 회원 수 만큼 동적으로 생성하고 응답한다.
        - http://localhost:8080/servlet/members 에서 html 화면 확인가능
        - 페이지 소스 보기 하면 html 태그들을 다 볼 수 있다.

- 너무 힘든 작업들이다...그래서!! 
- 템플릿 엔진으로 바꿔야 한다.
    - 템플릿 엔진은 html 안에 자바 코드를 넣는 것임.(서블릿보다 훨씬 편하다). cf) 서블릿은 자바 안에 html 코드를 넣는 것
    - 지금까지 서블릿과 자바 코드만으로 HTML을 만들어보았다. 서블릿 덕분에 동적으로 원하는 HTML을 마음껏 만들 수 있다. 정적인 HTML 문서라면 화면이 계속 달라지는 회원의 저장 결과라던가, 회원 목록 같은 동적인 HTML을 만드는 일은 불가능 할 것이다. 그런데, 코드에서 보듯이 이것은 매우 복잡하고 비효율 적이다. 자바 코드로 HTML을 만들어 내는 것 보다 차라리 HTML 문서에 동적으로 변경해야 하는 부분만 자바 코드를 넣을 수 있다면 더 편리할 것이다. 이것이 바로 템플릿 엔진이 나온 이유이다. 템플릿 엔진을 사용하면 HTML 문서에서 필요한 곳만 코드를 적용해서 동적으로 변경할 수 있다.
    - `대표적인 템플릿 엔진에는 JSP, Thymeleaf, Freemarker, Velocity`등이 있다. 다음 시간에는 JSP로 동일한 작업을 진행해보자. JSP는 가장 고전적인 템플릿 엔진

- 참고
    - JSP는 성능과 기능면에서 다른 템플릿 엔진과의 경쟁에서 밀리면서, 점점 사장되어 가는 추세이다. 템플릿 엔진들은 각각 장단점이 있는데, 강의에서는 JSP는 앞부분에서 잠깐 다루고, 스프링과 잘 통합되는 Thymeleaf를 사용한다.

- welcome 페이지 변경
    - 서블릿에서 JSP, MVC 패턴, 직접 만드는 MVC 프레임워크, 그리고 스프링까지 긴 여정을 함께할 것이다. 편리하게 참고할 수 있도록 welcome 페이지를 변경하자. 

## JSP로 회원 관리 웹 애플리케이션 만들기
- 