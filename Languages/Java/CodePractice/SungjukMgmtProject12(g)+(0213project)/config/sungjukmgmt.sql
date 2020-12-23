/* 관리자로 들어가서 해야됨
sqlplus /nolog

conn SYSTEM as sysdba
*/
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE USER jimin IDENTIFIED BY jimin
DEFAULT tablespace USERS
TEMPORARY tablespace temp;

ALTER USER jimin 
DEFAULT TABLESPACE USERS
QUOTA UNLIMITED ON users;

GRANT connect, resource TO jimin;
GRANT CREATE SEQUENCE TO jimin;
GRANT CREATE PROCEDURE TO jimin;
GRANT CREATE VIEW TO jimin;

conn jimin/jimin@localhost:1521/ORCL   /* conn jimin/jimin 해도 됨 */

/* 회원 */
CREATE TABLE jimin.Member (
	userid VARCHAR2(12) NOT NULL, /* 사용자아이디 */
	passwd VARCHAR2(14) NOT NULL /* 사용자패스워드 */
);

COMMENT ON TABLE jimin.Member IS '회원';

COMMENT ON COLUMN jimin.Member.userid IS '사용자아이디';

COMMENT ON COLUMN jimin.Member.passwd IS '사용자패스워드';

CREATE UNIQUE INDEX jimin.PK_Member
	ON jimin.Member (
		userid ASC
	);

ALTER TABLE jimin.Member
	ADD
		CONSTRAINT PK_Member
		PRIMARY KEY (
			userid
		);

/* 학생 */
CREATE TABLE jimin.Student (
	hakbun VARCHAR2(12) NOT NULL, /* 학번 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	kor NUMBER(3) NOT NULL, /* 국어 */
	eng NUMBER(3) NOT NULL, /* 영어 */
	mat NUMBER(3) NOT NULL, /* 수학 */
	edp NUMBER(3) NOT NULL, /* 전산 */
	tot NUMBER(3), /* 총점 */
	avg NUMBER(5,2), /* 평균 */
	grade CHAR(1) /* 학점 */
);

COMMENT ON TABLE jimin.Student IS '학생';

COMMENT ON COLUMN jimin.Student.hakbun IS '학번';

COMMENT ON COLUMN jimin.Student.name IS '이름';

COMMENT ON COLUMN jimin.Student.kor IS '국어';

COMMENT ON COLUMN jimin.Student.eng IS '영어';

COMMENT ON COLUMN jimin.Student.mat IS '수학';

COMMENT ON COLUMN jimin.Student.edp IS '전산';

COMMENT ON COLUMN jimin.Student.tot IS '총점';

COMMENT ON COLUMN jimin.Student.avg IS '평균';

COMMENT ON COLUMN jimin.Student.grade IS '학점';

CREATE UNIQUE INDEX jimin.PK_Student
	ON jimin.Student (
		hakbun ASC
	);

ALTER TABLE jimin.Student
	ADD
		CONSTRAINT PK_Student
		PRIMARY KEY (
			hakbun
		);

/* 새 테이블 */
CREATE TABLE jimin.Teacher (
	teacherid VARCHAR2(12) NOT NULL, /* 선생아이디 */
	name VARCHAR2(20) NOT NULL /* 선생이름 */
);

COMMENT ON TABLE jimin.Teacher IS '새 테이블';

COMMENT ON COLUMN jimin.Teacher.teacherid IS '선생아이디';

COMMENT ON COLUMN jimin.Teacher.name IS '선생이름';

CREATE UNIQUE INDEX jimin.PK_Teacher
	ON jimin.Teacher (
		teacherid ASC
	);

ALTER TABLE jimin.Teacher
	ADD
		CONSTRAINT PK_Teacher
		PRIMARY KEY (
			teacherid
		);

ALTER TABLE jimin.Student
	ADD
		CONSTRAINT FK_Member_TO_Student
		FOREIGN KEY (
			hakbun
		)
		REFERENCES jimin.Member (
			userid
		);

ALTER TABLE jimin.Teacher
	ADD
		CONSTRAINT FK_Member_TO_Teacher
		FOREIGN KEY (
			teacherid
		)
		REFERENCES jimin.Member (
			userid
		);

CREATE OR REPLACE PROCEDURE student_insert_sp
(
    p_hakbun        IN       Student.hakbun%TYPE,
    p_name        IN       Student.name%TYPE,
    p_kor        IN       Student.kor%TYPE,
    p_eng        IN       Student.eng%TYPE,
    p_mat        IN       Student.mat%TYPE,
    p_edp        IN       Student.edp%TYPE
)
IS
    p_tot             Student.tot%TYPE;
    p_avg             Student.avg%TYPE;
    p_grade             Student.grade%TYPE;
BEGIN
    p_tot := p_kor + p_eng + p_mat + p_edp;
    p_avg := p_tot / 4;
    IF p_avg >= 90 THEN p_grade := 'A';
    ELSIF p_avg >= 80 THEN p_grade := 'B';
    ELSIF p_avg >= 70 THEN p_grade := 'C';
    ELSIF p_avg >= 60 THEN p_grade := 'D';
    ELSE p_grade := 'F';
    END IF;

    INSERT INTO Student(hakbun, name, kor, eng, mat, edp, tot, avg, grade)
    VALUES (p_hakbun, p_name, p_kor, p_eng, p_mat, p_edp, p_tot, p_avg, p_grade);
    COMMIT;
END;
/


CREATE OR REPLACE PROCEDURE student_select_sp
(
    t_hakbun         IN       Student.hakbun%TYPE,
    student_record      OUT    SYS_REFCURSOR
)
IS
BEGIN
    OPEN student_record FOR
    SELECT hakbun, name, kor, eng, mat, edp
    FROM Student
    WHERE hakbun = t_hakbun;
END;
/

CREATE OR REPLACE PROCEDURE student_delete_sp
(
    p_hakbun        IN             Student.hakbun%TYPE
)
IS
BEGIN
    DELETE FROM Student
    WHERE hakbun = p_hakbun;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE student_selectall_sp
(
    student_record      OUT    SYS_REFCURSOR
)
IS
BEGIN
    OPEN student_record FOR
    SELECT hakbun, name, kor, eng, mat, edp, tot, avg, grade
    FROM Student
    ORDER BY tot DESC;
END;
/

CREATE OR REPLACE PROCEDURE student_update_sp
(
   p_kor        IN     Student.kor%TYPE,
   p_eng        IN     Student.eng%TYPE,
   p_mat        IN     Student.mat%TYPE,
   p_edp        IN     Student.edp%TYPE,
   p_hakbun        IN     Student.hakbun%TYPE
)
IS
  p_tot           Student.tot%TYPE;
  p_avg           Student.avg%TYPE;
  p_grade         Student.grade%TYPE;
BEGIN
  p_tot := p_kor + p_eng + p_mat + p_edp;
  p_avg := p_tot / 4;
  CASE TRUNC((p_avg / 10), 0)
    WHEN 10 THEN p_grade := 'A';
    WHEN 9 THEN p_grade := 'A';
    WHEN 8 THEN p_grade := 'B';
    WHEN 7 THEN p_grade := 'C';
    WHEN 6 THEN p_grade := 'D';
    ELSE p_grade := 'F';
  END CASE;
  
  UPDATE Student SET kor = p_kor,  eng = p_eng,
  mat = p_mat, edp = p_edp, tot = p_tot, avg = p_avg, grade = p_grade
  WHERE hakbun = p_hakbun;
  
  COMMIT;
END;
/

--회원테이블에 가입날짜 칼럼 추가
ALTER TABLE Member   ADD regdate  DATE;

CREATE OR REPLACE PROCEDURE member_insert_sp
(
  p_userid      IN     Member.userid%TYPE, 
  p_passwd      IN     Member.passwd%TYPE
)
IS
BEGIN
  INSERT INTO Member(userid, passwd, regdate)
  VALUES(p_userid, p_passwd, SYSDATE);
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE member_login_sp
(
  p_userid      IN     Member.userid%TYPE, 
  member_record  OUT   SYS_REFCURSOR
)
IS
BEGIN
  OPEN member_record FOR
  SELECT passwd FROM Member
  WHERE userid = p_userid;
END;
/