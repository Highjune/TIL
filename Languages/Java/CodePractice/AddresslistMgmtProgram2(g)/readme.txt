https://youtu.be/Mnq-kMId1ME 과제에 대한 설명(그림으로)
https://youtu.be/7fj06IoX9sc  ~5:00까지 과제에 대한 상세설명. 5:00~7:00 udp 방법 다시 정리. 7:00부터는 코딩시작
https://youtu.be/F-u3peB5I7A 
https://youtu.be/gPg4euPSqak
https://youtu.be/uOXTmnVxHAQ   32:50부터 프로그램 전체 그림 설명1 (중요**) 
https://youtu.be/Dox9j9mRx9I  (이어서) ~~3:50까지 프로그램 전체 그림 설명2, 16:55분에 server기준 설명.
https://youtu.be/wLbpyeIpVZU 
https://youtu.be/i2xNTkfUaYQ 프로그램 실행

cf) 이렇게 파일에 저장하지 않고 DB에 저장하면 사실 훨씬 편하다. 파일에 저장하려고 하니 이렇게 더 까다로운 작업이 필요.




가동은 cmd창에서 서버먼저 실행.


<주소록관리프로그램2> - 파일전송
client에서 server로 직렬화
server에서 client로 역직렬화

TCP or UDP
AddressServer, AddressClient 2개로 만들기.

*AddressClient 
-프런트 엔드임 
-UI담당
-메뉴 보여줌 show menu(), 진짜 작업은 서버에서
-CRRUD (조회, 입력받는 것 등은 다 이미 들고온 arraylist(vector)에서 이루어지므로 client에서 이루어진다는 뜻)
-client는 server를 2번밖에 호출 안한다. (로딩시, 종료시), 로딩시에는 역직렬화로 다 가져올 때와 종료시 직렬화로 다 저장해야 되니까.

*AddressServer(원래 DB역할이어야 하는데 여기서는 파일로 저장)
-백엔드임. 그래서 Client가 보낸 주소를 저장하고 client가 요청한 address를 넘겨주고.
-저장과 오픈 담당

cf) client가 필요한 파일을 달라고 했을 때 server는 하드디스크에서 해당하는 파일 뒤져서 있으면 찾아서 보내고, 없으면 만들어서 보내주고. 
cf) client가 로딩하자마자 서버에서 역직렬화해서 다 갖고 와야 됨. (파일이 없어도 null넘기고, 파일이 있는데 데이터가 없어도 null넘기고, 파일도 데이터도 있으면 arraylist(or vector)에 넣어서 넘겨주기)
cf) client가 요청할 떄만 session을 연결하고 아닐 때는 끊어야 한다. 그래야만 socket exception이 발생하지 않는다.
ex) 파일 요청할때 session연결해서 파일 client에게 넘겨주고 끊고, 종료할 떄 session 연결해서 client한테 파일 받아서 저장하고 다시 끊고.