# SQL 
> 유용하거나 생소한 SQL 기록
> 기본적인 개념들도 정리(감으로 얼추 알고만 있었던 개념들)

- 기존에 존재하는 key값을 제외하고(중복제외) insert 하고 싶을 때
```
INSERT INTO db.user_table(
					id
					, `name`
					, admin_pw
			) 
			
			SELECT 
				'google_login_id'
				, 'google'
				, SHA2(1q2w3e4r, 256)
			FROM DUAL
			WHERE NOT EXISTS (
						SELECT id
						FROM db.user_table
						WHERE id = 'id'
					);
```


- 특정한 날(1일)의 범위 선택(between 으로)
    - 사실 아래처럼 말고 부등호로 표현하면 더 간단할 수 있다.
```
SELECT *
FROM ex_table
WHERE specific_day BETWEEN DATE_FORMAT(now(), '%Y-%m-%d 00:00:00') AND DATE_FORMAT(now(), '%Y-%m-%d 23:59:59')
``` 
- 임의 번호 생성
    - 로그인시 keyPin 생성할 때 유용(중복접속X)
```
UPDATE admin_user_table SET 
keypin = CONCAT(ROUND(RAND()*1000000,0), ROUND(RAND()*1000000,0), ROUND(RAND()*1000000,0))
WHERE user_id = _userid;
```

- 로그인 프로시저
    - 파라미터로 userid와 password 2가지 받음
    - use_yn 은 아이디 활성화 여부    
    - 경우 수 3가지
        - 아이디가 없을 경우
        - 비밀번호가 틀릴 경우(아이디는 존재)
        - 둘 다 일치해서 로그인 성공(-> 기존에 갖고 있는 keyPin값 다시 랜덤으로 업데이트 수정, 성공한 메시지 리턴)
```
DROP PROCEDURE IF EXISTS `db_name`.`sp_login`;
DELIMITER $$
CREATE PROCEDURE `db_name`.`sp_login`(IN _userid VARCHAR(100), IN _login_password VARCHAR(100))
Main:
BEGIN
        DECLARE existUser INT;
        SET _userid       = LOWER(_userid);
        
        SELECT  COUNT(user_id) INTO existUser
        FROM   admin_user_table
        WHERE  user_id = _userid AND use_yn = 'Y';
        
        IF existUser < 1 THEN
                SELECT '300'             AS RECODE,
                       '가입한 회원정보가 없거나 비활성 계정입니다.' AS MSG;
                
                LEAVE Main;
        END IF;
        
        SELECT  COUNT(user_id) INTO existUser
        FROM   admin_user_table
        WHERE  user_id = _userid and login_password = SHA2(_login_password, 256);
        
        IF existUser < 1 THEN
                SELECT '400'             AS RECODE,
                       '비밀번호가 틀렸습니니다.' AS MSG;
                
                LEAVE Main;
        ELSE
        	-- update keypin      
        	UPDATE admin_user_table SET 
				keypin = CONCAT(ROUND(RAND()*1000000,0), ROUND(RAND()*1000000,0), ROUND(RAND()*1000000,0))
			WHERE user_id = _userid;
        	SELECT '200' AS RECODE, 'Success' AS MSG, user_id, gubun, keypin FROM admin_user_table where user_id = _userid; 
        END IF;

END $$
DELIMITER ;

```

- 모든 데이터베이스에 있는 테이블 정보 조회
```
select * from INFORMATION_SCHEMA.columns
```


- CASE WHEN 구문
```
SELECT  
        case 
        when home_score = FLOOR(entire_numbers / 2) + 1 
                then (SELECT `name` FROM team_table WHERE id = home_team_id)
        when away_score = FLOOR(entire_numbers / 2) + 1 
                then (SELECT `name` FROM team_table WHERE id = away_team_id)
        ELSE 'No data'
        END AS winner_team_name		

FROM dblol.pd_match pm
```


- 이미 채워져 있는 A컬럼의 값들을 B컬럼(null 또는 기본값) 으로 복사(대신 where절이 없으므로 매우 조심해야 함)
```
UPDATE test_table
SET B = A
;
```

- Upsert(insert + update), 기존에 데이터가 없으면 insert, 만약 있으면 update
`ON DUPLICATE KEY UPDATE`
```
INTO DB.`test_table` (
        column1
        , column2
)
VALUES (
        'test1'
        , 'test2'
)
ON DUPLICATE KEY UPDATE 
        column2 = 'update_data'

```

- 테이블 정의서에 맞게 컬럼 select 하는 것
```
SELECT 
        t1.`column_name`
        , t1.column_comment
        , CASE 
                WHEN t1.numeric_precision IS NULL THEN t1.column_type
                ELSE CONCAT(t1.data_type, '(', t1.numeric_precision, ')')
          END AS column_type1
        , '' AS length
        , t1.is_nullable
        , t1.column_key
        , IFNULL(t1.column_default, '') AS column_default
FROM INFORMATION_SCHEMA.columns t1
WHERE t1.table_schema='database_schema_name' 
AND t1.table_name='ex_table_name'
ORDER BY t1.ordinal_position;
```

- 여러 query에 하나의 변수 값으로 세팅해서 넣고자 할 때 `SET @변수 = ''`
```
SET @specific_day_from = '2021-03-01 00:00:00';
SET @specific_day_to = '2021-04-01 00:00:00';

SELECT * 
FROM db_schema.ex_table
WHERE 1=1
AND insert_time BETWEEN DATE_FORMAT(@specific_day_from, '%Y-%m-%d %H:%i:%s') AND DATE_FORMAT(@specific_day_to, '%Y-%m-%d %H:%i:%s')
```

- SubQuery의 명칭이 동일할 경우, 제일 바깥에서 쓴 쿼리의 명칭이 유효하다. 아래 GROUP BY으 T1.column 에서의 컬럼은 제일 바깥 A 테이블을 의미하는 것임. 

```
SELCET *
FROM A (
        SELECT *
        FROM B (
                SELECT *
                FROM C
        ) T1
) T1
GROUP BY T1.column
```


- 월별 등록자수(1명이 여러번 신청해도 1번으로). cf) 일별이면 제일 안의 DATE_FORMAT(insert_time, `%Y-%m`) 을 DATE_FORMAT(insert_time, `%Y-%m-%d`)으로 수정
```
SET @from_time = '2021-01-01 00:00:00';
SET @end_time = '2021-12-31 00:00:00';

SELECT regMonth, COUNT(*) AS monthUserCount
FROM (
	SELECT regMonth, member_id, COUNT(*) AS cnt
	FROM (
		SELECT t1.member_id, t1.name, DATE_FORMAT(t1.insert_time, '%Y-%m') AS regMonth
		FROM schema.event_entry AS t1
		WHERE insert_time BETWEEN DATE_FORMAT(@from_time, '%Y-%m-%d %H:%i:%s') AND DATE_FORMAT(@end_time, '%Y-%m-%d %H:%i:%s')
	) AS T1
	GROUP BY T1.regMonth, T1.member_id
) AS T1
GROUP BY T1.regMonth
ORDER BY T1.regMonth
;
```

- 월별 신청수(한명이 여러번 가능). cf) 일별이면 제일 안의 DATE_FORMAT(insert_time, `%Y-%m`) 을 DATE_FORMAT(insert_time, `%Y-%m-%d`)으로 수정
```
SET @from_time = '2021-01-01 00:00:00';
SET @end_time = '2021-12-31 00:00:00';

SELECT regMonth, COUNT(*) AS monthRegistCounts
FROM (
	SELECT id, name DATE_FORMAT(insert_time, '%Y-%m') AS regMonth
	FROM schema.user AS t1
	WHERE insert_time BETWEEN DATE_FORMAT(@from_time, '%Y-%m-%d %H:%i:%s') AND DATE_FORMAT(@end_time, '%Y-%m-%d %H:%i:%s')
) AS T1
GROUP BY T1.regMonth
ORDER BY T1.regMonth
;
```

- 지금시간대가 특정 시간대(시작 ~ 끝) 에 있을 시 1 또는 0으로 표시
```
SELECT 
        IF(NOW() BETWEEN DATE_FORMAT(STR_TO_DATE(begin_time, '%Y-%m-%d'), '%Y-%m-%d 00:00:00') AND DATE_FORMAT(STR_TO_DATE(end_time, '%Y-%m-%d'), '%Y-%m-%d 23:59:59'), 1, 0) AS is_game_active

FROM table
```

- 총 3판 2선(3판 2선, 5판 3선 등) 인 게임에서 homeTeam, awayTeam 의 스코어 따라 이긴 팀, 그리고 각  이긴팀, home팀, away팀
```
SELECT 
        t2.name AS home_team_name
        , t2.id AS home_team_id
        , t3.name AS away_team_name
        , t3.id AS away_team_id
        , CASE
                WHEN t1.home_score = FLOOR(t1.number_of_games / 2) + 1
                        THEN t2.name
                WHEN t1.away_score = FLOOR(t1.number_of_Games / 2) + 1
                        THEN t2.name
                ELSE ''
                END
                AS winner_team_name
        , t4.id AS winner_team_id
FROM game_table t1
LEFT OUTER JOIN game_team_table t2 ON t1.home_team_id = t2.id
LEFT OUTER JOIN game_team_table t3 ON t1.away_team_id = t3.id
LEFT OUTER JOIN game_team_table t4 ON t1.winner_team_id = t4.id
```

- group by
  - group by 에서 지정한 열 이외의 열은 집계함수(ex. sum(), count())를 사용하지 않은 채 select 구에 지정할 수 없다.

- Mysql 에서는 데이터를 추가하거나 갱신할 경우, 동일한 테이블을 서브쿼리에서 사용할 수 없도록 되어있다. 
  - 그래서 아래와 같은 쿼리는 에러가 난다(You Can’t specify target table ‘(테이블이름)’ for update in FROM clause
  - 에러나는 쿼리
  ```
  DELETE FROM sampleTable WHERE a = (SELECT MIN(a) FROM sampleTable)
  ```
  - 그래서 변수를 사용하거나 인라인 뷸 임시 테이블을 만들도록 처리하면 된다.
  ```
  DELETE FROM sampleTable WHERE a = (SELECT a FROM (SELECT MIN(a) AS a FROM sampleTable) AS x);
  ```
