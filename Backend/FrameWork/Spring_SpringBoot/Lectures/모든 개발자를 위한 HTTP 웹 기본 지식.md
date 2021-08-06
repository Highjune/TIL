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
- IP 프로토콜의 한계
    - 비연결성
        - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
    - 비신뢰성
        - 중간에 패킷이 사라지면?
        - 패킷이 순서대로 안오면?
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
    - 네트워크 인터페이스 계층(랜 카드 등)


- HTTP를 TCP가 감싸고 있고 그 위를 다시 IP가 감싸고 있고 마지막으로 Ethernet frame이 감싸고 있다고 생각하면 된다. (pdf 참조)
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
- rfc 표준 찾아보기
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
        - ex) 그냥 `Jun`을 찾으면 됨
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
            - `foo`
        - authority
            - `example.com:8042`
        - /over/there
            - `path`


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
    - https://www.google.com:`443`/search?q=hello&hl=ko
    - 포트(PORT)
    - 접속 포트
    - 일반적으로 생략. 생략시 http는 80, https는 443

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
   - 클라이언트 서버 구조
   - 무상태 프로토콜(스테이스리스), 비연결성
   - HTTP 메시지
   - 단순함, 확장 가능

## 클라이언트 서버 구조
- Request Response 구조
- 클라이언트는 서버에 요청(HTTP 메시지를 통해서) 을 보내고, 응답을 대기
- 서버가 요청에 대한 결과(HTTP 메시지를 통해서) 를 만들어서 응답

- 이렇게 클라이언트-서버 2가지로 분리하는 것이 엄청 중요하다.
    - 양쪽이 독립적으로 개발을 진행할 수 있음.


## Stateful, Stateless
- pdf참고하기

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
    - TCP/IP는 기본적으로 연결(서버에 요청 후 응답을 받음)을 유지한다.
    - 그래서 클라이언트1이 하나의 서버에 연결 후, 클라이언트2, 3이 계속 요청을 하면 클라이언트 1, 2는 계속 연결이 되어 있는 상태다.
    - 그래서 서버는 연결을 계속 유지하고 서버 자원을 소모한다.
- 연결을 유지하지 않는 모델
    - 각각의 클라이언트가 서버에 요청 후 응답을 받으면 그 즉시 TCP/IP 연결을 끊어버린다.
    - 서버는 연결유지X, 최소한의 자원 유지
- 비 연결성
    - HTTP는 기본이 연결을 유지하지 않는 모델
    - 일반적으로 초 단위의 이하의 빠른 속도로 응답
    - 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
        - 예) 웹 브라우저에서 계속 연속해서 검색 버튼을 누르지는 않는다.
    - 서버 자원을 매우 효율적으로 사용할 수 있음

- 비 연결성, 한계와 극복
    - 단점
        - TCP/IP 연결을 새로 맺어야 함 - 3 way handshake 시간 추가(검색해서 무엇을 보다가 다른 것을 클릭해서 들어갈 때 TCP/IP를 새로 맺어야 함)
        - 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수 많은 자원이 함께 다운로드
        - 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
            - 기본적으로 HTTP는 지속 연결을 쓴다. 예전의 keep-alive
        - HTTP/2, HTTP/3에서 더 많은 최적화
    - 
