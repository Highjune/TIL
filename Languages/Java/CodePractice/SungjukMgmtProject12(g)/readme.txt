<MVC 모델> - 성적관리프로젝트 12 (미완성)
cf) 수정, 삭제 만들어보기(preparedstatement로)
수정 - ? 6개 필요(국어, 영어, 수학, 학점, 등급)
삭제 - ? 1개 필요(학점 1개로 삭제하니까)
=> 만들어보기
cf) 게시판이든 뭐든 다 MVC로 나눌 수 밖에 없다.
Dao에서 preparedStatement로 처리함.
cf)preparedStatment를 사용하면 매번 문법검사, 개체검사를 할 필요가 없다. 원래 쿼리를 직접 만들어서 보낼 때는 검사들을 해야 하는데 그럴 필요가 없다.
처음에 문장을 만들 때만 검사를 하고 그 이후에는 값만 바꿔서 사용. 여러개를 한꺼번에 입력할 때 가장 좋다.

2티어.(성적관리프로젝트 11과 동일) - ubuntu virtual box의 192.168.56.2머신에 mariadb Database(project DB의 student 테이블. jimin계정)

https://youtu.be/hLNrLmPwahQ 37분 30초부터
https://youtu.be/8HuoVBJRZ_4 
https://youtu.be/XK5Rjru46m0 
https://youtu.be/0-7-u40qBPk 10분부터


default pacakge - MainClass
com.example.controller - InsertService, SelectService
com.example.dao - DBClose, DBConnection, StudentDao
com.example.view - Calc, Input, Output, Search, ShowMenu, Student
