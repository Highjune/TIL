## SQL 
> 유용하거나 생소한 SQL 기록

- 특정한 날(1일)의 범위 선택(between 으로)
    - 사실 아래처럼 말고 부등호로 표현하면 더 간단할 수 있다.
```
SELECT *
FROM ex_table
WHERE BETWEEN DATE_FORMAT(specific_day, '%Y-%m-%d 00:00:00')  AND DATE_FORMAT(specific_day, '%Y-%m-%d 23:59:59')
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
    - 경우수 3가지
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