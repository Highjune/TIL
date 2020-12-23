<성적관리프로젝트 11> - Jdbc (DBConnection, DBClose 로 클래서 빼서)

virtualbox에 ubuntu(192.168.56.2)의 mariadb의 project db의 student테이블 (jimin/javamariadb) 계정

프로젝트 생성시 next-libraries에 mariadb driver 넣어야 됨 (add External jars로)
default 패키지 - 나머지
com.example.libs 패키지 - DBClose, DBConnection

https://youtu.be/Yx7A_DMJTI8 / exERD이용해서 DB모델링 하고 성적관리프로그램11(mariadb 써서) (20200211)
https://youtu.be/6DArng2gjKU / (코딩은 없음, 테이블 데이터 베이스 작업)  ubuntu(192.168.56.2)의 jimin계정 만들고 project DB 만들고 exerd로 만든 DB에 student테이블 만들기.  sungjukmgmt.sql에 다 저장함.
https://youtu.be/IpDjSYUtDic / 3분 40초부터 다시 코딩 시작.
https://youtu.be/pQhuPPJ23Uk
https://youtu.be/aYU_hnpax2U
https://youtu.be/hLNrLmPwahQ 20분까지


메인에서는 input-ouput 순으로 먼저 만들고 다른 클래스를 만들기.



cf) 
오라클의 스키마 - 계정
mariadb 스키마 - 데이터베이스

Student - 직렬화, hakbun, name, kor, eng, mat, tot, avg, grade, get/set, toString까지
(default pacakage)
Main - 생성자에 new Scanner(System.in), process함수, showmenu 함수(1. 전체학생보기, 2. 학생등록, 3. 학생조회, 4. 학생정보수정, 5. 학생삭제, 6. 파일로 백업하기, 7. 종료하기)
Input - 생성자에 scan, conn, calc 초기화, do-while로 입력받기, insert까지
Calc - tot, avg, grade 계산
Search - 생성자에 scan(메인에서 넘겨받음), conn 초기화, search함수에서 select sql 보내서 resultSet 들고오기
Update - 생성자에 scan(메인에서 넘겨받음), conn 초기화, update함수에서 Student 받아서 수정하고 insert sql까지.
Delete - 생성자에서 conn 초기화, delete함수에서 deletesql 보내기
Output - 백업하는 output1함수, 화면에 출력하는 output함수. output1함수는 backup.ser로 내보내는 것.

(com.example.libs 패키지)
DBClose - Connection만, Connection과 Statement만, Connection, Statement, ResultSet까지 다 각각 파라미터로 받는 함수 생성
DBConnection - 파일이름(mariadb.properties) 받아서 연결하는 것.

mariadb.properties - db.driver, db.url, db.user, db.password 정의
sungjukmgmt.sql - 테이블 정의



