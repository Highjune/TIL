CREATE TABLE practice.sungjukmgmt(
	hakbun CHAR(7) NOT NULL PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	kor TINYINT NOT NULL,
	eng TINYINT NOT NULL,
	mat TINYINT NOT NULL,
	tot SMALLINT,
	AVG DOUBLE(5, 2),
	grade CHAR(1)
)

COMMIT;
