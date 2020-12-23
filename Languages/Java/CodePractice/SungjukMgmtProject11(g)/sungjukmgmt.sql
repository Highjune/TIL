--root
CREATE USER 'jimin'@'192.168.56.1' IDENTIFIED BY 'javamariadb';

CREATE DATABASE project;

USE mysql;
SELECT host, user FROM user;

GRANT ALL PRIVILEGES project.* TO 'jimin'@'192.168.56.1';
FLUSH PRIVILEGES;

--jimin
-- �� ���̺�
CREATE TABLE `project`.`Student` (
	`hakbun` CHAR(7)     NOT NULL COMMENT '�й�', -- �й�
	`name`   VARCHAR(20) NOT NULL COMMENT '�̸�', -- �̸�
	`kor`    TINYINT     NOT NULL COMMENT '����', -- ����
	`eng`    TINYINT     NOT NULL COMMENT '����', -- ����
	`mat`    TINYINT     NOT NULL COMMENT '����', -- ����
	`tot`    SMALLINT    NULL     COMMENT '����', -- ����
	`avg`    DOUBLE(5,2) NULL     COMMENT '���', -- ���
	`grade`  CHAR(1)     NULL     COMMENT '����' -- ����
)
COMMENT '�л����̺�';

-- �� ���̺�
ALTER TABLE `project`.`Student`
	ADD CONSTRAINT `PK_Student` -- �� ���̺� �⺻Ű
		PRIMARY KEY (
			`hakbun` -- �й�
		);