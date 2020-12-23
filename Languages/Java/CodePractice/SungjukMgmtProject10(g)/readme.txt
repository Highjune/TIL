성적관리프로그램10 
2티어(window10 - client, linux utuntu - Server)
Jdbc - DB연동(mariadb)해서 프로그램 작성  - 192.168.56.2 virtualbox에 있는 것

해당프로젝트 우클릭 - build path - driver 추가
UI를 통해서 입력받고 데이터는 DB에 저장 (insert만). 저장 후 heidSQL에서 확인가능
학번, 이름, 국어, 영어, 수학을 입력받아서 DB에 저장
	
https://youtu.be/IHLhMixVhEY  / (virtualbox의 mariadb 켜고 HeidSQL로 192.168.56.2 들어감. world database 설정값 - utf_general_8 바꾸기, HeidSQL에서 world.Student 테이블 만듬.)
https://youtu.be/zuJw_vs7WtQ / mariadb driver(.jar) 다운받아서 build path로 추가. 작업~ 
https://youtu.be/bSI0Mwp2QBY / 40분까지

SQL에서 order by 할 것이라서 sort클래스 필요없다.


cf) mariadb driver (.jar파일안에 있는 driver) https://downloads.mariadb.com/Connectors/java/connector-java-2.5.4/ 에서 다운로드하면 됨.
https://youtu.be/zuJw_vs7WtQ 8분경에 다운로드 하는 영상 있음

Student - hakbun, name, kor, eng, mat, tot, avg, grade의 get/set, tostring까지.
Main - Input과 Output만 있음. (input은 isnert할 때만, ouput은 모든 데이터 다 볼 때)
Input - 값들 받아서 DB에 저장. Driver와 Connection하기, 입력받아서(do-while문으로 y/n값으로 더 실행할지 계산하기) 바로 calc에 넣어서 계산 하기, sql문 만들어서 실행까지, 실행 후의 값 받기. 
Calc - Student값 받아서 단일계산(vector 등 collection 아님)
Output - DB의 값들을 받아서 출력, Connection 연결하고 Resultset으로 받기. printlabel.
cf) sort는 없음. 어차피 Output에서 들고 나올 때 총점기준 내림차순

