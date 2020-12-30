## 오라클 환경설정

### 계정생성
- cmd창에서
```
sqlplus /nolog

conn sys as sysdba

ALTER SESSION SET "_ORACLE_SCRIPT"=ture;

CREATE USER ID
IDENTIFIED BY password
DEFAULT TABLESPACE temp;

ALTER USER ID DEFAULT TABLESPACE USERS
QUOTA UNLIMITED ON users;

GRANT resource, connect to ID;

(원래 아래로 연결해서 테이블 만들어야 하지만 sql developer에서 작업)
conn ID/Password@localhost:1521/ORCL 
```


### 링크
[오라클실습-옛날 책이지만 기본기 좋음](http://blog.daum.net/why_i_am/category/%EC%98%A4%EB%9D%BC%ED%81%B4%EC%8B%A4%EC%8A%B5)