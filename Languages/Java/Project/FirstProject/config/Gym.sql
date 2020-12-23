ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE USER gym IDENTIFIED BY 123
DEFAULT tablespace USERS
TEMPORARY tablespace temp;

ALTER USER gym 
DEFAULT TABLESPACE USERS
QUOTA UNLIMITED ON users;

GRANT connect, resource TO gym;
GRANT CREATE SEQUENCE TO gym;
GRANT CREATE PROCEDURE TO gym;
GRANT CREATE VIEW TO gym;


/* static */
CREATE TABLE gym.origin (
   num NUMBER(5) NOT NULL, /* 회원번호 */
   name VARCHAR2(15) NOT NULL, /* 이름 */
   gender CHAR(1) NOT NULL, /* 성별 */
   age NUMBER(3) NOT NULL, /* 나이 */
   phone VARCHAR2(20) NOT NULL, /* 연락처 */
   height NUMBER(4, 1) NOT NULL, /* 키(cm) */
   weight NUMBER(4, 1) NOT NULL, /* 몸무게(kg) */
   goal NUMBER(3, 1) NOT NULL, /* 목표체중 */
   bmi NUMBER(3, 1) NOT NULL, /* BMI */
   startd DATE NOT NULL, /* 등록일 */
   endd DATE NOT NULL, /* 종료일 */
   tchul NUMBER(4) /* 총출석일 */
);

COMMENT ON TABLE gym.origin IS 'static';

COMMENT ON COLUMN gym.origin.num IS '회원번호';

COMMENT ON COLUMN gym.origin.name IS '이름';

COMMENT ON COLUMN gym.origin.gender IS '성별';

COMMENT ON COLUMN gym.origin.age IS '나이';

COMMENT ON COLUMN gym.origin.phone IS '연락처';

COMMENT ON COLUMN gym.origin.height IS '키(cm)';

COMMENT ON COLUMN gym.origin.weight IS '몸무게(kg)';

COMMENT ON COLUMN gym.origin.goal IS '목표체중';

COMMENT ON COLUMN gym.origin.bmi IS 'BMI';

COMMENT ON COLUMN gym.origin.startd IS '등록일';

COMMENT ON COLUMN gym.origin.endd IS '종료일';

COMMENT ON COLUMN gym.origin.tchul IS '총출석일';

CREATE UNIQUE INDEX gym.PK_origin
   ON gym.origin (
      num ASC
   );

ALTER TABLE gym.origin
   ADD
      CONSTRAINT PK_origin
      PRIMARY KEY (
         num
      );

/* change */
CREATE TABLE gym.change (
   Serial NUMBER(5) NOT NULL, /* 고유번호 */
   num NUMBER(5) NOT NULL, /* 회원번호 */
   checkday DATE NOT NULL, /* 측정날짜 */
   weight NUMBER(3, 1) NOT NULL /* 몸무게(kg) */
);

COMMENT ON TABLE gym.change IS 'change';

COMMENT ON COLUMN gym.change.Serial IS '고유번호';

COMMENT ON COLUMN gym.change.num IS '회원번호';

COMMENT ON COLUMN gym.change.checkday IS '측정날짜';

COMMENT ON COLUMN gym.change.weight IS '몸무게(kg)';

CREATE UNIQUE INDEX gym.PK_change
   ON gym.change (
      Serial ASC
   );

ALTER TABLE gym.change
   ADD
      CONSTRAINT PK_change
      PRIMARY KEY (
         Serial
      );

ALTER TABLE gym.change
   ADD
      CONSTRAINT FK_origin_TO_change
      FOREIGN KEY (
         num
      )
      REFERENCES gym.origin (
         num
      );

--ORIGIN 테이블 데이터 
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (1, '관리자', 'G', 100, '1588-5588', 1, 1, 1, 1,TO_DATE('01/01/01','yyyy-mm-dd'),TO_DATE('20/06/30','yyyy-mm-dd'), 1);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (11,'허강준','M',32,'010-1234-5678',180,78,75,19.4,TO_DATE('19.12.25','yyyy-mm-dd'),TO_DATE('20.06.28','yyyy-mm-dd'),48);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (12,'최문정','F',25,'010-2345-6789',163,47,44,17.69,TO_DATE('19.11.14','yyyy-mm-dd'),TO_DATE('20.08.16','yyyy-mm-dd'),61);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (13,'왕건모','M',25,'010-3456-7890',176,59,65,19.05,TO_DATE('19.10.05','yyyy-mm-dd'),TO_DATE('20.07.05','yyyy-mm-dd'),69);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (14,'이선문','M',30,'010-4567-8901',173.5,83,75,27.9,TO_DATE('19.09.01','yyyy-mm-dd'),TO_DATE('20.06.01','yyyy-mm-dd'),91);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (33, 'testo','M',20,'010-9999-9999',175,150,90,48.98,TO_DATE('19.06.05','yyyy-mm-dd'),TO_DATE('20.02.20','yyyy-mm-dd'),223);
INSERT INTO "GYM"."ORIGIN" (NUM, NAME, GENDER, AGE, PHONE, HEIGHT, WEIGHT, GOAL, BMI, STARTD, ENDD, TCHUL)
VALUES (44,'testx','M',25,'010-8888-7777',175,70,65,22.86,TO_DATE('19.06.05','yyyy-mm-dd'),TO_DATE('20.02.20','yyyy-mm-dd'),180);


--CHANGE 테이블 데이터
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('1', '33', TO_DATE('2019-06-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '144')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('2', '44', TO_DATE('2019-06-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '73')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('3', '33', TO_DATE('2019-07-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '132')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('4', '44', TO_DATE('2019-07-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '72')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('5', '33', TO_DATE('2019-08-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '124')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('6', '44', TO_DATE('2019-08-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '71')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('7', '14', TO_DATE('2019-09-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '82.3')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('8', '33', TO_DATE('2019-09-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '116.3')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('9', '44', TO_DATE('2019-09-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '70')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('10', '13', TO_DATE('2019-10-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '61.2')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('11', '14', TO_DATE('2019-10-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '79.8')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('12', '33', TO_DATE('2019-10-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '109.1')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('13', '44', TO_DATE('2019-10-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '69')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('14', '33', TO_DATE('2019-11-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '103.4')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('15', '44', TO_DATE('2019-11-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '68')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('16', '14', TO_DATE('2019-10-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '80.5')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('17', '12', TO_DATE('2019-11-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '46.5')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('18', '13', TO_DATE('2019-11-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '62.5')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('19', '33', TO_DATE('2019-12-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '97.1')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('20', '44', TO_DATE('2019-12-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '67')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('21', '11', TO_DATE('2019-12-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '77.7')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('22', '14', TO_DATE('2019-11-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '79.4')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('23', '13', TO_DATE('2019-12-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '63')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('24', '11', TO_DATE('2020-01-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '76.3')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('25', '13', TO_DATE('2020-01-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '63.2')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('26', '33', TO_DATE('2020-01-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '92.9')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('27', '14', TO_DATE('2020-01-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '78.6')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('28', '12', TO_DATE('2020-01-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '45.9')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('29', '13', TO_DATE('2020-02-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '62.5')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('30', '12', TO_DATE('2020-02-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '45.2')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('31', '14', TO_DATE('2020-02-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '77.9')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('32', '33', TO_DATE('2020-02-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '89.4')
INSERT INTO "GYM"."CHANGE" (SERIAL, NUM, CHECKDAY, WEIGHT) VALUES ('33', '11', TO_DATE('2020-02-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '77.5')



--프로시저  UI 순서대로---------------------------------------------------
--프로시저  UI 순서대로---------------------------------------------------
--프로시저  UI 순서대로---------------------------------------------------
--유저 몸무게감량률순위 누락--------------------------
--------------------02.19  17:50기준-------------------------------------

--member_login_sp - 로그인 프로시저

create or replace PROCEDURE member_login_sp
(
 g_num	IN	origin.num%TYPE,
 member_record  OUT     SYS_REFCURSOR
)
IS
BEGIN
 OPEN member_record FOR
 SELECT num,substr(phone,-4) passwd FROM origin
 WHERE g_num=num;
 
 COMMIT;

END;

--USER_BODY_SELECT_SP - 유저 내 신체정보 조회 프로시저

create or replace PROCEDURE USER_BODY_SELECT_SP
(
  g_num    IN    change.num%TYPE,
  member_record  OUT     SYS_REFCURSOR
)

IS
BEGIN
  OPEN member_record FOR
select to_char(checkday,'yyyy-mm-dd') checkday, cweight, reduce, trunc(cweight/(oheight*oheight)*10000,2) bmi
from	 (SELECT rank()over (order by c.checkday desc) rank, c.checkday, o.height oheight, c.weight cweight,
        c.weight-(LAG(c.weight)over (order by c.checkday )) reduce, o.weight oweight
			  FROM origin o,change c
			  WHERE o.num = c.num and o.num= g_num)
order by rank;

 COMMIT;
END;

--user_selectall_sp - 유저 내 정보조회 프로시저

create or replace PROCEDURE user_selectall_sp
(          
  g_num      IN      origin.num%type,
  member_record  OUT   SYS_REFCURSOR
)
IS


BEGIN
   OPEN member_record FOR
SELECT name, gender, age, phone, height, weight, to_char(startd||' ~ '||endd) period,
          goal, to_char(trunc((tchul/(endd - startd)*100),1)||'% ('||tchul||'일/'||to_number(endd-startd)||'일)') rate
   FROM  origin
   where num = g_num
  order by name;
     
COMMIT;
END;

--user_ranktchul_sp - 유저 출석률 순위 프로시저

create or replace PROCEDURE user_ranktchul_sp
(
    member_record  OUT     SYS_REFCURSOR
)
IS
BEGIN
  OPEN member_record FOR     --tchul은 int, gap은 string
    select distinct(num),name, nvl(tchul,0) tchul, to_char(endd - startd) gap
    from origin
    where num > 10
    order by num;

  COMMIT;

END;

--admin_selectall_sp - 관리자 전체회원 목록 프로시저

create or replace PROCEDURE admin_selectAll_sp
(
    member_record  OUT     SYS_REFCURSOR
)
IS
BEGIN
  OPEN member_record FOR
  SELECT num,name,gender,age,phone,to_char(startd||' ~ '||endd) gigan
  FROM origin
  ORDER BY name;

END;

--admin_select_gender_sp - 관리자 성별 조회 프로시저

create or replace PROCEDURE admin_select_gender_sp
(
    g_gender       IN      origin.gender%TYPE,
    member_record  OUT     SYS_REFCURSOR
)
IS
BEGIN
  OPEN member_record FOR
  SELECT num,name,gender,age,phone,to_char(startd) startd,to_char(endd) endd
  FROM origin
  WHERE gender = upper(g_gender)
  order by name;  
  end;

--admin_search_sp - 관리자 회원검색(번호로조회) 프로시저

create or replace PROCEDURE admin_search_sp
(          
  g_num      IN      origin.num%type,
  member_record  OUT   SYS_REFCURSOR
)
IS


BEGIN
   OPEN member_record FOR
select checkday, name, num, gender, age, phone, height, cweight,startd, endd, goal, trunc(cweight/(height*height)*10000,2) bmi, cha, rate, to_char(startd||' ~ '||endd) gigan
    from  (SELECT to_char(c.checkday,'yyyy-mm-dd') checkday, rank()over (order by c.checkday desc) rank,  o.num num, o.name name, o.gender gender, o.age age, o.phone phone, o.height height, c.weight cweight, to_char(o.startd,'yy-mm-dd') startd, to_char(o.endd,'yy-mm-dd')endd,
           o.goal, to_char(trunc((o.tchul/(o.endd - o.startd)*100),1)||'% ('||o.tchul||'일/'||to_number(o.endd-o.startd)||'일)') rate,
           c.weight-(LAG(c.weight)over (order by c.checkday )) cha
           FROM  origin o, change c
           where o.num = c.num and o.num = g_num order by rank)
          where rank = 1;

     
     
COMMIT;
END;

--admin_insert_sp - 관리자 회원등록 프로시저

create or replace PROCEDURE admin_insert_sp
(
 g_num	  IN	origin.num%TYPE,
 g_name   IN  origin.name%TYPE,
 g_gender IN  origin.gender%TYPE,
 g_age    IN  origin.age%TYPE,
 g_phone  IN  origin.phone%TYPE,
 g_height IN  origin.height%TYPE,
 g_weight IN  origin.weight%TYPE,
 g_startd IN  origin.startd%TYPE,
 g_endd   IN  origin.endd%TYPE,
 g_goal   IN  origin.goal%TYPE
)
IS
 g_bmi    origin.bmi%TYPE;
BEGIN
 g_bmi := g_weight/(g_height*g_height*0.0001);
 INSERT INTO origin(num,name,gender,age,phone,height,weight,startd,endd,goal,bmi)
 VALUES (g_num,g_name,g_gender,g_age,g_phone,g_height,g_weight,g_startd,g_endd,g_goal,g_bmi);
 COMMIT;

END;

--admin-updateall_sp - 관리자 회원 정보수정(번호로조회) 프로시저

create or replace PROCEDURE admin_UpdateAll_sp
(
 g_num	  IN	origin.num%TYPE,
 g_name   IN  origin.name%TYPE,
 g_gender IN  origin.gender%TYPE,
 g_age    IN  origin.age%TYPE,
 g_phone  IN  origin.phone%TYPE,
 g_height IN  origin.height%TYPE,
 g_weight IN  origin.weight%TYPE,
 g_startd IN  origin.startd%TYPE,
 g_endd   IN  origin.endd%TYPE,
 g_goal   IN  origin.goal%TYPE
 
)
IS
 g_bmi    origin.bmi%TYPE;
BEGIN
 g_bmi := g_weight/(g_height*g_height*0.0001);
update origin
set NAME = g_name, GENDER = g_gender, AGE = g_age, PHONE = g_phone, HEIGHT = g_height, WEIGHT = g_weight,
           GOAL = g_goal, BMI = g_bmi, STARTD = g_startd, ENDD = g_endd
where num = g_num;

 COMMIT;
END;

--admin_change_update_sp - 관리자 회원 신체정보수정(번호로조회) 프로시저

create or replace PROCEDURE admin_change_update_sp
(
    g_serial          IN      change.serial%TYPE,
    g_checkday        IN      change.checkday%TYPE,
    g_weight          IN      change.weight%TYPE    
)
IS

BEGIN
  update change
  set checkday = g_checkday, weight = g_weight
  where serial = g_serial;
  
  COMMIT;
END;

--admin_delete_sp - 관리자 회원삭제(번호로조회)

create or replace PROCEDURE admin_delete_sp 
(
    g_number       IN      origin.num%TYPE
)
IS
BEGIN
  
  DELETE FROM change
  WHERE num=g_number;
  DELETE FROM origin
  WHERE num=g_number;

  COMMIT;

END;




