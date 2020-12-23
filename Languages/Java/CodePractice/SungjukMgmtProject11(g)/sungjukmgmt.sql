--root
CREATE USER 'jimin'@'192.168.56.1' IDENTIFIED BY 'javamariadb';

CREATE DATABASE project;

USE mysql;
SELECT host, user FROM user;

GRANT ALL PRIVILEGES project.* TO 'jimin'@'192.168.56.1';
FLUSH PRIVILEGES;

--jimin
-- 새 테이블
CREATE TABLE `project`.`Student` (
	`hakbun` CHAR(7)     NOT NULL COMMENT '학번', -- 학번
	`name`   VARCHAR(20) NOT NULL COMMENT '이름', -- 이름
	`kor`    TINYINT     NOT NULL COMMENT '국어', -- 국어
	`eng`    TINYINT     NOT NULL COMMENT '영어', -- 영어
	`mat`    TINYINT     NOT NULL COMMENT '수학', -- 수학
	`tot`    SMALLINT    NULL     COMMENT '총점', -- 총점
	`avg`    DOUBLE(5,2) NULL     COMMENT '평균', -- 평균
	`grade`  CHAR(1)     NULL     COMMENT '평점' -- 평점
)
COMMENT '학생테이블';

-- 새 테이블
ALTER TABLE `project`.`Student`
	ADD CONSTRAINT `PK_Student` -- 새 테이블 기본키
		PRIMARY KEY (
			`hakbun` -- 학번
		);