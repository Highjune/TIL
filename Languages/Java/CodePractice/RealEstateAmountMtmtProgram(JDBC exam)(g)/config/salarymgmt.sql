/* 호급수당 */
CREATE TABLE jimin.SalaryBonus (
	grade NUMBER(1) NOT NULL, /* 호급 */
	bonus NUMBER(6) NOT NULL /* 수당 */
);

COMMENT ON TABLE jimin.SalaryBonus IS '호급수당';

COMMENT ON COLUMN jimin.SalaryBonus.grade IS '호급';

COMMENT ON COLUMN jimin.SalaryBonus.bonus IS '수당';

CREATE UNIQUE INDEX jimin.PK_SalaryBonus
	ON jimin.SalaryBonus (
		grade ASC
	);

ALTER TABLE jimin.SalaryBonus
	ADD
		CONSTRAINT PK_SalaryBonus
		PRIMARY KEY (
			grade
		);

/* 기본급 */
CREATE TABLE jimin.DefaultSalary (
	num NUMBER(1) NOT NULL, /* 기본급수 */
	defsalary NUMBER(5) NOT NULL /* 기본급여액 */
);

COMMENT ON TABLE jimin.DefaultSalary IS '기본급';

COMMENT ON COLUMN jimin.DefaultSalary.num IS '기본급수';

COMMENT ON COLUMN jimin.DefaultSalary.defsalary IS '기본급여액';

CREATE UNIQUE INDEX jimin.PK_DefaultSalary
	ON jimin.DefaultSalary (
		num ASC
	);

ALTER TABLE jimin.DefaultSalary
	ADD
		CONSTRAINT PK_DefaultSalary
		PRIMARY KEY (
			num
		);

/* 부서 */
CREATE TABLE jimin.Department (
	code CHAR(1) NOT NULL, /* 부서명코드 */
	dname VARCHAR2(20) NOT NULL /* 부서명 */
);

COMMENT ON TABLE jimin.Department IS '부서';

COMMENT ON COLUMN jimin.Department.code IS '부서명코드';

COMMENT ON COLUMN jimin.Department.dname IS '부서명';

CREATE UNIQUE INDEX jimin.PK_Department
	ON jimin.Department (
		code ASC
	);

ALTER TABLE jimin.Department
	ADD
		CONSTRAINT PK_Department
		PRIMARY KEY (
			code
		);

/* 야간수당 */
CREATE TABLE jimin.NightBonus (
	nightcode NUMBER(1) NOT NULL, /* 야간수당코드 */
	nightbonus NUMBER(4) NOT NULL /* 야간수당 */
);

COMMENT ON TABLE jimin.NightBonus IS '야간수당';

COMMENT ON COLUMN jimin.NightBonus.nightcode IS '야간수당코드';

COMMENT ON COLUMN jimin.NightBonus.nightbonus IS '야간수당';

CREATE UNIQUE INDEX jimin.PK_NightBonus
	ON jimin.NightBonus (
		nightcode ASC
	);

ALTER TABLE jimin.NightBonus
	ADD
		CONSTRAINT PK_NightBonus
		PRIMARY KEY (
			nightcode
		);

/* 새 테이블 */
CREATE TABLE jimin.Employee (
	empno CHAR(4) NOT NULL, /* 사원번호 */
	name VARCHAR2(20) NOT NULL, /* 사원이름 */
	num NUMBER(1) NOT NULL, /* 기본급수 */
	code CHAR(1) NOT NULL, /* 부서명코드 */
	grade NUMBER(1) NOT NULL, /* 호급 */
	nightcode NUMBER(1) NOT NULL,  /* 야간수당코드 */
	family NUMBER(1) NOT NULL  /* 가족수 */
);

COMMENT ON TABLE jimin.Employee IS '새 테이블';

COMMENT ON COLUMN jimin.Employee.empno IS '사원번호';

COMMENT ON COLUMN jimin.Employee.name IS '사원이름';

COMMENT ON COLUMN jimin.Employee.num IS '기본급수';

COMMENT ON COLUMN jimin.Employee.code IS '부서명코드';

COMMENT ON COLUMN jimin.Employee.grade IS '호급';

COMMENT ON COLUMN jimin.Employee.nightcode IS '야간수당코드';

COMMENT ON COLUMN jimin.Employee.family IS '가족수';

CREATE UNIQUE INDEX jimin.PK_Employee
	ON jimin.Employee (
		empno ASC
	);

ALTER TABLE jimin.Employee
	ADD
		CONSTRAINT PK_Employee
		PRIMARY KEY (
			empno
		);

ALTER TABLE jimin.Employee
	ADD
		CONSTRAINT FK_DefaultSalary_TO_Employee
		FOREIGN KEY (
			num
		)
		REFERENCES jimin.DefaultSalary (
			num
		);

ALTER TABLE jimin.Employee
	ADD
		CONSTRAINT FK_Department_TO_Employee
		FOREIGN KEY (
			code
		)
		REFERENCES jimin.Department (
			code
		);

ALTER TABLE jimin.Employee
	ADD
		CONSTRAINT FK_SalaryBonus_TO_Employee
		FOREIGN KEY (
			grade
		)
		REFERENCES jimin.SalaryBonus (
			grade
		);

ALTER TABLE jimin.Employee
	ADD
		CONSTRAINT FK_NightBonus_TO_Employee
		FOREIGN KEY (
			nightcode
		)
		REFERENCES jimin.NightBonus (
			nightcode
		);

INSERT INTO SalaryBonus(grade, bonus) VALUES(1, 900000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(2, 400000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(3, 600000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(4, 800000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(5, 300000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(6, 800000);
INSERT INTO SalaryBonus(grade, bonus) VALUES(7, 800000);

INSERT INTO DefaultSalary(num, defsalary) VALUES(1, 15000);
INSERT INTO DefaultSalary(num, defsalary) VALUES(2, 25000);
INSERT INTO DefaultSalary(num, defsalary) VALUES(3, 35000);
INSERT INTO DefaultSalary(num, defsalary) VALUES(4, 45000);

INSERT INTO Department(code, dname) VALUES('A', '영업부');
INSERT INTO Department(code, dname) VALUES('B', '업무부');
INSERT INTO Department(code, dname) VALUES('C', '홍보부');
INSERT INTO Department(code, dname) VALUES('D', '인사부');
INSERT INTO Department(code, dname) VALUES('E', '경리부');
INSERT INTO Department(code, dname) VALUES('F', '판촉부');
INSERT INTO Department(code, dname) VALUES('G', '총무부');

INSERT INTO NightBonus(nightcode, nightbonus) VALUES(1, 1500);
INSERT INTO NightBonus(nightcode, nightbonus) VALUES(2, 2500);
INSERT INTO NightBonus(nightcode, nightbonus) VALUES(3, 3500);
INSERT INTO NightBonus(nightcode, nightbonus) VALUES(4, 4500);

COMMIT;

--사원 데이터 추가
CREATE OR REPLACE PROCEDURE employee_insert_sp
(
  p_empno         IN      Employee.empno%TYPE,
  p_name          IN      Employee.name%TYPE,
  p_num           IN      Employee.num%TYPE,
  p_code          IN      Employee.code%TYPE,
  p_grade         IN      Employee.grade%TYPE,
  p_nightcode     IN      Employee.nightcode%TYPE,
  p_family        IN      Employee.family%TYPE
)
IS
BEGIN
  
  INSERT INTO Employee(empno, name, num, code, grade, nightcode, family)
  VALUES(p_empno, p_name, p_num, p_code, p_grade, p_nightcode, p_family);
  
  COMMIT;
END;

CREATE OR REPLACE PROCEDURE employee_selectall_sp
(
    employee_record    OUT     SYS_REFCURSOR
)
IS
BEGIN
  OPEN employee_record FOR
  SELECT e.empno, e.name, d.dname, e.num, de.defsalary, s.bonus, 
         e.family * 7000, n.nightbonus
  FROM Employee e INNER JOIN Department d ON e.code = d.code 
                  INNER JOIN SalaryBonus s ON e.grade = s.grade 
                  INNER JOIN NightBonus n  ON e.nightcode = n.nightcode
                  INNER JOIN DefaultSalary de ON e.num = de.num;
END;

CREATE OR REPLACE PROCEDURE employee_select_sp
(
     p_empno    IN      employee.empno%TYPE,
     employee_record   OUT    SYS_REFCURSOR
)
IS
BEGIN
  OPEN employee_record FOR
  SELECT empno, name, num, nightcode, family
  FROM Employee
  WHERE empno = p_empno;
END;