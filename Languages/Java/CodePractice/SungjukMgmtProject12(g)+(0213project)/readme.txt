<0213 프로젝트> - DB랑 테이블 다시 만들어야 될듯( .sql 파일 제대로 다시 부어서 - procedure가 아마 좀 이상한 것 같음...), 그리고 테이블이 왜 student, member, teacher있는지 exerd만드는 영상 보고 테이블간 관계 보고 이해하기
MVC패턴, 오라클DB(localhost. jimin/jimin), callablestatement로 연결
cf) Statement -> preparedstatement -> callablestatment(현재)
callablestatement는 접근하고자 하는 것이 table, view 등이 아니라 stored procedure일 경우에만.
장점은 query문 자체가 보이지 않는다. 코드가 간결.

build path 로 driver연결해야됨

https://youtu.be/urIObzrxans / exerd생성
https://youtu.be/kQZHGhS0ivw / cmd에서 jimin계정생성(만듬), exerd 포워드 엔지니어링으로 만들기(20분쯤)(그런데 내 노트북에서는 exerd실행 안되서 못 만듬, sungjuk.sql에 있는 소스로 직접 붇기), 38분쯤 procedure생성
https://youtu.be/U6US3FRdHX8 / insert procedure만든 것 실행
https://youtu.be/kV3p1jCY82U
https://youtu.be/NtLImU1tZSE / 진행중인 MVC모델 process설명, MVC패턴 설명 + 코딩
https://youtu.be/lHoZLAVgsbA / 커서설명+프로시저작성(30분쯤에)
https://youtu.be/HpUlpqmZER4 
https://youtu.be/vZIBcimAUbI / exerd로 테이블 추가 생성 및 작업 + 코딩
https://youtu.be/JUcBxNAba4g
https://youtu.be/Mxm7qYdz95Y 
https://youtu.be/nUoCt1p4ECQ


cf) stored procedure를 제공하는 DB를 사용하는 경우에는 callablestatement를 사용할 수 있다
만약 지원을 안하는 DB라면 callablestatement를 사용하지 못하고 preparedstatement를 사용해야 한다.

buildpath - configure buildpath - source 탭 - add forder - 0213(프로젝트폴더)에 폴더추가 - config폴더생성 - apply and close (이렇게 만들면 일반적인 폴더 모양이랑 약간 다르다. build path로 만들었기 때문에)
이 폴더 안에 oracle.properties, sungjukmgmt.exerd, sungjukmgmt.sql 넣어두기 
cf) 이클립스에는 class path를 bulipath라고 한다.

(폴더에 있는 파일들), service는 controller를 말하는 것임.
com.example.dao - DBClose, DBConnection, MembershipshipDao(인터페이스), MembershipDaoImpl, SungjukMgmtDao(인터페이스), SungjukMgmtDaoImpl
com.example.main - MainClass
com.example.service - MembershipService(인터페이스), MembershipServiceImpl, SungjukMgmtService(인터페이스), SungjukMgmtService
com.example.view - Input, Login, Output, Register, Search, SungjukMgmtUI, Update
com.example.vo - MemberVO, StudentVO
cf) 1차 프로젝트 같은 경우 보면 admin, user 두 가지의 actor가 있다면 VO도 2개가 되어야 되기 때문에 VO2개 만들고 vo패키지로 따로 뺌

만들 때는 항상 VO부터 만들어야 된다.

*stored procedure 만들 때 SYS_RECURSOR ?
->  SYS_RECURSOR 타입은 오라클에서 만든 커서를 다른 언어에서 가져다 쓸 때.
(일반 CURSOR가 아니라 언어에서 커서를 가져다 쓸 때 SYS_RECURSOR 사용하면 된다, SYS_RECURSOR는 오라클 내에서 쓰는 커서가 아니라서 일반 오라클pl/sql 기본서에 나와있지 않다. 언어쪽에서 커서를 사용시 필요한 개념이다
단점은 언어에서 사용하기 위해서 만든 것이므로 프로시저 생성 후에 cmd창에서 테스트해볼 수가 없다. 일반 커서는 cmd창에서 테스트 가능하다.

*커서를 배워야 되는 이유
pl/sql에서는 stored procedure를 써야 되는데 stored procedure에서는 select가 2건 이상의 row가 나오면 에러가 난다.
그래서 2건 이상의 레코드가 나오는 select에서는 반드시 커서를 사용해야 된다. (오라클만 해당. mariadb같은 경우에는 2건 이상의 row가 나오는 select를 하는 stored procedure해도 에러가 안난다)
물론 2건 이상 아닌 경우에도 사용해도 되긴 한다.




