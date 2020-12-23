(TCP방식)간단히 웹서버 만들어서 user에게 간단한 index.html 보내기

https://youtu.be/HPZj7gd434E  ==> request or response packet에 대해 대단히 중요한 내용(웹 서버의 원리)
https://youtu.be/E4320Un8gjg


<웹 서버의 원리>

user가 요청한 경로에 관한 파일을 user에게 보여준다. 근데 이것이 라우터 안에 (ex. 회사 내 파일) 있으면 파일서버라고 한다.
만약 라우터 밖에 있으면 그것에 바로 웹 서버. 그런데 라우터 밖에 있는 곳은 211.~ 뭐 이런식으로 접근하는 것이 아니라 URL에 접근해야 하는 것이다.
즉, 파일서버에게 요청. 라우터를 넘어가려면 TCP로 해야 된다. 요청한 파일을 printwriter로 유저에게 내보내는 것임

문서이름 안 넣고 localhost:80만 치면 기본문서(apache의 경우 index.html)이 뜬다. 
request packet의 header의 첫줄의 경로에는 / 만 있는 것을 보고 웹 서버는 경로를 따로 요청하지 않았으니 index.html을 보여준다.
 

브라우저의 역할은 html이라고 되어있는 파일을 읽고 실행하는 것