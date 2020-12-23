https://youtu.be/6cCt1NS-E_M 5:30 전체 그림설명 시작
https://youtu.be/XUTv0mg-wrk 

서버 ON한 후에, cmd창에서 java로 client 파일 실행

<UDP방식>

datagram - tcp에서 말하는 packet
실제로 전송하고 받는 데이터는 user datagrampacket 안에 있다.
이 packet을 전송하고 받는 것이 datagramsocket 이다.

Datagram packet을 실어나르는 것이 udp. 나가는 packet과 들어오는 packet이 있다.
고정된 도로, 커넥션 없다. 라인자체가 없다.  버스마다 알아서 현지에 도착
각자 흩어져서 집결지에서 모이는 것. 
우리는 버스(packet)를 만들고 그 안에 데이터를 실어서 보낸다(socket의 send()로).
목적지 주소, 포트번호가 있는 socket-나가는 용
목적지 주소, 포트번호가 없는 socket-받는 용
받는 곳에서는 socket의 receive()로 받는다.

출발지(Sender)에서 나가는 버스(sender)는 항상 목적지(Receiver의 socket 위치 : 8888)가 있고,  목적지 입장(Receiver)에서의 들어오는 버스는 포트번호, ip가 없다.
sender쪽에서 버스(package)에 message를 보내는데 그것은 byte[] 단위이며, Receiver는 받은 것을 String으로 꺼낸다