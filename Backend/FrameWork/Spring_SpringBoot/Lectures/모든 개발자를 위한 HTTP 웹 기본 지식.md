- [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#) 강의 필기 내용

- 모든 것이 HTTP 기반 위에서 동작한다. 우리가 잘 아는 HTML, 이미지, 파일뿐 아니라 앱과 서버가 통신할 때, 서버와 서버가 통신할 때 등 모두다 HTTP 프로토콜 위에서 데이터를 주고 받는다. 그래서 모바일 앱 개발자, 웹 프런트, 백엔드 개발자는 HTTP 에 대한 지식이 필수적이다. 특히 백엔드 개발자들은 스프링 웹 MVC나 django, Ruby on Rails, Tomcat, Spring boot, php, jsp와 같은 웹 기술이나 웹 프레임워크를 사용하게 될텐데, 이런 `모든 웹 기술들이 HTTP 기술을 기반으로 구현이 되어 있다.`
- HTTP 웹 지식이 반드시 필요하다. HTTP 메서드 중 POST, GET 둘 중 뭐를 사용할까?, HTTP 상태코드는 어떤 것을 사용하는 것이 좋을까? 등에 대한 고민이 필요하다.  
- `개발자는 평생 HTTP 기반위에서 개발해야 한다.` 언젠가 한번은 HTTP 정리해야 함.
- 실무에 꼭 필요한 핵심 내용
- 상세한 그림으로 설명(꼭 다 필기하려고 하지말기). pdf를 보기
- 특히 백엔드 개발자에게 많이 필요. 어떤 HTTP 메서드 사용해야 할지 등 다 백엔드 개발자가 설계해야 한다. 
- HTTP 도 결국에는 TCP/IP 나 UDP 위에서 동작하는 것이므로 인터넷 네트워크에 대한 지식부터 시작.

# 인터넷 네트워크 
## 인터넷 통신
## IP(인터넷 프로토콜) 
- 인터넷 프로토콜의 역할
    - 지정한 IP 주소(IP Address)에 데이터 전달
    - 패킷(packet)이라는 통신 단위로 데이터 전달 
        - 데이터를 패킷(출발IP, 목적지 IP, 기타 등) 으로 감싸서 보냄
        - 패킷이 인터넷망의 수많은 노드들을 거쳐서 최종 서버에 도착


- IP 프로토콜의 한계
    - 비연결성
        - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
    - 비신뢰성
        - 중간에 패킷이 사라지면? (소실)
        - 패킷이 순서대로 안오면?
            - 출발 : 1. hello / 2. world!
            - 도착 : 2. world! / hello 라고 올 수도 있다.
    - 프로그램 구분
        - 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면?

- 이런 문제들을 해결하는 것이 바로 TCP

## TCP, UDP
- IP의 문제들을 해결해주는 것이 바로 TCP
- UDP는 다른 방면에서 도움이 됨.
- 인터넷 프로토콜 스택의 4계층
    - 애플리케이션 계층 (HTTP, FTP)
    - 전송 계층 (TCP, UDP)
    - 인터넷 계층 (IP)
    - 네트워크 인터페이스 계층(LAN 드라이버, LAN 장비 등)


- HTTP를 TCP가 감싸고 있고 그 위를 다시 IP가 감싸고 있고 마지막으로 Ethernet frame이 감싸고 있다고 생각하면 된다. (pdf 참조)
    ![프로토콜 계층 사진](https://user-images.githubusercontent.com/57219160/129349501-d684ddea-4f3a-4f9e-8849-c60c63f456c5.PNG)
    ![IP패킷](https://user-images.githubusercontent.com/57219160/129349868-141ee885-7dde-4386-8dc8-38f3fe5a0f8b.PNG)
    ![TCP IP 패킷 정보](https://user-images.githubusercontent.com/57219160/129349877-098c2b38-03fb-4c1f-aed4-dcfc193d9aff.PNG)
    - HTTP
        - 출발지IP, 목적지 IP, 기타...
    - TCP 세그먼트
        - 출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 정보...
    - 전송 데이터

- 패킷이란?
    - 수하물(package) + 덩어리(bucket)의 합성어


- TCP의 특징(전송 제어 프로토콜, Transmission Control Protocol)
    - 연결지향 - TCP 3 way handshake(가상 연결)
        - 연결을 우선 하고 나서 메세지 보냄. 
    - 데이터 전달 보증
        - 상대가 메시지를 못 받으면 알 수 있다.
    - 순서보장
    - 신뢰할 수 있는 프로토콜
    - 현재는 대부분 TCP 사용

- TCP 3 way handshake는 사실 가상 연결이다.
    - 순서
        1. 클라이언트가 서버에게 `SYN(Syncronize, 접속요청)` 을 보냄
        2. 서버가 클라이언트에게 `SYN, ACK(요청 수락)` 을 답장
        3. 다시 클라이언트가 서버에게 `ACK`을 보냄
        4. 3단계까지가 끝난 후 데이터 전송 시작
        - 요즘에는 3단계의 ACK과 4단계의 데이터 전송을 같이 한다.
    - 논리적으로 연결이 되었다는 뜻
    - 중간에 수많은 연결노드서브들이 진짜로 연결이 됐는지 안되었는지는 모른다

- 데이터 전달 보증
    - 데이터를 전송하면 서버에서 데이터 잘 받았다라고 전해줌. 

- 순서 보장
    1. 클라이언트가 패킷1, 패킷2, 패킷3 순서로 서버에게 보냄
    2. 그런데 서버에는 패킷1, `패킷3, 패킷2` 순서로 도착(잘못 도착함)
    3. 그래서 서버는 클라이언트에게 `패킷2`부터 다시 보내라고 함. 
    4. 그러면 클라이언트는 `아 패킷2부터 잘못되었구나라고 생각하여 다시 보냄`
    - TCP에는 순서 등의 정보가 담겨있으므로 가능

- UDP(사용자 데이터그램 프로토콜, User Datagram Protocol)
    - 하연 도화지에 비유(기능이 거의 없음)
    - 연결지향 - TCP 3 way handshake X
    - 데이터 전달 보증 X
    - 순서 보장 X
    - 데이터 전달 및 순서가 보장되지 않지만, 단순하고 빠름
    - 정리
        - IP와 거의 같다. +PORT +체크섬(메시지에 대해서 맞는지 검증해주는 데이터) 정도만 추가
        - 애플리케이션에서 추가 작업이 필요하다.
        - 여기서 말하는 port란?
            - 나의 하나의 PC(1개의 IP)에 음악, 게임을 동시에 하고 있다면 하나의 IP에 여러 패킷이 오는데 그 여러 패킷이 각각 음악, 게임 등 어디에 속하는지 구별.

- 그러면 UDP를 왜 사용하는가?
    - TCP는 여러 절차(3 shake)가 있으므로 무겁기도 하고 좀 느리다. 더 이상 최적화를 못한다.
    - 그런데 인터넷이 이미 모두 다 TCP 기반으로 쓰고 있으므로 TCP 를 손을 못 댄다.
    - 그래서 TCP를 그대로 쓰고 UDP를 사용하여 최적화에 사용. UDP는 도화지와 같으므로 내가 원하는 것을 애플리케이션 레벨에서 만들면 된다. 기능 확장 가능

- 요즘에는 UDP가 각광받고 있다.
    - 새로운 HTTP3 에서 UDP 사용


- 보통 TCP/IP를 같이 묶어서 얘기한다.

## PORT
![port](https://user-images.githubusercontent.com/57219160/129350848-25eec158-3daa-4ad6-9ac4-257fa2fad89e.PNG)
- 배가 도착하는 항구
- IP는 목적지의 서버를 찾는 것이고, 그 서버 안에서 돌아가는 application 을 구분하는 것이 PORT
- IP는 아파트, PORT는 동호수

- 0 ~ 65535 할당 가능
- 0 ~ 1023 : 잘 알려진 포트, 사용하지 않는 것이 좋음
    - FTP - 20, 21
    - TELNET - 23
    - HTTP - 80
    - HTTPS - 433


## DNS (Domain Name System)
- IP는 기억하기 어렵고 변경될(신규 IP로) 수 있다.
- 중간에 전화번호부 같은 서버를 제공(DNS 서버)
- 도메인 명을 IP 주소로 바꿀 수 있음.
- DNS 서버
    - 각각의 도메인은 유료로 사야한다.

|도메인 명|ip|
|--|--|
|google.com|200.200.200.2|
|aaa.com|210.210.210.3|

- 순서
    - 클라이언트가 DNS서버에 도메인명 `google.com` 요청
    - DNS서버가 찾아서 `200.200.200.2` 제공
    - 그래서 클라이언트는 `200.200.200.2` 서버(도메인 서버에 미리 등록해 놓는 주체) 로 접속

- 나중에 IP가 바뀌면 서버는 DNS에 등록해 놓음.



# URI와 웹 브라우저 요청 흐름
## URI(Uniform Resource Identifier)
- [rfc 표준 찾아보기](https://www.ietf.org/rfc/rfc3986.txt)
- URI, URL, URN
    - URI는 로케이터(`l`ocator), 이름(`n`ame) 또는 둘 다 추가로 분류될 수 있다.


- URI는 식별자이고 URL, URN을 포괄하는 개념이라고 생각하면 된다.
    - URL(Uniform Resource Locator)
        - 리소스가 있는 위치를 지정
        - 식별하는 위치
        - ex) June이 사는 `동네`에 가면 찾을 수 있음
        - 거의 URL만 씀
        - 우리가 흔히 웹 브라우저에서 쓰는 것
    - URN(Uniform Resource Name)  
        - 리소스에 이름을 부여
        - 식별이름
        - ex) 그냥 `June`을 찾으면 됨
        - 잘 안 씀. 이름을 부여하면 거의 찾을 수 없다. 이름에 다 하나하나 다 매칭을 해야하므로. URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않음
        - urn:isbn:8960777331 (어떤 책의 isbn URN)
    - 위치는 변할 수 있지만, 이름은 변하지 않는다.
    

- URL
    - ex) foo://example.com:8042/over/there?name=ferret#nose
        - scheme
            - `foo`
        - authority
            - `example.com:8042`
        - /over/there
            - `path`
        - name=ferret
            - `query`
        - nose
            - `fragment`

- URN
    - ex) urn:example:animal:ferret:nose
        - scheme
            - `urn`
        - `path`
            - `example:animal:ferret:nose`


- URI(Uniform Resource Identifier) 
    - `U`niform : 리소스 식별하는 통일된 방식
    - `R`esource : 자원, URI로 식별할 수 있는 모든 것(제한 없음)
    - `I`dentifier : 다른 항목과 구분하는데 필요한 정보
    

- 앞으로 URI와 URL과 같은 의미로 이야기하겠음


- URL 전체 문법
    - scheme://[userinfo@]host[:port][/path][?query][#fragment]
    - https://www.google.com:443/search?q=hello&hl=ko
    - 프로토콜(https)
    - 호스트명(www.google.com)
    - 포트번호(443)
    - 패스(/search)
    - 쿼리 파라미터(q=hello&hl=ko)

- 아래에서 하나씩 설명
- URL scheme
    - `scheme`://[userinfo@]host[:port][/path][?query][#fragment]
    - `https`://www.google.com:443/search?q=hello&hl=ko
    - 주로 프로토콜 사용
    - 프로토콜 : 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙
        - ex) http, https, ftp 등등
    - http는 80포트, https 443 포트를 주로 사용, 그래서 http, https 프로토콜을 쓰면 포트는 생략 가능
    - https는 http에 보안 추가(HTTP Secure)

- URL userinfo
    - scheme://`[userinfo@]`host[:port][/path][?query][#fragment]
    - https://www.google.com:443/search?q=hello&hl=ko
    - URL에 사용자정보를 포함해서 인증
    - 거의 사용하지 않음
    

- URL host
    - scheme://[userinfo@]`host`[:port][/path][?query][#fragment]
    - https://`www.google.com`:443/search?q=hello&hl=ko
    - 호스트명
    - 도메인명 또는 IP주소를 직접 사용가능


- URL port
    - scheme://[userinfo@]host[`:port`][/path][?query][#fragment]
    - https://www.google.com`:443`/search?q=hello&hl=ko
    - 포트(PORT)
    - 접속 포트
    - 일반적으로 생략. 웹의 대부분은 http, https 를 사용하는데 http는 80을, https는 443을 생략해도 된다.


- URL path
    - scheme://[userinfo@]host[:port][`/path`][?query][#fragment]
    - https://www.google.com:443/`search`?q=hello&hl=ko
    - 리소스 경로(path), 계층적 구조
    - 예)
        - /home/file1.jpg
        - /members
        - /members/100, /items/iphone12


- URL query
    - scheme://[userinfo@]host[:port][/path][`?query`][#fragment]
    - https://www.google.com:443/search`?q=hello&hl=ko`
    - key=value 형태 
    - ?로 시작, &로 추가 가능 ?keyA-valueA&keyB=valueB
    - query parameter, query string 등으로 불림, 웹서버에 제공하는 파라미터, 문자 형태(숫자로 적어도 문자로 넘어감)


- URL fragment
    - scheme://[userinfo@]host[:port][/path][?query][`#fragment`]
    - https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html`#getting-started-introducing-spring-boot`
    - fragment
    - html 내부 북마크 등에 사용
    - 서버에 전송하는 정보 아님


## 웹 브라우저 요청 흐름
- pdf 꼭 보기(강의 4분짜리)
- 클라이언트(IP: 100.100.100.1) 웹브라우저가 구글 서버(IP: 200.200.200.2)에 요청
    - `www.google.com:443` -> DNS 조회 (IP:200.200.200.2), HTTPS PORT 생략(443)
    ```
    https://www.google.com:443/search?q=hello&hl=ko
    ```
- HTTP 요청 메시지 생성(브라우저가)
```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com

```
- HTTP 메시지 전송

![HTTP 전송 메시지](https://user-images.githubusercontent.com/57219160/129666698-503f1973-3cf5-43f1-9519-bec4e16b0664.PNG)
- 패킷 생성

![패킷 생성](https://user-images.githubusercontent.com/57219160/129666773-e97b81bb-0fed-4a95-b101-2721babb4677.PNG)
- 요청 패킷 전달 (클라이언트 -> 서버)

![전달](https://user-images.githubusercontent.com/57219160/129666859-6eca22df-f804-493f-a92c-0ac7af45aa4f.PNG)
- HTTP 응답 메시지 생성(브라우저가)
```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
    <body>...</body>
</html>
```
- 요청 패킷 전달 (서버 -> 클라이언트)

![요청 패킷 전달서버에게](https://user-images.githubusercontent.com/57219160/129667003-42001d51-316f-4507-89e3-90f590fb0552.PNG)
- 웹 브라우저가 HTML 렌더링

![렌더링](https://user-images.githubusercontent.com/57219160/129667201-aa896db5-0701-4c8e-929b-ebe2a142b34c.PNG)


# HTTP 기본
## 모든 것이 HTTP
- `H`yper`T`est `T`ransfer `P`rotocol
- HTTP 메시지에 모든 것을 전송
    - HTML, TEXT
    - IMAGE, 음성, 영상, 파일
    - JSON, XML(API)
    - 거의 모든 형태의 데이터 전송 가능
    - 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용
    - 지금은 HTTP 시대!      

- HTTP 역사
    - HTTP/0.9 1991년: GET 메서드만 지원, HTTP 헤더X
    - HTTP/1.0 1996년: 메서드, 헤더 추가
    - `HTTP/1.1` 1997년: 가장 많이 사용, 우리에게 가장 중요한 버전
    - RFC2068 (1997) -> RFC2616 (1999) -> RFC7230~7235 (2014)
    - HTTP/2 2015년: 성능 개선
    - HTTP/3 진행중: TCP 대신에 UDP 사용, 성능 개선

- 기반 프로토콜
    - TCP : HTTP/1.1, HTTP/2
    - UDP : HTTP/3
    - 현재 HTTP/1.1 주로 사용
        - HTTP/2, HTTP/3 도 점점 증가

- HTTP 특징
   - 클라이언트 <-> 서버 구조
   - 무상태 프로토콜(stateless), 비연결성
   - HTTP 메시지
   - 단순함, 확장 가능

## 클라이언트 서버 구조
- Request Response 구조
- 클라이언트는 서버에 요청(HTTP 메시지를 통해서) 을 보내고, 응답을 대기
- 서버가 요청에 대한 결과(HTTP 메시지를 통해서) 를 만들어서 응답

- 이렇게 클라이언트 <-> 서버 2가지로 분리하는 것이 엄청 중요하다.
    - 양쪽이 독립적으로 개발을 진행할 수 있음.

## Stateful, Stateless
- pdf참고하기(고객이 점원에게 주문하는 스토리)

- 무상태 프로토콜이다.

- 스테이스리스(Stateless)
    - 서버가 클라이언트의 상태를 보존X
    - 장점 : 서버 확장성 높음(스케일 아웃)
    - 단점 : 클라이언트가 추가 데이터 전송

- Stateful, Stateless 차이
    - 상태 유지 : 중간에 다른 점원으로 바뀌면 안된다. (중간에 다른 점원으로 바뀔 때 사고자 하는 상품의 상태(2개, 2만원짜리, 사이즈 등) 정보를 다른 점원에게 미리 알려줘야 한다.), 항상 상태를 관리해야 한다.
    - 무상태 : 중간에 다른 점원으로 바뀌어도 된다.
        - 각각의 모든 점원한테 모든 정보를 한번에 다 준다.
        - 갑자기 고객이 증가해도 점원을 대거 투입할 수 있다.
        - 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다.
    - 무상태는 응답 서버를 쉽게 바꿀 수 있다. -> `무한한 서버 증설 가능`

- 상태 유지(Stateful)
    - 항상 같은 서버(서버 여러 대 중 서버 1번)가 유지되어야 한다.(여러 서버가 있더라도)
    - 항상 서버 1번이랑만 통신(1번 서버만이 클라이언트A의 정보, 즉 노트북, 2개를 사고싶다고 하는 사실을 알고있음)
    - 그러다가 만약 서버 1번이 뻗어버리면, 클라이언트A는 노트북 -> 2개 주문 -> 결제 이 과정을 처음부터 다 다시 해야 한다.
- 무상태(Stateless)
    - 아무 서버나 호출해도 된다.
    - 클라이언트가 요청을 할 때부터 필요한 데이터를 다 담아서 보낸다(노트북, 2개, 구매하려고 함)
    - `스케일 아웃(서버를 막 늘리는 것, 수평 확장)` 에 유리하다.

- Stateless 실무 한계
    - 모든 것을 무상태로 설계할 수 있는 경우도 있고 없는 경우도 있다.
    - 무상태
        - ex) 로그인이 필요 없는 단순한 서비스 소개 화면
    - 상태 유지
        - ex) 로그인
    - 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지
    - 일반적으로 브라우저 쿠키와 서버 세션등을 사용해서 상태 유지
    - 상태 유지는 최소한만 사용
    - 단점) 데이터를 너무 많이 보내야 한다.

- 그래서 웹 애플리케이션을 설계할 때는 최대한 무상태로 설계하고, 상태유지는 최소한으로.


## 비연결성(connectionless)
- 연결을 유지하는 모델
    - 그래서 클라이언트1이 하나의 서버에 연결 후, 클라이언트2, 3이 계속 요청을 하면 클라이언트 1, 2는 계속 연결이 되어 있는 상태다.
    - 그래서 서버는 연결을 계속 유지하고 서버 자원을 소모한다.
- 연결을 유지하지 않는 모델
    - 각각의 클라이언트가 서버에 요청 후 응답을 받으면 그 즉시 TCP/IP 연결을 끊어버린다.
    - 서버는 연결유지X, 최소한의 자원 유지
- 비 연결성
    - `HTTP는 기본이 연결을 유지하지 않는 모델`
    - 클라이언트 1이 서버에 요청을 하고 난 후 응답을 받으면 TCP/IP는 연결을 끊는다. 그래서 클라이언트 2, 3이 각각 연결을 할 때는 그 전의 연결들이 다 끊겨있는 상태다.
    - 일반적으로 초 단위 이하의 빠른 속도로 응답
    - 실제로 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
        - 예) 웹 브라우저에서 계속 연속해서 검색 버튼을 누르지는 않는다. 
    - 서버 자원을 매우 효율적으로 사용할 수 있음
    - 참고) 원래 TCP/IP는 기본적으로 연결(서버에 요청 후 응답을 받음)을 유지한다.

- 비 연결성, 한계와 극복
    - 단점
        - TCP/IP 연결을 새로 맺어야 함 - 3 way handshake 시간 추가(검색해서 무엇을 보다가 다른 것을 클릭해서 들어갈 때 TCP/IP를 새로 맺어야 함)
        - 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수 많은 자원이 함께 다운로드
        - 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
            - 기본적으로 HTTP는 지속 연결을 쓴다. 예전에는 keep-alive 
        - HTTP/2, HTTP/3에서 더 많은 최적화


- HTTP 초기 - 연결, 종료 낭비
    - 클라이언트와 서버 간의
        - 연결(0.1초), `요청/HTML 응답`(0.1초), 종료(0.1초) => 0.3초
        - 연결(0.1초), `요청/자바스크립트 응답`(0.1초), 종료(0.1초) => 0.3초
        - 연결(0.1초), `요청/이미지 응답`(0.1초), 종료(0.1초) => 0.3초
        - 총 0.9초
- HTTP 지속 연결(Persistent Connections)
    - 클라이언트와 서버 간의
        - 연결(0.1초)
        - `요청/HTML 응답(0.1초), 요청/자바스크립트 응답(0.1초), 요청/이미지 응답(0.1초)`
        - 종료(0.1초)
        - 총 0.5초


- 스테이스리스를 기억하자
    - 서버 개발자들이 어려워하는 업무
        - 정말 같은 시간에 딱 맞추어 발생하는 대용량 트래픽
        - 예) 선착순 이벤트, 명절 KTX 예약, 학과 수업 등록
        - 예) 저녁 6:00 선착순 1000명 치킨 할인 이벤트 -> 수만명 동시 요청

- 매우중요) 최대한 스테이스리스로 설계하는 것이 중요하다. 어떻게든!!!!!!!!!!!!!
    - 그러면 대용량의 트래픽이 오더라도 서버를 확 늘려서 대응할 수 있는 방법이 많아진다. 어쩔 수 없는 부분만 상태 유지를 하도록 잘 분리해서 설계하는 것이 중요하다.
    - 그래서 보통 이렇게 많이 한다. 첫 페이지는 로그인이 필요 없는 정적 페이지를 하나 뿌린다. 그래서 아무 상태 없는 HTML 하나만 두는 것이다. 이 페이지에서 사람들이 좀 들여다보게 하고 놀게 한 다음에 이벤트에 참여하게 한다. 그러면 지연이 조금 생기니까!

## HTTP 메시지
- 우리가 생각할 수 있는 모든 바이너리 데이터들을 다 보낼 수 있다.
- HTTP 메시지에 모든 것을 전송
    - HTML, TEXT
    - IMAGE, 음성, 영상, 파일
    - JSON, XML
    - 거의 모든 형태의 데이터 전송 가능
    - 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용
    - `지금은 HTTP 시대!`

- HTTP 는 요청메지와 응답메시지의 구조가 다르다.
- pdf 보기

![메시지 구조](https://user-images.githubusercontent.com/57219160/129676172-3d2d7d1f-f43c-4356-9caa-7de0fa1f1cb9.PNG)

- HTTP 메시지 구조
    - start-line 시작 라인
    - header 헤더
    - empty line 공백 라인(CRLF)(무조건 있어야 함)
    - message body

- 공식 스펙에서 확인가능(https://datatracker.ietf.org/doc/html/rfc7230#section-3)
    - start-line
    - *( header-field CRLF ) - 여러 개의 header 필드들
    - CRLF 
    - [ message-body ] - 없어도 됨

- 시작 라인(요청 메시지), request
    ```
    GET /search?q=hello&hl=ko HTTP.1.1
    Host: www.google.com
    (공백)
    ```
    - start-line = `request-line` / status-line 으로 2가지인데 요청 메시지에서는 request-line 이라고 부른다.
    - `request-line` = method SP(공백) request-target SP HTTP-version CRLF(엔터)
    - 3가지가 들어감
        - HTTP 메서드(GET: 조회)
        - 요청 대상 (/search?q=hello&hl=ko) - path임
        - HTTP Version

    1. HTTP 메서드
        - 종류 : GET, POST, PUT, DELETE...
        - 서버가 수행해야 할 동작 지정
            - GET : 리소스 조회
            - POST : 요청 내역 처리
    2. 요청 대상(요청 메시지)
        - absolute-path[?query] (절대경로[?쿼리])
        - 절대경로="/" 로 시작하는 경로
        - 참고: *, http://...?x=y 와 같이 다른 유형의 경로지정 방법도 있다.
    3. HTTP 버전
        
- 시작 라인(응답 메시지), response
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length:3423

    <html>
        <body>...</body>
    </html>
    ```
    - start-line = request-line / `status-line` 으로 2가지인데 응답 메시지에서는 `status-line` 이라고 부른다.
    - `status-line` = HTTP-version SP status-code SP reason-phrase CRLF
    1. HTTP 버전
    2. HTTP 상태 코드 : 요청 성공, 실패를 나타냄
        - 200 : 성공
        - 400 : 클라이언트 요청 오류
        - 500 : 서버 내부 오류
    3. 이유 문구 : 사람이 이해할 수 있는 짧은 상태 코드 설명 글


- HTTP 헤더
    - header-field = field-name":" OWS field-value OWS (OWS : 띄어쓰기 허용, 해도 되고 안해도 됨)
        - field-name 과 :는 붙여서 써야 함
    - filed-name 은 대소문자 구문 없음(Host, host 무관), value(www.google.com)은 당연히 대소문자 구분
    - 요청 메시지에서의 헤더는 `Host: www.google.com`
        - `Host: `는 괜찮은데 `Host :`는 안됨
    - 응답 메시지에서의 HTTP 헤더는
    ```
    Content-Type: text/html;charset=UTF-8
    Content-Length: 3423
    ```
    - 용도  
        - HTTP 전송에 필요한 모든 부가정보
        - 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 어플리케이션 정보, 캐시 관리 정보...
        - 표준 헤더가 너무 많음
            - https://en.wikipedia.org/wiki/List_of_HTTP_header_fields
        - 필요시 임의의 헤더 추가 가능
            - helloworld: hihi

- HTTP 메시지 바디
    - 보통 응답 메시지에 담겨 있음 (요청 메시지도 body 본문을 가질 수 있다)
    - 응답 메시지에서의 body 예시
    ```
    <html>
        <body>...</body>
    </html>
    ```
    - 실제 전송할 데이터
    - HTML 문서, 이미지, 영상, JSON 등등 byte로 표현할 수 있는 모든 데이터 전송 가능(압축했다면 압축된 것이 담겨있음)


- 단순함 확장 가능
    - HTTP는 단순하다. 스펙도 읽어볼만...
    - HTTP 메시지도 매우 단순
    - 크게 성공하는 표준 기술은 단순하지만 확장 가능한 기술


# HTTP 메서드
## HTTP API를 만들어보자
- 회원 정보 관리 API를 만들어라
    - 회원 목록 조회
    - 회원 조회
    - 회원 등록
    - 회원 수정
    - 회원 삭제

- API URI 설계 - URI(Uniform Resource Identifier)
    - 회원 목록 조회 /read-member-list
    - 회원 조회 /read-member-by-id
    - 회원 등록 /create-member
    - 회원 수정 /update-member
    - 회원 삭제 /delete-member

- 이것은 좋은 URI 설계일까?
- 가장 중요한 것은 `리소스 식별`
- API URI 고민 - URI(Uniform Resource Identifier)
    - 리소스의 의미는 뭘까?
        - 회원을 등록하고 수정하고 조회하는게 리소스가 아니다!
        - 예) 미네랄을 캐라 -> 미네랄이 리소스임. `캐라`는 리소스가 아니다.
        - `회원이라는 개념 자체가 바로 리소스다.`
    - 리소스를 어떻게 식별하는게 좋을까?
        - 회원을 등록하고 수정하고 조회하는 것을 모두 배제
        - `회원이라는 리소스만 식별하면 된다. -> 회원 리소스를 URI에 매핑`
- API URI 설계 - URI(Uniform Resource Identifier)
    - `회원` 목록 조회
    - `회원` 조회
    - `회원` 등록
    - `회원` 수정
    - `회원` 삭제

- API URI 설계 - URI(Uniform Resource Identifier
    - `회원` 목록 조회 /members
    - `회원` 조회 /members/{id} `-> 어떻게 구분하지?`
    - `회원` 등록 /members/{id} `-> 어떻게 구분하지?`
    - `회원` 수정 /members/{id} `-> 어떻게 구분하지?`
    - `회원` 삭제 /members/{id} `-> 어떻게 구분하지?`
    - 참고: 계층 구조상 상위를 컬렉션으로 보고 복수단어 사용 권장(member -> members)

- `리소스와 행위를 분리!!!`, `가장 중요한 것은 리소스를 식별하는 것.`
    - `URI는 리소스만 식별!`, URI는 리소스의 `행위` 를 판별하는데 사용하면 안된다.
    - `리소스`와 해당 리소스를 대상으로 하는 `행위`를 분리
        - 리소스 : 회원
        - 행위 : 조회, 등록, 삭제, 변경
    - 리소스는 명사(미네랄), 행위는 동사(캐라)
    - 행위(메서드)는 어떻게 구분? `HTTP 메서드가 해준다.`

## HTTP 메서드 - GET, POST
- HTTP 메서드는 클라이언트가 서버에 요청할 때 `기대되는 행동`이다.
- 주요 메서드
    - GET: 리소스 조회
    - POST: 요청 데이터 처리, 주로 등록에 사용
    - PUT: 리소스를 대체, 해당 리소스가 없으면 생성
        - ex) 빈 파일을 폴더에 넣는 것. 없으면 생성, 있으면 덮어버림.
    - PATCH: 리소스 부분 변경
    - DELETE: 리소스 삭제

- 기타 메서드
    - HEAD : GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환
    - OPTIONS : 대상 리소스에 대한 통신 가능 옵션(메서드)을 설명(주로 CORS에서 사용)
    - CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
    - TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행

- GET
    ```
    GET /search?q=hello&hl=ko HTTP/1.1
    Host: www.google.com
    
    ```
    - 리소스 조회
    - 서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달
    - 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않음

    - 리소스 조회1 - 메시지 전달
        - 클라이언트가 서버에 아래의 요청 메시지를 보내면
        ```
        GET /members/100 HTTP/1.1
        Host: localhost:8080

        ```
    - 리소스 조회2 - 서버도착
        - 서버는 아이디가 100번인 회원을 조회(GET) 해서 DB에서 들고옴
        - 데이터를 만듬(JSON인데 다른 형식의 데이터일 수도 있음). 만약 HTML 이라면 웹 브라우저(클라이언트)가 서버로부터 받은 HTML 태그 정보를 읽어서 보여줄 것임. 
        ```
        {
            "username" : "young",
            "age" : 20
        }
        ```
    - 리소스 조회3 - 응답 데이터를 클라이언트에게 보낸다.
        ```
        HTTP/1.1 200 OK
        Content-type: application/json
        Content-Length: 34

        {
            "username": "young",
            "age": 20
        }
        ```

- POST
    ```
    POST /members HTTP/1.1
    Content-typ0e: application/json

    {
        "username": "hello",
        "age": 20
    }
    ```
    - 요청 데이터 처리
    - `메시지 바디를 통해 서버로 요청 데이터 전달` 
    - 서버는 요청 데이터를 `처리`
        - 메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다.(물론 서로 약속을 해놓은 상태)
    - 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용
        - 미리 약속된 상태 : 서버는 "클라이언트야, 너가 데이터를 /members에 POST로 보내면 그 데이터를 난 저장할거야, 또는 그 데이터를 내부적인 프로세스에 쓰는데 사용할거야" 라고 미리 서로 약속. 여기서는 신규로 등록으로 약속.
    - 리소스 등록
        1. 클라이언트가 아래의 메시지를 `/members`라는 곳에 전달
        ```
        POST /members HTTP/1.1
        Content-type: application/json

        {
            "username": "hello",
            "age": 20
        }
        ```
        2. 신규 리소스 생성
        - /members 에 데이터를 받아서 DB에 등록해서 새로운 id값 생성(신규 리소스 식별자 생성)
        - /members/100
        ```
         {
            "username": "hello",
            "age": 20
        }
        ```
        3. 응답 데이터를 클라이언트에게 전송
        - 200메시지로 보내도 된다. 그리고 보통 201로 보내면 Location필드를 통해서 자원이 생성된 신규 URI 주소를 보내준다.
        ```
        HTTP/1.1 201 Created
        Content-Type: application/json
        Content-Length: 34
        Location: /members/100

        {
            "username": "young",
            "age": 20
        }
        ```

    - POST 는 요청 데이터를 어떻게 처리한다는 뜻일까? 예시
        - 스펙: POST 메서드는 `대상 리소스가 리소스의 고유한 의미 체계에 따라 요청에 포함된 표현을 처리하도록 요청`합니다. (구글 번역)
        - 예를 들어 POST는 다음과 같은 기능에 사용됩니다.
            - HTML 양식에 입력된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공
                - ex) HTML FORM에 입력한 정보로 회원 가입, 주문 등에서 사용
            - 게시판, 뉴스 그룹, 메일링 리스트, 블로그 또는 유사한 기사 그룹에 메시지 게시
                - ex) 게시판 글쓰기, 댓글 달기
            - 서버가 아직 식별하지 않은 새 리소스 생성
                - ex) 신규 주문 생성
            - 기존 자원에 데이터 추가
                - ex) 한 문서 끝에 내용 추가하기
        - 정리 : `이 리소스 URI에 POST 요청이 오면 요청 데이터를 어떻게 처리할지 리소스마다 따로 정해야 함 -> 정해진 것이 없음`


- POST 정리
    1. 새 리소스 생성(등록)
        - 서버가 아직 식별하지 않은 새 리소스 생성
    2. 요청 데이터 처리
        - 단순히 데이터를 생성하거나, 변경하는 것을 넘어서 프로세스를 처리해야 하는 경우
        - 예) 주문에서 결제완료 -> 배달시작 -> 배달완료 처럼 단순히 값 변경을 넘어 프로세스의 상태가 변경되는 경우(서버에서 큰 변화가 일어나는 것)
        - POST의 결과로 새로운 리소스가 생성되지 않을 수도 있음
        - 예) POST /orders/{orderId}/start-delivery (컨트롤 URI)
            - 주문번호(orderId)로 배달을 시작해라.(start-delivery)
            - 원래는 URI 설계를 리소스 단위로 해야하는데 어쩔 수 없이 리소스 단위로 설계가 안될 때가 있다.
            - 동사의 의미가 담긴 URI -> `컨트롤 URI` 라고 부른다.
            - 실무에서는 리소스 단위로만 URI 를 다 설계할 수는 없다. 최대한 리소스 단위로 설계하고 난 후 어쩔 수 없는 부분들은 컨트롤 URI로 설계
    3. 다른 메서드로 처리하기 애매한 경우
        - 예) JSON으로 조회 데이터를 넘겨야 하는데, GET 메서드를 사용하기 어려운 경우(메세지 바디를 넣을 수 있긴 한데 허용 안하는 서버들이 많아서 아예 체크를 안함)
        - 이럴 경우 조회이지만 POST를 사용, 애매한 POST
        
    - 참고) 사실 POST는 모든 것을 할 수 있다. 그런데 조회할 때는 GET을 쓰는 것이 유리하다. 서버끼리 약속을 해둔다. `GET으로 오면 캐싱을 하겠다.`. POST로 오면 캐싱을 하는 것이 어렵다. 그래서 조회의 경우는 최대한 GET을 쓰고, 위와 같은 경우들은 POST 사용하기

## HTTP 메서드 - PUT, PATCH, DELETE
- PUT
    ```
    PUT /members/100 HTTP/1.1
    Content-type: application/json

    {
        "username": "hello",
        "age": 20
    }
    ```
    1. 리소스를 대체
        - 쉽게 이야기해서 덮어버림(폴더에 파일을 넣는 것과 동일. 기존 것이 있으면 덮고, 없으면 생성)
        - 리소스가 있으면 대체(완전히). 수정이 아니고 아예 갈아치움. 수정은 PATCH 메서드.
        - 리소스가 없으면 생성
        - 위 코드에서 /members/100 이 있다면 완전히 대체함(덮어버림), 없으면 생성
    2. 중요! 클라이언트가 리소스를 식별
        - 클라이언트가 리소스 위치를 알고 URI 지정
            - 위의 코드에서 /members/100 의 위치를 정확하게 알고 있음. 100번의 위치에 넣을 것이라고 지정함.
        - POST와 차이점임
            - POST는 /members 까지만 안다. 100번의 위치에 만들어질지 200번의 위치에 만들어질지 모른다.

    - 주의! 리소스를 완전히 대체한다
        - 클라이언트가 아래처럼 요청메시지를 보낸다. (username 필드가 없다.)
        ```
        PUT /members/100 HTTP/1.1
        Content-type: application/json

        {
            "age":50
        }
        ```
        - 서버에서는 /members/100의 위치에 기존에 아래의 데이터가 있다.
        ```
        {
            "username": "young",
            "age: 20
        }
        ```
        - 전송 결과는? 서버에서 완벽히 대체되므로 기존의 username 필드가 삭제된다.
        ```
        {
            "age":50
        }
        ``` 
    
- PATCH
    - 리소스 부분 변경
        - 클라이언트가 아래처럼 요청메시지를 보낸다. (username 필드가 없다.)
        ```
        PATCH /members/100 HTTP/1.1
        Content-type: application/json

        {
            "age":50
        }
        ```
        - 서버에서는 /members/100의 위치에 기존에 아래의 데이터가 있다.
        ```
        {
            "username": "young",
            "age: 20
        }
        ```
         - 전송 결과는? username필드가 지워지지 않고 age필드의 값만 수정된다.
        ```
        {
            "username": "young",
            "age": 50
        }
        ```
    - 그런데 PATCH 지원이 안되는 서버들이 있다. 그런 경우에는 POST를 사용하면 된다.

- DELETE
    - 리소스 제거
        - 클라이언트가 아래로 요청 메시지 보냄
        ```
        DELETE /members/100 HTTP/1.1
        Host: localhost:8080
        ```
        - 서버의 /members/100에는 아래의 데이터가 기존에 존재
        ```
        {
            "username": "young",
            "age": 20
        }
        ```
        - 결과는? 서버의 /members/100 리소스가 제거된다.
    

## HTTP 메서드의 속성(안전, 멱등, 캐시가능)
- [표로 정리](https://ko.wikipedia.org/wiki/HTTP)

- 안전(Safe Methods)
    - 호출해도 리소스를 변경하지 않는다.
    - GET은 안전
    - PATCH, POST, DELETE, PUT은 안전X
    - Q) 그래도 계속 호출해서, 로그 같은게 쌓여서 장애가 발생하면?
        - 안전은 해당 리소스만 고려한다. 그런 부분까지는 고려X

- 멱등(Idempotent)
    - f(f(x)) = f(x)
    - 한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 똑같다.
    - 멱등 메서드
        - GET: 한 번 조회하든, 두 번 조회하든 같은 결과가 조회된다.
        - PUT: 결과를 대체한다. 따라서 같은 요청을 여러번 해도 최종 결과는 같다.
            - 같은 파일을 계속 업로드
        - DELETE: 결과를 삭제한다. 같은 요청을 여러번 해도 삭제된 결과는 똑같다.
        - `POST`: `멱등이 아니다`. 두 번 호출하면 같은 결제가 중복해서 발생할 수 있다.
    - 활용
        - 자동 복구 메커니즘
        - 서버가 TIMEOUT 등으로 정상 응답을 못주었을 때, 클라이언트가 같은 요청을 다시 해도 되는가? 판단 근거
            - 예를 들어 DELETE요청을 했는데 정상 응답 없었을 경우, 클라이언트가 자동으로 다시 재시도.
    - Q) 재요청 중간에 다른 곳에서 리소스를 변경해버리면?
        - 사용자1 : GET -> username:A, age:20
        - 사용자2 : PUT -> usrename:A, age:30
        - 사용자1 : GET -> username:A, age:30 -> 사용자2의 영향으로 바뀐 데이터 조회
        - A: 멱등은 외부 요인으로 중간에 리소스가 변경되는 것까지는 고려하지 않는다.

- 캐시가능(Cacheable)
    - 응답 결과 리소스를 캐시해서 사용해도 되는가?
    - GET, HEAD, POST, PATCH 캐시가능
    - 실제로는 GET, HEAD 정도만 캐시로 사용 
        - POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않음.

# HTTP 메서드 활용
## 클라이언트에서 서버로 데이터 전송
- 데이터 전달 방식은 크게 2가지
    1. 쿼리 파라미터를 통한 데이터 전송
        - GET
        - 주로 정렬 필터(검색어)
    2. 메시지 바디를 통한 데이터 전송
        - POST, PUT, PATCH
        - 회원 가입, 상품 주문, 리소스 등록, 리소스 변경

- 4가지 상황
    - 정적 데이터 조회
        - 이미지, 정적 텍스트 문서
    - 동적 데이터 조회
        - 주로 검색, 게시판 목록에서 정렬 필터(검색어)
    - HTML Form을 통한 데이터 전송
        - 회원 가입, 상품 주문, 데이터 변경
    - HTTP API를 통한 데이터 전송
        - 회원 가입, 상품 주문, 데이터 변경
        - 서버 to 서버, 앱 클라이언트, 웹 클라이언트(Ajax)
    
- 정적 데이터 조회(pdf 174 보기)
    - 쿼리 파라미터 미사용
    - 클라이언트 요청메시지
    ```
    GET /static/star.jpg HTTP/1.1
    Host: localhost:8080
    ```
    - 서버 응답메시지
        - /static/star.jpg 준다
        ```
        HTTP/1.1 200 OK
        Content-Type: image/jpeg
        Content-Length: 34012

        fkdlhkdjskdahfkajsdhfjskdahf
        asdfkjshadfkjshadfkjhasdkfjhskdaj
        ```
    - 이미지, 정적 텍스트 문서
    - 조회는 GET 사용
    - 정적 데이터는 일반적으로 쿼리 파라미터 없이 리소스 경로로 단순하게 조회 가능

- 동적 데이터 조회
    - 쿼리 파라미터 사용
    - https://www.google.com/search?`q=hello&hl=ko`
    - 클라이언트 요청 메시지
        - `?q=hello&hl=ko` 쿼리 파라미터를 서버에서 key=value로 꺼낼 수 있음. 꺼내서 hello에 대한 정보를 찾아서 보여줌
        ```
        GET /search?q=hello&hl=ko HTTP/1.1
        Host: www.google.com
        
        ```
    - 서버 응답 메시지
        - 쿼리 파라미터를 기반으로 정렬 필터해서 결과를 동적으로 생성

    - 정리
        - 주로 검색, 게시판 목록에서 정렬 필터(검색어)
        - 조회 조건을 줄여주는 필터, 조회 결과를 정렬하는 정렬 조건에 주로 사용
        - 조회는 GET 사용
        - GET은 쿼리 파라미터 사용해서 데이터를 전달
        
- HTML Form 데이터 전송
    - POST 전송 - 저장
        - 화면
            - username : `kim`, age : `20` / 전송
        - HTML 코드
        ```
        <form action="/save" method="post">   // post
            <input type = "text" name = "username" />
            <input type = "text" name = "age" />
            <button type = "submit">전송</button>
        </form>
        ```
        - 전송버튼을 누르면 `웹 브라우저가 Form의 데이터를 읽어서 HTTP 메시지를 생성해준다.`
        - 웹 브라우저가 생성한 요청 HTTP 메시지
            - 쿼리 파라미터 같은 Content-Type을 application/x-www-form-urlencoded 라고 한다.(서버간에 다 약속이 되어있다. 웬만한 웹서버들은 이런것들을 다 파싱해서 사용할 수 있도록 구현이 되어있다)
        - 폼으로 보내면 아래와 같이 데이터 부분에 쿼리파라미터 형태로 데이터가 넘어간다.
        ```
        POST /save HTTP/1.1
        Host: localhost:8080
        Content-Type: application/x-www-form-urlencoded // 폼으로 보냈음

        usernmae=kim&age=20  // 쿼리파라미터 형태, POST이므로 바디에 사용
        ```
    - GET 전송 - 저장
        - 사용하지 말기!
        - 화면
            - username : `kim`, age : `20` / 전송
        - HTML Form으로 데이터를 전송할 때 메서드를 GET으로 바꿀 수 있음
        ```
        <form action="/save" method="get">   // get 
            <input type = "text" name = "username" />
            <input type = "text" name = "age" />
            <button type = "submit">전송</button>
        </form>
        ```
        - 웹 브라우저가 생성한 요청 HTTP 메시지
            ```
            GET /save?usernmae=kim&age=20 HTTP/1.1
            Host: localhost:8080
            
            ```
            - GET이므로 메시지 바디를 안 쓰고 데이터를 쿼리 파라미터에 넣어서 서버에 전달
            - 그래서 URL에 직접 쳐서 넣어도 되지만, form 태그에 데이터를 입력하고 전송버튼을 누르면 GET이라고 지정되어 있더라도 url 경로에 데이터를 넣게 됨 (강의다시듣기)
            - 주의!) GET은 조회에만 사용!, 리소스 변경(/save)이 발생하는 곳에 사용하면 안됨. 이렇게 사용하지 말기
    - GET 전송 - 조회
        - 화면
            - username : `kim`, age : `20` / 전송
        - form태그
        ```
        <form action="/members" method="get">
            <input type = "text" name = "username" />
            <input type = "text" name = "age" />
            <button type = "submit">전송</button>
        </form>
        ```
        - 웹 브라우저가 생성한 요청 HTTP 메시지
        ```
        GET /members?username=kim&age=20 HTTP/1.1
        Host: localhost:8080
        
        ```
    - muiltipart/form-data (pdf181 참조), 파일 전송시 사용(binary 데이터 전송시 사용)
        - 화면
            - username : `kim`
            - age : `20`
            - file : 파일 선택 (intro.jpg)
            - 전송(버튼)
        - HTML 코드
        ```
        <form action="/members" method="post" enctype="multipart/form-data">   //   enctype="multipart/form-data" 
            <input type = "text" name = "username" />
            <input type = "text" name = "age" />
            <input type = "file" name = "file1" />
            <button type = "submit">전송</button>
        </form>
        ```
        - 웹 브라우저가 생성한 요청 HTTP 메시지
        ```
        POST /save HTTP/1.1
        Host: localhost:8080
        Content-Type: multipart/form-data; boundary=-----XXX 
        Content-Length: 10457
        
        ------XXX
        Content-Disposition: form-data; name="username"
        
        kim
        ------XXX
        Content-Disposition: form-data; name="age"
        
        20
        ------XXX
        Content-Disposition: form-data; name="file1"; filename="intro.png"
        Content-Type: image/png
        
        109238a9o0p3eqwokjasd09ou3oirjwoe9u34ouief...  // 파일
        ------XXX--  // 끝에는 -- 추가
        ```

    - 정리
        - HTML Form submit시 POST 전송
            - 예) 회원 가입, 상품 주문, 데이터 변경
        - Content-Type: application/x-www-form-urlencoded 사용(default) 
            - form의 내용을 메시지 바디를 통해서 전송(key=value, 쿼리 파라미터 형식)
            - 전송 데이터를 url encoding 처리
                - 예) abc김 -> abc%EA%B9%80
        - HTML Form은 GET 전송도 가능
        - Content-Type: multipart/form-data
            - 파일 업로드 같은 바이너리 데이터 전송시 사용
            - 다른 종류의 여러 파일과 폼의 내용 함께 전송 가능(그래서 이름이 multipart)
        - 참고: HTML Form 전송은 `GET, POST만 지원`

        
- HTTP API 데이터 전송
    - HTML FORM을 쓰지 않는 모든 상황
    - 안드로이드 애플리케이션 등에서 클라이언트가 서버에 데이터를 바로 전송해야 하는 경우(HTTP API로 데이터를 전송한다고 표현)
    - 아래의 메시지를 직접 다 만들어서 넘기면 된다. 보통 클라이언트의 라이브러리에 다 있다. 이걸 다 해준다.
    ```
    POST /members HTTP/1.1
    Content-type: application/json

    {
        "username": "young",
        "age": 20
    }
    ```
    - 정리
        - 서버 to 서버
            - 백엔드 시스템 통신(백엔드 서버끼리), 왜냐하면 백엔드끼리 통신할때는 HTML같은 것이 없고 기계끼리 통신하는 것이므로.
        - 앱 클라이언트
            - Html에서 Form 전송 대신 자바 스크립트를 통한 통신에 사용(AJAX)
            - 예) React, VueJs 같은 웹 클라이언트와 API 통신
        - POST, PUT, PATCH : 메시지 바디를 통해 데이터 전송
            - 다 활용가능
        - GET : 조회, 쿼리, 파라미터로 데이터 전달
        - Content-Type: Application/json을 주로 사용 (사실상 표준)
            - TEXT, XML, JSON 등등
            - 예전에는 XML을 많이 사용했었음


## HTTP API 설계(서로 약속) 예시
1. HTTP API - 컬렉션
    - POST 기반 등록
    - 예) 회원 관리 API 제공
2. HTTP API - 스토어
    - PUT 기반 등록
    - 예) 정적 컨텐츠 관리, 원격 파일 관리
3. HTML FORM 사용
    - 웹 페이지 회원 관리
    - GET, POST만 지원



- 회원 관리 시스템 - API 설계(POST 기반 등록)
    - 회원 목록 /members -> `GET`
    - 회원 등록 /members -> `POST`
    - 회원 조회 /members/{id} -> `GET`
    - 회원 수정 /members/{id} -> `PATCH, PUT, POST`
        - 개념적으로는 PATCH를 사용하는 것이 맞다. PUT은 다 덮어버리기 때문에 잘 사용은 안한다. 왜냐하면 클라이언트에서 모든 데이터를 빠짐없이 다 보내야 하기 때문이다. 물론 게시글 수정같은 경우(다 덮어도 되는) 유용하긴 함. 게시글 같은 경우는 부분 수정이 아니라 수정한 전체 글을 다시 클라이언트에서 서버로 보내서 수정하므로. 
    - 회원 삭제 /members/{id} -> `DELETE`
    - 참고) /members -> 이런것들을 `컬렉션`이라고 한다.
        - 컬렉션(Collection) 이란
            - 서버가 관리하는 리소스 디렉토리
            - 서버가 리소스의 URI를 생성하고 관리
            - 여기서 컬렉션은 /members
    - POST - 신규 자원 등록 특징
        - 클라이언트는 등록될 리소스의 URI를 모른다. (100번인지 등). -> PUT이랑 다름
            - 회원 등록 /members -> POST
            - POST /members -> 클라이언트는 정확한 URI를 모른다.
        - 서버가 새로 등록된 리소스 URI를 생성해준다. 
            ```
            HTTP/1.1 201 Created
            Location: /members/100
            ```
        
    
- 파일 관리 시스템 - API 설계(PUT 기반 등록)
    - 파일 목록 /files -> `GET`
    - 파일 조회 /files/{filename} -> `GET`
    - 파일 등록 /files/{filename} -> `PUT`
    - 파일 삭제 /files/{filename} -> `DELETE`
    - 파일 대량 등록 /files -> `POST`
        - 이미 PUT을 파일 등록으로 정했기 때문에, /files POST의 의미를 내가 임의로 정할 수 있다. 여기서는 대량 등록이라고 정의함.
    - PUT - 신규 자원 등록 특징
        - 클라이언트가 리소스 URI를 알고 있어야 한다.
            - 파일 등록 /files/{filename} -> PUT
            - PUT /files/star.jpg -> 클라이언트가 알고 있음.
            - 물론 실제로 내부에는 star.jpg 라는 별 사진이 들어있어야 함. -> 서버에 전송
        - 클라이언트가 직접 리소스의 URI를 지정한다.
        - 스토어(Store) 란
            - 클라이언트가 관리하는 리소스 저장소
            - 클라이언트가 리소스의 URI를 알고 관리
            - 여기서 스토어는 /files
    
- 실제로는 POST와 PUT 중에서 컬렉션 기반의 POST를 대부분 사용한다. 그리고 위의 API설계에서처럼 깔끔하게 HTTP메서드만으로 해결이 안되는 경우들도 많은데, 그럴 경우에는 컨트롤 URI를 사용한다. 


- HTML FORM 사용
    - HTML FORM은 기본적으로 GET, POST만 지원 => 그래서 리소스(/members)와 메서드만으로는 구분하기 힘드므로 컨트롤 URI 사용)
    - AJAX, JS 같은 기술을 사용해서 해결 가능 -> 회원 API 참조
    - 여기서는 순수 HTML, HTML FORM 이야기
    - GET, POST만 지원하므로 제약이 있음
    - 설계
        - 회원 목록 /members -> `GET`
        - 회원 등록 폼 /members/new -> `GET`
        - 회원 등록 /members/new, /members -> `POST`
            - 둘 중 선택 가능. 김영한 선생님은 회원 등록하는 폼을 불러올 때의 (/members/new -> GET)와 등록을 할 때(/members/new -> POST)의 URI(/members/new)를 통일 (그러면 나중에 작업할 때 수월)
        - 회원 조회 /members/{id} -> `GET`
        - 회원 수정 폼 /members/{id}/edit -> `GET`
        - 회원 수정 /members/{id}/edit, /members/{id} -> `POST` 
            - 역시 둘 다 사용가능. 그런데 회원 수정 폼을 들고 오는 것과 동일한 URI가 더 나을 듯
        - 회원 삭제 /members/{id}/delete -> `POST`
            - DELETE 메서드를 못 사용하므로 컨트롤 URI 사용
    - 컨트롤 URI
        - GET, POST만 지원하므로 제약이 있음
        - 이런 제약을 해결하기 위해 `동사`로 된 리소스 경로 사용
        - POST의 /new, /edit, /delete가 컨트롤 URI 
        - HTTP 메서드로 해결하기 애매한 경우 사용(HTTP API포함)
        - `실무에서 정말 많이 씀!!!!!!`. 이상적으로는 HTTP메서드로 해결하면 되지만 실제로는 컨트롤 URI를 사용함. 하지만 중구난방으로 사용하면 안된다.


- 정리 
    1. HTTP API - 컬렉션
        - POST 기반 등록
        - 서버가 리소스 URI 결정
    2. HTTP API - 스토어
        - PUT 기반 등록
        - 클라이언트가 리소스 URI 결정
    3. HTML FORM 사용
        - 순수 HTML + HTML form 사용
        - GET, POST만 지원
    - [참고하면 좋은 URI 설계의 4가지 개념](https://restfulapi.net/resource-naming/)
        - 문서(document)
            - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
            - 예) /members/100, /files/star.jpg
        - 컬렉션(collection)
            - 서버가 관리하는 리소스 디렉터리
            - 서버가 리소스의 URI를 생성하고 관리
            - 예) /members
        - 스토어(store)
            - 클라이언트가 관리하는 자원 저장소
            - 클라이언트가 리소스의 URI를 알고 관리
            - 예) /files
        - 컨트롤러(controller), 컨트롤 URI
            - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
            - 동사를 직접 사용
            - 예) /members/{id}/delete
    - API 설계 요령
        - 기준) 문서, 컬렉션, 스토어 + HTTP메서드(GE, POST, DELETE, PUT)으로 최대한 해결이 안되면 컨트롤 URI로 해결.



# HTTP 상태코드
## HTTP 상태코드 소개
- 상태코드
    - 1xx(Informational) : 요청이 수신되어 처리중
        - 잘 사용안함
    - 2xx(Successful) : 요청 정상 처리
    - 3xx(Redirection) : 요청을 완료하려면 추가 행동이 필요
    - 4xx(Client Error) : 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음
    - 5xx(Server Error) : 서버 오류, 서버가 정상 요청을 처리하지 못함

- 만약 모르는 상태 코드가 나타나면?
    - 클라이언트가 인식할 수 없는 상태코드를 서버가 반환하면?
    - 클라이언트는 상위 상태코드로 해석해서 처리
    - 미래에 새로운 상태 코드가 추가되어도 클라이언트를 변경하지 않아도 됨
    - 예)
        - 299 ??? -> 2xx (Successful)
        - 451 ??? -> 4xx (Client Error)
        - 599 ??? -> 5xx (Server Error)


## 1xx(Informational)
    - 요청이 수신되어 처리중
    - 거의 사용하지 않아서 생략


## 2xx - 성공

- 2xx(Successful)
    - 클라이언트의 요청을 성공적으로 처리
    - 200 OK
    - 201 Created
    - 202 Accepted
    - 204 No Content

- 200 Ok
    - 요청 성공
    - 요청 메시지
    ```
    GET /members/100 HTTP/1.1
    Host: localhost:8080
    
    ```
    - 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: application/json
    Content-Length: 34
    
    {
        "username": "young",
        "age": 20
    }
    ```

- 201 Created
    - 요청 성공해서 새로운 리소스가 생성됨
    - 요청 메시지
    ```
    POST /members HTTP/1.1
    Content-Type: application/json

    {
        "username": "young",
        "age": 20
    }
    ```
    - 응답 메시지
        - PUT이므로 서버에서 리소스 URI 생성
        - 생성된 리소스는 응답의 `Location 헤더 필드로 식별`
        ```
        HTTP/1.1 201 Created
        Content-Type: application/json
        Content-Length: 34
        Location: /members/100    //   여기서 식별 가능하다

        {
            "username": "young",
            "age": 20
        }
        ```
- 202 Accepted
    - 요청이 접수되었으나 처리가 완료되지 않았음
    - 배치 처리 같은 곳에서 사용
    - 예) 요청 접수 후 1시간 뒤에 배치 프로세스가 요청을 처리함
    - 잘 사용안함

- 204 No Content
    - 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음
    - 예) 웹 문서 편집기(ex. VSCode) 에서 save 버튼
    - save 버튼의 결과로 아무 내용이 없어도 된다.
    - save 버튼을 눌러도 같은 화면을 유지해야 한다.
    - 결과 내용이 없어도 204 메시지(2xx)만으로 성공을 인식할 수 있다.

## 3xx - 리다이렉션1
- 요청을 완료하기 위해 유저 에이전트의 추가 조치 필요, 클라이언트에게 다시 보냄
    - 유저 에이전트 : 클라이언트 프로그램(웹 브라우저)
- 리다이렉션 이해
    - 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉트)
- 자동 리다이렉트 흐름(pdf 208)
    - 이벤트 페이지 들어갔는데, 행사 종료된 이벤트 페이지에서 현재 진행중인 이벤트 페이지로 안내하는 것.
    1. URL: /event 로 요청
    ```
    GET /event HTTP/1.1
    Host: localhost:8080
    ```
    2. 응답
    ```
    HTTP/1.1 301 Moved Permanently
    Location: /new-event
    ```
    3. 자동 리다이렉트 (브라우저에서)
    URL : /event -> URL : /new-event
    4. 요청
    ```
    GET /new-event HTTP/1.1
    Host: localhost:8080
    ```
    5. 응답
    ```
    HTTP/1.1 200 OK
    ...
    ```
- 종류
    1. 영구 리다이렉션 - 특정 리소스의 URI가 영구적으로 이동
        - 예) /members -> /users
        - 예) /event -> /new-event
    2. 일시 리다이렉션 - 일시적인 변경
        - 주문 완료 후 주문 내역 화면으로 이동
        - PRG : `P`ost/`R`edirect/`G`et
    3. 특수 리다이렉션
        - 결과 대신 캐시를 사용
                
- 영구 리다이렉션
    - 301, 308 
    - 리소스의 URI가 영구적으로 이동
    - 원래의 URL을 사용X, 검색 엔진(ex. 구글) 등에서도 변경 인지
    - 301 Moved Permanently
        - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY. 100%는 아님) -> 대부분의 브라우저가 이렇게 구현이 되어있다.
        - 301 리다이렉션 과정(pdf 211)
            1. 요청
            ```
            POST /event HTTP/1.1
            Host: localhost:8080

            name=hello&age=20 // 메시지 존재
            ```
            2. 응답
            ```
            HTTP/1.1 301 Moved Permanently
            location: /new-event
            ```
            3. 자동 리다이렉트 후 요청(GET으로 변경, 메시지 제거되었음)
            ```
            GET /new-event HTTP/1.1
            Host: localhost:8080
            ```
            4. 클라이언트는 등록을 위해서 다시 POST로 메시지(name=hello&age=20) 새작성 해서 보내야 한다. -> 308 로 해결가능
            5. 응답
            ```
            HTTP/1.1 200 OK
            ...(중략)
            ```

    - 308 Permanent Redirect
        - 301과 기능은 같음
        - 리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지됨. 301처럼 GET으로 변경 되고 메시지가 제거되지 않는다)
        - 308 리다이렉션 과정(pdf 212)
            1. 요청
            ```
            POST /event HTTP/1.1
            Host: localhost:8080

            name=hello&age=20 // 메시지 존재
            ```
            2. 응답
            ```
            HTTP/1.1 308 Permanent Redirect
            location: /new-event
            ```
            3. 자동 리다이렉트 후 요청(POST 유지, 메시지 유지)
            ```
            POST /new-event HTTP/1.1
            Host: localhost:8080

            name=hello&age=20
            ```
            4. POST 메서드가 유지되었고, 메시지 역시 삭제되지 않았으므로 위의 요청메시지 그대로 사용해도 된다.
            5. 응답
            ```
            HTTP/1.1 200 OK
            ...(중략)
            ```
        - 그런데 실무에서는 사실 이렇게 308을 쓰지 않는다. /event 에서 /new-event로 바뀌면 내부적으로 전달해야 하는 데이터 자체가 다 바뀐다. 그래서 이런 경우에는 POST로 와도(그대로 유지가 되어도) 웬만해서는 다시 GET으로 돌리는 것이 맞다. 

## 일시적인 리다이렉션
- 302, 307, 303
- 리소스의 URI가 일시적으로 변경. 안 바뀔수도 있음
- 따라서 검색 엔진 등에서 URL을 변경하면 안됨. 다음에 어떻게 될지 모르기 때문에 오던 곳으로 계속 들어와야 함. 
- 302 Found
    - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY, 브라우저마다 다를 수 있으므로). 대부분(100%는 아님) GET으로 변함.
- 307 Temporary Redirect
    - 302와 기능은 같음
    - 리다이렉트시 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다. MUST NOT)
- 303 See Other
    - 302와 기능은 같음
    - 리다이렉트시 요청 메서드가 100% 명확하게 GET으로 변경

- 실무에서는 307, 303을 쓰기를 희망하지만 302가 제일 많이 쓰이고 있음.

- 그럼 일시적인 리다이렉션은 언제 사용할까? 아래에서 설명.

- PRG: Post/Redirect/Get
    - 일시적인 리다이렉션 - 예시        
        - POST로 주문 후에 웹 브라우저를 새로고침하면?
        - 새로고침은 다시 요청(주문)을 의미
        - 중복 주문이 될 수 있다. (물론 서버쪽에서도 따로 막아야 한다)

- PRG 사용전 과정
    1. URL: /order에 요청
    ```
    POST /order HTTP/1.1
    Host: localhost:8080

    itemId=mouse&count=1
    ```
    2. DB에 주문데이터 저장(mouse 1개)
    3. 응답
    ```
    HTTP/1.1 200 OK

    <html>주문완료</html>
    ```
    4. 결과 화면(주문 완료 페이지. URL:/ order에)에서 새로고침. 
    5. 요청(4번에서 새로고침 했으니)
    ```
    POST /order HTTP/1.1
    Host: localhost:8080

    itemId=mouose&count=1
    ```
    6. DB에 주문데이터 저장(mouse 1개). -> 중복 저장이 됨
    7. 응답
    ```
    HTTP/1.1 200 OK

    <html>주문완료</html>
    ```

- PRG 일시적인 리다이렉션으로 위 상황 해결(중복 주문)
    - POST로 주문후에 새로 고침으로 인한 중복 주문 방지
    - POST로 주문후에 주문 결과 화면을 GET 메서드로 리다이렉트
    - 새로고침해도 결과 화면을 GET으로 조회
    - 중복 주문 대신에 결과 화면만 GET으로 다시 요청

- PRG 적용후 과정
    1. URL: /order에 요청
    ```
    POST /order HTTP/1.1
    Host: localhost:8080

    itemId=mouse&count=1
    ```
    2. DB에 주문데이터 저장(mouse 1개)
    3. 응답
    ```
    HTTP/1.1 302 Found
    Location: /order-result/19

    ```
    4. 웹브라우저에서 자동 Redirect(URL:/order -> URL:/order-result/19), 3번에서 3xx계열이랑 Location 필드 있으므로.
        - URL:/order-result/19는 주문완료 페이지다
    5. 요청
        - GET임
    ```
    GET /order-result/19 HTTP/1.1
    Host: localhost:8080

    ```
    6. DB에 주문데이터 조회(19번)
    7. 응답
    ```
    HTTP/1.1 200 OK
    <html>주문완료</html>
    ```
    8. URL:/order-result/19 결과 화면에서 새로고침 -> GET /order-result/19 결과 화면만 다시 요청(5번으로 이동)

- PRG 적용 이후 리다이렉트
    - URL이 이미 POST -> GET으로 리다이렉트 됨
    - 새로 고침 해도 GET으로 결과 화면만 조회

- 그래서 뭘 써야 하나요?
    - 302, 307, 303
    - 다시 정리
        - 302 Found -> GET으로 변할 수 있음
        - 307 Temporary Redirect -> 메서드가 변하면 안됨
        - 303 See Other -> 메서드가 GET으로 변경
    - 역사
        - 처음 302 스펙의 의도는 HTTP 메서드를 유지하는 것
        - 그런데 웹 브라우저들이 대부분 GET으로 바꾸어버림(일부는 다르게 동작)
        - 그래서 모호한 302를 대신하는 명확한 307, 303이 등장함(301 대응으로 308도 등장)
    - 현실
        - 307, 303을 권장하지만 현실적으로 이미 많은 애플리케이션 라이브러리들이 302를 기본값으로 사용
        - 자동 리다이렉션시에 GET으로 변해도 되면 그냥 302를 사용해도 큰 문제 없음. 

- 기타 리다이렉션 : 300, 304
    - 300 Multiple Choices : 안쓴다
    - 304 Not Modified
        - 많이 사용함
        - 캐시를 목적으로 사용
        - 클라이언트에게 리소스가 수정되지 않았음을 알려준다. 따라서 클라이언트는 로컬PC에 저장된 캐시를 재사용한다. (캐시로 리다이렉트 한다), 네트워크 다운로드 자원 아낄 수 있음
        - 304 응답은 서버가 request 응답에 메시지 바디를 포함하면 안된다.(클라이언트가 로컬 캐시를 사용해야 하므로)
        - 조건부 GET, HEAD 요청시 사용
        

## 4xx - 클라이언트 오류
- 클라이언트의 요청에 잘못된 문법 등으로 서버가 요청을 수행할 수 없음.
- 오류의 원인이 클라이언트에 있음
- 중요! 클라이언트가 이미 잘못된 요청, 데이터를 보내고 있기 때문에, 똑같은 재시도가 실패함

- 400 Bad Request
    - 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
    - 요청 구문, 메시지 등등 오류
    - 클라이언트는 요청 내용을 다시 검토하고, 보내야함
    - 예) 요청 파라미터가 잘못되거나, API 스펙이 맞지 않을 때(ex. 숫자 -> 문자로 잘못보낼 경우)
    - 이런 경우들은 사실 백엔드에서 다 커버해야 한다. API 스펙이 안 맞으면 400오류로 다 튕기도록. 이런 것들을 500 오류로 처리하면 안된다. 그러면 클라이언트 쪽에서는 자신이 잘못한 줄 모르고 서버 오류로 착각한다.

- 401 Unauthorized
    - 클라이언트가 해당 리소스에 대한 인증이 필요함. 
    - 인증(Authentication) 되지 않음. 로그인이 안된 것임
    - 401 오류 발생시 응답에 WWW-Authenticate 헤더와 함께 인증 방법을 설명해 줘야 한다.
    - 참고
        - 인증(Authentication) : 본인이 누구인지 확인(로그인)
        - 인가(Authorization) : 권한부여 (ADMIN 권한처럼 특정 리소스에 접근할 수 있는 권한, 인증이 있어야 인가가 있음)
        - 오류 메시지가 Unauthorized 이지만 인증 되지 않음(이름이 좀 헷갈리게 명명되어 있어서 아쉬움, 마치 인가에 대한 내용같음)

- 403 Forbidden
    - 서버가 요청을 이해했지만 승인을 거부함
    - 주로 인증 자격 증명은 있지만(로그인), 접근 권한이 불충분한 경우
    - 예) 어드민 등급이 아닌 사용자가 로그인은 했지만, 어드민 등급의 리소스에 접근하는 경우

- 404 Not Found
    - 요청 리소스를 찾을 수 없음
    - 요청 리소스가 서버에 없음
    - 또는 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때(403 코드 보여주기 싫을 때)

## 5xx - 서버 오류
- 서버 문제로 오류 발생
- 서버에 문제가 있기 때문에 똑같이 재시도 하면 성공할 수도 있음(복구가 되거나 등등)

- 500 Internal server Error
    - 서버 문제로 오류 발생
    - 애매하면 500 오류
    - 주의) 고객의 잔고가 부족해서 출금이 안되는 경우 -> 이런 경우는 500 에러를 내면 안된다. 500 에러는 무조건 서버가 터지거나 하는 서버 자체의 문제. 비즈니스 로직상 예외케이스는 서버 자체의 문제와는 별개
        

- 503 Service Unavailable
    - 서비스 이용 불가
    - 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음
    - Retry-After 헤더 필드로 얼마뒤에 복구되는지 보낼 수도 있음
    

# HTTP 헤더1 - 일반 헤더
## HTTP 헤더 개요
- header-field = field-name ":" OWS field-value OWS (OWS:띄어쓰기 허용)
- field-name은 대소문자 구분 없음
    - 아래에서 Host: `www.google.com`
    ```
    GET /search?q=hello&hl=ko HTTP/1.1
    Host: www.google.com
    ```
    - 아래에서 두줄. `Content-Type: text/html;charset=UTF-8`, `Content-Length: 3423`
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length: 3423

    <html>
        <body>...</body>
    </html>
    ```
- 용도
    - HTTP 전송에 필요한 모든 부가정보
    - 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보...
    - 표준 헤더가 너무 많음
        - https://en.wikipedia.org/wiki/List_of_HTTP_header_fields
    - 필요시 임의의 헤더 추가 가능
        - helloworld: hihi

- 분류 - RFC2616(과거) 
    - HTTP 헤더
    <img width="681" alt="스크린샷 2021-08-18 오전 12 33 19" src="https://user-images.githubusercontent.com/57219160/129756430-aa7b940f-e3f3-4119-8048-cb30096b6030.png">
    
    - 헤더 분류(pdf 234)
        - General 헤더 : 메시시 전체에 적용되는 정보. ex) Connection: close
        - Request 헤더 : 요청 정보, 예) User-Agent: Mozila/5.0 (Machintosh; ...)
        - Response 헤더 : 응답 정보, 예) Server: Apache
        - Entity 헤더 : 엔티티 바디 정보, 예) Content-Type: text/html, Content-Length:3423
        
    - HTTP 바디
    
        <img width="672" alt="스크린샷 2021-08-18 오전 12 38 13" src="https://user-images.githubusercontent.com/57219160/129756916-d9054aa6-e666-4154-9c25-f4c41462d3c3.png">
    
        - 메시지 본문(message body)은 엔티티 본문(entity body)을 전달하는데 사용
        - 엔티티 본문은 요청이나 응답에서 전달할 실제 데이터
        - `엔티티 헤더`는 `엔티티 본문`의 데이터를 해석할 수 있는 정보 제공
            - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등
    
- 그런데 스펙이 바뀐다.
    - HTTP표준이 1999년 RCF2616이 폐지가 됨
    - 2014년 RFC7230~7235 등장

- RFC723x 변화 
    - 엔티티(Entity) -> 표현(Representation) 으로 변경
    - Representation = representation Metadata + representation Data
    - 표현 = 표현 메타데이터 + 표현 데이터

- message body - RFC7230(최신)

    <img width="672" alt="스크린샷 2021-08-18 오전 12 38 13" src="https://user-images.githubusercontent.com/57219160/129756916-d9054aa6-e666-4154-9c25-f4c41462d3c3.png">
    
    - 메시지 본문(message body)을 통해 표현 데이터 전달
    - 메시지 본문 = 페이로드(payload)
    - `표현`은 요청이나 응답에서 전달할 실제 데이터 (표현 헤더 + 표현 데이터)
    - `표현 헤더는 표현 데이터`를 해석할 수 있는 정보 제공
        - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등
    - 참고: 표현 헤더는 표현 메타데이터와, 페이로드 메시지를 구분해야 하지만, 여기서는 생략

## 표현
- 만약 회원 리소스가 있다고 가정한다면, 회원 리소스를 HTML 리소스로 전송하든지(표현), JSON 형식으로 전송하든지(표현). 그래서 `표현`이라고 말함. 사실 리소스 자체는 추상적이다. DB에 있을수도 있고 바이트코드로 어딘가에 저장. 
- 클라이언트 서버간에 주고받을 때는 서로 이해할 수 있는 무엇인가로 변환(표현)해서 데이터를 전달해야 한다. DB 안의 바이너리 데이터를 그대로 전달할 수는 없으니.
- Content-Type: 표현 데이터의 형식
- Content-Encoding: 표현 데이터의 압축 방식
- Content-Language: 표현 데이터의 자연 언어
- Content-Length: 표현 데이터의 길이
- 표현 헤더는 전송, 응답 둘다 사용

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
    <body>...</body>
</html>
```

- Content-Type
    - 미디어 타입, 문자 인코딩
    - 컨텐트 바디에 들어가는 종류가 뭐니? 를 말해준 것
    - 예) 
        - text/html;charset=utf-8
        - application/json (기본이 utf-8)
        - image/png
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length: 3423

    <html>
        <body>...</body>
    </html>
    ```
    ```
    HTTP/1.1 200 OK
    Content-Type: application/json
    Content-Length: 16
    
    {
        "data":"hello"
    }
    ```
    

- Content-Encoding
    - 표현 데이터 인코딩
    - 표현 데이터를 압축하기 위해 사용
    - 데이터를 전달하는 곳에서 압축 후(바디 부분을) 인코딩 헤더 추가
    - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
    - 예)
        - gzip
        - defalte
        - identity(압축 안한다는 것)
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Encoding: gzip
    Content-Length: 521

    lasdhfsadhfkajshdfklsajhdflksajhdf
    asdkjfhaskldjfhdasdlfkjasl;dkfjlaskdv
    ```
    

- Content-Language
    - 표현 데이터의 자연 언어를 표현
    - 예)
        - ko
        - en
        - en-US
    ```
    HTTP.1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Language: ko
    Content-Length: 521

    <html>
    안녕하세요
    </html>
    ```
    ```
    HTTP.1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Language: en
    Content-Length: 521

    <html>
    hello
    </html>
    ```
    

- Content-Length
    - 표현 데이터의 길이
    - 바이트 단위
    - Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안됨
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length: 5

    hello
    ```
    


## 협상(컨텐츠 네고시에이션)
- Accept: 클라이언트가 선호하는 미디어(컨텐트) 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어
- 클라이언트가 선호하는 표현 요청을 서버에게 부탁하는 것(꼭 서버가 다 맞춰줄 순 없지만 클라이언트가 원하는 양식으로 최대한 맞춰줌)
- 협상 헤더는 `요청시에만 사용`
- 서버가 만약에 제공할 수 있는 컨텐트 타입이 JSON, xml 둘 다 가능한 상태. 만약 클라이언트A는 json을 선호, 클라이언트B는 xml을 선호. 클라이언트A, B는 각각 Accpet 속성에 원하는 데이터 타입 넣어서 보내면 된다. 물론 클라이언트A, B는 모두 사전에 서버가 둘을 다 제공하는지는 미리 알고 있어야 한다. 


- Accept-Languge 적용 전
    - 클라이언트는 한국어 브라우저를 사용중. 
        - 요청 메시지
        ```
        GET /event
        ```
    - 서버는 다중 언어 지원 서버
        1. 기본 영어(en)
        2. 한국어 지원(ko)
        - 응답 메시지
        ```
        Content-Language: en
        
        hello(영어)
        ```
    - 그래서 클라이언트는 한국어 브라우저를 사용중이지만 영어(hello)를 받게 된다. 즉 서버는 클라이언트의 입장, 선호 언어를 모르기 때문에.
- Accept-Language 적용 후
    - 클라이언트는 한국어 브라우저를 사용중. 그리고 선호 언어를 미리 말해줌
        - 요청 메시지
        ```
        GET /event
        Accept-Language: ko
        ```
    - 서버는 다중 언어 지원 서버
        1. 기본 영어(en)
        2. 한국어 지원(ko)
        - 응답 메시지
        ```
        Content-Language: ko
        
        안녕하세요
        ```
    - 그래서 클라이언트는 원하는 언어(ko)를 받게 된다.

- Accpet-Language 복잡한 예시
    - 클라이언트는 한국어 브라우저를 사용중. 그리고 선호 언어를 미리 말해줌
        - 요청 메시지
        ```
        GET /event
        Accept-Language: ko
        ```
    - 서버는 다중 언어 지원 서버(클라이언트가 원하는 언어인 ko는 없음)
        1. 기본 독일어(de)
        2. 영어도 지원(en)
        - 응답 메시지
        ```
        Content-Language: de
        
        Hallo (독일어)
        ```
    - 문제) 클라이언트 입장에서는 한국어(ko)를 원하지만 만약 없다면 영어(en)로 왔으면 좋겠다라는 입장. 독일어는 어려우니까... ㅠㅠ
        - 그래서 협상과 우선순위가 필요!

- 협상과 우선순위1
    ```
    GET /event
    Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
    ```
    - Quality Values(q) 값 사용
    - 0 ~ 1, `클수록 높은 우선순위`
    - 생략하면 1
    - Accept-Language: ko-KR;ko;q=0.9,en-US;q=0.8,en;q=0.7
        1. ko-KR;q=1 (q=1생략)
            - 한국사람이 쓰는 한국어
        2. ko;q=0.9
            - 공통 한국어
        3. en-US;q=0.8
            - US가 쓰는 영어
        4. en;q=0.7
- 그래서 위의 복잡한 예시에서 다시 보냄.
    - 클라이언트는 한국어 브라우저를 사용중. 그리고 선호 언어와 우선순위를 알려줌
        - 요청 메시지
        ```
        GET /event
        Accept-Language: ko-KR;ko;q=0.9,en-US;q=0.8,en;q=0.7
        ```
    - 서버는 다중 언어 지원 서버
        1. 기본 독일어(de)
        2. 영어도 지원(en)
        - 응답 메시지
        ```
        Content-Language: en
        
        Hello (영어)
        ```
    - 서버가 지원할 수 있는 언어 중에서 클라이언트가 선호하는 순위 안에서 정해서 내줌
    

- 협상과 우선순위2
    ```
    GET /event
    Accept: text/*, text/plain, text/plain;format=flowed, */*
    ```
    - Quality Values(q)
    - 구체적인 것이 우선한다.
    - Accept: text/*, text/plain, text/plain;format=flowed, */*
        1. text/plain;format=flowed
        2. text/plain
        3. text/*
        4. */*
        
        
- 협상과 우선순위3
    - 구체적인 것을 기준으로 미디어 타입을 맞춘다.
    ```
    Accept: text/*;q=0.3, text/html;q=0.7, text/html;level=1,
    text/html;level=2;q=0.4, */*;q=0.5
    ```
    |Media Type | Quality |
    |--|--|
    |text/html;level=1|1|
    |text/html|0.7|
    |text/plain|0.3|
    |text/jpeg|0.5|
    |text/html;level=2|0.4|
    |text/html;level=3|0.7|



## 전송 방식
- Transfer-Encoding
- Range, Content-Range
- 단순 전송
    - Content-Length
    - /event로 요청 메시지. 
    ```
    GET /event
    ```
    - 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length: 3423

    <html>
        <body>...</body>
    </html>
    ```
    - 한번에 요청해서 한번에 쭈욱 받는것. 컨텐츠 길이(3423)를 적어주는 것. 

- 압축 전송
    - Content-Encoding
    - /event로 요청 메시지. 
    ```
    GET /event
    ```
    - 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Encoding: gzip
    Content-Length: 521
    
    saldkjfal;skdjfqwkhsdjkhfsdlkf
    ```
    - 무엇으로 압축했는지 넣어줘야 한다. (Content-Encoding)
    - 용량이 굉장히 많이 줄어든다.
- 분할 전송
    - Transfer-Encoding
    - chukced 는 덩어리(쪼개서) 로 보낸다는 것.
    - /event로 요청 메시지. 
    ```
    GET /event
    ```
    - 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: text/plain
    Transfer-Encoding: chunked

    5
    Hello
    5
    World
    0
    \r\n
    ```
    - 먼저 Hello(5바이트)를 먼저 보내고, 다음 World(5바이트)를 보낸 후 끝나면 엔터(\r\n)
    - 그러면 클라이언트 입장에서는 먼저 World가 오기 전에 먼저 Hello를 받아 볼 수 있다.
    - 용량이 큰 것을 한번에 보내지 않고(기다려야 함) 이런식으로 분할해서 보내면 바로바로 확인할 수 있다.
    - 주의) 분할전송할 때는 Content-Lenght를 넣으면 안된다. 왜냐하면 예상이 안되고 각각의 용량(5바이트)을 (강의다시듣기) 필기..^^;
- 범위 전송
    - Range, Content-Range
    - /event로 요청 메시지. 
    ```
    GET /event
    Range: bytes=1001-2000
    ```
    - 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: text/plain
    Content-Range: bytes 1001-2000 / 2000

    alsdfh;asodhfkasjdhfklasjhdfkl
    ```
    - 사진 데이터를 중간정도 받다가 끊겼다면? 처음부터 다시 요청하면 용량이 아까우니까 덜 받은 부분의 범위를 지정해서 요청할 수 있다.

## 일반 정보
- From
    - 유저 에이전트의 이메일 정보
    - 일반적으로 잘 사용되지 않음
    - 검색 엔진 같은 곳에서, 주로 사용
        - 검색 엔진 담당자에게 내 사이트 방문하지 말아달라고 연락해야 할 때.
    - 요청에서 사용

- Referer
    - 이전 웹 페이지 주소
    - 엄청 자주 사용함
    - 현재 요청된 페이지의 이전 웹 페이지 주소
    - A -> B로 이동하는 경우 B를 요청할 때 Referer: A를 포함해서 요청
    - Referer를 사용해서 유입 경로 분석 가능
    - 요청에서 사용
    - 참고: referer는 단어 referrer의 오타

- User-Agent
    - User-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36
    - 클라이언트의 애플리케이션 정보(웹 브라우저 정보, 등등)
        - 클라이언트 애플리케이션을 유저 에이전트라고 한다.
    - 통계 정보
    - 어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능
        - 서버 입장에서 도움이 됨.
        - 특정 종류의 브라우저에서 계속 버그가 생기면 로그를 파싱해보면 알 수 있다.
    - 요청에서 사용

- Server
    - 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
        - ORIGIN 서버란?
            - 사실 HTTP 요청을 하면 중간에 수많은 프록시 서버(캐시 서버 등) 를 거친다. 그런 서버들을 다 거치고 제일 끝에 있는 실제로 HTTP 처리를 해주는 서버.
    - Server: Apache/2.2.22 (Debian)
    - sever: nginx
    - 응답에서 사용

- Date
    - 메시지가 발생한 날짜와 시간
    - Date: Tue, 15 Nov 1994 08:12:31 GMT
    - 응답에서 사용


## 특별한 정보
- Host
    ```
    GET /search?q=hello&hl=ko HTTP/1.1
    Host: www.google.com
    ```
    - 요청한 호스트 정보(도메인)
    - 요청에서 사용
    - `필수` 헤더임
    - 하나의 서버(IP)가 여러 도메인을 처리해야 할 때 구분해줌
    - 예시 상황(pdf 269)
        
        ![캡처](https://user-images.githubusercontent.com/57219160/129822487-14bb97ef-584f-4be6-bedd-b49c6ef87171.PNG)
        - 클라이언트(IP:100.100.100.1) 의 요청 메시지(만약 Host 헤더 필더가 없다면)
        ```
        GET /hello HTTP/1.1
        ```
        - 하나의 서버 안(IP: 200.200.200.2)에 여러 개의 애플리케이션이 다른 도메인(aaa.com, bbb.com, ccc.com)으로 구동이 되어 있는 경우
        - 클라이언트는 /hello가 서버 안의 3가지 도메인 중 어느 애플리케이션과 관련이 있는지 알지 못한다(aaa.com)과 관련이 있는 애플리케이션일 수도 있고 bbb.com, ccc.com 도 마찬가지). 구분할 방법이 없다.
        - 구분할 방법이 없다. 왜냐하면 IP로만 통신을 하기 때문에. IP(200.200.200.2)로만 TCP/IP 연결해서 요청 메시지를 보내는 것이므로. 
        - 그래서 Host 헤더를 무조건 넣어야 하는 스펙 개정이 이루어졌다.
        ```
        GET /hello HTTP/1.1
        Host: aaa.com
        ```
        - TCP/IP는 아이피로만 통신을 하는데 다행히 서버는 메시지를 받자마자 Host를 확인해서 aaa.com 으로 가상호스팅을 해준다. 서버 안에서 다 설정을 해둘 수 있다. 

- Location
    - 페이지 리다이렉션
    - 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉트)
    - 응답코드 3xx 에서 설명
    - 201 (Created): Location 값은 요청에 의해 생성된 리소스 URI을 의미
        - 201의 값에도 사용할 수 있음.
    - 3xx (Redirection): Location 값은 요청을 자동으로 리디렉션하기 위한 대상 리소스를 가리킴.

- Allow
    - 허용 가능한 HTTP 메서드
    - 405 (Method Not Allowed)에서 응답에 포함해야 함
    - Allow: GET, HEAD, PUT
        - 그러면 클라이언트는 POST는 지원안하는 메서드구나 ~ 라고 알 수 있음.
    - 서버에 많이 구현되어 있진 않아서 많이 안 쓴다.

- Retry-After
    - 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
    - 503 (Service Unavilable): 서비스가 언제까지 불능인지 알려줄 수 있음
    - Retry-After: Fri, 31 Dec 1999 23:59:59 GMT (날짜 표기)
        - 다시 서비스가 시작할 수 있는 시간
    - Retyr-After: 120 (초단위 표기)
        - 몇 초 뒤에 가능
    - 날짜로도 표기할 수 있고, 초단위로도 가능

## 인증
- Authorization: 클라이언트 인증 정보를 서버에 전달
    - 인증하는 여러 메커니즘이 엄청 많다. 그런 것들마다 value에 들어가는 값은 다 다르다. ex) AUTH인증, ~인증 등
    - HTTP 에서는 어떤 인증 종류가 들어오든 간에 일단 인증 헤더를 제공하는 것임.
    ```
    Authorization: Basic xxxxxxxxxxxx
    ```
- WWW-Authenticate: 리소스 접근시 필요한 인증 방법 정의
    - 401 Unauthorized 응답과 함께 사용
    ```
    WWW-Authenticate: Newauth realm="apps", type=1, 
    title="Login to \"apps\"", Basic realm="simple"
    ```
    - 위의 값에 해당하는 부분을 참고해서 제대로 된 인증정보를 만들어라~ 하는 뜻
    - 서버에서 클라이언트로 반환


## 쿠키
- `Set-Cookie`: 서버에서 클라이언트로 쿠키 전달(응답)
- `Cookie`: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달

- 쿠키 미사용시
    - 처음 welcome 페이지 접근
        - 웹 브라우저에서 요청
        ```
        GET /welcome HTTP/1.1
        ```
        - 서버에서 응답 메시지
        ```
        HTTP/1.1 200 OK

        안녕하세요. 손님 
        ```
    - 로그인
        - 웹 브라우저에서 요청
        ```
        POST /login HTTP/1.1
        user=홍길동
        ```
        - 서버에서 응답 메시지
        ```
        HTTP/1.1 200 OK

        홍길동님이 로그인했습니다. 
        ```
    - 로그인 후
        - 웹 브라우저에서 요청
        ```
        GET /welcome HTTP/1.1
        ```
        - 서버에서 응답 메시지
        ```
        HTTP/1.1 200 OK

        안녕하세요. 손님 
        ```
        - 로그인 후 내가 기대한 것은 '안녕하세요, 홍길동님' 인데 '안녕하세요, 손님' 이라고 뜬다.
    - 왜 그럴까?
        - 서버입장에서는 /welcome 요청만 받았기에, 로그인한 사용자인지 아닌지 서버입장에서는 구분할 수가 없다. (HTTP통신은 전송만 되고 나면 연결을 다 끊어버리므로)
        - 서버가 Stateless이므로
            - HTTP는 무상태(Stateless) 프로토콜이다.
            - 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다.
            - 클라이언트가 다시 요청하면 서버는 이전 요청을 기억하지 못한다.
            - 클라이언트와 서버는 서로 상태를 유지하지 않는다.
    - 대안은 모든 요청에 사용자 정보를 포함시키는 것이다.
        - 웹 브라우저에서 요청
        ```
        GET /welcome?user=홍길동 HTTP/1.1
        ```
        - 서버에서 응답 메시지
        ```
        HTTP/1.1 200 OK

        안녕하세요. 홍길동님
        ```
        - 그런데 이 대안은 또 문제가 있다. 과연 모든 요청과 링크에 매번 사용자 정보를 포함시킬 것인가? 보안문제도 있고..
        ```
        GET /welcome?user=홍길동 HTTP/1.1
        ```
        ```
        GET /board?user=홍길동 HTTP/1.1
        ```
        ```
        GET /order?user=홍길동 HTTP/1.1
        ```
        ```
        GET /xxx...?user=홍길동 HTTP/1.1
        ```
    - 이렇게 모든 요청에 정보를 넘기는 문제가 생긴다. 매번!!..
        - 모든 요청에 사용자 정보가 포함되도록 개발해야한다.
        - 그리고 또 문제는.. 만약 브라우저를 완전히 종료하고 다시 연다면? 
            - 물론 이것은 요즘에 웹 스토리지라는 곳에 저장을 하면 되긴 한다.
- 쿠키 도입!! (pdf 285그림 참조)
    - 로그인 시
        - 웹 브라우저에 요청메시지
        ```
        POST /login HTTP/1.1
        user=홍길동
        ```
        - 서버 응답 메시지(`이 내용을 쿠키!!!로 감싸서 저장`)
            - `Set-Cookie` 로 `user=홍길동` 을 쿠키로 감싼다.
        ```
        HTTP/1.1 200 OK
        Set-Cookie: user=홍길동

        홍길동님이 입장했습니다.
        ```
        - 클라이언트는 쿠키 저장소에 저장한다. (`웹 브라우저 내부에는 쿠키 저장소가 있다`)
        ```
        user=홍길동
        ```
    - 로그인 이후 welcome페이지 접근
        - 웹 브라우저에 요청 메시지
            - `웹 브라우저는 자동으로 서버에 요청할 때마다 무조건 쿠키 저장소를 조회한다.`
            - 쿠키 저장소에서 조회한 후 `user=홍길동` 을 들고옴
            - 그러면 매번 지저분하게 URL에 정보를 넣거나 하지 않아도 된다.
        ```
        GET /welcome HTTP/1.1
        Cookie: user=홍길동
        ```
        - 서버에서 응답 메시지
            - `홍길동님`을 표시할 수 있다.
        ```
        HTTP/1.1 200 OK

        안녕하세요 홍길동님
        ```
    - 모든 요청에 쿠키 정보 자동 포함
        - 웹 브라우저는 어떤 url이든간에 지정한 서버에 대해서는 쿠키의 데이터를 자동으로 다 추출해서 보내준다.
        ```
        GET /welcome HTTP/1.1
        Cookie: user=홍길동
        ```
        ```
        GET /board HTTP/1.1
        Cookie: user=홍길동
        ```
        ```
        GET /order HTTP/1.1
        Cookie: user=홍길동
        ```
        ```
        GET /xxx... HTTP/1.1
        Cookie: user=홍길동
        ```
- 서버에서 쿠키 세팅할 때 
    - 예) set-cookie: `sessionId=abcde1234`; `expires`=Sat, 26-Dec-2020 00:00:00 GMT; `path`=/; `domain`=.google.com; `Secure`
        - expires : 쿠키 만료 시간
        - path, domain : 허용되는 경로들, 도메인
        - Secure : 쿠키의 보안정보 담기는 곳
- 쿠키의 주 사용처
    - 사용자 로그인 세션 관리
        - 사실 홍길동이라는 정보를 그대로 내보내는 건 보안상 위험. 로그인이 성공되면 서버에서 세션값를 만들어서 DB에 저장 후, 클라이언트에(쿠키에) 세션값을 반환해줌. 그러면 클라이언트는 매번 서버에 요청할 때마다 그 세션값을 보낸다. 그러면 서버는 그 세션값을 받으면 DB에 있는 세션값과 비교해서 '아~홍길동이구나'라고 판단.
    - 광고 정보 트래킹
        - 웹 브라우저를 사용하는 사람이 어떤 광고를 보는지.
- 쿠키 정보는 항상 서버에 전송됨(세팅이 되면 무조건 다 전송이 됨)
    - 네트워크 트래픽 추가 유발
        - 아무래도 몇 가지 정보가 더 넘어가니깐.
    - 그래서 최소한의 정보만 사용(세션 id, 인증 토큰)해야 한다.
    - 서버에 전송하지 않고, 클라이언트 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지 (localStorage, sessionStorage) 참고(클라이언트 자바스크립트 로직에서만 사용)
- 주의!
    보안에 민감한 데이터는 저장하면 안됨(주민번호, 신용카드 번호 등등), 쿠키든 웹 스토리지든.

- 쿠키 - 생명주기(Expires, max-age)
    - Set-Cookie: `expires`=Sat, 26-Dec-2020 04:39:21 GMT
        - 만료일이 되면 쿠키 삭제
        - GMT 기준으로 넣어야 한다.
    - Set-Cookie: `max-age`=3600 (3600초)
        - 0이나 음수를 지정하면 쿠키 삭제
        - ex) 3600초가 지나면 쿠키가 삭제 
    - 세션 쿠키: 만료 날짜를 생략하면 브라우저 종료시까지만 유지
    - 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지
    
- 쿠키 - 도메인(domain)
    - 내가 들어가는 아무 사이트마다 쿠키가 생기면 안되니까.
    - 예) domain=example.org
    - 명시: 명시한 문서 기준 도메인 + 서브 도메인 포함
        - domain=example.org를 지정해서 쿠키 생성
            - example.org는 물론이고
            - dev.example.org도 쿠키접근
    - 생략: 현재 문서 기준 도메인만 적용
        - example.org에서 쿠키를 생성하고 domain 지정을 생략
            - example.org는 물론이고
            - dev.example.org도 쿠키접근
     
- 쿠키 - 경로(Path)
    - 예) path=/home
    - 이 경로를 포함한 하위 경로 페이지만 쿠키 접근
    - 일반적으로 path=/ 루트로 지정 
        - 왜냐하면 한 도메인 안에서 쿠키를 다 전송하기를 원하기 떄문
    - 예)
        - path=/home 지정한다면?
            - /home -> 가능
            - /home/level1 -> 가능
            - /home/level1/level2 -> 가능
            - /hello -> 불가능

- 쿠키 - 보안(Secure, HttpOnly, SameSite)
    - Secure
        - 쿠키는 http, https를 구분하지 않고 전송
        - Secure를 적용하면 https인 경우에만 전송
    - HttpOnly
        - XSS 공격 방지
        - 자바스크립트에서 접근 불가(document.cookie)
            - 원래는 자바스크립트에서 쿠키에 접근 가능
        - HTTP 전송에만 사용
    - SameSite
        - XSRF 공격 방지
        - (내가 요청하는) 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송
            - 원래는 달라도 전송 가능

# HTTP 헤더2 - 캐시와 조건부 요청
## 캐시 기본 동작
- 캐시가 없을 때(pdf 295)
    - 첫 번째 요청(웹브라우저가)
    ```
    GET /star.jpg
    ```
    - 서버 응답 메시지
    ```
    HTTP/1.1 200 OK
    Content-Type: image/jpeg
    Content-Length: 34012

    jhfajfkdkdlajskdf;klajsdf;lkajsd;flkjasdf   // 실제 바이트 코드들
    safkdlsafkdljskdjskdafjkdjskdfjskdaflakjsfd 
    ```
    - 이렇게 star.jpg를 보내줄 때 용량이 총 1.1M라 가정한다면
        - HTTP 헤더: 0.1M 으로 가정
        - HTTP 바디: 1.0M 으로 가정
    - 두 번째 요청
        - 또 똑같이 1.1M 전송을 하게 된다. 2번째.

    - 이렇게 캐시가 없다면?
        - 데이터가 변경되지 않아도 계속 네트워크를 통해서 데이터를 다운로드 받아야 한다.
        - 인터넷 네트워크는 매우 느리고 비싸다.(pc의 메모리, 하드디스크에 비해)
        - 브라우저 로딩 속도가 느리다.
        - 느린 사용자 경험
        
- 캐시 적용했을 때(pdf 300)
    - 첫 번째 요청(웹브라우저가)
    ```
    GET /star.jpg
    ```
    - 서버 응답 메시지(서버에서 )
    ```
    HTTP/1.1 200 OK
    Content-Type: image/jpeg
    cache-control: max-age=60  // 캐시가 유효한 시간(초)
    Content-Length: 34012

    jhfajfkdkdlajskdf;klajsdf;lkajsd;flkjasdf   
    safkdlsafkdljskdjskdafjkdjskdfjskdaflakjsfd 
    ```
    - 웹 브라우저에는 내부에 캐시를 저장하는 `브라우저 캐시`가 존재.
        - 응답 결과를 이 브라우저 캐시에 저장한다. (60초 동안 유효)

    - 두 번째 요청
        - 우선 브라우저 캐시에서 검색한다.
        - 만약 아직 60초 제한시간 이내라면 캐시에서 바로 조회에서 star.jpg를 들고온다.
        - 즉, 네트워크를 톨할 필요가 없다는 것
    - 이렇게 캐시 적용한다면 장점은?
        - 캐시 덕분에 캐시 가능 시간동안 네트워크를 사용하지 않아도 된다.
        - 비싼 네트워크 사용량을 줄일 수 있다.
        - 브라우저 로딩 속도가 매우 빠르다.(한번 들어간 적이 있는 곳은 상대적으로 더 빠르다)
        - 빠른 사용자 경험
    - 세 번째 요청 - 캐시 시간 초과
        - 브라우저 캐시를 검색했는데 캐시 유효 시간 검증을 통해 시간(60초)가 지났다면?
        - 당연히 다시 서버에 요청해야 함. 그러면 같은 HTTP 메시지(1.1M)가 온다.
        - 그리고 응답 결과를 다시 캐시에 저장한다. 60초간.
    - 캐시 시간이 초과?
        - 캐시 유효 시간이 초과하면, 서버를 통해 데이터를 다시 조회하고, 캐시를 갱신한다. (초과 시간은 서버에서 꺼낸 정보의 신선한 정도라고 생각하면 될 듯)
        - 이 때 다시 네트워크 다운로드가 발생한다.

## 검증 헤더와 조건부 요청1
- 캐시 시간 초과
    - 캐시 유효 시간이 초과해서 서버에 다시 요청하면 다음 두 가지 상황이 나타난다.
        1. 서버에서 기존 데이터를 변경함. 
            - 기존별 -> 바뀐별
        2. 서버에서 기존 데이터를 변경하지 않음.
            - 기존별 그대로.
    - 캐시 만료후에도 서버에서 데이터를 변경하지 않을 경우!
    - 생각해보면 데이터를 전송하는 대신에 저장해 두었던 로컬 캐시를 재사용 할 수 있다.
    - 단 클라이언트의 데이터와 서버의 데이터가 같다는 사실을 확인할 수 있는 방법 필요
    - 그래서 검증 헤더가 생겼다.
    
- 검증 헤더 추가
    - 첫 번째 요청
    ```
    GET /star.jpg
    ```
    - 응답 메시지
        - `Last-Modified:2020년 11월 10일 10:00:00 추가`. `검증헤더` 추가.
        ```
        HTTP/1.1 200 OK
        Content-Type: image/jpeg
        cache-control: max-age=60
        Last-Modified: 2020년 11월 10일 10:00:00  // 데이터가 마지막에 수정된 시간. 실제로는 UTC표기법으로 적어야 함
        Content-Length: 34012

        jfkdskdjljdljskdafljskadflkjas;dfkljaskdlfjasdf
        sajfkdajkd;ajkd;jskdaf;askdjf;jskdaf;jskad;fkja
        ```
        - 즉 데이터 최종 수정일 : `2020년 11월 10일 10:00:00` 인 것.
    - 그러면 브라우저 캐시에는 캐시, 유효시간뿐 아니라 `데이터 최종 수정일`도 기억해둔다
        - star.jpg
        - 유효시간
        - 데이터 최종 수정일
    - 두 번째 요청
        - 캐시 시간 초과
        - 요청시 브라우저 캐시를 먼저 찾았는데 시간이 초과된 상태.
        - 그런데, 캐시에 Last-Modified 값이 존재한다면, 데이터 최종 수정일을 요청메시지에 넣어서 보냄(`조건부 요청임`)
        ```
        GET /star.jpg
        if-modified-since: 2020년 11월 10일 10:00:00 // 캐시가 가지고 있는, 데이터 최종 수정일. 
        ```
    - 서버에서 확인 함
        - 서버가 가지고 있는 데이터 최종 수정일과 요청메시지에 있는 최종 수정일을 비교
    - 서버에서 응답 메시지
        - `HTTP Body가 없음.`
        - 304 Not Modified 메시지(보낸 요청에 대해서 변한 내용이 없다는 것)
        ```
        HTTP/1.1 304 Not Modified
        Content-Type: image/jpeg
        cache-control: max-age=60
        Last-Modified: 2020년 11월 10일 10:00:00  
        Content-Length: 34012

        ```
        - 0.1M용량만 보냄 : 총 1.1M의 용량중에서 HTTP Body에 해당하는 1.0M 용량을 안 보내도 되니까 HTTP 헤더부분인 0.1M 만 보낸다. -> `네트워크 부하 줄어듬`
    - 브라우저 캐시에서 캐시 재세팅(정보들 다시 최신화)
        - 60초 유효시간 다시 초기화
        - 데이터 최종 수정일 최신화
        - 응답 결과를 재사용, 헤더 데이터 갱신
    - 브라우저 캐시에서 데이터 불러와서 사용

- 검증 헤더와 조건부 요청 정리
    - 캐시 유효 시간이 초과해도, 서버의 데이터가 갱신되지 않으면
    - 304 Not Modified + 헤더 메타 정보만 응답(바디X)
    - 클라이언트는 서버가 보낸 응답 헤더 정보로 캐시의 메타 정보를 갱신
    - 클라이언트는 캐시에 저장되어 있는 데이터 재활용
    - 결과적으로 네트워크 다운로드가 발생하지만 용량이 적은 헤더 정보만 다운로드
    - 매우 실용적인 해결책
    - 웹 브라우저는 이 메커니즘을 대부분 실행하고 있다.


## 검증 헤더와 조건부 요청2
- 검증 헤더
    - 캐시 데이터와 서버 데이터가 같은지 검증하는 데이터
    - Last-Modified, ETag
- 조건부 요청 헤더
    - 클라이언트가 서버에 요청할 때 Last-Modified, ETag를 활용해서 조건부 요청 헤더를 만드는 것
    - 검증 헤더로 조건에 따른 분기
    - If-Modified-Since: Last-Modified 와 같이 사용
    - If-None-Match: ETag 와 같이 사용
    - 조건이 만족하면 200 OK
    - 조건이 만족하지 않으면 304 Not Modified

- If-Modified-Sicne: 이후에 데이터가 수정되었으면?
    - 데이터 미변경 예시
        - 캐시: 2020년 11월 10일 10:00:00 vs 서버:2020년 11월 10일 10:00:00
        - `304 Not Modified`, 헤더 데이터만 전송(BODY 미포함)
            - 304 Redirection - 너의 캐시로 Redirection 해서 그 데이터를 그대로 뿌려라~ 라는 말
        - 전송 용량 0.1M (헤더 0.1M, 바디 1.0)
    - 데이터 변경 예시
        - 캐시: 2020년 11월 10일 10:00:00 vs 서버: 2020년 11월 10일 `11`:00:00 (수정됨)
        - `200 OK`, 모든 데이터 전송(BODY 포함)
        - 전송 용량 1.1M (헤더 0.1M, 바디 1.0M)
    

- Last-Modified, If-Modified-Since 단점
    - 1초 미만(0.x초) 단위로 캐시 조정이 불가능. 최소가 초단위
    - 날짜 기반의 로직 사용 
    - 데이터를 수정해서 날짜가 다르지만, 같은 데이터를 수정해서 데이터 결과가 똑같은 경우
        - 데이터 : A -> B -> A 로 다시 수정. => 이런 경우에도 데이터를 다 다운 받을 것임(날짜가 다르니깐)
    - 서버에서 별도의 캐시 로직을 관리하고 싶은 경우 => ETag
        - 예) 스페이스나 주석처럼 크게 영향이 없는 변경에서 캐시를 유지하고 싶은 경우

- ETag, If-None-Match
    - ETag(Entity Tag)
    - 캐시용 데이터에 임의의 고유한 버전 이름을 달아둠(날짜가 아니라)
        - 예) ETag: "v1.0", ETag: "a2jiodwjekjl3"
        - 해시는 파일(컨텐츠)이 동일하면 동일한 해시결과 나옴. 
    - 데이터가 변경되면 이 이름을 바꾸어서 변경함(Hash를 다시 생성)
        - 예) ETag: "aaaaa" -> ETag: "bbbbb"
    - 진짜 단순하게 ETag만 보내서 같으면 유지, 다르면 다시 받기!

    - 첫 번째 요청
    ```
    GET /star.jpg
    ```
    - 응답 메시지
        - 1.1M 전체 전송
    ```
    HTTP/1.1 200 OK
    Content-Type: image/jpeg
    cache-control: max-age=60
    ETag: "aaaaaaaaaa"
    Content-Length: 3402

    jfkk;asjfkdkda;kljasdfkljsdakfhsadkjhfasdk
    ;ishdv;klashdv;klhsdkjvhjskdavhklajsdhvklj
    ```
    - 웹 브라우저는 브라우저 캐시에 ETag저장
        - 60초 유효값
        - Etag "aaaaaaaaaa" 저장
    - 두번째 요청
        ```
        GET /star.jpg
        If-None-Match: "aaaaaaaaaa" // 캐시가 가지고 있는 ETag
        ```
        - 시간 초과된 상태
        - 브라우저 캐시에 들려보니 시간이 초과된 것을 알게 됨
        - ETag "aaaaaaaaaa" 를 요청메시지에 넣어서 보냄
    - 서버는 갖고 있는 ETag의 값과 방금 보내온 ETag의 값을 비교. 
    - 응답 메시지
        - 두 값이 같으면 데이터가 아직 수정되지 않았다는 말 -> 304 
        - HTTP 바디 없음. 그래서 0.1M만 전송
        ```
        HTTP/1.1 304 Not Modified
        Content-Type: image/jpeg
        cache-control: max-age=60
        ETag: "aaaaaaaaaa"
        Content-Length: 34012

        ```
    - HTTP 응답을 받고 난 후, 브라우저 캐시 재세팅(응답결과를 재사용)
        - 60초 유효 
        - ETag "aaaaaaaaaa" 갱신
        
    - 브라우저가 브라우저 캐시를 찾아서 (60초 유효하니 가능-다시 갱신됐으니) 캐시에서 조회(star.jpg).

- ETag, If-None-Match 정리
    - 진짜 단순하게 ETag만 서버에 보내서 같으면 유지, 다르면 다시 받기!
    - `캐시 제어 로직을 서버에서 완전히 관리`
    - 클라이언트는 단순히 이 값을 서버에 제공(클라이언트는 캐시 메커니즘을 모름)
    - 예)
        - 서버는 배타 오픈 기간인 3일 동안 파일이 변경되어도 ETag를 동일하게 유지(실제로 직접 이렇게는 안한다)
        - 애플리케이션 배포 주기에 맞추어 ETag 모두 갱신

## 캐시와 조건부 요청 헤더
1. 캐시 제어 헤더
    - Cache-Control: 캐시 제어
    - Pragma: 캐시 제어(하위 호환)
    - Expires: 캐시 유효 기간(하위 호환)


- Cache-Control - 캐시 지시어(directives)
    - Cache-Control: max-age
        - 캐시 유효 시간, 초 단위
    - Cachce-Control: no-cache
        - 데이터는 캐시해도 되지만, 항상 원(origin) 서버에 검증하고 사용
            - 중간 캐시 서버말고 원 서버
    - Cache-Control: no-store
        - 데이터에 민감한 정보가 있으므로 저장하면 안됨 (메모리에서 사용하고 최대한 빨리 삭제)
- Pragme - 캐시 제어(하위 호환)
    - Pragma: no-cache
    - HTTP 1.0 하위 호환
- Expires - 캐시 만료일 지정(하위 호환)
    - expires: Mon, 01 jan 1990 00:00:00 GMT
    - 캐시 만료일을 정확한 날짜로 지정
    - HTTP 1.0부터 사용
    - 지금은 더 유연한 Cache-Control: max-age 권장(더 유연)
    - Cache-Control: max-age와 함께 사용하면 Expires는 무시됨

2. 검증 헤더와 조건부 요청 헤더
- 검증 헤더 (Validator)
    - ETag: "v1.0", ETag: "asdlkjsdaf"
    - Last-Modified: Thu, 04 Jun 2020 07:19:24 GMT
- 조건부 요청 헤더
    - If-Match, If-None-Match: ETag 값 사용
    - If-Modified-Since, If-Unmodified-Since: Last-Modified 값 사용


## 프록시 캐시
- 원 서버 직접 접근(pdf 344)
    - origin 서버 (원 소스가 있는 곳 = 원 서버)

- 한국에서의 클라이언트들(웹 브라우저1, 2, 3)이 미국에 있는 원 서버에 접근 하려면 각각 다`500ms (0.5초)`.
- 그런데 중간에 한국어딘가에 프록시 캐시 서버를 두면 한국의 클라이언트들은 이 서버에 접속하는 것은 `100ms(0.1초)`밖에 걸리지 않는다. 

- 한국의 클라이언트 서버들의 캐시를 `private 캐시(로컬)`, 프록시 서버에 있는 캐시를 `public 캐시(공용)`라고 한다.

- CDN서비스라고 해서 요새 많이 하고 있다. 특히 글로벌 서비스들.
    - AWS 등
    - 사람들    잘 안 보는 외국 Youtube 보면 다운로드가 좀 느리다. 그런데 사람들이 많이 보는 것들 보면 로딩 속도가 엄청 빠르다. 그것들은 모두 다 한국 어딘가에 있는 서버에서 다운 받는 것이다.

- 최초에 요청하는 첫번째 유저한테는 없어서 느리다. 그런데 한 번 다운을 받아두면 두번째 유저부터는 빨리 조회할 수 있다. 아니면 프록시 캐시에다가 데이터를 애초부터 밀어넣는 경우도 있다.



- Cache-Control (캐시 지시어(directives) - 기타)
    - Cache-Control: public
        - 응답이 public 캐시에 저장되어도 된다
    - Cache-Control: private
        - 응답이 해당 사용자만을 위한 것임, private 캐시에 저장해야 함(기본값)
        - 프록시 서버에 저장되면 안됨(사용자 정보 등)
    - Cache-Control: s-maxage
        - 프록시 캐시에만 적용되는 max-age
    - Age: 60 (HTTP 헤더)
        - 오리진 서버에서 응답 후 프록시 캐시 내에 머문 시간(초)

## 캐시 무효화
- Cache-Control(확실한 캐시 무효화 응답)
    - 캐시를 적용안하면 캐시가 적용안하는 것이 아니다. 적용 안해도 웹 브라우저들이 GET요청인 경우에는 임의로 해버리기도 한다. 
    - 그런데 확실하게 캐시가 적용 안되어야 하는 순간이 있다.
        - ex) 통장 잔고 등

- 확실하게 캐시를 무효화하게 하려면?
    - Cache-Control: no-cache, no-store, must-revalidate 다 넣기
    - Pragma: no-cache 넣기
        - HTTP 1.0 하위 호환
    - 이렇게 4가지를 넣으면 무효화 가능

- 캐시 지시어(directives) 하나씩 설명 - 확실한 캐시 무효화
    - Cache-Control: no-cache
        - 데이터는 캐시해도 되지만, 항상 `원 서버에 검증`하고 사용(이름에 주의!)
    - Cache-Control: no-store
        - 데이터에 민감한 정보가 있으므로 저장하면 안됨 (메모리에서 사용하고 최대한 빨리 삭제)
    - Cache-Control: must-revalidate
        - 캐시 만료후 최초 조회시 `원 서버에 검증`해야함
        - 원 서버 접근 실패시 반드시 오류가 발생해야함 - 504(Gateway Timeout)
        - must-revalidate는 캐시 유효 시간이라면 캐시를 사용함
    - Pragma: no-cache
        -  HTTP 1.0 하위 호환
    

- no-cache vs must-revalidate (pdf 351 꼭 참조)
    - 프록시 캐시 서버 - 원 서버가 연결되어 있을 경우
        - no-cache
            1. 캐시 서버 요청 (no-cache + ETag)
            2. 원 서버 요청(no-cache + ETag)
            3. 원 서버 검증
            4. 응답(304 Not Modified), 원서버 -> 프록시 캐시서버 
            5. 응답(304 Not Modified), 프록시 캐시서버 -> 웹 브라우저
            6. 웹 브라우저는 브라우저 캐시 검색 후(no-cache, ETag: "aaa") 캐시 데이터 사용해서 활용

    - 프록시 캐시 서버 - 원 서버가 연결X - 순간 네트워크 단절, 원 서버 접근 불가
        - no-cache
            1. 캐시 서버 요청 (no-cache + ETag)
            2. 원 서버에 접근할 수 없는 경우,  캐시 서버 설정에 따라서 캐시 데이터를 반환할 수 있음(Error or 200 OK - 오류보다는 오래된 데이터라도 보여주자)
            3. 응답(200 OK), 응답(304 Not Modified), 프록시 캐시서버 -> 웹 브라우저.
            - 즉 프록시 캐시가 응답해줌
        - must-validate
            1. 캐시 서버 요청 (no-cache + ETag)
            2. 원 서버에 접근할 수 없는 경우, `항상 오류`가 발생해야함. (`504 Gateway Timeout`, 매우 중요한 돈과 관련된 결과로 생각해보자)
            3. 응답(504 Gateway Timeout)

    

----

- 추가로 필요한 내용들은 지금까지 학습한 것들을 기반으로 필요시 검색을 통한 습득
(단, 정확하지 않은 자료가 많으므로, 항상 의심)

- HTTP에 대해서 더 깊이있게 학습하려면? (너무 많아서..부분적으로 찾아보기)
    1. HTTP 스펙
        - RFC 2616 : https://tools.ietf.org/html/rfc2616 -> 주의 이것을 보면 안됨
        - RFC 7230~7235 : https://tools.ietf.org/html/rfc7230 -> 이걸로 모두 개정(2014년 개정)
    2. HTTP 완벽가이드 책
        - 정석급으로 정리가 잘되어 있음
        - RFC 2616 기준이라는 점 감안하더라도 잘되어 있음

- 백엔드 개발자
    - 백엔드 개발자는 스프링(Spring) 웹 MVC, JSP, PHP, ASP.net, Node.js, 파이썬 장고, 루비 온 레일즈와 같은 웹 프레임워크나 기술들을 사용하는데, 이러한 웹 기술들은 모두 HTTP를 기반으로 구현.
- 처음 웹 기술을 공부하는 개발자
    - HTTP 기본 이해를 통해 웹 프레임워크가 제공하는 기술을 깊이있게 이해 가능
- 실무에서 웹 기술을 사용하는 개발자
    - API URI 설계, 메서드 선택 등등 HTTP와 관련된 설계시 명확한 기준에서 선택

